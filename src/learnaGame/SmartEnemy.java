package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.MultipleGradientPaint.ColorSpaceType;
import java.awt.Rectangle;
import java.util.Random;

import javax.swing.plaf.PanelUI;

public class SmartEnemy extends GameObject{
	//calculate the distance between the two.
	private Handler handler;
	private GameObject player;
	
	
	public SmartEnemy(float x, float y, ID id,Handler handler) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
		this.handler=handler;
		
	}

	public Rectangle getBounds() {
		return new Rectangle((int)x, (int)y, 16, 16);
	}
	
	
	public void tick() {
		// TODO Auto-generated method stub
		x+=velX;
		y+=velY;
		for(int i=0;i<handler.object.size();i++) {
			if(handler.object.get(i).getId()==ID.Player) {
				//先把玩家摘出来
				player=handler.object.get(i);
			}
		}
		
		float diffX=x-player.getX()-8;
		float diffY=y-player.getY()-8;
		float distance =(float)Math.sqrt(((x-player.getX())*(x-player.getX())) + ((y-player.getY())*(y-player.getY())));
		
		velX=(float) ((-1.0/distance)*diffX);
		velY=(float) ((-1.0/distance)*diffY);
		
		
		if(this.y<=0||this.y>=Game.HEIGHT-48)velY*=-1;
		if(this.x<=0||this.x>=Game.WIDTH-16)velX*=-1;
	
		handler.addObject(new Trail((int)x, (int)y, ID.Trail,Color.green, 16,16,0.05f, handler));
		
	}

	
	public void render(Graphics g) {
		// TODO Auto-generated method stub
		
			g.setColor(Color.red);
		g.fillRect((int)x, (int)y, 16, 16);
	}
	
}
