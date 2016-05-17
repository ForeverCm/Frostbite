/**
 * 死锁: 哲学家就餐问题!
 *
 * 布尔变量: true 表示吃饭! false 表示思考!
 */

private boolean state;

public synchronized void eating() {
	if (!state) {
		if (chopstickArray.getRight(id).isAvailable()) { //右手边筷子可用
			if (chopstickArray.getLeft(id).isAvailable()) { //左手边筷子可用

				//设置筷子不可用
				chopstickArray.getRight(id).setAvailable(false);
				chopstickArray.getleft(id).setAvailable(false);

				try {
					Thread.sleep(1000); //设置吃饭时间为 1 秒
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} else {
				try {
					wait(new Random().nextInt(100)); //小于 0.1 秒时间内检查筷子是否可用
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			} 
		} else {
			try {
				wait(new Random().nextInt(100)); //小于 0.1 秒时间内检查筷子是否可用
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	state = true;
}
//总结: 本例难在如何解决死锁问题, 即如果 5 个哲学家都在等待别人的筷子, 程序就会进入死锁状态!
//当遇到比较复杂的问题时, 通常利用面向对象的思想将问题分割.
//如: 本例可以分割成筷子和哲学家两种对象, 每个对象只关心自己的状态, 不考虑与其他对象的交互, 问题就会变得简单明了!!