import javax.swing.*;    
import java.awt.*;
public class Table extends JPanel {
 
	GridLayout tableSize;
	int xNums;
	int yNums;
	
	public void setTableSize(int x,int y)
	{
		tableSize=new GridLayout(x,y);
	}
	
	public Table(GridLayout tableSize)
	{
		//layout=new GridLayout(xNums,yNums);
		super(tableSize);
		xNums=tableSize.getColumns();
		yNums=tableSize.getRows();
	}
	
	/*
	public DrawGrid(GridLayout layout,int x,int y)
	{
		tableSize=new GridLayout(x,y);
		super(layout);
	}
	*/
	
	
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		
		int width=getWidth();
		int height=getHeight();
	
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);

		for(int i=0;i<yNums-1;i++)
		{
			g.drawLine(0, height/yNums*(i+1), width, height/yNums*(i+1));
			
		}

		for(int j=0;j<xNums-1;j++)
		{
			g.drawLine(width/xNums*(j+1),0,width/xNums*(j+1),height);
		}
		
	}
}
 
