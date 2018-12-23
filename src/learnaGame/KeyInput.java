package learnaGame;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class KeyInput extends KeyAdapter{
	//��ȡ������Ӧ����ƥ���Ӧ����
	private Handler handler;
	private boolean[] keyDown= new boolean[4];//��ȷ���Ƿ��г����İ�����Ȼ������������
	
	
	public KeyInput(Handler handler) {
		this.handler=handler;
		
		keyDown[0]=false;

		keyDown[1]=false;//S
		keyDown[2]=false;//D
		keyDown[3]=false;//A
	}
	
	
	
	public void keyPressed(KeyEvent e) {
		int key=e.getKeyCode();
		//������Ҫ����ID�������ж�
		if(key==KeyEvent.VK_ESCAPE)System.exit(1);
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			
			if(tempObject.getId()==ID.Player) {
				//key event for player one
				if(key==KeyEvent.VK_W) {tempObject.setVelY(-5);keyDown[0]=true;}
				if(key==KeyEvent.VK_S) { tempObject.setVelY(5);keyDown[1]=true;}
				if(key==KeyEvent.VK_A) { tempObject.setVelX(5);keyDown[2]=true;}
				if(key==KeyEvent.VK_D) { tempObject.setVelX(-5);keyDown[3]=true;}
				
				
			}
			
		}
		//System.out.println(key);
	}
	
	public void keyReleased(KeyEvent e) {
		int key=e.getKeyCode();
		for(int i=0;i<handler.object.size();i++) {
			GameObject tempObject=handler.object.get(i);
			
		
		if(tempObject.getId()==ID.Player) {
			//key event for player one
			//#7�澭���޸ģ�����˰�����ĳ�ͻ���
			if(key==KeyEvent.VK_W) keyDown[0]=false;//tempObject.setVelY(0);
			if(key==KeyEvent.VK_S) keyDown[1]=false;//tempObject.setVelY(0);
			if(key==KeyEvent.VK_A) keyDown[2]=false;//tempObject.setVelX(0);
			if(key==KeyEvent.VK_D) keyDown[3]=false;//tempObject.setVelX(0);
			
			//vertical movement
			if(!keyDown[0] &&!keyDown[1]) tempObject.setVelY(0);
			//horizontal movement

			if(!keyDown[2] &&!keyDown[3]) tempObject.setVelX(0);
			
		}
		
		
		
		}
	}

}
