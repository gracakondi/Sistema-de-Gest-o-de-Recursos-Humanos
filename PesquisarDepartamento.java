/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: PesquisarDepartamentoVisao.java
Data: 23.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;


public class PesquisarDepartamento extends JFrame
{	
	PainelCentro centro;
	PainelSul sul;
	
	public PesquisarDepartamento()
	{
		super("Pesquisar Funcionario");
		
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
	
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JComboBox nomeDeptJCB;
		JTextField idJTF;
		JRadioButton pesquisarPorNomeJRB, pesquisarPorIDJRB;
		ButtonGroup group;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(3, 2));
			
			group = new ButtonGroup();
			
			add( pesquisarPorNomeJRB = new JRadioButton("Pesquisar Por Nome", true) );
			add( pesquisarPorIDJRB = new JRadioButton("Pesquisar Por ID do Funcionarrio", false) );
			group.add(pesquisarPorNomeJRB);
			group.add(pesquisarPorIDJRB);
			
			add( new JLabel("Escolha o Nome Procurado") );
			add( nomeDeptJCB = new JComboBox( DepartamentoFile.getAllNames() ) );
			
			add( new JLabel("Digite o Numero do Docuemento Procurado") );
			add( idJTF = new JTextField() );
			idJTF.setEnabled(false);
			
			pesquisarPorNomeJRB.addActionListener(this);
			pesquisarPorIDJRB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarPorNomeJRB)
			{
				nomeDeptJCB.setEnabled(true);
				idJTF.setEnabled(false);
			}
			else
			{
				nomeDeptJCB.setEnabled(false);
				idJTF.setEnabled(true);
			}
		}
		
		public int getTipoPesquisa()
		{
			if (pesquisarPorNomeJRB.isSelected())
				return 1;
			else
				return 2;
		}
		public String getNomeProcurado()
		{
			return String.valueOf(nomeDeptJCB.getSelectedItem());
		}
		public String getIDProcurado()
		{
			return idJTF.getText().trim();
		}
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton pesquisarJB, cancelarJB;
		
		public PainelSul()
		{
			add(pesquisarJB = new JButton("Pesquisar", new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/search32.png") ) );
			add(cancelarJB = new JButton("Cancelar" , new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/delete24.png")) );
			
			pesquisarJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarJB)
				if (centro.getTipoPesquisa() == 1)
					DepartamentoFile.getDeptbyName( centro.getNomeProcurado() );
				else
					DepartamentoFile.pesquisarDeptByID( centro.getIDProcurado() );
			else
				dispose();
		}
	}
}
