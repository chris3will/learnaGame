package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.Rectangle;
import java.util.Random;

public class EnemyBossBullet extends GameObject{

	private Handler handler;
	Random r=new Random();
	
	public EnemyBossBullet(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		
		this.handler=handler;
		velX=(r.nextInt(5 - -5)+ -5);
		velY=5;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	
	public void tick() {
		// TODO Auto-generated method stub
		
		x+=velX;
		y+=velY;
		
		//if(this.y<=0||this.y>=Game.HEIGHT-48)velY*=-1;
		//if(this.x<=0||this.x>=Game.WIDTH-16)velX*=-1;
	
		if(y>=Game.HEIGHT) handler.removeObject(this);
		
		handler.addObject(new Trail((int)x, (int)y, ID.Trail,Color.white, 16,16,0.05f, handler));
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
			g.setColor(Color.white);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
