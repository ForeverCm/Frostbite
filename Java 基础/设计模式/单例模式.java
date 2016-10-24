//懒汉式
public class Singleton {
	private static Singleton instance = null;

	//私有构造函数
	private Singleton() {

	}

	public static synchronized getInstance() {
		if (instance == null) 
			instance = new Singleton();

		return instance;
	}
}



//饿汉式
public class Singleton {
	private static final Singleton instance = new Singleton();

	private Singleton() {

	}

	public static Singleton getInstance() {
		return instance;
	}
}