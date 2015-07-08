package com.googlecode.jxquery.utils;

import java.lang.annotation.Annotation;
import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.HashSet;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang.ClassUtils;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Sep 24, 2011
 */
public class ReflectionHelper {
	public static <A extends Annotation> Field[] getAllFields(Class<?> type,
			@SuppressWarnings("unchecked") Class<A>... qualifieds) {
		Set<Field> fs = new HashSet<Field>();
		if (null != qualifieds && qualifieds.length > 0) {
			CollectionUtils.addAll(fs,
					getQualifiedFields(type.getDeclaredFields(), qualifieds));
		} else {
			CollectionUtils.addAll(fs, type.getDeclaredFields());
		}

		Class<?> superType = type.getSuperclass();
		while (superType != null) {

			if (null != qualifieds && qualifieds.length > 0) {
				CollectionUtils.addAll(
						fs,
						getQualifiedFields(superType.getDeclaredFields(),
								qualifieds));
			} else {
				CollectionUtils.addAll(fs, superType.getDeclaredFields());
			}
			superType = superType.getSuperclass();
		}

		return fs.toArray(new Field[fs.size()]);
	}

	private static <A extends Annotation> Field[] getQualifiedFields(
			Field[] fs, Class<A>[] qualifieds) {
		Set<Field> qualifiedFs = new HashSet<Field>();
		for (Field f : fs) {
			for (Class<A> q : qualifieds) {
				if (null != f.getAnnotation(q)) {
					qualifiedFs.add(f);
					break;
				}
			}
		}

		return qualifiedFs.toArray(new Field[qualifiedFs.size()]);
	}

	public static Class<?> getFieldComponentType(Field field) {
		Class<?> clz = null;

		Type t = field.getGenericType();
		Class<?> c = field.getType();

		if (c.isArray()) {
			clz = c.getComponentType();
		} else if (isCollectionType(c) && (t instanceof ParameterizedType)) {
			ParameterizedType pt = (ParameterizedType) t;
			clz = (Class<?>) pt.getActualTypeArguments()[0];
		} else {
			// FIXME THROW EXCEPTION NEED GENERIC TYPE COLLECTION
		}

		return clz;
	}

	public static boolean isCollectionType(Class<?> type) {
		if (null == type)
			return false;
		boolean isCollectionType = type.isArray()
				|| ClassUtils.getAllInterfaces(type).contains(Iterable.class);

		return isCollectionType;
	}
}
