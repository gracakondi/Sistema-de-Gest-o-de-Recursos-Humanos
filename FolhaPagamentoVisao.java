/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: FolhaPagamentoVisao.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class FolhaPagamentoVisao extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	private JMenu editarMenu, moverMenu, ajudaMenu;
	private JMenuItem funcionarioItem;
	private JMenuItem anteriorItem;
	private JMenuItem sobreItem;
	
	PainelCentro funCentro;
	PainelSul funSul;

	public FolhaPagamentoVisao ()
	{
		//super("Funcionarios Empregados");

		menuBar();
		setJMenuBar(menuBar);
		
		setTitle("FOLHA DE PAGAMENTOS");
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelNorte extends JPanel
	{
	}  
	
	class PainelCentro extends JPanel
	{
		
		public PainelCentro()
		{
		}
	}

	class PainelSul extends JPanel
	{
	}

	public static void main (String [] args)
	{
		new FolhaPagamentoVisao();
				
	}	
	
	public void menuBar ()
	{
		menuBar = new JMenuBar();
		
		editarMenu = new JMenu("Editar Folha");
		editarMenu.setMnemonic('L');
		moverMenu = new JMenu("Ir Para");
		moverMenu.setMnemonic('L');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		
		//ITENS DO MENU SAIR
		moverMenu.add(anteriorItem  = new JMenuItem("Voltar"));
		anteriorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		//ITENS DO MENU PESQUISARRR
		editarMenu.addSeparator();
		editarMenu.add( funcionarioItem  = new JMenuItem("Editar Funcionario Existente"));
		//editarMenu.add( pesDepItem  = new JMenuItem("Pesquisar por Departamento"));
		//editarMenu.add( pesIDItem  = new JMenuItem("Pesquisar por ID"));

		menuBar.add(editarMenu);		
		menuBar.add(moverMenu);
		menuBar.add(ajudaMenu);
		
		anteriorItem.addActionListener(this);
				
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == anteriorItem)
			dispose();
	}
}		
