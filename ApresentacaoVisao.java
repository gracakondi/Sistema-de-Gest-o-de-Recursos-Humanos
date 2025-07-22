/*#################################
Tema: Gestao de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: ApresentacaoVisao.java
Data: 27-05-2024
#################################*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;

public class ApresentacaoVisao extends JFrame
{

	private PainelCentro centro;
	private PainelSul sul;
	private PainelNorte norte;

	public ApresentacaoVisao ()
	{
		getContentPane().add(norte = new PainelNorte(), BorderLayout.NORTH);
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);

		setTitle("SEJA BEM-VINDE!");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	    public  void criarGUI() {
        JFrame frame = new JFrame();
        frame.setSize(1600, 900);
        frame.setLayout(new BorderLayout());

        // Conteúdo principal
        JPanel painelPrincipal = new JPanel();
        painelPrincipal.setBackground(Color.LIGHT_GRAY);
        frame.add(painelPrincipal, BorderLayout.CENTER);

        // Centralizar a janela na tela
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

	class PainelNorte extends JPanel
	{
		 JTextArea descricaoJTA;
		 JPanel painelNorte;
		 JLabel bannerJL;
		 
		 public PainelNorte()
		 {	
		 	setLayout( new GridLayout(3, 1) );
		 	
		 	bannerJL = new JLabel(new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/showbanner.jpeg"));
			add (bannerJL);
		 
			JPanel painel1 = new JPanel( new GridLayout(1, 1) );
			add( new JScrollPane( descricaoJTA = new JTextArea(10, 10) ) );
			descricaoJTA.setFocusable(false);
			descricaoJTA.setText("\t Bem vindo ao Sistema de Gestao de Recursos Humanos\n\n" +
			"\tDesenvolvido por Gildo Graca Kondi de identificacao 33049, aluno do primeiro ano de engenharia Informatica da UCAN\n"+
			"\t Este sistema foi concebido para facilitar a gestao dos dados dos funcionarios, departamenntos e contratos, permitindo localizar os mesmos dados de forma rapida e segura.\n\n" + 
			"\tEste sistema foi criado como projecto de exame da cadeira de Fundamentos de Programacao II lecionada pelo prof Osvaldo Ramos, no Curso de Engenharia Informatica da UCAN. \n" + 
			"\tSe concorda com os termos e condicoes clica em concordar para avancar");
			add(painel1); 
		 }
		 
	} 
		 
	class PainelCentro extends JPanel implements ActionListener
	{
		 JCheckBox termosJCB;
		public PainelCentro()
		{
		
		
			JPanel painel = new JPanel( new GridLayout(1, 3) );
			add( new JLabel("            ") );
			add(termosJCB = new JCheckBox("concordo com os termos de uso!"));
			add( new JLabel("            ") );
			add(painel);

	//		add(new JLabel("   "));
	//		add(termosJCB = new JCheckBox("concordo com os termos de uso!"));
	//		add(new JLabel(" "));
	//		

			termosJCB.addActionListener(this);
		}
		
		public void actionPerformed (ActionEvent evt)
		{
			if (evt.getSource() == termosJCB)
				if (termosJCB.isSelected ())
					sul.activarJCheckBox(true);
				else
					sul.activarJCheckBox(false);
		}
	}

	class PainelSul extends JPanel implements ActionListener
	{
		private JButton proximoJB, naoConcordoJB;

		public PainelSul()
		{	
		setLayout( new GridLayout(2, 1) );
			
			JPanel buttons = new JPanel (new GridLayout (1,1));
			add(new JLabel("            ") );
			add (proximoJB = new JButton("Proximo"));
			add (naoConcordoJB = new JButton("Nao Concordo"));
			add(new JLabel("            ") );
			add(buttons);
			
			add(new JLabel("            ") );
			add(new JLabel("            ") );

			activarJCheckBox(false);

			proximoJB.addActionListener(this);
			naoConcordoJB.addActionListener(this);
		}

		public void activarJCheckBox(boolean estado)
		{
			proximoJB.setEnabled(estado);
		}

		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == proximoJB)
			{
				dispose();
				new LoginVisao();
				criarGUI();
			}
			else
				dispose();
			//	JFrame.frame.dispose();
		}

	}

	public static void main (String [] args)
	{
		Vector_Tabelas.inic();
		new ApresentacaoVisao();
	}
}
