package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.Rectangle;
import java.util.Random;

public class MenuParticle extends GameObject{

	private Handler handler;
	private Color col;
	Random r=new Random();
	int dir=0;
	
	public MenuParticle(int x, int y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		
		dir=r.nextInt(2);
		this.handler=handler;
		
		
		velX=(r.nextInt(5 - -5)+ -5);
		velY=(r.nextInt(5 - -5)+ -5);
		if(velX==0)velX=1;
		if(velY==0)velY=1;
		col=new Color(r.nextInt(255), r.nextInt(255), r.nextInt(255));
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
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail,col, 16,16,0.05f, handler));
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
		g.setColor(col);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
