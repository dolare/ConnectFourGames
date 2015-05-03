import javax.swing.*;
import java.awt.*;
import java.math.*;

public class Map {
 
	private int m_Columns;
	 
	private int m_Rows;
	 
	private int m_Map[][];
	
	public int m_Count;
	
	private int m_Place[];
	
	public Map()
	{
		
	}
	 
	public Map(int Width, int Height) 
	{
		m_Map=new int [Width][Height];
		m_Rows=Width;
		m_Columns=Height;
		m_Place=new int [Width];
		
		for(int i=0;i<m_Rows;i++)
		{
			for(int j=0;j<m_Columns;j++)
			{
				m_Map[i][j]=0;
						
			}
		}
		m_Count=Width*Height;
		for(int i=0;i<m_Rows;i++)
		{
			m_Place[i]=Height;
		}
		
	}
	 
	public void SetPlayer(int PlayerFlag, int row,int Column) 
	{
		m_Map[row][Column]=PlayerFlag;
	}
	 
	public boolean IsWin(int x,int y,int PlayerFlag) 
	{
		int pxleft,pxright,pyup,pydown;
		pxleft=pxright=x;
		pyup=pydown=y;
		int count;

		count=0;
		while(pxleft>=0 && m_Map[pxleft][y]==PlayerFlag)
		{
			pxleft--;
			count++;
		}
		while(pxright<m_Rows && m_Map[pxright][y]==PlayerFlag)
		{
			pxright++;
			count++;
		}
		if(count-1>=4)
			return true;

		count=0;
		while(pyup>=0 && m_Map[x][pyup]==PlayerFlag)
		{
			pyup--;
			count++;
		}
		while(pydown<m_Columns && m_Map[x][pydown]==PlayerFlag)
		{
			pydown++;
			count++;
		}
		if(count-1>=4)
			return true;

		count=0;
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxleft>=0 && pyup>=0 && m_Map[pxleft][pyup]==PlayerFlag)
		{
			pxleft--;
			pyup--;
			count++;
		}
		
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxright<m_Rows && pydown<m_Columns && m_Map[pxright][pydown]==PlayerFlag)
		{
			pxright++;
			pydown++;
			count++;
		}
		if(count-1>=4)
			return true;
		

		count=0;
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxright<m_Rows && pyup>=0 && m_Map[pxright][pyup]==PlayerFlag)
		{
			pxright++;
			pyup--;
			count++;
		}
		
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxleft>=0 && pydown<m_Columns && m_Map[pxleft][pydown]==PlayerFlag)
		{
			pxleft--;
			pydown++;
			count++;
		}
		if(count-1>=4)
			return true;

		return false;
	}

	public boolean IsEqual()
	{
		if(m_Count==0)
			return true;
		else
			return false;
	}

	public int ComputerPlace() 
	{
		double a = Math.random()*m_Columns;
		int randomNum = new Double(a).intValue(); 
		return randomNum;
	}

	public void AddPlace(int Col)
	{
		if(m_Place[Col]>0)
			m_Place[Col]-=1;
	}

	public int Place(int Col)
	{
		return m_Place[Col];
	}
	
	public int CalNum(int x,int y,int PlayerFlag)
	{
		int pxleft,pxright,pyup,pydown;
		pxleft=pxright=x;
		pyup=pydown=y;
		int num1,num2,num3,num4;
		num2=0;
		while(pxleft>=0 && m_Map[pxleft][y]==PlayerFlag)
		{
			pxleft--;
			num2++;
		}
		while(pxright<m_Rows && m_Map[pxright][y]==PlayerFlag)
		{
			pxright++;
			num2++;
		}
		num2--;
		num1=0;
		while(pyup>=0 && m_Map[x][pyup]==PlayerFlag)
		{
			pyup--;
			num1++;
		}
		while(pydown<m_Columns && m_Map[x][pydown]==PlayerFlag)
		{
			pydown++;
			num1++;
		}
		num1--;
		num3=0;
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxleft>=0 && pyup>=0 && m_Map[pxleft][pyup]==PlayerFlag)
		{
			pxleft--;
			pyup--;
			num3++;
		}
		
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxright<m_Rows && pydown<m_Columns && m_Map[pxright][pydown]==PlayerFlag)
		{
			pxright++;
			pydown++;
			num3++;
		}
		num3--;
		
		num4=0;
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxright<m_Rows && pyup>=0 && m_Map[pxright][pyup]==PlayerFlag)
		{
			pxright++;
			pyup--;
			num4++;
		}
		
		pxleft=pxright=x;
		pyup=pydown=y;
		while(pxleft>=0 && pydown<m_Columns && m_Map[pxleft][pydown]==PlayerFlag)
		{
			pxleft--;
			pydown++;
			num4++;
		}
		num4--;
		
		return Max4(num1,num2,num3,num4);
	}
	
	public int Max4(int x1,int x2,int x3,int x4)
	{
		int max=0;
		
		max=x1;
		if(max<x2)
			max=x2;
		if(max<x3)
			max=x3;
		if(max<x4)
			max=x4;
		return max;
	}
	
	public int ComputerAiPlace()
	{
		for(int num=4;num>0;num--)
		{
			
				for(int col=0;col<m_Columns;col++)
				{
					SetPlayer(1,Place(col),col);
					if(CalNum(Place(col),col,1)==num)
					{
						SetPlayer(0,Place(col),col);
						return col;
					}
					SetPlayer(0,Place(col),col);
				}
				
				for(int col=0;col<m_Columns;col++)
				{
					SetPlayer(2,Place(col),col);
					if(CalNum(Place(col),col,2)==num)
					{
						SetPlayer(0,Place(col),col);
						return col;
					}
					SetPlayer(0,Place(col),col);
				}
			
		}
		return 0;
	}
}
 
