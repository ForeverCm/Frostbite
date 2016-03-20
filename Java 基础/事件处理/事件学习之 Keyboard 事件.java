/*
* 键盘事件: 
* 键盘事件用于处理在键盘上所输入的信息. 
* KeyEvent 类不仅可以获取到产生键盘事件的事件源, 而且还可以获取到键盘输入按键的信息.
*/

import java.awt.Container;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class LocalTest extends KeyAdapter implements ActionListener {
	JFrame jFrame = null;
	JLabel jLabel = null;
	JTextField jTextField = null;
	String key = "";
	
	public LocalTest() {
		jFrame = new JFrame("键盘监听示例"); //创建窗口
		Container contentPane = jFrame.getContentPane();
		contentPane.setLayout(new GridLayout(3, 1));
		
		jLabel = new JLabel();
		jTextField = new JTextField();
		jTextField.requestFocus(); //获取焦点
		//为 TextField 添加事件监听器
		jTextField.addKeyListener(this);
		
		JButton jButton = new JButton();
		//为 Button 添加事件监听器
		jButton.addActionListener(this);
		
		contentPane.add(jLabel);
		contentPane.add(jTextField);
		contentPane.add(jButton);
		
		jFrame.setSize(500, 400);
		jFrame.setVisible(true);
		jFrame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
	}
		
	//响应 Button 事件
	public void actionPerformed(ActionEvent e) {
		key = "";
		jLabel.setText(""); //将 Label 要显示的字符串重置为空
		jTextField.setText(""); //将 TextField 要显示的字符串重置为空
		jTextField.requestFocus(); //获取焦点
	}
	
	public void keyTyped(KeyEvent e) {
		char c = e.getKeyChar(); //获取键盘输入的文本字符串
		if (c == 'n') {
			/** 若输入字符串0, 就会弹出新的窗口 **/
			JFrame jFrameNew = new JFrame("这是一个新的窗口");
			jFrameNew.setSize(200, 200);
			jFrameNew.setVisible(true);
		}
		key = key + c;
		jLabel.setText(key); //设置 Label 将要显示的字符串
	}
	
	public static void main(String[] args) {
		new LocalTest();
	}
}