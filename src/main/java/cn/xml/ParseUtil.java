package cn.xml;

import com.alibaba.fastjson.JSONObject;
import org.json.XML;

public class ParseUtil {
    public static String xml2Json(String xml) throws Exception{
        org.json.JSONObject jsonObject= XML.toJSONObject(xml);
        return jsonObject.toString();
    }
}
