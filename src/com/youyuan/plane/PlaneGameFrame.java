package com.youyuan.plane;

import com.youyuan.util.GameUtil;
import com.youyuan.util.MyFrame;

import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Date;
//import com.youyuan.util.MyFrame.PaintThread;

public class PlaneGameFrame extends MyFrame{
	Image bg = GameUtil.getImage("images/bg.jpg");
	Plane p = new Plane("images/plane.png",150,50);
//	Explode baozha = new Explode(50,50);
	
	ArrayList bulletList = new ArrayList();//定义子弹数组，个数不限；泛型之后关注
	Date startTime;
	Date endTime;
	Explode bao;
	
	public void paint(Graphics g) {
		g.drawImage(bg, 0, 0, null);
		p.draw(g);
//		baozha.draw(g);
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
					p.setLive(false);//碰到后，飞机死掉，设置飞机生存状态为false
//					g.drawString("Game Over",(int)p.x,(int)p.y);//飞机坐标位置打印信息
//					Color c = g.getColor();
//					g.setColor(Color.white);
//					g.drawString("Game Over", 100, 200);//放在此处每次都打印
//					g.setColor(c);
					
					//碰到后爆炸
//					Explode bao = new Explode(p.x,p.y);//放到此处会new多个
					if(bao == null) {
						endTime = new Date();
						bao = new Explode(p.x,p.y);
						
					}
					bao.draw(g);
					
					break;
					
					
				}
			}
		if(!p.isLive()) {//死掉后打印信息
//			Color c = g.getColor();
//			g.setColor(Color.white);
//			Font f = new Font("宋体",Font.BOLD,50);//设置字体
//			g.setFont(f);
//			g.drawString("Game Over", 100, 200);
//			g.setColor(c);
//			printInfo(g,"Game Over",50,100,200,Color.white);
			long period = (startTime.getTime()-endTime.getTime())/1000;
			printInfo(g,"时间："+period+"秒",20,120,260,Color.white);
//			printInfo(g,"分数：100",10,50,100,Color.yellow);
			switch((int)period/10) {
			case 0:
			case 1:
				printInfo(g,"菜鸟",50,100,200,Color.WHITE);
				break;
			case 2:
				printInfo(g,"小鸟",50,100,200,Color.WHITE);
				break;
			case 3:
				printInfo(g,"老鸟",50,100,200,Color.YELLOW);
				break;
			case 4:
				printInfo(g,"鸟王子",50,100,200,Color.YELLOW);
				break;
			default:
				printInfo(g,"鸟人",50,100,200,Color.YELLOW);
				break;			
			}
		}
		
	}
	/**
	 * 封装死掉后打印信息
	 * @param g
	 * @param str
	 * @param size
	 */
	public void printInfo(Graphics g,String str,int size,int x,int y,Color color) {
		Color c = g.getColor();
		g.setColor(color);
		Font f = new Font("宋体",Font.BOLD,size);//设置字体
		g.setFont(f);
		g.drawString(str, x, y);
		g.setColor(c);		
	}
//	public void printInfo(Graphics g,String str,int size) {
//		Color c = g.getColor();
//		g.setColor(Color.WHITE);
//		Font f = new Font("宋体",Font.BOLD,size);//设置字体
//		g.setFont(f);
//		g.drawString(str, 100, 200);
//		g.setColor(c);		
//	}
	
	public static void main(String[] args) {
		new PlaneGameFrame().launchFrame();
	}
	//重写launchFrame方法
	public void launchFrame() {		
		super.launchFrame();
		//增加键盘的监听
		addKeyListener(new KeyMonitor());//在窗口加载类中注册定义的监听
		//初始化生成一堆子弹对象
		for(int i=0;i<20;i++) {
			Bullet b = new Bullet();
			bulletList.add(b);//数组中添加对象
		}
		//窗口加载获取开始时间
		startTime = new Date();
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
