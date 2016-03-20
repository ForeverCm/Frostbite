/**
 *鼠标事件: MouseEvent, 
 * 鼠标监听器: MouseListener 和 MouseMotionListener.
 *
 * MouseListener:负责鼠标的按下/抬起/进入某一区域.当组件注册了鼠标监听器后,如果组件发生以上的动作事件后,就会激活相应的事件处理方法. 
 *
 * MouseMotionListener:主要负责鼠标的拖动事件处理.当用户注册了MouseMotionListener的组件上拖动鼠标时,就会激活mouseDragged(MouseEvent e)方法, 如果用户此时没有按下鼠标而是移动鼠标时, 就会激活 mouseMoved(MouseEvent e)方法.
 */

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class MouseTest extends WindowAdapter implements MouseListener {
	JFrame jFrame = null;
	JButton jButton1 = null;
	JLabel jLabel = null;
	
	public MouseTest() {
		jFrame = new JFrame("鼠标事件范例"); //创建窗口
		
		Container contentPane = jFrame.getContentPane(); //获取容器
		contentPane.setLayout(new GridLayout(2, 1)); //设置布局方式
		
		jButton1 = new JButton("按钮"); //创建按钮
		jLabel = new JLabel("初始状态, 还没有鼠标事件", JLabel.CENTER); //创建文本标签
		
		jButton1.addMouseListener(this); //为按钮添加事件监听
		
		contentPane.add(jLabel);
		contentPane.add(jButton1);
		
		jFrame.pack(); //将窗口调整到适当大小
		jFrame.setVisible(true);
		
		jFrame.addWindowListener(this); //为窗口添加事件监听器
	}
	
	public void mousePressed(MouseEvent e) { 
		jLabel.setText("您已按下鼠标"); 
	}
	
	//鼠标释放事件
	public void mouseReleased(MouseEvent e) {
		jLabel.setText("您已松开鼠标");
	}
	
	//鼠标进入事件
	//鼠标光标进入组件几何形状的未遮掩部分时产生的 mouseEntered 事件
	public void mouseEntered(MouseEvent e) {
		jLabel.setText("光标已经进入按钮");
	}
	
	//鼠标离开事件
	//鼠标光标离开组件几何形状的未遮掩部分时产生的 mouseExited
	public void mouseExited(MouseEvent e) {
		jLabel.setText("光标已经离开按钮");
	}
	
	public void mouseClicked(MouseEvent e) {
		jLabel.setText("您单击了按钮");
	}
	
	public void windowClosing(WindowEvent e) {
		System.exit(0);
	}
	
	public static void main(String[] args) {
		new MouseTest();
	}
}