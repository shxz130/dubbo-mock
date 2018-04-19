/**
 * 
 * 平安付 Copyright (c) 2013-2016 PingAnFu,Inc.All Rights Reserved.
 */
package com.github.jettyrun.common.utils.file.bean;

import java.util.List;


/**
 * 读文件
 */
public class FileReadBean {
  /** 当前批次返回的数据 */
  private List<String> lines;
  /** 是否读取至最后 */
  private boolean isEnd;
  /** 最后读取行号 */
  private int lastLineNumber;

  public Integer getStartLineNumber(boolean hasFirstLine, int pageSize, int pageNo) {

    int pageNumber = pageSize * pageNo;
    pageNumber = hasFirstLine ? pageNumber + 1 : pageNumber;
    if (pageNumber == lastLineNumber) {
      return hasFirstLine ? (pageNo - 1) * pageSize + 2 : (pageNo - 1) * pageSize + 1;
    } else {
      pageNumber = pageSize * (pageNo - 1);
      pageNumber = hasFirstLine ? pageNumber + 1 : pageNumber;

      return pageNumber + 1;
    }
  }


  public List<String> getLines() {
    return lines;
  }


  public void setLines(List<String> lines) {
    this.lines = lines;
  }


  public boolean isEnd() {
    return isEnd;
  }


  public void setEnd(boolean isEnd) {
    this.isEnd = isEnd;
  }


  public int getLastLineNumber() {
    return lastLineNumber;
  }


  public void setLastLineNumber(int lastLineNumber) {
    this.lastLineNumber = lastLineNumber;
  }

  @Override
  public String toString() {
    return "FileReadBean{" +
            "lines=" + lines +
            ", isEnd=" + isEnd +
            ", lastLineNumber=" + lastLineNumber +
            '}';
  }
}
