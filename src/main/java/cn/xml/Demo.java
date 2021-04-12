package cn.xml;

import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Map;
import java.util.Set;

public class Demo {
    public static void main (String[] args) throws Exception {
        /*JSONObject jsonObject=new JSONObject();
        jsonObject.put("name","骚宁");
        jsonObject.put("age","24");
        String string = jsonObject.toString();
        String s = ParseFastjsonToXml.jsonToNoRootXml(string);
        Set<Map.Entry<String, Object>> entries = jsonObject.entrySet();
        System.out.println(s);*/

        StringBuffer sb=new StringBuffer();
        InputStreamReader inputStreamReader=new InputStreamReader(new FileInputStream("D:\\1234.txt"), Charset.forName("utf-8"));
//        BufferedReader bufferedReader=new BufferedReader(new FileReader("D:\\123.txt"));
        BufferedReader bufferedReader=new BufferedReader(inputStreamReader);
        String data =bufferedReader.readLine();
        while (data!=null){
            sb.append(data);
            data=bufferedReader.readLine();
        }
        bufferedReader.close();
        inputStreamReader.close();
        String string = sb.toString();
        System.out.println(string);
        String s = ParseFastjsonToXml.jsonToNoRootXml(string);
        System.out.println(s);
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(new FileOutputStream("D:\\4321.txt"),Charset.forName("utf-8"));
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        bufferedWriter.write(s);
        bufferedWriter.close();
        outputStreamWriter.close();
    }
}
