package jxquery.google.utils;

import java.io.InputStream;

import org.apache.commons.lang.StringUtils;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Oct 2, 2011
 */
public class ResourceHelper {
	public static InputStream getResourceAsStreamFromPackage(Class<?> clz,
			String fileName) {
		String packageNameToPath = StringUtils.replace(clz.getPackage()
				.getName(), ".", "/");
		String resName = packageNameToPath + "/" + fileName;
		InputStream resourceStream = Thread.currentThread()
				.getContextClassLoader().getResourceAsStream(resName);

		return resourceStream;
	}
}
