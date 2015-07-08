
<p>
	jxQuery is for parsing JSON, XML format contents, which is using
	xquery(<a href="http://www.w3.org/TR/xquery/" rel="nofollow">http://www.w3.org/TR/xquery/</a>)
	to access both XML, and JSON.
</p>
<p>Highlights:</p>
<ul>
	<li>Support JSON and XML format content</li>
	<li>Support full syntax of xquery <a
		href="http://www.w3.org/TR/xquery/" rel="nofollow">http://www.w3.org/TR/xquery/</a>,
		like /node[@attr&gt;20]/subNode
	</li>
	<li>Implementation of FieldCreator<a
		href="/p/jxquery/w/edit/FieldCreator">?</a> could create value object
		on demand, input will be either org.w3c.dom.Node or
		org.w3c.dom.NodeList<a href="/p/jxquery/w/edit/NodeList">?</a></li>
</ul>
<p></p>
<p>Dependencies:</p>
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
<p></p>
<h2>
	<a name="Usage_-_MAVEN"></a>Usage - MAVEN<a href="#Usage_-_MAVEN"
		class="section_anchor"></a>
</h2>
<p>
	<a href="https://oss.sonatype.org/#nexus-search;quick~jxquery"
		rel="nofollow">https://oss.sonatype.org/#nexus-search;quick~jxquery</a>
</p>
<pre class="prettyprint">
		<span class="tag">&lt;dependencies&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ..........<br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span
		class="tag">&lt;dependency&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span
		class="tag">&lt;groupId&gt;</span><span class="pln">com.googlecode.jxquery</span><span
		class="tag">&lt;/groupId&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span
		class="tag">&lt;artifactId&gt;</span><span class="pln">jxquery</span><span
		class="tag">&lt;/artifactId&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span
		class="tag">&lt;version&gt;</span><span class="pln">1.0.0</span><span
		class="tag">&lt;/version&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; &nbsp; </span><span
		class="tag">&lt;/dependency&gt;</span><span class="pln"><br>&nbsp; &nbsp; &nbsp; &nbsp; &nbsp; ..........<br></span><span
		class="tag">&lt;/dependencies&gt;</span>
	</pre>
<h2>
	<a name="Usage_-_JSON"></a>Usage - JSON<a href="#Usage_-_JSON"
		class="section_anchor"></a>
</h2>
<pre class="prettyprint">
		<span class="typ">InputStream</span><span class="pln"> </span><span
		class="kwd">in</span><span class="pln"> </span><span class="pun">=</span><span
		class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span
		class="typ">FileInputStream</span><span class="pun">(</span><span
		class="kwd">new</span><span class="pln"> </span><span class="typ">File</span><span
		class="pun">(</span><span class="str">"xxx.JSON"</span><span
		class="pun">));</span><span class="pln"><br></span><span
		class="typ">PersonInfo</span><span class="pln"> p </span><span
		class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span
		class="pln"> </span><span class="typ">PersonInfo</span><span
		class="pun">();</span><span class="pln"><br></span><span
		class="typ">JSONPopulater</span><span class="pun">.</span><span
		class="kwd">eval</span><span class="pun">(</span><span class="kwd">in</span><span
		class="pun">,</span><span class="pln"> p</span><span class="pun">);</span>
	</pre>
<h2>
	<a name="Usage_-_XML"></a>Usage - XML<a href="#Usage_-_XML"
		class="section_anchor"></a>
</h2>
<pre class="prettyprint">
		<span class="typ">InputStream</span><span class="pln"> </span><span
		class="kwd">in</span><span class="pln"> </span><span class="pun">=</span><span
		class="pln"> </span><span class="kwd">new</span><span class="pln"> </span><span
		class="typ">FileInputStream</span><span class="pun">(</span><span
		class="kwd">new</span><span class="pln"> </span><span class="typ">File</span><span
		class="pun">(</span><span class="str">"xxx.XML"</span><span
		class="pun">));</span><span class="pln"><br></span><span
		class="typ">PersonInfo</span><span class="pln"> p </span><span
		class="pun">=</span><span class="pln"> </span><span class="kwd">new</span><span
		class="pln"> </span><span class="typ">PersonInfo</span><span
		class="pun">();</span><span class="pln"><br></span><span
		class="typ">XMLPopulater</span><span class="pun">.</span><span
		class="kwd">eval</span><span class="pun">(</span><span class="kwd">in</span><span
		class="pun">,</span><span class="pln"> p</span><span class="pun">);</span>
	</pre>
<h2>
	<a name="Usage_-_Annotation_Query"></a>Usage - Annotation Query<a
		href="#Usage_-_Annotation_Query" class="section_anchor"></a>
</h2>
<p>
	<strong>note: below annotation name @XQueryField changed to
		@jxQuery </strong>
</p>
<p>
	<img
		src="https://lh6.googleusercontent.com/-5MosW9hgZ98/TojzcHEddaI/AAAAAAAAAGk/Cvv2Q_PVg14/s912/jxquery1.png">
</p>
<p>
	1. /firstName query from node<br> <br> 2. Creator indicates
	the implementation of FieldCreator<a
		href="/p/jxquery/w/edit/FieldCreator">?</a> to field custom field
	value, See. jxquery.google.creator.FieldCreator<a
		href="/p/jxquery/w/edit/FieldCreator">?</a><br> <br> 3.
	Array type maps to the JSON array<br> <br> 4.
	[@type=’fax’] selects the fax type phoneNumber from the array<br>
	<br> 5. Address is a custom type<br> <br> 6. Notice that
	phoneNumberJSON, for JSONPopulate it is capable to populate a
	org.json.JSONObject as its JSON String, which can address the need of
	mutant objects
</p>
<p>
	<img
		src="https://lh3.googleusercontent.com/-nPwJbCXlVyI/TojzcoaEYVI/AAAAAAAAAGo/-7Ayac0yxPU/s912/jxquery2.png">
</p>
<p>
	1. /firstName query from node<br> <br> 2. Creator indicates
	the implementation of FieldCreator<a
		href="/p/jxquery/w/edit/FieldCreator">?</a> to field custom field
	value, See. jxquery.google.creator.FieldCreator<a
		href="/p/jxquery/w/edit/FieldCreator">?</a><br> <br> 3.
	Array type maps to the JSON array<br> <br> 4.
	[@type=’fax’] selects the fax type phoneNumber from the array<br>
	<br> 5. Address is a custom type<br> <br>
</p>
<p>
	<img
		src="https://lh4.googleusercontent.com/-50OazY907vM/Tojzcw8wWSI/AAAAAAAAAGs/R4gn6vaI6BA/s912/jxquery3.png">
</p>
<p>
	1. [@type=’home’] selects the home type phoneNumber from the array<br>
	<br> 2. /skills selects the string array from JSON<br> <br>
	3. [@teamMbrCnt&gt;=20] selects the project with team member count
	greater than 20<br> <br> 4. Project is a custom type<br>
	<br>
</p>
