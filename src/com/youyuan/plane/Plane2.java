package com.youyuan.plane;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.KeyEvent;

import com.youyuan.util.GameUtil;
/**
 * 抽象出，图片来源，坐标
 * @author Administrator
 *
 */
public class Plane2 {
//	Image img = GameUtil.getImage("images/plane.png");
	Image img;//飞机图片是变量
	double x,y;
	
	public void draw(Graphics g) {
		g.drawImage(img, (int)x, (int)y, null);
	}
//	定义飞机构造方法
	public Plane2() {
		//空参构造器
	}
	public Plane2(String imgpath,double x,double y) {
		super();
		this.img = GameUtil.getImage(imgpath);
		this.x = x;
		this.y = y;
	}
	//通过捕捉按键来移动方向
	public void move(KeyEvent e) {//把对象传进来
		switch(e.getKeyCode()) {
		case KeyEvent.VK_LEFT://左
			x -= 10;
			break;
		case KeyEvent.VK_UP://右
			y -= 10;
			break;
		case KeyEvent.VK_RIGHT://右
			x += 10;
			break;
		case KeyEvent.VK_DOWN:
			y += 10;
			break;
		default :
			break;
		}
		
	}
	

}
