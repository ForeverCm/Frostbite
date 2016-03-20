//方式一: 将响应事件定义在一个外部类中
import java.awt.*;
import javax.swing.*;

public class ActionEvent {
	public static void main(String args[]) {
		JFrame jf = new JFrame("ActionEvent");
		JButton jb = new JButton("click");

		//注册事件监听
		jb.addActionListener(new ButtonHandler());
		jf.getContentPane().add(jb, BorderLayout.CENTER);
		jf.pack();
		jf.setVisible(true);
	}
}

import java.awt.event.*;
public class ButtonHandler implements ActionListener {
	public void actionPerformed(ActionEvent e) {
		System.out.println("Take Action");
	}
}



//方式二: 匿名内部类和私有内部类的实现方式
import java.awt.*;
import java.awt.event.*;

public class ActionEvent {
	private Frame fr = new Frame("MyFrame");
	private Button bu = new Button("MyButton");
	
	public ActionEvent() {
		fr.setSize(400, 300);
		fr.pack();
		fr.setVisible(true);
		fr.add(bu);
		
		//注册事件监听
		fr.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent we)
			{
				System.exit(0);
			}
		});
	}
	
	fr.addActionListener(new ButtEvent());

	private class ButtEvent implements ActionListener {
		public void actionPerformed(ActionEvent ae) {
			bu.setLabel("YourButton");
		}
	}
	
	public static void main(String args[]) {
		new ActionEvent();
	}
}



//方式三: 将事件监听程序定义在组件代码中
import java.awt.*;
import java.awt.event.*;

public class ActionListener {
	public static void main(String args[]) {
		Frame fr = new Frame();
		Button mb = new MyButton();
		
		fr.add(mb); //AWT 直接调用 add() 方法, 没有 getContentPane() 方法
		fr.pack();
		fr.setVisible(true);
	}
}

public class MyButton {
	public MyButton(String text) {
		super(text);
		addActionListener(this);
	}
	
	public void actionPerformed(ActionEvent ae) {
		System.exit(0);
	}
}