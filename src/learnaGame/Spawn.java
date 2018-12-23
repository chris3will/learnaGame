package learnaGame;

import java.security.Guard;
import java.util.Random;

public class Spawn {
	//正儿八经的游戏内容，规则，过程的设置
	private Handler handler;
	private HUD hud;
	private int scoreKeep=0;
	private Random r=new Random();
	int flag=1;
	public Spawn(Handler handler,HUD hud) {
		this.handler=handler;
		this.hud=hud;
		
	}
	
	public void tick() {
		//all you want in the game
		scoreKeep++;
		
		if(scoreKeep>=300)
		{
			scoreKeep=0;
			hud.setLevel(hud.getLevel()+1);
			if(hud.getLevel()==2) {
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel()==3) {
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			}else if(hud.getLevel()==4) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));
				
			}else if(hud.getLevel()==5) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));	
			}else if(hud.getLevel()==6) {
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));	
			}
			else if(hud.getLevel()==7) {
				handler.addObject(new SmartEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.SmartEnemy, handler));	
			}else if(hud.getLevel()==8) {
				handler.addObject(new FastEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.FastEnemy, handler));	
			}else if(hud.getLevel()==10) {
				handler.clearEnemys();
				handler.addObject(new EnemyBoss((Game.WIDTH/2)-48,-120, ID.FastEnemy, handler));	
			}
		}
		/*else {
			if(flag==1) {
			handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH-50), r.nextInt(Game.HEIGHT-50), ID.BasicEnemy, handler));
			flag=0;
			}
		}*/
	}
}
