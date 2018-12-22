package learnaGame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public void tick() {
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObject=object.get(i);
			//获取每一个对象，并出发它
			tempObject.tick();
		}
	}
	public void render(Graphics g) {
		//启用画笔，并启动绘制功能
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObJect=object.get(i);
			tempObJect.render(g);
		}
	}
	
	public void addObject(GameObject object) {
		this.object.add(object);
	}
	
	public void removeObject(GameObject object) {
		this.object.remove(object);
	}
	
	public void clearEnemys() {
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObject=object.get(i);
			
			if(tempObject.getId()==ID.Player) {
				object.clear();
				addObject(new Player((int)tempObject.getX(), (int)tempObject.getY(), ID.Player, this));
			}
		}
	}

}
