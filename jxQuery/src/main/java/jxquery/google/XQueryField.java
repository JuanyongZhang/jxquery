package jxquery.google;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

/**
 * @Author : <a href="mailto:Juanyong.zhang@carefirst.com">Cham
 *         Juanyong.zhang</a>
 * @Date : Sep 27, 2011
 */
@Retention(RUNTIME)
@Target({ FIELD })
public @interface XQueryField {
	String query();

	String creator() default "";
}
