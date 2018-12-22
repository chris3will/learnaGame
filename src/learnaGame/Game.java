package learnaGame;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

import org.omg.CORBA.PRIVATE_MEMBER;

public class Game extends Canvas implements Runnable {
	
	/**
	 * 
	 */

	private static final long serialVersionUID = 3126065444234718722L;

	static final int WIDTH=640;

	static final int HEIGHT=WIDTH/12*9;
	private Thread thread;
	private boolean running=false;
	private Random r;
	
	private Handler handler;
	
	private HUD hud;
	
	private Spawn spawner;
	
	
	public Game() {
		//更多的是作为一个初始化
		//#7中添加了算法，避免人类躲避，有一个可以实现主动追踪
		handler=new Handler();
		
		this.addKeyListener(new KeyInput(handler));
		
		
		//游戏主体窗口
		new Window(WIDTH,HEIGHT,"let's build a game", this);
	
		hud= new HUD();
		
		spawner=new Spawn(handler, hud);
		
		r=new Random();
		
		handler.addObject(new Player(WIDTH/2, HEIGHT/2-32, ID.Player,handler));
		
		
		
		
		
		handler.addObject(new BasciEnemy((Game.WIDTH/2)-48, -120, ID.BasicEnemy, handler));
			
		
	}
	
	
	public synchronized void start() {
		//开始函数
		//等价于先声明一个runnable 对象
		//然后通过同时开始的方式，调用Thread的start方法，生成一个新的thread对象，然后调用它自己的run，即这个模板函数
		
		thread=new Thread(this);
		thread.start();
		running=true;
	}
	
	public synchronized void stop() {
		//终止函数 
		try {
			 thread.join();
			 running=false;
		 }catch (Exception e) {
			// TODO: handle exception
			 e.printStackTrace();
		 }
	}
	
	public void run() {
		//很流行的运行模板，其中的参数指标不用在意。主要的就是自己的 tick（） 和render（）
		long lastTime=System.nanoTime();
		double amountOfTicks=60.0;
		double ns=1000000000/amountOfTicks;
		double delta=0;
		long timer=System.currentTimeMillis();
		int frames=0;
		while(running) {
			long now=System.nanoTime();
			delta+=(now-lastTime)/ns;
			lastTime=now;
			while(delta>=1) {
				tick();
				//大TICK
				delta--;
			}
			if(running)
				render();
				//大RENDER
			frames++;
			
			
			if(System.currentTimeMillis()-timer>1000) {
				timer+=1000;
				//System.out.println("FPS: "+frames);
				frames=0;
			}
		}
		stop();
	}
	
	private void tick()
	{
		handler.tick();
		hud.tick();
		spawner.tick();
	}
	
	private void render() {
		BufferStrategy bs=this.getBufferStrategy();
		if(bs==null) {
			this.createBufferStrategy(3);
			return ;
		}
		
		Graphics g=bs.getDrawGraphics();
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		
		handler.render(g);
		hud.render(g);
		g.dispose();
		bs.show();	
		
	}
	
	public static float clamp(float var,float min,float max) {//检测碰撞，并限制图像在缓冲区内的位置
		if(var >= max)
		{
			System.out.println(var=max);
			return var=max;
		}
		else if(var <= min) {
			System.out.println(var=min);
			return var=min;
		}
		else {
			
			return var;
		}
	}
	
	
	public static void main(String[] args) {
		new Game();
	}
}
