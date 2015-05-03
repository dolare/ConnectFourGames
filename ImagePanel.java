import java.awt.*;                       //��ʾͼ������
import java.awt.event.ActionEvent;       //   
import java.awt.event.ActionListener;
import java.io.*;
import javax.imageio.*;
import javax.swing.*;

class ImagePanel extends JPanel 
{
	private Image img;
	
	public ImagePanel(String imagePath) 
	{
		try 
		{
			File f = new File(imagePath);
			img = ImageIO.read(f);
		} catch (IOException e) 
		{
			e.printStackTrace();
		}
	}

	public void paintComponent(Graphics g) 
	{
		super.paintComponent(g);
		Graphics2D g2 = (Graphics2D) g;

		if (img != null) 
		{
			g2.drawImage(img, 0, 0, getWidth(), getHeight(), 0, 0, img
					.getWidth(null), img.getHeight(null), null);
		}
	}
}