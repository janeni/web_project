package com.sunjx.java.io;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by jx on 2017/6/4.
 */
public class TestRWCharStream {
    public static void main(String[] args) {
        try {
            File file=new File("src/main/java/com/sunjx/java/io/txt/java.txt");
            FileInputStream fis = new FileInputStream(file);
            InputStreamReader isr=new InputStreamReader(fis,"UTF-8");
            char c[]=new char[1024];
            while(isr.read(c)!=-1){
                System.out.println(c);
            }

            isr.close();
            fis.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
