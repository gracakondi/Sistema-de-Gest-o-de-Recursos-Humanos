/*
Tema: Gestao de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: MenuPrincipalVisao.java
Data: 25-05-2024
*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import javax.swing.UIManager.*;

public class MenuPrincipalVisao extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu pesquisaMenu,ajudaMenu;
	private JMenuItem pesFuncItem, pesDepItem, pesContItem; 
	private JMenuItem sobreItem, sairItem;
	
	PainelNorte menuNorte;
	PainelCentro menuCentro;
	PainelSul menuSul;
	
	public MenuPrincipalVisao (String usuario)
	{	
		
		instanciarObjectos();
		
		setJMenuBar(menuBar);

		definirTema();
		//PainelNorte.add(lbImagem);
	
		getContentPane().add( menuNorte = new PainelNorte(), BorderLayout.NORTH);
		getContentPane().add( menuCentro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add( menuSul = new PainelSul(), BorderLayout.SOUTH);
		
		setTitle("Departamento dos Recursos Humanos: " + usuario);
		setSize(1600, 900);
		setVisible(true);
		setLocationRelativeTo(null);
	}
	
	class PainelNorte extends JPanel
	{	
		JLabel bannerJL;
	
		public PainelNorte ()
		{	
			setLayout (new GridLayout (1,1));
			
			bannerJL = new JLabel(new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/menu.jpeg"));
			add (bannerJL);
		}
	}
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JTextField  titleJTF;
		JButton funcionarioJB, departamentoJB, folhaJB, contratoJB;
		
		public PainelCentro ()
		{	
			setLayout (new GridLayout (2, 4));

			//ADICIONANDO O NOME AOS BOTOES E LINHAS
			add(new JLabel("   ")); add( funcionarioJB = new JButton("Funcionarios"));add( contratoJB = new JButton("Contratos"));add(new JLabel("   ")); 
			
			add(new JLabel("   ")); add( folhaJB = new JButton("Folha de Pagamento"));add( departamentoJB = new JButton("Departamento"));add(new JLabel("   "));
			
			//ADICIONANDO O EVENTO AOS BOTOES
			funcionarioJB.addActionListener(this);
			departamentoJB.addActionListener(this);
			folhaJB.addActionListener(this);
			contratoJB.addActionListener(this);

		}
		
		public void actionPerformed(ActionEvent evt)
		{			
			if (evt.getSource() == funcionarioJB)		
				new FuncionarioVisao();	
				
			 if (evt.getSource() == contratoJB)		
				new ContratoVisao();	
			
			 if (evt.getSource() == departamentoJB)		
				new DepartamentoVisao();	
		
			 if (evt.getSource() == folhaJB)
				new FolhaPagamentoVisao();	
		}
	}

	class PainelSul extends JPanel 
	{
		public PainelSul ()
		{
			setLayout (new GridLayout (1,3));

		add(new JLabel("-----------------------"));
		add(new JLabel ("Desenvolvido por Gildo Kondi, 2024"));
		add(new JLabel ("--------------------"));
		
		}
	
	}
	
	public void instanciarObjectos()
	{
		menuBar = new JMenuBar();
		
		pesquisaMenu = new JMenu("Pesquisar");
		pesquisaMenu.setMnemonic('P');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		//ITENS DO MENU SAIR
		sairItem = new JMenuItem("Sair");
		sairItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_S, InputEvent.CTRL_MASK));
		
		
		//ITENS DO MENU PESQUISARRR
		pesquisaMenu.add( pesFuncItem  = new JMenuItem("Pesquisar por Funcionario"));
		pesquisaMenu.add( pesDepItem  = new JMenuItem("Pesquisar por Departamento"));
		pesquisaMenu.add( pesContItem  = new JMenuItem("Pesquisar por Contrato"));	

		sobreItem = new JMenuItem("Sobre");
		
		ajudaMenu.add(sobreItem);
		ajudaMenu.add(sairItem);

		menuBar.add(pesquisaMenu);
		menuBar.add(ajudaMenu);
		
		sairItem.addActionListener(this);
		sobreItem.addActionListener(this);
		
		pesFuncItem.addActionListener(this);
		pesDepItem.addActionListener(this);
		pesContItem.addActionListener(this); 
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == sobreItem)
			//ajuda();
			JOptionPane.showMessageDialog(null, "Amigonaaaaaa");
		if (evt.getSource() == pesFuncItem)
			new PesquisarFuncionario();
		if (evt.getSource() == pesDepItem)
			 new PesquisarDepartamento();
		if (evt.getSource() == pesContItem)
			new PesquisarContrato();
		
	}
	
	public static void ajuda()
	{	
		String output = "Sobre O sistema de Gestao de Recursos Humanos\n\n";
		JTextArea sobre = new JTextArea(20, 40);
			sobre.setText( output );
			sobre.setFocusable(false);
		//	JOptionPane.showMessageDialog(null, new JScrollPane( sobre ), 		"Sobre");
					//JOptionPane.INFORMATION_MESSAGE
	}
	 public void definirTema() 
	 {
        try {
            for (LookAndFeelInfo info : UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException e) {
        }
    } 
	
}

