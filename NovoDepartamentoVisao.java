/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Kondi
Numero: 33049
Ficheiro: NovoDepartamentoVisao.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class NovoDepartamentoVisao extends JFrame
{
	PainelNorte norte;
	PainelCentro centro;
	PainelSul sul;
	boolean editar;
	
	public NovoDepartamentoVisao (boolean alterar, DepartamentoModelo modelo)
	{
		super("Cadastro de Novo Departamento");
		
		editar = alterar;
		
		definirTema();
		
		JPanel painelNorte = new JPanel();
		JLabel Imagem = new JLabel(new ImageIcon("/home/gildo/Documentos/Osvaldo Ramos/OsvaldoRamos2817/image/topo.jpg"));
		painelNorte.add(Imagem);
		
		getContentPane().add(norte = new PainelNorte(), BorderLayout.NORTH);
		
		if (!alterar)
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		else
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		
		pack();
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	
	class PainelNorte extends JPanel
	{
		JTextArea areaPrincipal;
		
		public PainelNorte()
		{
			setLayout( new GridLayout(1, 1) );
			
		}
	}
	
	class PainelCentro extends JPanel
	{
		private JTextField idJTF, orcamentoJTF, nomeJTF, missaoJTF, nmembrosJTF;
		private JComboBox gerenteJCB;
		private DepartamentoFile deptFile;
		
		
		public PainelCentro()
		{
			setLayout( new GridLayout(3, 4, 10, 4) );
			//(3, 4, 10, 4)
			deptFile = new DepartamentoFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("ID") );
			add( idJTF = new JTextField() );
			idJTF.setText( "00" + deptFile.getProximoCodigo() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Departamento") );
			add( nomeJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			add( new JLabel("Gerente") );
			add( gerenteJCB = UInterfaceBox.createJComboBoxsTabela2("Gerente.tab") );
			add( new JLabel("Missao") );
			add( missaoJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Numero de Membros") );
			add( nmembrosJTF = new JTextField() );
			nmembrosJTF.setText( "00" );
			add( new JLabel("Orcamento") );
			add( orcamentoJTF = new JTextField() );
			add( new JLabel("            ") );
			
		}
		
		public PainelCentro(DepartamentoModelo modelo)
		{
			setLayout( new GridLayout(3, 6, 10, 6) );
			
			deptFile = new DepartamentoFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("Id") );
			add( idJTF = new JTextField() );
			idJTF.setText( "00"+ modelo.getIDDept() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Departamento") );
			add( nomeJTF = new JTextField() );
			nomeJTF.setText( modelo.getNomeDept() );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			add( new JLabel("Gerente") );
			add( gerenteJCB = UInterfaceBox.createJComboBoxsTabela2("Gerente.tab") );
			gerenteJCB.setSelectedItem( modelo.getGerente() );
			add( new JLabel("Missao") );
			add( missaoJTF = new JTextField() );
			missaoJTF.setText( modelo.getMissao() );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Numero de Membros") );
			add( nmembrosJTF = new JTextField() );
			nmembrosJTF.setText( ""+ modelo.getMembros() );
			add( new JLabel("Orcamento") );
			add( orcamentoJTF = new JTextField() );
			orcamentoJTF.setText( modelo.getOrcamento() );
			add( new JLabel("            ") );
			
		}
		
		//METODO GETTERS
		public int getIDDept()
		{
			return Integer.parseInt( idJTF.getText().trim());
		}
		
		public String getNomeDept()
		{
			return nomeJTF.getText().trim();
		}
		
		public int getMembros()
		{
			return Integer.parseInt( nmembrosJTF.getText().trim());
		}
		
		public String getGerente()
		{
			return String.valueOf( gerenteJCB.getSelectedItem() );
		}

		public String getMissao()
		{
			return missaoJTF.getText().trim();
		}
		
		public String getOrcamento()
		{
			return orcamentoJTF.getText().trim();
		}
		
		
		//METODOS SETTERS
		public void setIDDept (int id)
		{
			idJTF.setText("" + id);
		}
		public void setNomeDept (String nome)
		{
			nomeJTF.setText(nome);
		}
		
		public void setMembros (int nmembros)
		{
			nmembrosJTF.setText("" + nmembros);
		}
		
		public void setGerente (String gerente)
		{
			gerenteJCB.setSelectedItem(gerente);
		}
		
		public void setMissao (String missao)
		{
			missaoJTF.setText( missao );
		}
		
		public void setOrcamento(String orcamento)
		{
			orcamentoJTF.setText(orcamento);
		}
		
		
		// --- salvar
		public void guardarDados()
		{			
			DepartamentoModelo modelo = new DepartamentoModelo( getNomeDept(),getIDDept(),
			getMembros(), getGerente(), getMissao(), getOrcamento(), true);
		
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
			modelo.guardarDados();			
			dispose();
		}
		
		//--- alterar
		public void alterar()
		{			
			DepartamentoModelo modelo = new DepartamentoModelo( getNomeDept(),getIDDept(),
			getMembros(), getGerente(), getMissao(), getOrcamento(), true);
					
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
			modelo.altera();			
			dispose();
		}
		
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton salvarJB, cancelarJB;
		
		public PainelSul()
		{
			add(salvarJB = new JButton("Salvar", new ImageIcon("") ) );
			add(cancelarJB = new JButton("Cancelar", new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/delete24.png")) );
			
			salvarJB.addActionListener(this);
			cancelarJB.addActionListener(this);
		}
		
		public void actionPerformed(ActionEvent evt)
		{
			if (evt.getSource() == salvarJB)
				if (editar)
					centro.alterar();
				else
					centro.guardarDados();
			else
				dispose();
		}
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
