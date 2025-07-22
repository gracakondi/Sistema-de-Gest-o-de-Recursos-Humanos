/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: ContratoVisao.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class ContratoVisao extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu editarMenu, moverMenu, ajudaMenu;
	private JMenuItem funcionarioItem, tipoDepartamentoItem, tipoContratoItem;
	private JMenuItem anteriorItem;
	private JMenuItem sobreItem;

	PainelCentro funCentro;
	PainelSul funSul;

	public ContratoVisao ()
	{
		//super("Funcionarios Empregados");
		
		menuBar();
		setJMenuBar(menuBar);
		
		getContentPane().add(funCentro = new PainelCentro(), BorderLayout.CENTER);
		
		setTitle("CONTRATOS");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel implements ActionListener
	{
		JButton criarConJB, editarConJB, eliminarConJB, verConJB;
		
		public PainelCentro()
		{
			setLayout (new GridLayout (1, 4));
			
			//ADICIONEI UM SUBTITULO PARA A PAGINA
			add (new JLabel ("AREA DE RECURSOS HUMANOS")); 
			
			add(verConJB = new JButton("Ver Contrato"));
			add(criarConJB = new JButton("Criar Contrato"));
			add(editarConJB = new JButton("Editar Contrato"));
			add(eliminarConJB = new JButton("Eliminar Contrato"));
			
			criarConJB.addActionListener(this);
			editarConJB.addActionListener(this);
			eliminarConJB.addActionListener(this);
			verConJB.addActionListener(this);
			
		}
		
		public void actionPerformed (ActionEvent evt)
		{
			if (evt.getSource() == criarConJB)
				new NovoContratoVisao(false, new ContratoModelo() );	
				
			 if (evt.getSource() == editarConJB)
				new EditarContratoVisao();
				
			if (evt.getSource() == eliminarConJB)
				new EliminarContratoVisao();
				
			if (evt.getSource() == verConJB)
				ContratoFile.verContratos();
		}
		
	}

	class PainelSul extends JPanel
	{
	}

	
	public static void main (String [] args)
	{
		new ContratoVisao();
				
	}
	
	public void menuBar ()
	{
		menuBar = new JMenuBar();
		
		editarMenu = new JMenu("Editar Campos do Contrato");
		editarMenu.setMnemonic('L');
		moverMenu = new JMenu("Ir Para");
		moverMenu.setMnemonic('L');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		
		//ITENS DO MENU SAIR
		moverMenu.add(anteriorItem  = new JMenuItem("Voltar"));
		anteriorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		//ITENS DO MENU PESQUISARRR
	//	editarMenu.addSeparator();
		editarMenu.add( funcionarioItem  = new JMenuItem("Adicionar Funcionario"));
		editarMenu.add( tipoDepartamentoItem  = new JMenuItem("Editar Tipos de Departamentos"));
		editarMenu.add( tipoContratoItem  = new JMenuItem("Editar Tipos de Contratos"));
		ajudaMenu.add( sobreItem = new JMenuItem("Sobre"));
		
		menuBar.add(editarMenu);		
		menuBar.add(moverMenu);
		menuBar.add(ajudaMenu);
		
		editarMenu.add(funcionarioItem);
		editarMenu.add(tipoDepartamentoItem);
		editarMenu.add(tipoContratoItem);
				
		anteriorItem.addActionListener(this);
		funcionarioItem.addActionListener(this);
		tipoDepartamentoItem.addActionListener(this);
		tipoContratoItem.addActionListener(this);
		sobreItem.addActionListener(this);
		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == anteriorItem)
			dispose();
		
		if (evt.getSource() == funcionarioItem)
			Tabela2.editarNovosItems("Nome.tab", "Novo Funcionario");
		
		if (evt.getSource() == tipoContratoItem)
			Tabela2.editarNovosItems("ContratoTipo.tab", "Tipos de Contratos");
		if (evt.getSource() == tipoDepartamentoItem)
			Tabela2.editarNovosItems("Departamento.tab", "Departamento");
			
		if (evt.getSource() == sobreItem)
			MenuPrincipalVisao.ajuda();
	}	
	
}		
