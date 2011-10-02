package jxquery.google.test;

import static jxquery.google.utils.ResourceHelper.getResourceAsStreamFromPackage;

import java.io.InputStream;

import junit.framework.Assert;
import jxquery.google.JSONPopulater;
import jxquery.google.XMLPopulater;
import jxquery.google.test.person.PersonInfo;
import jxquery.google.test.resume.Resume;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.junit.Test;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Cham Juanyong.zhang</a>
 * @Date : Jan 21, 2011
 */
public class AppTest {

	@Test
	public void testPersonJSON() throws Exception {
		final String fileName = "person.json";
		final String fName = "John";
		final String faxNbr = "212 555-2345";

		InputStream in = getResourceAsStreamFromPackage(
				PersonInfo.class, fileName);

		PersonInfo p = new PersonInfo();
		System.out.println(ToStringBuilder.reflectionToString(JSONPopulater
				.eval(in, p)));
		Assert.assertEquals(fName, p.getFirstName());
		Assert.assertEquals(faxNbr, p.getFax()[0].getNumber());
		System.out.println("##########################");
	}

	@Test
	public void testResumeJSON() throws Exception {
		final String fileName = "resume.json";

		final String email = "Juanyong.zhang@gmail.com";
		final int count = 2;

		InputStream in = getResourceAsStreamFromPackage(Resume.class,
				fileName);

		Resume r = new Resume();

		System.out.println(ToStringBuilder.reflectionToString(JSONPopulater
				.eval(in, r)));

		Assert.assertEquals(email, r.getEmail());
		Assert.assertEquals(count, r.getProjectsSizeGt20().size());

		System.out.println("##########################");
	}

	@Test
	public void testPersonXML() throws Exception {
		final String fileName = "person.xml";
		final String fName = "John";
		final String faxNbr = "212 555-2345";

		InputStream in = getResourceAsStreamFromPackage(
				PersonInfo.class, fileName);

		PersonInfo p = new PersonInfo();
		System.out.println(ToStringBuilder.reflectionToString(XMLPopulater
				.eval(in, p)));
		
		
		Assert.assertEquals(fName, p.getFirstName());
		Assert.assertEquals(faxNbr, p.getFax()[0].getNumber());
		System.out.println("##########################");
	}

	@Test
	public void testResumeXML() throws Exception {
		final String fileName = "resume.xml";

		final String email = "Juanyong.zhang@gmail.com";
		final int count = 2;

		InputStream in = getResourceAsStreamFromPackage(Resume.class,
				fileName);

		Resume r = new Resume();

		System.out.println(ToStringBuilder.reflectionToString(XMLPopulater
				.eval(in, r)));

		Assert.assertEquals(email, r.getEmail());
		Assert.assertEquals(count, r.getProjectsSizeGt20().size());

		System.out.println("##########################");
	}
}
