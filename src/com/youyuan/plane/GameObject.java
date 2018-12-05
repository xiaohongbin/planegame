package com.youyuan.plane;

import java.awt.Image;
import java.awt.Rectangle;

import com.youyuan.util.GameUtil;

/**
 * 封装游戏物体类，抽象出共有属性；坐标，速度，方法
 * @author Administrator
 *
 */
public class GameObject {
	Image img;//飞机图片是变量
	double x,y;
	double speed =10;//定义移动速度
	int width,height;
	//获得飞机矩形
	public Rectangle getRect() {
//		Rectangle r = new Rectangle((int)x,(int)y,30,30);//坐标，高度，宽度
//		Rectangle r = new Rectangle((int)x,(int)y,img.getWidth(null),img.getHeight(null));//获取飞机宽度，高度
//		Rectangle r = new Rectangle((int)x,(int)y,width,height);
//		return r;
		return new Rectangle((int)x,(int)y,width,height);
		
	}
	
	public GameObject(double x, double y, double speed) {
		super();
		this.x = x;
		this.y = y;
		this.speed = speed;
	}	
	/**
	 * 物体无设定图片时
	 * @param x
	 * @param y
	 * @param speed
	 * @param width
	 * @param height
	 */
	public GameObject(double x, double y, double speed, int width, int height) {
		this(x,y,speed);
		this.width = width;
		this.height = height;
	}
	/**
	 * 物体有设定图片时
	 * @param img
	 * @param x
	 * @param y
	 * @param speed
	 * @param width
	 * @param height
	 */
	public GameObject(Image img, double x, double y, double speed, int width, int height) {
		this(x,y,speed);
		this.img =img;
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	public GameObject(String imgpath, double x, double y, double speed, int width, int height) {
		this(x,y,speed);
		this.img =GameUtil.getImage(imgpath);
		this.width = img.getWidth(null);
		this.height = img.getHeight(null);
	}
	
	public GameObject() {
		
	}
	
	

}
