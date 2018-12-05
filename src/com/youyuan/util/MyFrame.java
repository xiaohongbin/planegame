package com.youyuan.util;

import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import com.youyuan.util.Constant;

/**
 * 封装父类
 * @author Administrator
 *
 */
public class MyFrame extends Frame{
	/**
	 * 加载窗口
	 */
	public void launchFrame() {
		//addWindowListener需要先加载,但是通过this方式就可以在任意位置
		
		setSize(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);//设置窗口长宽
		setLocation(400,400);//设置起点坐标
		setVisible(true);
			
//		new PaintThread().run();
		new PaintThread().start();//启动重画线程
		addWindowListener(new WindowAdapter() {//通过this方式就可以在任意位置，去掉this，addWindowListener方法必须放在首行
			@Override
			public void windowClosing(WindowEvent e) {//多态重写
				System.exit(0);
			}
			
		});	
		
		
	}
	/**
	 * 利用双缓冲技术消除闪烁
	 */
	private Image offScreenImage = null;
	public void update(Graphics g) {
		if(offScreenImage == null)
			offScreenImage = this.createImage(Constant.GAME_WIDTH,Constant.GAME_HEIGHT);
		
		Graphics gOff = offScreenImage.getGraphics();

		paint(gOff);
		g.drawImage(offScreenImage, 0, 0, null);
	}
	
	/**
	 * 定义一个重画窗口线程类，是一个内部类
	 * 通过重画线程类控制paint 线程
	 * @author Administrator
	 *
	 */
	public class PaintThread extends Thread{
		public void run() {
			while(true) {
				repaint();//重画窗口方法，paint()
				try {
					Thread.sleep(40);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
