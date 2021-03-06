事件处理是图形界面和用户进行交互的重要组成部分, Java 中的事件处理机制包括: 事件源, 事件和事件处理器三个部分.

1>事件监听器(Listener): 
	<常用事件监听器>
    ActionListener：接收操作事件的监听器接口。
    AdjustmentListener：接收调整事件的监听器接口。
    FocusListener：接收组件上的键盘焦点事件的监听器接口。
    InputMethodListener：接收输入方法事件的监听接口。
    KeyListener：用于接收键盘事件的监听接口。
    MouseListener：接收组件上的鼠标事件(包括按下、单击、进入或者离开)的监听器接口。
    MouseMotionListener：接收组件上的鼠标移动事件的监听接口。
    MouseWheelListener：接收组件上的鼠标滚轮事件的监听接口。
    TextListener：接收文本事件的监听器接口。
    WindowListener：接收窗口事件的监听接口。

2>事件适配器(Adapter):
	上文介绍了事件监听器都是以实现事件监听器的接口方式进行定义的, 而实现接口, 就必须实现接口中的所有方法.Java 中针对每个事件监听器的接口, 系统的定义了相应的实现类, 并称之为事件适配器(Adapter). 这样一来就只需继承事件适配器并覆盖几个必要的方法就可以了
	
	<常用事件适配器>
    ComponentAdapter：接收组件事件的抽象适配器。
    ContainerAdapter：接收容器事件的抽象适配器。
    FocusAdapter：接收键盘焦点事件的抽象适配器。
    KeyAdapter：接收键盘事件的抽象适配器。
    MouseAdapter：接收鼠标事件的抽象适配器类。
    MouseMotinAdapter：接收鼠标移动事件的抽象适配器类。
    WindowAdapter：接收窗口事件的抽象适配器类。
	
3>事件:
	事件就是触发一个组件产生的动作, 在 Swing 中有很多的事件, 如: 鼠标事件, 焦点事件, 每一个事件类都会与一个相应的接口对应, 并由事件所引起的动作都会存放在接口需要实现的方法中。
	1)鼠标事件
	2)键盘事件
	3)焦点事件: 鼠标单击到某一个按钮上的图片时, 这个按钮就获得了焦点。	
	例如:鼠标单击窗口的标题栏，就说明这个标题栏获得了焦点。单击这个窗口中的任意一个组件时，这个组件就获得了焦点。并且不同的组件获得焦点后的显示是不同的，例如在文本框获取到焦点时，鼠标的光标就会不停的闪动。一个窗口中的组件，在同一时间只能够有一个组件获得焦点。如果单击了另一个组件，此时该组件就会失去焦点。
		在Java 中与焦点相关的方法如下:
		1--FocusOwner: 焦点拥有者, 即持有焦点的组件.
		2--FocusWindow: 焦点窗口, 即含有焦点拥有者的窗口.
		3--ActiveWindow: 活动窗口, 包含焦点的框架或者对话框.
		除去弹出对话框外, 大部分情况下焦点窗口和活动窗口是一个窗口, 因为弹出对话框不是放置在一个窗体中的组件获取焦点,所以它的焦点窗口和活动窗口不是同一个.