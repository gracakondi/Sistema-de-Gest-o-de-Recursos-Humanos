/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: DepartamentoVisao.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class DepartamentoVisao extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu editarMenu, moverMenu, ajudaMenu;
	private JMenuItem gerenteItem;
	private JMenuItem anteriorItem;
	private JMenuItem sobreItem;	
		
	PainelNorte deptNorte;
	PainelCentro deptCentro;
	PainelSul funSul;

	public DepartamentoVisao ()
	{
		//super("Funcionarios Empregados");
		
		menuBar();
		setJMenuBar(menuBar);
		
		getContentPane().add( deptNorte = new PainelNorte(), BorderLayout.NORTH);
		getContentPane().add(deptCentro = new PainelCentro(), BorderLayout.CENTER);
		
		setTitle("DEPARTAMENTOS");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelNorte extends JPanel
	{
		JLabel bannJL;
	
		public PainelNorte ()
		{	
			setLayout (new GridLayout (1,1));
			
			bannJL = new JLabel(new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/background.png"));
			//ADICIONEI UM SUBTITULO PARA A PAGINA
			add (bannJL);
		}
	} 
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JButton criarDeptJB, editarDeptJB, eliminarDeptJB, verDeptJB;
		
		public PainelCentro()
		{
			setLayout (new GridLayout (1, 4));
			
			//ADICIONEI UM SUBTITULO PARA A PAGINA
			add (new JLabel ("AREA DE RECURSOS HUMANOS")); 
			
			add(verDeptJB = new JButton("Ver Contrato"));
			add(criarDeptJB = new JButton("Criar Contrato"));
			add(editarDeptJB = new JButton("Editar Contrato"));
			add(eliminarDeptJB = new JButton("Eliminar Contrato"));
			
			criarDeptJB.addActionListener(this);
			editarDeptJB.addActionListener(this);
			eliminarDeptJB.addActionListener(this);
			verDeptJB.addActionListener(this);
		}
		
		public void actionPerformed (ActionEvent evt)
		{
			if (evt.getSource() == criarDeptJB)
				new NovoDepartamentoVisao(false, new DepartamentoModelo() );	
				
			 if (evt.getSource() == editarDeptJB)
				new EditarDepartamentoVisao();
				
			else if (evt.getSource() == eliminarDeptJB)
				new EliminarDepartamentoVisao();
				
			if (evt.getSource() == verDeptJB)
				DepartamentoFile.verDepartamentos();
			
		}
	}

	class PainelSul extends JPanel
	{
	}
	
	public static void main (String [] args)
	{
	
		new DepartamentoVisao();
		
	}	
	
	public void menuBar()
	{
		menuBar = new JMenuBar();
		
		editarMenu = new JMenu("Editar Departamentos");
		editarMenu.setMnemonic('L');
		moverMenu = new JMenu("Ir Para");
		moverMenu.setMnemonic('L');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		
		//ITENS DO MENU SAIR
		moverMenu.add(anteriorItem  = new JMenuItem("Voltar"));
		anteriorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		//ITENS DO MENU PESQUISARRR
		editarMenu.add( gerenteItem  = new JMenuItem("Editar Gerentes"));
		//editarMenu.add( pesDepItem  = new JMenuItem("Pesquisar por Departamento"));
		//editarMenu.add( pesIDItem  = new JMenuItem("Pesquisar por ID"));
		ajudaMenu.add(sobreItem = new JMenuItem("Sobre"));

		menuBar.add(editarMenu);		
		menuBar.add(moverMenu);
		menuBar.add(ajudaMenu);
		
		gerenteItem.addActionListener(this);
		anteriorItem.addActionListener(this);	
		sobreItem.addActionListener(this);	
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == gerenteItem)
			Tabela2.editarNovosItems("Gerente.tab", "Novo Gerente");
		if (evt.getSource() == anteriorItem)
			dispose();
		if (evt.getSource() == sobreItem)
			MenuPrincipalVisao.ajuda();
	}
	
}		
