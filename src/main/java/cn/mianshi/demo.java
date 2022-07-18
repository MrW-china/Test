package cn.mianshi;

import java.util.ArrayList;
import java.util.HashMap;

public class demo {
    public static void main(String[] args) {
        ArrayList<String> stringList = new ArrayList<>();
        stringList.add("变速器类型:自动 变速器型号:AT8(DP2) 保养加注量:4 变速器规格：Esso LT 71141 *以上信息均为参考值不代表同实车完全一致，为了避免损失，具体换油前请核对实车变速器类型！");
        stringList.add("变速器类型:手动 保养加注量:1.6-1.7 变速器规格:80W-90(北方夏季):75W-90(北方冬季);80W-90或80W-140(南方全年) *以上信息均为参考值不代表同实车完全一致，为了避免损失，具体换油前请核对实车变速器类型！");
        String s = stringList.get(0);
        String[] s1 = s.split(" ");
        String s2 = stringList.get(1);
        String[] s3 = s2.split(" ");
        for (int i = s1.length - 1; i >= 0; i--) {
            if (!(s1[i].contains(":") || s1[i].contains("：")) && (!s1[i].contains("*"))) {
                s1[i - 1] = s1[i - 1] + " " + s1[i];
                s1[i] = " ";
            }
        }
        for (int i = 0; i < s1.length; i++) {
            /*if (s1[i].contains(":") || s1[i].contains("：")) {
                String str=new String(s1[i]);
                s1[i].replace(':','=');
                System.out.println(s1[i]);
            }*/
            if (s1[i].contains(":")) {
                String[] split = s1[i].split(":");
                if (split.length > 2) {
                    for (int j = 1; j < split.length - 1; j++) {
                        split[1] += split[j + 1];
                    }
                }
                System.out.println(split[0] + "=" + split[1]);
            }
            if (s1[i].contains("：")) {
                String[] split = s1[i].split("：");
                if (split.length > 2) {
                    for (int j = 1; j < split.length - 1; j++) {
                        split[1] += split[j + 1];
                    }
                }
                System.out.println(split[0] + "=" + split[1]);
            }
        }
        for (int i = 0; i < s3.length; i++) {
            /*if (s3[i].contains(":") || s3[i].contains("：")) {
                System.out.println(s3[i]);
            }*/
            if (s3[i].contains(":")) {
                String[] split = s3[i].split(":");
                if (split.length > 2) {
                    for (int j = 1; j < split.length - 1; j++) {
                        split[1] += split[j + 1];
                    }
                }
                System.out.println(split[0] + "=" + split[1]);
            }
            if (s3[i].contains("：")) {
                String[] split = s3[i].split("：");
                if (split.length > 2) {
                    for (int j = 1; j < split.length - 1; j++) {
                        split[1] += split[j + 1];
                    }
                }
                System.out.println(split[0] + "=" + split[1]);
            }
        }
    }
}
