package com.youyuan.plane;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;

import com.youyuan.util.Constant;

/**
 * 抽象子弹属性，坐标，图片，速度，移动角度，子弹大小，生成不同子弹
 * @author Administrator
 *
 */
public class Bullet extends GameObject{
	double degree;
	
	public Bullet() {
		degree = Math.random()*Math.PI*2;//角度随机
		//子弹从中心位置
		this.x = Constant.GAME_WIDTH/2;
		this.y = Constant.GAME_HEIGHT/2;
		this.width = 10;
		this.height = 10;
		
	}
	public void draw(Graphics g) {
		Color c =g.getColor();
		g.setColor(Color.yellow);//填充颜色
		g.fillOval((int)x, (int)y, (int)width, (int)height);//填充原点方法
		g.setColor(c);
		//子弹角度
		
		x += speed*Math.cos(degree);
		y +=speed*Math.sin(degree);
		//子弹到达边缘反弹
		if(y>Constant.GAME_HEIGHT-height||y<30) {
			degree = -degree;
		}
		if(x<0||x>Constant.GAME_WIDTH-width) {
			degree = Math.PI-degree;
		}				
	}

}
