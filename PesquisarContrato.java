/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Osvaldo Ramos
Numero: 2817
Ficheiro: PesquisarContrato.java
Data: 23.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;


public class PesquisarContrato extends JFrame
{	
	PainelCentro centro;
	PainelSul sul;
	
	public PesquisarContrato()
	{
		super("Pesquisar Z Contrato");
		
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
	
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JComboBox nomeContratoJCB;
		JTextField cargoJTF;
		JRadioButton pesquisarPorNomeJRB, pesquisarPorCargo;
		ButtonGroup group;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(3, 2));
			
			group = new ButtonGroup();
			
			add( pesquisarPorNomeJRB = new JRadioButton("Filtrar Por Nome", true) );
			add( pesquisarPorCargo = new JRadioButton("Filtrar Por Cargo do Funcionarrio", false) );
			group.add(pesquisarPorNomeJRB);
			group.add(pesquisarPorCargo);
			
			add( new JLabel("Escolha o Nome Procurado") );
			add( nomeContratoJCB = new JComboBox( FuncionarioFile.getAllNames() ) );
			
			add( new JLabel("Digite o Numero do Docuemento Procurado") );
			add( cargoJTF = new JTextField() );
			cargoJTF.setEnabled(false);
			
			pesquisarPorNomeJRB.addActionListener(this);
			pesquisarPorCargo.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarPorNomeJRB)
			{
				nomeContratoJCB.setEnabled(true);
				cargoJTF.setEnabled(false);
			}
			else
			{
				nomeContratoJCB.setEnabled(false);
				cargoJTF.setEnabled(true);
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
			return String.valueOf(nomeContratoJCB.getSelectedItem());
		}
		public String getIDProcurado()
		{
			return cargoJTF.getText().trim();
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
					ContratoFile.getContratobyName( centro.getNomeProcurado() );
				else
					ContratoFile.pesquisarContratoByID( centro.getIDProcurado() );
			else
				dispose();
		}
	}
}
