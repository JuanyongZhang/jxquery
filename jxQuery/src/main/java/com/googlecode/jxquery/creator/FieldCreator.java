package com.googlecode.jxquery.creator;

/**
 * Create a custom field value on the input object.
 * <p>
 * Object is {@link org.w3c.dom.Node Node} or {@link org.w3c.dom.NodeList
 * NodeList}
 * </p>
 * 
 * @Author:<a href="mailto:Juanyong.zhang@carefirst.com">Cham Juanyong.zhang</a>
 * @Date:Sep 29, 2011
 * 
 */
public interface FieldCreator<T> {

	public T create(Object org);
}
