package learnaGame;

import java.awt.Graphics;
import java.util.LinkedList;

public class Handler {
	LinkedList<GameObject> object=new LinkedList<GameObject>();
	public void tick() {
		for(int i=0;i<object.size();i++)
		{
			GameObject tempObject=object.get(i);
			//��ȡÿһ�����󣬲�������
			tempObject.tick();
		}
	}
	public void render(Graphics g) {
		//���û��ʣ����������ƹ���
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

}
