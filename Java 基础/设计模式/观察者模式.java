//抽象观察者
public interface Watcher {
	public void update(String str);
}

//抽象主题角色（被观察者）
public interface Watched {
	public void addWatcher(Watcher watcher);

	public void removeWatcher(Watcher watcher);

	public void notifyWatchers(String str);
}

//观察者
public class ConcreteWatcher implements Watcher {
	@Override 
	public void update(String str) {
		System.out.println(str);
	}
}

//主题角色
public class ConcreteWatched implements Watched {
	private List<Watcher> list = new ArrayList<>();

	@Override
	public void addWatcher(Watcher watcher) {
		list.add(watcher);
	}

	@Override
	public void removeWatcher(Watcher watcher) {
		list.remove(watcher);
	}

	@Override
	public void notifyWatchers(String str) {
		for (Watcher watcher : list) {
			watcher.update(str);
		}
	}
}



//测试
public class Test {
	public static void main(String[] args) {
		Watched girl = new ConcreteWatched();

		Watcher boy1 = new ConcreteWatcher();
		Watcher boy2 = new ConcreteWatcher();
		Watched boy3 = new ConcreteWatcher();

		//注册
		girl.addWatcher(boy1);
		girl.addWatcher(boy2);
		girl.addWatcher(boy3);

		girl.notifyWatchers("我美不美？");
	}
}