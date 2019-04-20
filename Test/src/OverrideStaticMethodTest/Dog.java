package OverrideStaticMethodTest;

public class Dog extends Animal {

    public static void walk(){
        System.out.println("狗行走");
    }

    public static void main(String[] args) {
        new Dog().walk();
    }
}
