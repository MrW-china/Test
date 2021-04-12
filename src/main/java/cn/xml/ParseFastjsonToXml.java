package cn.xml;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.Map;
import java.util.Set;

public class ParseFastjsonToXml {
    public static String jsonToNoRootXml (String json) {
        try {
            StringBuffer stringBuffer = new StringBuffer();
            stringBuffer.append("<?xml version=\"1.0\" encoding=\"utf-8\"?>");
            JSONObject jsonObject = JSON.parseObject(json);
            jsonToXmlStr(jsonObject, stringBuffer);
            return stringBuffer.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void jsonToXmlStr (JSONObject jsonObject, StringBuffer stringBuffer) {
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        for (Map.Entry<String, Object> entry : entries) {
            if ("com.alibaba.fastjson.JSONObject".equals(entry.getValue().getClass().getName())) {
                stringBuffer.append("<").append(entry.getKey()).append(">");
                JSONObject jsonObject1 = jsonObject.getJSONObject(entry.getKey());
                jsonToXmlStr(jsonObject1, stringBuffer);
                stringBuffer.append("</").append(entry.getKey()).append(">");
            } else if ("com.alibaba.fastjson.JSONArray".equals(entry.getValue().getClass().getName())) {
                JSONArray jsonArray = jsonObject.getJSONArray(entry.getKey());
                for (int i = 0; i < jsonArray.size(); i++) {
                    stringBuffer.append("<").append(entry.getKey()).append(">");
                    JSONObject jsonObject1 = jsonArray.getJSONObject(i);
                    jsonToXmlStr(jsonObject1, stringBuffer);
                    stringBuffer.append("</").append(entry.getKey()).append(">");
                }
            }else if ("java.lang.String".equals(entry.getValue().getClass().getName())){
                stringBuffer.append("<").append(entry.getKey()).append(">").append(entry.getValue());
                stringBuffer.append("</").append(entry.getKey()).append(">");

            }
        }
    }
}
