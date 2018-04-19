/*
 * Copyright 2002-2017 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.github.jettyrun.common.utils.file;

import com.github.jettyrun.common.utils.file.bean.FileReadBean;
import com.github.jettyrun.common.utils.type.ObjectUtils;
import com.github.jettyrun.common.utils.type.StringUtils;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileVisitResult;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.StandardCopyOption;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;
import java.util.List;


public class FileUtils {


	public static final int BUFFER_SIZE = StreamUtils.BUFFER_SIZE;

	public static boolean deleteRecursively(File root) {
		if (root == null) {
			return false;
		}

		try {
			return deleteRecursively(root.toPath());
		}
		catch (IOException ex) {
			return false;
		}
	}


	public static boolean deleteRecursively(Path root) throws IOException {
		if (root == null) {
			return false;
		}
		if (!Files.exists(root)) {
			return false;
		}

		Files.walkFileTree(root, new SimpleFileVisitor<Path>() {
			@Override
			public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
				Files.delete(file);
				return FileVisitResult.CONTINUE;
			}
			@Override
			public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException {
				Files.delete(dir);
				return FileVisitResult.CONTINUE;
			}
		});
		return true;
	}

	public static void copyRecursively(File src, File dest) throws IOException {

		copyRecursively(src.toPath(), dest.toPath());
	}


	public static void copyRecursively(final Path src,final Path dest) throws IOException {

		BasicFileAttributes srcAttr = Files.readAttributes(src, BasicFileAttributes.class);

		if (srcAttr.isDirectory()) {
			Files.walkFileTree(src, new SimpleFileVisitor<Path>() {
				@Override
				public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
					Files.createDirectories(dest.resolve(src.relativize(dir)));
					return FileVisitResult.CONTINUE;
				}
				@Override
				public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
					Files.copy(file, dest.resolve(src.relativize(file)), StandardCopyOption.REPLACE_EXISTING);
					return FileVisitResult.CONTINUE;
				}
			});
		}
		else if (srcAttr.isRegularFile()) {
			Files.copy(src, dest);
		}
		else {
			throw new IllegalArgumentException("Source File must denote a directory or file");
		}
	}



	public static int copy(File in, File out) throws IOException {
		return copy(Files.newInputStream(in.toPath()), Files.newOutputStream(out.toPath()));
	}


	public static void copy(byte[] in, File out) throws IOException {
		copy(new ByteArrayInputStream(in), Files.newOutputStream(out.toPath()));
	}


	public static byte[] copyToByteArray(File in) throws IOException {
		return copyToByteArray(Files.newInputStream(in.toPath()));
	}



	public static int copy(InputStream in, OutputStream out) throws IOException {
		try {
			return StreamUtils.copy(in, out);
		}
		finally {
			try {
				in.close();
			}
			catch (IOException ex) {
			}
			try {
				out.close();
			}
			catch (IOException ex) {
			}
		}
	}


	public static void copy(byte[] in, OutputStream out) throws IOException {

		try {
			out.write(in);
		}
		finally {
			try {
				out.close();
			}
			catch (IOException ex) {
			}
		}
	}


	public static byte[] copyToByteArray(InputStream in) throws IOException {
		if (in == null) {
			return new byte[0];
		}

		ByteArrayOutputStream out = new ByteArrayOutputStream(BUFFER_SIZE);
		copy(in, out);
		return out.toByteArray();
	}


	public static int copy(Reader in, Writer out) throws IOException {


		try {
			int byteCount = 0;
			char[] buffer = new char[BUFFER_SIZE];
			int bytesRead = -1;
			while ((bytesRead = in.read(buffer)) != -1) {
				out.write(buffer, 0, bytesRead);
				byteCount += bytesRead;
			}
			out.flush();
			return byteCount;
		}
		finally {
			try {
				in.close();
			}
			catch (IOException ex) {
			}
			try {
				out.close();
			}
			catch (IOException ex) {
			}
		}
	}


	public static void copy(String in, Writer out) throws IOException {

		try {
			out.write(in);
		}
		finally {
			try {
				out.close();
			}
			catch (IOException ex) {
			}
		}
	}


	public static String copyToString(Reader in) throws IOException {
		if (in == null) {
			return "";
		}
		StringWriter out = new StringWriter();
		copy(in, out);
		return out.toString();
	}



	public static FileReadBean readForPage(File sourceFile, int pageNo, int pageSize,
										   boolean excludeFirstLine, String encoding) throws IOException {
		// 读取文件结果
		FileReadBean fileData = new FileReadBean();
		InputStreamReader isr = null;
		LineNumberReader reader = null;
		// 行数据
		List<String> dataLines = new ArrayList<String>();
		try {
			isr = new InputStreamReader(new FileInputStream(sourceFile), encoding);
			reader = new LineNumberReader(isr);
			// 从第一页开始
			if (pageNo <= 0) {
				pageNo = 1;
			}
			int startRow = (pageNo - 1) * pageSize + 1;
			int endRow = pageNo * pageSize;

			// 如果去除第一行头,实际数据均加1
			if (excludeFirstLine) {
				startRow += 1;
				endRow += 1;
			}

			String line = ""; // 行数据
			int lines = 0; // 读取到文件多少行
			int validLines = 0; // 在分页范围内的行数
			while (line != null) {
				line = reader.readLine();
				lines++;
				if (lines >= startRow && lines <= endRow) {
					if (line != null) {
						dataLines.add(line);
						validLines++;
					} else {
						break;
					}
				}

				if (lines > endRow) {
					break;
				}
			}

			if (validLines == pageSize) {
				fileData.setEnd(false);
			} else {
				fileData.setEnd(true);
			}
			fileData.setLines(dataLines);
			fileData.setLastLineNumber(startRow + validLines - 1);

		} catch (Exception e) {
			dataLines.clear();
			throw new IOException("文件读失败",e);
		} finally {
			try {
				if (null != isr) {
					isr.close();
				}
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				throw new IOException("文件读失败",e);
			}
		}
		return fileData;
	}


	public static void writeFile(String remoteFilePath, String fileName, StringBuffer sb,
								   String charset)throws IOException {
		FileChannel fc = null;
		try {
			File file = new File(remoteFilePath);
			if (!file.exists() && !file.isDirectory()) {// 目录不存在，重新创建
				file.mkdir();
			}
			String fullPath = remoteFilePath + fileName;
			File remoteFile = new File(fullPath);
			// 如果文件已存在,删除对应文件记录
			if (remoteFile.exists()) {
				remoteFile.delete();
			}
			// 生成文件
			fc = new FileOutputStream(fullPath).getChannel();
			fc.write(ByteBuffer.wrap(sb.toString().getBytes(charset)));// 通过FileChannel写入ByteBuffer中的内容,编码格式按照指定格式来

		} catch (Exception e) {
			throw new IOException("文件写失败",e);
		} finally {
			if (fc != null) {
				try {
					fc.close();
				} catch (IOException e) {
					throw new IOException("channel关闭失败",e);
				}
			}
		}
	}



	public static String readHeadLine(File file, String encoding)throws IOException  {

		InputStreamReader isr = null;
		LineNumberReader reader = null;

		try {
			isr = new InputStreamReader(new FileInputStream(file), encoding);
			reader = new LineNumberReader(isr);
			return reader.readLine();
		} catch (Exception e) {
			throw new IOException("读首行失败",e);
		} finally {
			try {
				if (null != isr) {
					isr.close();
				}
				if (null != reader) {
					reader.close();
				}
			} catch (IOException e) {
				throw new IOException("流关闭失败",e);
			}
		}
	}


	public static void writeFile(String remoteFilePath, String fileName, String data, String charset,
								 boolean isAppend) throws IOException {

		File file = new File(remoteFilePath);
		if (!file.exists() && !file.isDirectory()) {// 目录不存在，重新创建
			file.mkdir();
		}
		String fullPath = remoteFilePath + File.separator + fileName;
		File remoteFile = new File(fullPath);
		// 如果文件已存在,删除对应文件记录
		if (isAppend) {
			appendFile(remoteFile, data, charset);
		} else {
			writeNewFile(remoteFile, data, charset);
		}
	}

	public static void writeNewFile(File file, String data, String charset) throws IOException {
		if (file.exists()) {
			file.delete();
		}
		appendFile(file, data, charset);


	}


	public static void appendFile(File file, String data, String charset) throws IOException {
		BufferedWriter writer = null;
		try {
			writer =
					new BufferedWriter(new OutputStreamWriter((new FileOutputStream(file, true)), charset));
			writer.write(data);
			writer.close();
		} catch (IOException e) {
			if (!ObjectUtils.isEmpty(writer)) {
				try {
					writer.close();
				} catch (IOException e1) {
					throw new IOException("流关闭失败", e);
				}
			}
			throw new IOException("追加文件失败", e);
		}
	}

	public static String[] getFileNames(String basePath) throws IOException {
		if (StringUtils.isBlank(basePath)) {
			throw new IOException("文件路径不能为空");
		}
		File file = new File(basePath);
		if (file.isDirectory()) {
			return file.list();
		} else {
			throw new IOException("文件路径不是目录");
		}
	}
	@SuppressWarnings("resource")
	public static Integer getFileLineNumberCount(String fileName)
			throws FileNotFoundException, IOException {
		LineNumberReader reader;
		try {
			reader = new LineNumberReader(new FileReader(new File(fileName)));
		} catch (FileNotFoundException e) {
			throw e;
		}
		Integer count = 0;
		try {
			while (reader.readLine() != null) {
				count++;
			}
		} catch (IOException e) {
			throw e;
		} finally {
			reader.close();
		}
		return count;
	}


	public static String getFileName(String filePath, String fileName) {
		return String.format("%s%s%s", filePath, File.separator, fileName);
	}

	public static void createDirectory(String directory) throws Exception {
		File file = new File(directory);
		if (!file.exists()) {
			file.mkdir();
		}
		if (!file.isDirectory()) {
			throw new Exception("文件路径出错,不是文件路径");
		}
	}

	/**
	 * 将输入流写到文件中
	 * @param ins
	 * @param file
	 * @throws IOException
	 */
	public static void inputstreamToFile(InputStream ins, File file) throws IOException {
		OutputStream os = null;
		try {
			os = new FileOutputStream(file);
			int bytesRead = 0;
			byte[] buffer = new byte[8192];
			while ((bytesRead = ins.read(buffer, 0, 8192)) != -1) {
				os.write(buffer, 0, bytesRead);
			}
		} catch (Exception e) {
			throw new IOException("写文件异常", e);
		} finally {
			if (ObjectUtils.isEmpty(os)) {
				os.close();
			}
			if (ObjectUtils.isEmpty(ins)) {
				ins.close();
			}
		}
	}




}
