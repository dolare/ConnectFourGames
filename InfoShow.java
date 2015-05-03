import javax.swing.*;
import java.awt.*;

public class InfoShow extends JPanel {
 
	String Player1Name="p1";
	 
    String Player2Name="p2";
	 
	private int PlayerFlag=1;
	
	public int WinFlag=0;
	
	public int EqualFlag=0;
	
	private JLabel label=new JLabel("");
	
	
	String imagePath = "";
	
	JPanel panel;
	
	public InfoShow()
	{
		
		panel=new JPanel();
		panel.setOpaque(false);
		Font font=new Font("",Font.BOLD,20);
		label.setFont(font);
		this.setLayout(null);
		
		
		
		this.add(label);
		this.add(panel);
		label.setBounds(10,25,120,30);
		panel.setBounds(0,0,160,80);
	}
	 
	public void ShowMessage() 
	{
		if(WinFlag==0&&EqualFlag==0)
		{
			if(PlayerFlag==1)
			{
				label.setText(Player1Name+"'s turn");
			}
			else
			{
				label.setText(Player2Name+"'s turn");
			}
		}
	}
	 
	public void SetP1Name(String Name) {
		Player1Name=Name;
	}
	 
	public void SetP2Name(String Name) {
		Player2Name=Name;
	}
	 
	public void SetPlayerFlag(int id) 
	{
		PlayerFlag=id;
	}
	
	public void ShowWin()
	{
		WinFlag=1;
		if(PlayerFlag==1)
		{
			label.setText(Player1Name+" won");
			//this.add(label);
		}
		else
		{
			label.setText(Player2Name+" won");
			//this.add(label);
		}
		
	}
	
	public void ShowEqual()
	{
		
			label.setText("Tie");
	}
	
	protected void paintComponent(Graphics g)
	{
		
		super.paintComponent(g);
		int width=getWidth();
		int height=getHeight();
		
		g.setColor(Color.black);
		g.drawRect(0, 0, width-1, height-1);
		
		
	}
}
 
