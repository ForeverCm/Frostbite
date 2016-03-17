/**
 * 方法区溢出：
 * 方法区用于存放类的相关信息，如：类名、访问修饰符、常量池、字段描述、方法描述等，在主流框架如：Spring、Mybatis 对类增强时，通过 CGLib(Code Generation Library) 动态生成大量
 * 的运行时类，直至溢出。方法区溢出也是一种常见的内存溢出异常，一个类如果要被垃圾收集器回收掉，判定条件是非常苛刻的，在经常动态生成大量 Class 的应用中，需要特别注意
 * 类的回收状况。
 *
 * 同理，把 -XX:PermSize=10M 和 —XX:MaxPermSize=10M 设置为一样的大小。
 */
 
public class MethodAreaOOM {
    static class OOMObject {
        
    }
  
    public static void main(String[] args) {
        while (true) {
            Enhancer en = new Enhancer();
            en.setSuperClass(OOMObject.class);
            en.setUseCache(false);
            en.setCallback(new MethodInterceptor() {
                public Object intercept() throws Throwable {
                    return proxy.invokeSuper(obj, args);                  
                }
            });
            en.create();
        }
    }
}

/**
 * Caused by: java.lang.OutOfMemoryError: PermGen space
 *  at java.lang.ClassLoader.defineClass1(Native Method)
 *  at java.lang.ClassLoader.defineClassCond(ClassLoader.java:632)
 *  at java.lang.ClassLoader.defineClass(ClassLoader.java.616)
 * ......
 */