jxQuery is for parsing JSON, XML format contents, which is using xquery(http://www.w3.org/TR/xquery/) to access both XML, and JSON.

Highlights:
<ul>
<li>Support JSON and XML format content</li>
<li>Support full syntax of xquery <a href='http://www.w3.org/TR/xquery/'>http://www.w3.org/TR/xquery/</a>, like /node[@attr>20]/subNode</li>
<li>Implementation of FieldCreator could create value object on demand, input will be either org.w3c.dom.Node or org.w3c.dom.NodeList</li>
</ul>

Dependencies:
<ul>
<li>commons-beanutils-1.8.3.jar</li>
<li>commons-logging-1.1.1.jar</li>
<li>commons-collections-3.2.1.jar</li>
<li>commons-lang-2.5.jar</li>
<li>commons-io-2.0.1.jar</li>
<li>json-lib-2.4-jdk15.jar</li>
<li>log4j-1.2.9.jar</li>
<li>ezmorph-1.0.6.jar</li>
</ul>
## Usage - MAVEN ##
https://oss.sonatype.org/#nexus-search;quick~jxquery
```
<dependencies>
          ..........
		<dependency>
			<groupId>com.googlecode.jxquery</groupId>
			<artifactId>jxquery</artifactId>
			<version>1.0.0</version>
		</dependency>
          ..........
</dependencies>
```
## Usage - JSON ##
```
InputStream in = new FileInputStream(new File("xxx.JSON"));
PersonInfo p = new PersonInfo();
JSONPopulater.eval(in, p);
```
## Usage - XML ##
```
InputStream in = new FileInputStream(new File("xxx.XML"));
PersonInfo p = new PersonInfo();
XMLPopulater.eval(in, p);
```
## Usage - Annotation Query ##

**note: below annotation name @XQueryField changed to @jxQuery**

![https://lh6.googleusercontent.com/-5MosW9hgZ98/TojzcHEddaI/AAAAAAAAAGk/Cvv2Q_PVg14/s912/jxquery1.png](https://lh6.googleusercontent.com/-5MosW9hgZ98/TojzcHEddaI/AAAAAAAAAGk/Cvv2Q_PVg14/s912/jxquery1.png)

1. /firstName query from node<br />
2. Creator indicates the implementation of FieldCreator to field custom field value, See. jxquery.google.creator.FieldCreator<br />
3. Array type maps to the JSON array<br />
4. [@type=’fax’] selects the fax type phoneNumber from the array<br />
5. Address is a custom type<br />
6. Notice that phoneNumberJSON, for JSONPopulate it is capable to populate a org.json.JSONObject as its JSON String, which can address the need of mutant objects


![https://lh3.googleusercontent.com/-nPwJbCXlVyI/TojzcoaEYVI/AAAAAAAAAGo/-7Ayac0yxPU/s912/jxquery2.png](https://lh3.googleusercontent.com/-nPwJbCXlVyI/TojzcoaEYVI/AAAAAAAAAGo/-7Ayac0yxPU/s912/jxquery2.png)

1. /firstName query from node<br />
2. Creator indicates the implementation of FieldCreator to field custom field value, See. jxquery.google.creator.FieldCreator<br />
3. Array type maps to the JSON array<br />
4. [@type=’fax’] selects the fax type phoneNumber from the array<br />
5. Address is a custom type<br />


![https://lh4.googleusercontent.com/-50OazY907vM/Tojzcw8wWSI/AAAAAAAAAGs/R4gn6vaI6BA/s912/jxquery3.png](https://lh4.googleusercontent.com/-50OazY907vM/Tojzcw8wWSI/AAAAAAAAAGs/R4gn6vaI6BA/s912/jxquery3.png)

1. [@type=’home’] selects the home type phoneNumber from the array<br />
2. /skills selects the string array from JSON<br />
3. [@teamMbrCnt>=20] selects the project with team member count greater than 20<br />
4. Project is a custom type<br />