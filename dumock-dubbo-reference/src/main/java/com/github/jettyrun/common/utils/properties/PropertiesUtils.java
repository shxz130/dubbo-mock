/*
 * Copyright 2002-2016 the original author or authors.
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

package com.github.jettyrun.common.utils.properties;

import java.io.IOException;
import java.io.InputStream;
import java.io.Reader;
import java.net.URL;
import java.net.URLConnection;
import java.util.Enumeration;
import java.util.Properties;

import org.springframework.core.io.Resource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.util.ClassUtils;
import org.springframework.util.ClassUtils;
import org.springframework.util.DefaultPropertiesPersister;
import org.springframework.util.PropertiesPersister;
import org.springframework.util.ResourceUtils;

public abstract class PropertiesUtils {

	private static final String XML_FILE_EXTENSION = ".xml";


	public static Properties loadProperties(EncodedResource resource) throws IOException {
		Properties props = new Properties();
		fillProperties(props, resource);
		return props;
	}


	public static void fillProperties(Properties props, EncodedResource resource)
			throws IOException {
		fillProperties(props, resource, new DefaultPropertiesPersister());
	}


	static void fillProperties(Properties props, EncodedResource resource, PropertiesPersister persister)
			throws IOException {

		InputStream stream = null;
		Reader reader = null;
		try {
			String filename = resource.getResource().getFilename();
			if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
				stream = resource.getInputStream();
				persister.loadFromXml(props, stream);
			}
			else if (resource.requiresReader()) {
				reader = resource.getReader();
				persister.load(props, reader);
			}
			else {
				stream = resource.getInputStream();
				persister.load(props, stream);
			}
		}
		finally {
			if (stream != null) {
				stream.close();
			}
			if (reader != null) {
				reader.close();
			}
		}
	}


	public static Properties loadProperties(Resource resource) throws IOException {
		Properties props = new Properties();
		fillProperties(props, resource);
		return props;
	}


	public static void fillProperties(Properties props, Resource resource) throws IOException {
		InputStream is = resource.getInputStream();
		try {
			String filename = resource.getFilename();
			if (filename != null && filename.endsWith(XML_FILE_EXTENSION)) {
				props.loadFromXML(is);
			}
			else {
				props.load(is);
			}
		}
		finally {
			is.close();
		}
	}


	public static Properties loadAllProperties(String resourceName) throws IOException {
		return loadAllProperties(resourceName, null);
	}


	public static Properties loadAllProperties(String resourceName,  ClassLoader classLoader) throws IOException {
		ClassLoader classLoaderToUse = classLoader;
		if (classLoaderToUse == null) {
			classLoaderToUse = ClassUtils.getDefaultClassLoader();
		}
		Enumeration<URL> urls = (classLoaderToUse != null ? classLoaderToUse.getResources(resourceName) :
				ClassLoader.getSystemResources(resourceName));
		Properties props = new Properties();
		while (urls.hasMoreElements()) {
			URL url = urls.nextElement();
			URLConnection con = url.openConnection();
			ResourceUtils.useCachesIfNecessary(con);
			InputStream is = con.getInputStream();
			try {
				if (resourceName.endsWith(XML_FILE_EXTENSION)) {
					props.loadFromXML(is);
				}
				else {
					props.load(is);
				}
			}
			finally {
				is.close();
			}
		}
		return props;
	}

}
