package com.youyuan.plane;
/**
 * 飞机死掉以前
 */
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;

import com.youyuan.util.Constant;
import com.youyuan.util.GameUtil;
import com.youyuan.util.MyFrame;
//import com.youyuan.util.MyFrame.PaintThread;

public class PlaneGameFrame3 extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png",150,50);
	ArrayList bulletList = new ArrayList();//定义子弹数组，个数不限；泛型之后关注
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
		//画子弹
		for(int i=0;i<bulletList.size();i++) {
				Bullet b =(Bullet)bulletList.get(i);//数组中取出子弹
				b.draw(g);
				
				/**
				 * 检测和飞机的碰撞,检测所有子弹和飞机矩形是否有交互,
				 * intersects()方法
				 */
				boolean peng = b.getRect().intersects(p.getRect());
				if(peng) {
//					System.out.println("**************************");
					p.setLive(false);//碰到后，飞机死掉，设置飞机生存状态为false
//					g.drawString("Game Over",(int)p.x,(int)p.y);//飞机坐标位置打印信息
					Color c = g.getColor();
					g.setColor(Color.white);
					g.drawString("Game Over", 100, 200);
					g.setColor(c);
					
				}
			}
		if(p.isLive()) {
			
		}
		

	}
	
	public static void main(String[] args) {
		new PlaneGameFrame3().launchFrame();
	}
	//重写launchFrame方法
	public void launchFrame() {		
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());//在窗口加载类中注册定义的监听
		//初始化生成一堆子弹对象
				for(int i=0;i<50;i++) {
					Bullet b = new Bullet();
					bulletList.add(b);//数组中添加对象
				}
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
		public void keyPressed(KeyEvent e) {//键盘按下时，赋值为true
			p.addDirection(e);
			
		}
		@Override
		public void keyReleased(KeyEvent e) {//键盘抬起时，赋值为false
			p.minusDirection(e);
		}
		
	}		
		

}
