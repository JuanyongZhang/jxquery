package com.googlecode.jxquery.utils;

import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import net.sf.json.util.JSONUtils;

import org.apache.commons.lang.StringUtils;

/**
 * @Author : <a href="mailto:Juanyong.zhang@gmail.com">Juanyong.zhang</a>
 * @Date : Sep 28, 2011
 */
public class JSONHelper {
	public static String getSingleQuoteString(String orgJSON) {
		String json = null;

		if (JSONUtils.mayBeJSON(orgJSON)) {
			json = StringUtils.replace(orgJSON, JSONUtils.DOUBLE_QUOTE,
					JSONUtils.SINGLE_QUOTE);
		}

		return json;
	}

	public static JSONArray getJSONArrayFromSnippet(String jsonArray) {
		String json = null;
		if (JSONUtils.mayBeJSON(jsonArray)) {
			json = "{" + Constants.JSON_ARRAY + ":" + jsonArray + "}";
		}
		return JSONObject.fromObject(json).getJSONArray(Constants.JSON_ARRAY);
	}
}
