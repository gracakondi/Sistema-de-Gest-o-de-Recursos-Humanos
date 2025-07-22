/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Gildo Kondi
Numero: 33049
Ficheiro: EliminarFuncionarioVisao.java
Data: 14.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EliminarFuncionarioVisao extends JFrame
{	
	
	PainelCentro centro;
	PainelSul sul;
	
	public EliminarFuncionarioVisao()
	{
		super("Pesquisar para Eliminar Dados");
		
		getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
	
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	class PainelCentro extends JPanel implements ActionListener
	{
		JComboBox nomesFunJCB;
		JTextField idJTF;
		JRadioButton pesquisarPorNomeJRB, pesquisarPorIDJRB;
		ButtonGroup group;
		
		public PainelCentro()
		{
			setLayout( new GridLayout(3, 2));
			
			group = new ButtonGroup();
			
			add( pesquisarPorNomeJRB = new JRadioButton("Pesquisar Por Nome", true) );
			add( pesquisarPorIDJRB = new JRadioButton("Pesquisar Por Documento", false) );
			group.add(pesquisarPorNomeJRB);
			group.add(pesquisarPorIDJRB);
			
			add( new JLabel("Escolha o Nome Procurado") );
			add( nomesFunJCB = new JComboBox( FuncionarioFile.getAllNames() ) );
			
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
				nomesFunJCB.setEnabled(true);
				idJTF.setEnabled(false);
			}
			else
			{
				nomesFunJCB.setEnabled(false);
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
			return String.valueOf(nomesFunJCB.getSelectedItem());
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
			add(cancelarJB = new JButton("Cancelar", new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/delete24.png")) );
			
			pesquisarJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == pesquisarJB)
			{
				FuncionarioModelo modelo;
				
				if (centro.getTipoPesquisa() == 1)
				{
					modelo = FuncionarioFile.getFuncionariobyName( centro.getNomeProcurado() );
					
					JOptionPane.showMessageDialog(null, modelo.toString() );
					
					int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja eliminar estes dados?");
					
					if (opcao == JOptionPane.YES_OPTION)
					{
						//eliminar dados
						
						modelo.setStatus(false);
						
						new FuncionarioFile().eliminarDados( modelo );
					}
					else
						JOptionPane.showMessageDialog(null, "Operacao Interrompida por ordem do operador!");
				}
				else
					FuncionarioFile.pesquisarFuncByID( centro.getIDProcurado() );
			}
			else
				dispose();
		}
	}
}
