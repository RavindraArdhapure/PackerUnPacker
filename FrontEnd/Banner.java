import java.awt.*;
import java.awt.event.*;  
import java.awt.event.WindowListener;  
import java.awt.event.MouseListener;
import java.lang.*;

import java.awt.image.BufferedImage;
import java.io.*;
import javax.imageio.ImageIO;


public class Banner extends Frame implements MouseListener
{
	public static BufferedImage img;

	public Banner()	
	{	
		this.addMouseListener(this);
	
		//Anonymous class for closing
		addWindowListener(new WindowAdapter(){  
			public void windowClosing(WindowEvent e) 
			{  
                System.exit(0);
            }  
		});
		//Add Image
		try
		{
			img=ImageIO.read(new File("Img.png"));
		}
		catch(IOException e)
		{
            System.out.println(e.getMessage());   
            e.printStackTrace(); 
        }
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setBounds((dim.width/2)-(730/2), (dim.height/2)-(400/2), this.getWidth(), this.getHeight());
		// set size of window
		this.setSize(730,400);
		// set title of window
		this.setTitle("Marvellous Infosystems");
		//set color
		this.setBackground(Color.DARK_GRAY);
		this.setResizable(false);
		// Display that frame
		this.setVisible(true);
	}
	public void paint(Graphics g) 
	{
		g.drawImage(img, 0, 0,getWidth(),getHeight(), null);
    }
	public void mouseClicked(MouseEvent e)
	{  
        Graphics g=getGraphics();  
        g.setColor(Color.WHITE);  
		g.fill3DRect(e.getX(),e.getY(),10,10,true);  
        dispose();
        //Login Window
        LoginWindow lobj=new LoginWindow();
		
	}  
    public void mouseEntered(MouseEvent e) {}  
    public void mouseExited(MouseEvent e) {}  
    public void mousePressed(MouseEvent e) {}  
    public void mouseReleased(MouseEvent e) {}

}