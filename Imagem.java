import javax.swing.*;
import javax.swing.JLabel;


public class Imagem extends JFrame
{
	
	ImageIcon imagem = new ImageIcon(getClass().getResource("background.png")) ;
	JLabel label = new JLabel(imagem);
	
	public Imagem()
	{
	add(label);
	
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true); 
	}
	
	public static void main (String [] args)
	{
		new Imagem();
	}
	}
