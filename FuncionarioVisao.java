/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: FuncionarioVisao.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class FuncionarioVisao extends JFrame implements ActionListener
{
	private JMenuBar menuBar;
	
	private JMenu editMenu, moverMenu, ajudaMenu;
	private JMenuItem nacionalidadesItem, estadoCivilItem, provinciaMoradaItem, municipioMoradaItem, bairroMoradaItem, tipoDocumentosItem, departamentoItem;
	private JMenuItem anteriorItem;
	private JMenuItem sobreItem;
	
	PainelCentro funCentro;
	PainelSul funSul;

	public FuncionarioVisao ()
	{
		super("Funcionarios Empregados");
		
		menuBar();
		setJMenuBar(menuBar);
		
		getContentPane().add(funCentro = new PainelCentro(), BorderLayout.CENTER);
		
		//setTitle("Departamentos"); pack();
		setSize(1600, 900);
		setLocationRelativeTo(null);
		setVisible(true);
	}

	class PainelCentro extends JPanel implements ActionListener
	{
		JButton criarFuncJB, editarFuncJB, eliminarFuncJB, verFuncJB;
		
		public PainelCentro()
		{
			setLayout (new GridLayout (1, 4));
			
			//ADICIONEI UM SUBTITULO PARA A PAGINA
			add (new JLabel ("AREA DE RECURSOS HUMANOS")); 
			
			add(verFuncJB = new JButton("Ver Funcionarios"));
			add(criarFuncJB = new JButton("Criar Funcionario"));
			add(editarFuncJB = new JButton("Editar Funcinario"));
			add(eliminarFuncJB = new JButton("Eliminar Funcionario"));
			
			criarFuncJB.addActionListener(this);
			editarFuncJB.addActionListener(this);
			eliminarFuncJB.addActionListener(this);
			verFuncJB.addActionListener(this);
			
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == criarFuncJB)
				new NovoFuncionarioVisao(false, new FuncionarioModelo() );	
				
			 if (evt.getSource() == editarFuncJB)
				new EditarFuncionarioVisao();
				
			else if (evt.getSource() == eliminarFuncJB)
				new EliminarFuncionarioVisao();
				
			else if (evt.getSource() == eliminarFuncJB)
				new EliminarFuncionarioVisao();
				
			if (evt.getSource() == verFuncJB)
				FuncionarioFile.verFuncionarios();
				
					
		}
	}

	class PainelSul extends JPanel
	{
	}
	
	public static void main (String [] args)
	{
		new FuncionarioVisao();
	}
	
	public void menuBar ()
	{
		menuBar = new JMenuBar();
		
		//DANDO NOME AO MENU
		editMenu = new JMenu("Editar Campos");
		editMenu.setMnemonic('L');
		moverMenu = new JMenu("Ir Para");
		moverMenu.setMnemonic('L');
		ajudaMenu = new JMenu("Ajuda");
		ajudaMenu.setMnemonic('A');
		
		//DANDO NOME AOS ITENS
		nacionalidadesItem = new JMenuItem("Nacionalidades");
		provinciaMoradaItem = new JMenuItem("Provincias");
		municipioMoradaItem = new JMenuItem("Municipios");
		bairroMoradaItem  = new JMenuItem("Bairros");
		estadoCivilItem = new JMenuItem("Estado Civil");
		departamentoItem = new JMenuItem("Departamento");
		sobreItem = new JMenuItem("Sobre");
		
		//ITENS DO MENU SAIR
		moverMenu.add(anteriorItem  = new JMenuItem("Voltar"));
		anteriorItem.setAccelerator(KeyStroke.getKeyStroke(KeyEvent.VK_V, InputEvent.CTRL_MASK));
		
		
		//ITENS DO MENU PESQUISARRR
		//editarMenu.add( pesDepItem  = new JMenuItem("Pesquisar por Departamento"));
		//editarMenu.add( pesIDItem  = new JMenuItem("Pesquisar por ID"));
		
		editMenu.add(nacionalidadesItem);
		editMenu.add(provinciaMoradaItem);
		editMenu.add(municipioMoradaItem);
		editMenu.add(bairroMoradaItem);
		editMenu.addSeparator();
		editMenu.add(estadoCivilItem);
		editMenu.add(departamentoItem);
		ajudaMenu.add(sobreItem);

		menuBar.add(editMenu);		
		menuBar.add(moverMenu);
		menuBar.add(ajudaMenu);
		
		nacionalidadesItem.addActionListener(this);
		provinciaMoradaItem.addActionListener(this);
		municipioMoradaItem.addActionListener(this);
		bairroMoradaItem.addActionListener(this);
		estadoCivilItem.addActionListener(this);
		departamentoItem.addActionListener(this);
		anteriorItem.addActionListener(this);
		sobreItem.addActionListener(this);		
	}
	
	public void actionPerformed(ActionEvent evt)
	{
		if (evt.getSource() == nacionalidadesItem)
			Tabela2.editarNovosItems("Nacionalidades.tab", "Nova Nacionalidade");
		if (evt.getSource() == estadoCivilItem)
			Tabela2.editarNovosItems("EstadoCivil.tab", "Novo Estado Civil");
		if (evt.getSource() == tipoDocumentosItem)
			Tabela2.editarNovosItems("TipoDocumentos.tab", "Tipos de Documentos");
		if (evt.getSource() == departamentoItem)
			Tabela2.editarNovosItems("Departamento.tab", "Departamento");
		if (evt.getSource() == provinciaMoradaItem)
			Tabela2.editarNovosItems("Provincias.tab", "Nova Provincia");
		if (evt.getSource() == municipioMoradaItem)
			Tabela3_2.editarNovosItems("Provincias.tab", "Municipios.tab", "Provincias", "Municipios", "Novo Municipio");
		if (evt.getSource() == bairroMoradaItem)
			Tabela3_3.editarNovosItems("Provincias.tab", "Municipios.tab", "Bairro.tab", "Provincias", "Municipios", "Bairro", "Novo Bairro");
		if (evt.getSource() == sobreItem)
			MenuPrincipalVisao.ajuda();
		if (evt.getSource() == anteriorItem)
			dispose();
	}
	
	/*public void ajuda()
	{	
		String output;
		output = "Sobre O sistema de Gestao de Recursos Humanos";
		JTextArea sobre = new JTextArea(40, 40);
			sobre.setText( output );
			sobre.setFocusable(false);
			JOptionPane.showMessageDialog(null, new JScrollPane( sobre ), 
					"Sobre", JOptionPane.INFORMATION_MESSAGE);
	}*/
	
}
