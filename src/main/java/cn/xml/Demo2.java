package cn.xml;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;

public class Demo2 {
    public static void main (String[] args) throws Exception {
        BufferedReader bf=new BufferedReader(new FileReader("D:\\4321.txt"));
        String s = bf.readLine();
        StringBuilder sb=new StringBuilder();
        while(s!=null){
            sb.append(s);
            s=bf.readLine();
        }
        String s1 = ParseUtil.xml2Json(sb.toString());
        System.out.println(s1);
    }
}
