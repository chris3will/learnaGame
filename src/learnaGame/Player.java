package learnaGame;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.HeadlessException;
import java.awt.Rectangle;
import java.util.Random;

public class Player extends GameObject {
	

	Random r=new Random();
	Handler handler;
	
	
	public Player(int x,int y,ID id,Handler handler) {
		super(x,y,id);
		this.handler=handler;
		
		}
	
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}
	
	public void tick() {
		x-=velX;
		y+=velY;
		
		x=Game.clamp(x, 0, Game.WIDTH-32);
		y=Game.clamp(y, 0, Game.HEIGHT-72);
		
		handler.addObject(new Trail(x, y, ID.Player, Color.white, 32, 32, 0.02f, handler));
		
		collision();
	}
	
	
	private void collision() {
		for ( int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			
			if(tempObject.getId()==ID.BasicEnemy||tempObject.getId()==ID.FastEnemy) {
				if(getBounds().intersects(tempObject.getBounds())){
					HUD.HEALTH-=2;
					tempObject.setVelX(tempObject.getVelX()*(-1));
					tempObject.setVelY(tempObject.getVelY()*(-1));
				}
				
			}
		}
	}
	
	
	public void render(Graphics g) {
		if(id==ID.Player)g.setColor(Color.white);
		//else if(id ==id.Player2)g.setColor(Color.pink);
		g.fillRect(x, y, 32, 32);
	}
	
	
}
