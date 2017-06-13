package com.sunjx.java.io;

import javax.xml.bind.SchemaOutputResolver;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by jx on 2017/6/3.
 */
public class ReadByteStream {

    public static void main(String[] args) {
        try {
            //输出字节流
            FileInputStream fis=new FileInputStream("src/main/java/com/sunjx/java/io/txt/text.txt");
            byte input[]=new byte[1024];
            fis.read(input);
            String inputString=new String(input);
            System.out.println(inputString);

            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
