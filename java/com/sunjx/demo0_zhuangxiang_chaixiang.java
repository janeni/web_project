package com.sunjx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by jx on 2017/5/23.
 */
public class demo0_zhuangxiang_chaixiang {

    public static void main(String[] args){
            Integer i =1; //装箱
            int j = i ;//拆箱

            //典型应用
            //装箱
            List list = new ArrayList();
            list.add(1);
            list.add(2);
            list.add(3);

            //拆箱
            Iterator it = list.iterator();
            while(it.hasNext()){
                int k = (Integer)it.next();
        }
    }
}
