package ClassLoaderTest;

public class Test1 {
    public static void main(String[] args) {
        System.out.println(Test1.class.getClassLoader());
        Test2 test2 = new Test2();
        test2.test();
    }
}
