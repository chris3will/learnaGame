package learnaGame;

import java.security.Guard;
import java.util.Random;

public class Spawn {
	//正儿八经的游戏内容，规则，过程的设置
	private Handler handler;
	private HUD hud;
	private int scoreKeep=0;
	private Random r=new Random();
	
	public Spawn(Handler handler,HUD hud) {
		this.handler=handler;
		this.hud=hud;
	}
	
	public void tick() {
		//all you want in the game
		scoreKeep++;
		
		if(scoreKeep>=100)
		{
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			
			if(hud.getLevel()==2) {
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel()==3) {
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel()==4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}
			
		}
	}
}
