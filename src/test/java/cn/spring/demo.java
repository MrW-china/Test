package cn.spring;

import java.io.UnsupportedEncodingException;

public class demo {
    public static void main (String[] args) throws UnsupportedEncodingException {
        String s="sddf";
        byte[] bytes = s.getBytes();
        System.out.println(bytes);
        String ss=new String(bytes,"UTF-8");
        System.out.println(ss);
    }
}
