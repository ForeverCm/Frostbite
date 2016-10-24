//抽象工厂
public abstract class AbstractFactory {
	public abstract Vehicle create();
	public abstract Weapon create();
	public abstract Food create();
}

//工厂
public class Factory extends AbstractFactory {
	@Override
	public Vehicle create() {
		return new RangeRover();
	}

	@Override
	public Weapon create() {
		return new AK47();
	}

	@Override 
	public Food create() {
		return new Apple();
	}
}

//测试
public class Test {
	public static void main(String[] args) {
		AbstractFactory abf = new Factory();
		
		//产品一
		Vehicle v = abf.create();
		v.run();

		//产品二
		Weapon w = abf.create();
		w.fire();

		//产品三
		Food f = abf.create();
		f.price();
	}
}