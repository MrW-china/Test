package cn.xml;

import com.alibaba.fastjson.JSONObject;
import org.apache.http.client.methods.HttpPost;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class test {
    public static void main (String[] args) {
        String a ="一起";
        String b= "审单";
        System.out.println(a.hashCode());
        System.out.println(b.hashCode());

    }

}
