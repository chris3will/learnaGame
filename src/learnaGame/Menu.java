package learnaGame;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Random;

import learnaGame.Game.STATE;

public class Menu extends MouseAdapter{
	
	private Game game;
	private Handler handler;
	private HUD hud;
	Random r=new Random();
	
	public Menu(Game game,Handler handler,HUD hud) {
		//将主类 对象和存储对象的句柄传进来
		this.game=game;
		this.hud=hud;
		this.handler=handler;
		
	}
	
	public void mousePressed(MouseEvent e) {
		int mx=e.getX();
		int my=e.getY();
		
		if(game.gameState==STATE.Menu) {
			//play button
			if(mouseOver(mx, my,230, 150, 200, 64)) {
				game.gameState=STATE.Game;
				
				handler.addObject(new Player(Game.WIDTH/2, Game.HEIGHT/2-32, ID.Player,handler));
				handler.clearEnemys();
				handler.addObject(new BasciEnemy(r.nextInt(Game.WIDTH), 120, ID.BasicEnemy, handler));
			}
			//help button
			
			if(mouseOver(mx, my,230, 250, 200, 64)) {
				game.gameState=STATE.Help;
			}
			
			//quit button
			if(mouseOver(mx, my,230, 350, 200, 64)) {
				System.exit(1);
			}
			
		}
		
		
		if(game.gameState==STATE.Help) {
			if(mouseOver(mx, my,230, 350, 200, 64)) {
				game.gameState=STATE.Menu;
				return;
			}
		}
		
		if(game.gameState==STATE.End) {
			if(mouseOver(mx, my,230, 350, 200, 64)) {
				game.gameState=STATE.Game;
				hud.setLevel(1);
				hud.setScore(0);
				
				handler.addObject(new Player(Game.WIDTH/2, Game.HEIGHT/2-32, ID.Player,handler));
				handler.clearEnemys();
				
			}
		}
		
		
		
		
		
		
	}
	
	public void mouseReleased(MouseEvent e) {
		
	}
	public void tick() {
		
	}
	
	//查看是否已经选择过
	private boolean mouseOver(int mx,int my,int x,int y,int width,int height) {
		if(mx>x&&mx<x+width) {
			if(my>y&&my<y+height) {
				return true;
			}else return false;
		}else return false;
	}
	
	
	
	public void render(Graphics g) {
		//render 不要忘记刷子的意思
		//System.out.println(hud.getScore());
		if(game.gameState==STATE.Menu) {
			//确保只有在菜单界面下才有这些按键
			Font fnt=new Font("arial", 1, 50);
			Font fnt2=new Font("arial",2,30);
			
			g.setFont(fnt);
			g.setColor(Color.PINK);
			g.drawString("Wave", 240, 50);
			

			g.setFont(fnt2);
			g.setColor(Color
					.white);
			g.drawRect(230, 150, 200, 64);
			g.drawString("Play", 290, 190);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(230, 250, 200, 64);
			g.drawString("Help", 290, 290);
			
		
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(230, 350, 200, 64);
			g.drawString("Quit", 290, 390);
		}else if(game.gameState==STATE.Help) {
			Font fnt=new Font("arial", 1, 50);
			Font fnt2=new Font("arial",2,30);
			Font fnt3=new Font("arial",2,22);
			
			g.setFont(fnt);
			g.setColor(Color.PINK);
			g.drawString("Help", 230, 70);
			
			g.setFont(fnt3);
			g.drawString("Use WASD to move player and avoid crashing with the bricks!", 10, 200);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(230, 350, 200, 64);
			g.drawString("Back", 290, 390);
		}else if(game.gameState==STATE.End) {
			Font fnt=new Font("arial", 1, 50);
			Font fnt2=new Font("arial",2,30);
			Font fnt3=new Font("arial",2,22);
			
			g.setFont(fnt);
			g.setColor(Color.PINK);
			g.drawString("Game Over", 230, 70);
			
			g.setFont(fnt3);
			g.drawString("You have Scored: "+hud.getScore(), 10, 200);
			
			g.setFont(fnt2);
			g.setColor(Color.white);
			g.drawRect(230, 350, 200, 64);
			g.drawString("Try it again!",250, 390);
		}
		
		
		
	}
}
