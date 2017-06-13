package com.sunjx.java.abs_itf;

/**
 * Created by jx on 2017/6/10.
 */
interface Inter1{
    public static final int AGE=100;
    public abstract  void tell();

}
interface  Inter2{
    public abstract void say();
}
interface Inter3 extends Inter2,Inter1{

}
abstract class Abss1{
    public abstract void print();
}
class A extends Abss1 implements Inter1,Inter2 {
    @Override
    public void tell() {
        System.out.println(this.AGE);
    }

    public void say() {

    }
    public void print(){
        System.out.println("print:"+this.AGE);
    }
}


public class InterDemo {
    public static void main(String[] args) {
        Inter1 i=new Inter1() {
            @Override
            public void tell() {
                System.out.println("Inter.tell()");
            }
        };
        i.tell();
        A a =  new A();
        a.tell();
        System.out.println(a.AGE);
        System.out.println(Inter1.AGE);
        a.print();
    }
}
