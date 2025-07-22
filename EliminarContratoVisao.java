/*------------------------------------
Tema: Gestão de uma Morgue
Nome: Gildo Kondi
Numero: 33049
Ficheiro: EliminarContratoVisao.java
Data: 14.06.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class EliminarContratoVisao extends JFrame
{	
	
	PainelCentro centro;
	PainelSul sul;
	
	public EliminarContratoVisao()
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
		JComboBox nomeContratoJCB;
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
			add( nomeContratoJCB = new JComboBox( ContratoFile.getAllNames() ) );
			
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
				nomeContratoJCB.setEnabled(true);
				idJTF.setEnabled(false);
			}
			else
			{
				nomeContratoJCB.setEnabled(false);
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
			return String.valueOf(nomeContratoJCB.getSelectedItem());
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
				ContratoModelo modelo;
				
				if (centro.getTipoPesquisa() == 1)
				{
					modelo = ContratoFile.getContratobyName( centro.getNomeProcurado() );
					
					JOptionPane.showMessageDialog(null, modelo.toString() );
					
					int opcao = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja eliminar estes dados?");
					
					if (opcao == JOptionPane.YES_OPTION)
					{
						//eliminar dados
						
						modelo.setStatus(false);
						
						new ContratoFile().eliminarDados( modelo );
					}
					else
						JOptionPane.showMessageDialog(null, "Operacao Interrompida por ordem do operador!");
				}
				else
					ContratoFile.pesquisarContratoByID( centro.getIDProcurado() );
			}
			else
				dispose();
		}
	}
}
