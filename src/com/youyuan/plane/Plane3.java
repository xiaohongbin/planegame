package com.youyuan.plane;
/**
 * 游戏物体共有属性封装之前代码
 */
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyEvent;

import com.youyuan.util.GameUtil;
/**
 * 抽象出，图片来源，坐标
 * @author Administrator
 *
 */
public class Plane3 {
//	Image img = GameUtil.getImage("images/plane.png");
	Image img;//飞机图片是变量
	double x,y;
	double speed =10;//定义移动速度
	boolean left,right,up,down;//定义可以8个方向移动的变量
	int width,height;
	//获得飞机矩形
	public Rectangle getRect() {
//		Rectangle r = new Rectangle((int)x,(int)y,30,30);//坐标，高度，宽度
//		Rectangle r = new Rectangle((int)x,(int)y,img.getWidth(null),img.getHeight(null));//获取飞机宽度，高度
//		Rectangle r = new Rectangle((int)x,(int)y,width,height);
//		return r;
		return new Rectangle((int)x,(int)y,width,height);
		
	}
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
		move();
	}
//	定义飞机构造方法,属性初始化
	public Plane3() {
		//空参构造器
	}
	public Plane3(String imgpath,double x,double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.width =img.getWidth(null);
		this.height = img.getHeight(null);
		this.x = x;
		this.y = y;
	}
	//定义移动方式
	public void move() {//不再需要键盘事件参数KeyEvent e
		if(left) {
			x -=speed;//替换移动速度常量
		}
		if(right) {
			x +=speed;
		}
		if(up) {
			y -=speed;
		}
		if(down) {
			y +=speed;
		}
		
	}
	/**
	 * 封装键盘按下操作方法，addDirection
	 * @param e
	 */
	public void addDirection(KeyEvent e) {
		System.out.println("按下:"+e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT://左
			left = true;
			break;
		case KeyEvent.VK_UP://右
			up = true;
			break;
		case KeyEvent.VK_RIGHT://右
			right = true;
			break;
		case KeyEvent.VK_DOWN:
			down = true;
			break;
		default :
			break;
		}
	}
	/**
	 * 封装键盘抬起释放方法，minusDirection
	 * @param e
	 */
	public void minusDirection(KeyEvent e) {
		System.out.println("释放:"+e.getKeyCode());
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT://左
			left = false;
			break;
		case KeyEvent.VK_UP://右
			up = false;
			break;
		case KeyEvent.VK_RIGHT://右
			right = false;
			break;
		case KeyEvent.VK_DOWN:
			down = false;
			break;
		default :
			break;
		}
	}
	

}
