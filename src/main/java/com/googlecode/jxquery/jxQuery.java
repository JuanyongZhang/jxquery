package com.googlecode.jxquery;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import com.googlecode.jxquery.creator.FieldCreator;

/**
 * @Author : <a href="mailto:Juanyong.zhang@carefirst.com">Cham
 *         Juanyong.zhang</a>
 * @Date : Sep 27, 2011
 */
@Retention(RUNTIME)
@Target( { FIELD })
public @interface jxQuery {
	String query();

	Class<? extends FieldCreator<?>> creator() default BlankClass.class;
}
