package jxquery.google.utils;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Sep 24, 2011
 */
public class ClassHelper {
	public static boolean isLangType(Object obj) {
		boolean flag = false;
		if (null == obj)
			return flag;

		Class<?> clazz = obj.getClass();
		if (obj instanceof Class<?>) {
			clazz = (Class<?>) obj;
		}

		flag = Package.getPackage("java.lang").equals(clazz.getPackage());

		return flag;
	}
}
