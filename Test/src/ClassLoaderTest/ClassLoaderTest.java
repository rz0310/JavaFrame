package ClassLoaderTest;

public class ClassLoaderTest {
    public static void main(String[] args) {
        ClassLoader c1 = ClassLoaderTest.class.getClassLoader();
        System.out.println(c1);
        ClassLoader c1Parent = c1.getParent();
        System.out.println(c1Parent);
        ClassLoader c1Root = c1Parent.getParent();
        System.out.println(c1Root);
    }
}
