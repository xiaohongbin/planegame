package com.youyuan.plane;

import java.awt.Graphics;
import java.awt.Image;

import com.youyuan.util.GameUtil;

/**
 * 爆炸类，爆炸效果，加载一系列图片,
 * 数组图片,
 * 抽象出属性，坐标，图片数组，方法
 * @author Administrator
 *
 */
public class Explode {
	double x,y;
	static Image[] imgs = new Image[16];//如果不进行长度初始化，报错java.lang.ExceptionInInitializerError
	static {//静态数组赋值方法
		for(int i=0;i<16;i++) {
			imgs[i] = GameUtil.getImage("images/explode/e"+(i+1)+".gif");
			imgs[i].getWidth(null);//为了加载图片
		}
	}
	int count;
	
	public void draw(Graphics g) {
		if(count<=15) {
		g.drawImage(imgs[count], (int)x, (int)y,null);
		count++;
		}
	}
	/**
	 * 创建爆炸对象，添加构造函数，进行属性初始化
	 * @param x
	 * @param y
	 */
	public Explode(double x,double y) {
		this.x = x;
		this.y = y;
	}
	

}
