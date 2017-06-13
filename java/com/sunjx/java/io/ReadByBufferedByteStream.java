package com.sunjx.java.io;

import java.io.*;

/**
 * Created by jx on 2017/6/3.
 */
public class ReadByBufferedByteStream {
    public static void main(String[] args) {
        try {
            FileInputStream fis=new FileInputStream("src/main/java/com/sunjx/java/io/txt/movie.mp4");
            BufferedInputStream bis=new BufferedInputStream(fis);

            FileOutputStream fos=new FileOutputStream("src/main/java/com/sunjx/java/io/txt/movie_new.mp4");

            BufferedOutputStream bos=new BufferedOutputStream(fos);
            //大文件对应的数组大一些 小文件对应的数组小一些
            byte input[]=new byte[1024];
            int count=0;
            long before= System.currentTimeMillis();
            while(bis.read(input) != -1){
                count++;
                bos.write(input);

            }
            System.out.println((System.currentTimeMillis()-before)+"ms");
            bis.close();
            fis.close();
            bos.close();
            fos.close();
            System.out.println("读取了"+count+"次");


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        catch (IOException e) {
            e.printStackTrace();
        }

    };




}

