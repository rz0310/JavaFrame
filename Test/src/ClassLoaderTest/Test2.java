package ClassLoaderTest;

public class Test2 {
    public void test(){
        System.out.println(Test2.class);
        System.out.println(this.getClass());
        System.out.println(Test2.class.getClassLoader());
    }
}
