package com.sunjx;

import org.junit.jupiter.api.Test;

import java.util.*;

/**
 * Created by jx on 2017/5/23.
 */
public class demo1_zengqiang_for {


    public void test1(){
        //增强for循环
        int arr[]={1,2,3};
        for( int i:arr){
            System.out.println(i);
        }
    }

    public void test2(){
        List list=new ArrayList();
        list.add(3);
        list.add(4);
        list.add(5);
        for (Object item:list){
            int i = (Integer)item;
            System.out.print(i);
        }
    }
    public void test3(){
        Map map = new HashMap();
        map.put("1","aaa");
        map.put("2","bbb");
        map.put("3","ccc");


        Set set = map.keySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
           String key=(String) iterator.next();
            System.out.println(key +" = "+(String)map.get(key));
        }


    }
    public void test4(){
        Map map = new HashMap();
        map.put("1","aaa");
        map.put("2","bbb");
        map.put("3","ccc");


       Set set= map.entrySet();
       Iterator iterator = set.iterator();
       while(iterator.hasNext()){
          Map.Entry entry=(Map.Entry) iterator.next();
           System.out.println("key: "+entry.getKey()+"  value: "+entry.getValue());

       }


    }
    public void test5(){
        Map map = new HashMap();
        map.put("1","aaa");
        map.put("2","bbb");
        map.put("3","ccc");

      /*  for (Object set:map.entrySet()) {
            Set s=(Set)set;
            System.out.println("key: "+s.getKey()+"  value: "+entry.getValue());


        }*/


        Set set= map.entrySet();
        Iterator iterator = set.iterator();
        while(iterator.hasNext()){
            Map.Entry entry=(Map.Entry) iterator.next();
            System.out.println("key: "+entry.getKey()+"  value: "+entry.getValue());

        }


    }


}
