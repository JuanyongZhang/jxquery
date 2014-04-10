package com.googlecode.jxquery.utils;

import java.lang.reflect.Array;
import java.util.List;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Sep 24, 2011
 */
public class ArrayHelper {
	public static <T> T[] createArray(List<T> list, Class<T> clazz) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) Array.newInstance(clazz, list.size());
		for (int i = 0; i < array.length; i++) {
			array[i] = list.get(i);
		}
		return array;
	}

}
