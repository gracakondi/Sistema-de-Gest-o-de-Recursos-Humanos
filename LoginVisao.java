/*----------------------------------
Tema:Gestao de Recursos Humanos
Nome: Gildo Graca Kondi
Ficheiro: LoginVisao.java
Data: 25-05-2024
--------------------------------- */


import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;

public class LoginVisao extends JFrame
{

	private	PainelCentro centro;
	private	PainelSul sul;

	public LoginVisao ()
	{
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

		setTitle("Preencha os Campos Para Poder Acessar ao Sistema");
		setSize(600, 200);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel 
	{
		private JTextField usernameJTF;
		private JPasswordField passJPF;
		private String userCerto = "33049", passCerto = "Miley";

		public PainelCentro()
		{
			setLayout (new GridLayout(2, 4));
			
			//	add(new JLabel("LOG IN"));
				
			//LINHA 1
			add(new JLabel("             "));
			add(new JLabel("Nome de Utilizador:"));
			add( usernameJTF = new JTextField());
			add(new JLabel("         "));
		
			//LINHA2
			add(new JLabel("             "));
			add(new JLabel("Palavra-Passe:"));
			add(passJPF = new JPasswordField());
			add(new JLabel("             "));
		}

		// METODOS GETTERS
		public String getUsuario()
		{
			return usernameJTF.getText().trim();
		}

		public String getPass()
		{
			return passJPF.getText().trim();
		}
		
		public boolean loginValidado()
		{
			if (getUsuario().equals(userCerto) && getPass().equals(passCerto))
			return true;

			return false;
		}
	}


	class PainelSul extends  JPanel implements ActionListener
	{
		JButton loginJB, cancelarJB;

		public PainelSul ()
		{
			add(loginJB = new JButton("Log In"));
			add(cancelarJB = new JButton("Cancelar"));

			loginJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}

		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == loginJB)
			{
				if (centro.loginValidado())
				{
					String usuario = centro.getUsuario();
					dispose();
					
					
					new MenuPrincipalVisao(usuario);
				}
				else
					JOptionPane.showMessageDialog(null, "Sorry, Try Again");

			}
			else
				dispose();
		}
	}

    

	public static void main (String args [])
	{
		new LoginVisao();
		
	}

}
