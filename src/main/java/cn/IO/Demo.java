package cn.IO;


import java.io.*;

/*
 * 文件替换数据
 *
 * */
public class Demo {
    public static void main(String[] args) {
        try {

            //FileReader fileReader =new FileReader("D:\\20221026statement.txt");
            FileInputStream fileInputStream = new FileInputStream("C:\\Users\\10489\\Desktop\\vac\\对账\\20221107" +
                    "\\20221108statement.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GB2312");
            BufferedReader br = new BufferedReader(inputStreamReader);
            File file = new File("C:\\Users\\10489\\Desktop\\vac\\对账\\1.txt");
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            String line = "";
            while ((line = br.readLine()) != null) {
                if (line.indexOf("IPTV") != -1) {
                    continue;
                }
                bufferedWriter.write(line);
                bufferedWriter.newLine();
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
