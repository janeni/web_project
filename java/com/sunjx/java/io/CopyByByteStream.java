package com.sunjx.java.io;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by jx on 2017/6/3.
 */
public class CopyByByteStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis= new FileInputStream("src/main/java/com/sunjx/java/io/txt/ic_wrong.png");
            byte inputStream[]=new byte[1024];


            FileOutputStream fos=new FileOutputStream("src/main/java/com/sunjx/java/io/txt/ic_wrongnew.png");
            while (fis.read(inputStream)!=-1){
                fos.write(inputStream);
            }
            System.out.println("done");
            fis.close();
            fos.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
