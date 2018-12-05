package com.youyuan.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.youyuan.util.Constant;
import com.youyuan.util.GameUtil;
import com.youyuan.util.MyFrame;
//import com.youyuan.util.MyFrame.PaintThread;

public class PlaneGameFrame2 extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane2 p = new Plane2("images/plane.png",150,50);
	
	
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
	}	
	public static void main(String[] args) {
		new PlaneGameFrame2().launchFrame();
	}
	//重写launchFrame方法
	public void launchFrame() {	
		/**
		 * 写完监听后，需要窗口加载代码
		 * 第一种方法，直接copy过来
		 */
//		addWindowListener(new WindowAdapter() {
//			@Override
//			public void windowClosing(WindowEvent e) {
//				System.exit(0);
//			}
//		});
//		addKeyListener(new KeyMonitor());
//		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//设置窗口长宽
//		setLocation(400,400);//设置起点坐标
//		setVisible(true);
//		
//		new PaintThread().run();//启动重画线程
		
		
		//第二种方法，super
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());//在窗口加载类中注册定义的监听
		
		
	}			
	/**
	 * 控制飞机坐标移动，写新的内部类,定义为内部类，可以方便的使用外部类属性
	 * 定以后，在lanuchFrame中注册，调用，重写launchFrame方法
	 * 判断按下的键
	 * @author Administrator
	 *
	 */
	class KeyMonitor extends KeyAdapter{//继承键盘释放器
		@Override
		public void keyPressed(KeyEvent e) {
			System.out.println("按下:"+e.getKeyCode());
			p.move(e);//通过按键移动方向
			
		}
		@Override
		public void keyReleased(KeyEvent e) {
		System.out.println("释放:"+e.getKeyCode());
		}
		
	}		
		

}
