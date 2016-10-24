//抽象产品角色
public interface Moveable {
	void run();
}

//具体产品角色
public class Plane implements Moveable {
	@Override
	public void run() {
		System.out.println("飞机飞起来了！");
	}
}

public class Car implements Moveable {
	@Override
	public void run() {
		System.out.println("汽车开起来了！");
	}
}

//抽象工厂
public abstract class Factory {
	abstract Moveable create();
}

//工厂
public class PlaneFactory extends Factory {
	public Moveable create() {
		return new Plane();
	}
}

public class CarFactory extends Factory {
	public Moveable create() {
		return new Car();
	}
}

//测试
public class Test {
	public static void main(String[] args) {
		Factory fac = new CarFactory();
		Moveable car = fac.create();
		car.run();
	}
}