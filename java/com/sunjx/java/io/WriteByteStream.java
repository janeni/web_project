package com.sunjx.java.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jx on 2017/6/3.
 */
public class WriteByteStream {
    public static void main(String[] args) {
        //字节输出流
        try {
            FileOutputStream fos=new FileOutputStream("src/main/java/com/sunjx/java/io/txt/textfileoutstream.txt");
            String outString="write 123456写出中文";
            fos.write(outString.getBytes("UTF-8"));//文本、视频、音乐转变为字节数组

            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }finally {

        }


    }

}
