package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.Rectangle;
import java.util.Random;

public class BasciEnemy extends GameObject{

	private Handler handler;
	
	
	public BasciEnemy(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		
		this.handler=handler;
		velY=6;
		velX=3;
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		if(this.y<=0||this.y>=Game.HEIGHT-48)velY*=-1;
		if(this.x<=0||this.x>=Game.WIDTH-16)velX*=-1;
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail,Color.red, 16,16,0.05f, handler));
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
			g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
