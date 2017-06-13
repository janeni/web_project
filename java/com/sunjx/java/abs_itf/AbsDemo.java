package com.sunjx.java.abs_itf;

/**
 * Created by jx on 2017/6/10.
 */

/**
 * 拥有抽象方法的类就是抽象
 * 抽象类不能被直接实例化
 */
abstract class Abs{
    private int age;
    public void tell(){
    }
    //抽象方法
    public abstract void say();

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}

class Abs1 extends Abs{
    /**
     * 继承自抽象类的子类必须重写其所有的抽象方法
     */
    @Override
    public void say() {
        System.out.println(this.getAge());

    }
}
public class AbsDemo {
    public static void main(String[] args) {
        //抽象类不能被直接实例化
      //  Abs a = new Abs();
        Abs1 b = new Abs1();
        b.setAge(20);
        b.say();

    }

}
