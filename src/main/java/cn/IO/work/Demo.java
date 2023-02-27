package cn.IO.work;


import java.io.*;

/*
 * 文件替换数据
 *
 * */
public class Demo {
    public static void main(String[] args) {
        try {
            //FileReader fileReader =new FileReader("D:\\20221026statement.txt");
            FileInputStream fileInputStream = new FileInputStream("D:\\" +
                    "20230218_11_IPTVPayFee_9900_0001.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "GB2312");
            BufferedReader br = new BufferedReader(inputStreamReader);
            File file = new File("D:\\1.txt");
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
