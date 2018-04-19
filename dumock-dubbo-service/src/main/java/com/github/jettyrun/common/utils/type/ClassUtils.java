package com.github.jettyrun.common.utils.type;

import com.github.jettyrun.common.utils.reflect.ReflectionUtils;

import java.beans.Introspector;
import java.lang.reflect.*;
import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.LinkedHashSet;
import java.util.Set;


public abstract class ClassUtils {

	/** Suffix for array class names: "[]" */
	public static final String ARRAY_SUFFIX = "[]";

	/** Prefix for internal array class names: "[" */
	private static final String INTERNAL_ARRAY_PREFIX = "[";

	/** Prefix for internal non-primitive array class names: "[L" */
	private static final String NON_PRIMITIVE_ARRAY_PREFIX = "[L";

	/** The package separator character: '.' */
	private static final char PACKAGE_SEPARATOR = '.';

	/** The path separator character: '/' */
	private static final char PATH_SEPARATOR = '/';

	/** The inner class separator character: '$' */
	private static final char INNER_CLASS_SEPARATOR = '$';

	/** The CGLIB class separator: "$$" */
	public static final String CGLIB_CLASS_SEPARATOR = "$$";

	/** The ".class" file suffix */
	public static final String CLASS_FILE_SUFFIX = ".class";




	public static ClassLoader getDefaultClassLoader() {
		ClassLoader cl = null;
		try {
			cl = Thread.currentThread().getContextClassLoader();
		}
		catch (Throwable ex) {
		}
		if (cl == null) {
			cl = ClassUtils.class.getClassLoader();
			if (cl == null) {
				try {
					cl = ClassLoader.getSystemClassLoader();
				}
				catch (Throwable ex) {
				}
			}
		}
		return cl;
	}


	public static ClassLoader overrideThreadContextClassLoader( ClassLoader classLoaderToUse) {
		Thread currentThread = Thread.currentThread();
		ClassLoader threadContextClassLoader = currentThread.getContextClassLoader();
		if (classLoaderToUse != null && !classLoaderToUse.equals(threadContextClassLoader)) {
			currentThread.setContextClassLoader(classLoaderToUse);
			return threadContextClassLoader;
		}
		else {
			return null;
		}
	}


	public static Class<?> forName(String name, ClassLoader classLoader)
			throws ClassNotFoundException, LinkageError {

		if (name.endsWith(ARRAY_SUFFIX)) {
			String elementClassName = name.substring(0, name.length() - ARRAY_SUFFIX.length());
			Class<?> elementClass = forName(elementClassName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		if (name.startsWith(NON_PRIMITIVE_ARRAY_PREFIX) && name.endsWith(";")) {
			String elementName = name.substring(NON_PRIMITIVE_ARRAY_PREFIX.length(), name.length() - 1);
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}
		if (name.startsWith(INTERNAL_ARRAY_PREFIX)) {
			String elementName = name.substring(INTERNAL_ARRAY_PREFIX.length());
			Class<?> elementClass = forName(elementName, classLoader);
			return Array.newInstance(elementClass, 0).getClass();
		}

		ClassLoader clToUse = classLoader;
		if (clToUse == null) {
			clToUse = getDefaultClassLoader();
		}
		try {
			return (clToUse != null ? clToUse.loadClass(name) : Class.forName(name));
		}
		catch (ClassNotFoundException ex) {
			int lastDotIndex = name.lastIndexOf(PACKAGE_SEPARATOR);
			if (lastDotIndex != -1) {
				String innerClassName =
						name.substring(0, lastDotIndex) + INNER_CLASS_SEPARATOR + name.substring(lastDotIndex + 1);
				try {
					return (clToUse != null ? clToUse.loadClass(innerClassName) : Class.forName(innerClassName));
				}
				catch (ClassNotFoundException ex2) {
				}
			}
			throw ex;
		}
	}


	public static Class<?> resolveClassName(String className, ClassLoader classLoader) throws IllegalArgumentException {
		try {
			return forName(className, classLoader);
		}
		catch (ClassNotFoundException ex) {
			throw new IllegalArgumentException("Could not find class [" + className + "]", ex);
		}
		catch (LinkageError err) {
			throw new IllegalArgumentException("Unresolvable class definition for class [" + className + "]", err);
		}
	}


	public static String getShortName(String className) {
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		int nameEndIndex = className.indexOf(CGLIB_CLASS_SEPARATOR);
		if (nameEndIndex == -1) {
			nameEndIndex = className.length();
		}
		String shortName = className.substring(lastDotIndex + 1, nameEndIndex);
		shortName = shortName.replace(INNER_CLASS_SEPARATOR, PACKAGE_SEPARATOR);
		return shortName;
	}


	public static String getShortName(Class<?> clazz) {
		return getShortName(getQualifiedName(clazz));
	}


	public static String getShortNameAsProperty(Class<?> clazz) {
		String shortName = getShortName(clazz);
		int dotIndex = shortName.lastIndexOf(PACKAGE_SEPARATOR);
		shortName = (dotIndex != -1 ? shortName.substring(dotIndex + 1) : shortName);
		return Introspector.decapitalize(shortName);
	}


	public static String getClassFileName(Class<?> clazz) {
		String className = clazz.getName();
		int lastDotIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		return className.substring(lastDotIndex + 1) + CLASS_FILE_SUFFIX;
	}


	public static String getPackageName(Class<?> clazz) {
		return getPackageName(clazz.getName());
	}


	public static String getPackageName(String fqClassName) {
		int lastDotIndex = fqClassName.lastIndexOf(PACKAGE_SEPARATOR);
		return (lastDotIndex != -1 ? fqClassName.substring(0, lastDotIndex) : "");
	}


	public static String getQualifiedName(Class<?> clazz) {
		return clazz.getTypeName();
	}


	public static String getQualifiedMethodName(Method method) {
		return getQualifiedMethodName(method, null);
	}


	public static String getQualifiedMethodName(Method method,  Class<?> clazz) {
		return (clazz != null ? clazz : method.getDeclaringClass()).getName() + '.' + method.getName();
	}


	public static String getDescriptiveType( Object value) {
		if (value == null) {
			return null;
		}
		Class<?> clazz = value.getClass();
		if (Proxy.isProxyClass(clazz)) {
			StringBuilder result = new StringBuilder(clazz.getName());
			result.append(" implementing ");
			Class<?>[] ifcs = clazz.getInterfaces();
			for (int i = 0; i < ifcs.length; i++) {
				result.append(ifcs[i].getName());
				if (i < ifcs.length - 1) {
					result.append(',');
				}
			}
			return result.toString();
		}
		else {
			return clazz.getTypeName();
		}
	}


	public static boolean matchesTypeName(Class<?> clazz,String typeName) {
		return (typeName != null &&
				(typeName.equals(clazz.getTypeName()) || typeName.equals(clazz.getSimpleName())));
	}


	public static boolean hasConstructor(Class<?> clazz, Class<?>... paramTypes) {
		return (getConstructorIfAvailable(clazz, paramTypes) != null);
	}


	public static <T> Constructor<T> getConstructorIfAvailable(Class<T> clazz, Class<?>... paramTypes) {
		try {
			return clazz.getConstructor(paramTypes);
		}
		catch (NoSuchMethodException ex) {
			return null;
		}
	}


	public static boolean hasMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
		return (getMethodIfAvailable(clazz, methodName, paramTypes) != null);
	}


	public static Method getMethod(Class<?> clazz, String methodName, Class<?>... paramTypes) {
		if (paramTypes != null) {
			try {
				return clazz.getMethod(methodName, paramTypes);
			}
			catch (NoSuchMethodException ex) {
				throw new IllegalStateException("Expected method not found: " + ex);
			}
		}
		else {
			Set<Method> candidates = new HashSet<Method>(1);
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					candidates.add(method);
				}
			}
			if (candidates.size() == 1) {
				return candidates.iterator().next();
			}
			else if (candidates.isEmpty()) {
				throw new IllegalStateException("Expected method not found: " + clazz.getName() + '.' + methodName);
			}
			else {
				throw new IllegalStateException("No unique method found: " + clazz.getName() + '.' + methodName);
			}
		}
	}


	public static Method getMethodIfAvailable(Class<?> clazz, String methodName, Class<?>... paramTypes) {

		if (paramTypes != null) {
			try {
				return clazz.getMethod(methodName, paramTypes);
			}
			catch (NoSuchMethodException ex) {
				return null;
			}
		}
		else {
			Set<Method> candidates = new HashSet<Method>(1);
			Method[] methods = clazz.getMethods();
			for (Method method : methods) {
				if (methodName.equals(method.getName())) {
					candidates.add(method);
				}
			}
			if (candidates.size() == 1) {
				return candidates.iterator().next();
			}
			return null;
		}
	}


	public static int getMethodCountForName(Class<?> clazz, String methodName) {
		int count = 0;
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if (methodName.equals(method.getName())) {
				count++;
			}
		}
		Class<?>[] ifcs = clazz.getInterfaces();
		for (Class<?> ifc : ifcs) {
			count += getMethodCountForName(ifc, methodName);
		}
		if (clazz.getSuperclass() != null) {
			count += getMethodCountForName(clazz.getSuperclass(), methodName);
		}
		return count;
	}


	public static boolean hasAtLeastOneMethodWithName(Class<?> clazz, String methodName) {
		Method[] declaredMethods = clazz.getDeclaredMethods();
		for (Method method : declaredMethods) {
			if (method.getName().equals(methodName)) {
				return true;
			}
		}
		Class<?>[] ifcs = clazz.getInterfaces();
		for (Class<?> ifc : ifcs) {
			if (hasAtLeastOneMethodWithName(ifc, methodName)) {
				return true;
			}
		}
		return (clazz.getSuperclass() != null && hasAtLeastOneMethodWithName(clazz.getSuperclass(), methodName));
	}


	public static Method getMostSpecificMethod(Method method, Class<?> targetClass) {
		if (isOverridable(method, targetClass) &&
				targetClass != null && targetClass != method.getDeclaringClass()) {
			try {
				if (Modifier.isPublic(method.getModifiers())) {
					try {
						return targetClass.getMethod(method.getName(), method.getParameterTypes());
					}
					catch (NoSuchMethodException ex) {
						return method;
					}
				}
				else {
					Method specificMethod =
							ReflectionUtils.findMethod(targetClass, method.getName(), method.getParameterTypes());
					return (specificMethod != null ? specificMethod : method);
				}
			}
			catch (SecurityException ex) {

			}
		}
		return method;
	}




	private static boolean isOverridable(Method method,  Class<?> targetClass) {
		if (Modifier.isPrivate(method.getModifiers())) {
			return false;
		}
		if (Modifier.isPublic(method.getModifiers()) || Modifier.isProtected(method.getModifiers())) {
			return true;
		}
		return (targetClass == null ||
				getPackageName(method.getDeclaringClass()).equals(getPackageName(targetClass)));
	}


	public static Method getStaticMethod(Class<?> clazz, String methodName, Class<?>... args) {

		try {
			Method method = clazz.getMethod(methodName, args);
			return Modifier.isStatic(method.getModifiers()) ? method : null;
		}
		catch (NoSuchMethodException ex) {
			return null;
		}
	}




	public static boolean isPrimitiveArray(Class<?> clazz) {
		return (clazz.isArray() && clazz.getComponentType().isPrimitive());
	}



	public static String convertResourcePathToClassName(String resourcePath) {
		return resourcePath.replace(PATH_SEPARATOR, PACKAGE_SEPARATOR);
	}


	public static String convertClassNameToResourcePath(String className) {
		return className.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
	}


	public static String addResourcePathToPackagePath(Class<?> clazz, String resourceName) {
		if (!resourceName.startsWith("/")) {
			return classPackageAsResourcePath(clazz) + '/' + resourceName;
		}
		return classPackageAsResourcePath(clazz) + resourceName;
	}


	public static String classPackageAsResourcePath( Class<?> clazz) {
		if (clazz == null) {
			return "";
		}
		String className = clazz.getName();
		int packageEndIndex = className.lastIndexOf(PACKAGE_SEPARATOR);
		if (packageEndIndex == -1) {
			return "";
		}
		String packageName = className.substring(0, packageEndIndex);
		return packageName.replace(PACKAGE_SEPARATOR, PATH_SEPARATOR);
	}




	public static Class<?>[] toClassArray(Collection<Class<?>> collection) {
		if (collection == null) {
			return null;
		}
		return collection.toArray(new Class<?>[collection.size()]);
	}


	public static Class<?>[] getAllInterfaces(Object instance) {
		return getAllInterfacesForClass(instance.getClass());
	}


	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz) {
		return getAllInterfacesForClass(clazz, null);
	}


	public static Class<?>[] getAllInterfacesForClass(Class<?> clazz,  ClassLoader classLoader) {
		Set<Class<?>> ifcs = getAllInterfacesForClassAsSet(clazz, classLoader);
		return ifcs.toArray(new Class<?>[ifcs.size()]);
	}


	public static Set<Class<?>> getAllInterfacesAsSet(Object instance) {
		return getAllInterfacesForClassAsSet(instance.getClass());
	}


	public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz) {
		return getAllInterfacesForClassAsSet(clazz, null);
	}


	public static Set<Class<?>> getAllInterfacesForClassAsSet(Class<?> clazz,  ClassLoader classLoader) {
		if (clazz.isInterface() && isVisible(clazz, classLoader)) {
			return Collections.<Class<?>>singleton(clazz);
		}
		Set<Class<?>> interfaces = new LinkedHashSet<Class<?>>();
		Class<?> current = clazz;
		while (current != null) {
			Class<?>[] ifcs = current.getInterfaces();
			for (Class<?> ifc : ifcs) {
				interfaces.addAll(getAllInterfacesForClassAsSet(ifc, classLoader));
			}
			current = current.getSuperclass();
		}
		return interfaces;
	}


	public static Class<?> createCompositeInterface(Class<?>[] interfaces,ClassLoader classLoader) {
		return Proxy.getProxyClass(classLoader, interfaces);
	}


	public static Class<?> determineCommonAncestor( Class<?> clazz1,Class<?> clazz2) {
		if (clazz1 == null) {
			return clazz2;
		}
		if (clazz2 == null) {
			return clazz1;
		}
		if (clazz1.isAssignableFrom(clazz2)) {
			return clazz1;
		}
		if (clazz2.isAssignableFrom(clazz1)) {
			return clazz2;
		}
		Class<?> ancestor = clazz1;
		do {
			ancestor = ancestor.getSuperclass();
			if (ancestor == null || Object.class == ancestor) {
				return null;
			}
		}
		while (!ancestor.isAssignableFrom(clazz2));
		return ancestor;
	}


	public static boolean isVisible(Class<?> clazz, ClassLoader classLoader) {
		if (classLoader == null) {
			return true;
		}
		try {
			Class<?> actualClass = classLoader.loadClass(clazz.getName());
			return (clazz == actualClass);
		}
		catch (ClassNotFoundException ex) {
			return false;
		}
	}



	public static boolean isCglibProxy(Object object) {
		return isCglibProxyClass(object.getClass());
	}


	public static boolean isCglibProxyClass( Class<?> clazz) {
		return (clazz != null && isCglibProxyClassName(clazz.getName()));
	}


	public static boolean isCglibProxyClassName( String className) {
		return (className != null && className.contains(CGLIB_CLASS_SEPARATOR));
	}




}
