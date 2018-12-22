package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBoss extends GameObject{

	private Handler handler;
	Random r=new Random();
	
	
	
	
	private int timer= 80;//出现一个大魔王，准备射击出方块
	
	private int timer2=50;
	
	public EnemyBoss(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		
		this.handler=handler;
		velY=2;
		velX=0;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 96, 96);
	}
	
	
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		
		if(timer<=0)velY=0;
		else timer--;
		
		
		if(timer<=0)timer2--;
		if(timer2<=0) {
			if(velX==0)velX=5;
			if(velX>0)
			velX+=0.01f;
			else if(velX<0)
			velX-=0.01f;
			
			velX=Game.clamp(velX, -10, 10);
			
			int spawn =r.nextInt(19);
			if(spawn==0) handler.addObject(new EnemyBossBullet((int)x+48, (int)y+48, id.EnemyBossBullet, handler));
			
			
			
		}
		
		//if(this.y<=0||this.y>=Game.HEIGHT-96)velY*=-1;
		if(this.x<=0||this.x>=Game.WIDTH-96)velX*=-1;
	
		//handler.addObject(new Trail((int)x, (int)y, ID.Trail,Color.red, 96,96,0.02f, handler));
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
			g.setColor(Color.pink);
		g.fillRect((int)x, (int)y, 96, 96);
	}
	
}
