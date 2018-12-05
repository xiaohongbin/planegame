package com.youyuan.plane;

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
public class Plane extends GameObject{

	private boolean left,right,up,down;//定义可以8个方向移动的变量
	private boolean live = true;//飞机默认活着

	public void draw(Graphics g) {
		if(live) {
			g.drawImage(img, (int)x, (int)y, null);
			move();			
		}
		
	}
//	定义飞机构造方法,属性初始化
	public Plane() {
		//空参构造器
	}
	public Plane(String imgpath,double x,double y) {
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
//		System.out.println("按下:"+e.getKeyCode());
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
//		System.out.println("释放:"+e.getKeyCode());
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
	//设置私有变量 live set get方法
	public boolean isLive() {
		return live;
	}
	public void setLive(boolean live) {
		this.live = live;
	}
	
	

}
