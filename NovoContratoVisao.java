/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Kondi
Numero: 33049
Ficheiro: NovoContratoVisao.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class NovoContratoVisao extends JFrame
{
	PainelNorte norte;
	PainelCentro centro;
	PainelSul sul;
	boolean editar;
	
	public NovoContratoVisao (boolean alterar, ContratoModelo modelo)
	{
		super("Cadastro de Novo Contrato");
		
		editar = alterar;
		
		definirTema();
		
		/*JPanel painelNorte = new JPanel();
		JLabel lbImagem = new JLabel(new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/topo.jpg"));
		painelNorte.add(lbImagem);*/
		
		getContentPane().add(norte = new PainelNorte(), BorderLayout.NORTH);
		
		if (!alterar)
			getContentPane().add(centro = new PainelCentro(), BorderLayout.CENTER);
		else
			getContentPane().add(centro = new PainelCentro(modelo), BorderLayout.CENTER);
		
		getContentPane().add(sul = new PainelSul(), BorderLayout.SOUTH);
		
		//setSize(1600, 900);
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
			
			add( new JScrollPane( areaPrincipal = new JTextArea(40, 30) ) );
			areaPrincipal.setFocusable(false);
			areaPrincipal.setText("\t SISTEMA DE GESTAO DE RECURSOS HUMANOS\n\n" +
			
			"\t ATENCAO!!!Este sistema foi concebido para facilitar o controlo e \n" + 
			"\t Preencher os Campos de forma corecta para poderem ser guardados de forma correcta");
			
		}
	}
	
	class PainelCentro extends JPanel
	{
		private JTextField idJTF, horarioJTF, bancoJTF, contaBancariaJTF, cargoJTF, salarioJTF, dataInicioJTF, dataFimJTF;
		private JComboBox departContratoJCB, nomeJCB, tipoContratoJCB, departamentoJCB;
		private String [] tipoContratoArray = {"Mensal", "Semenstral", "Anual"};
		private JTextFieldData txtData, txtDataEnd;
		private ContratoFile contrFile;
		
	//	DataModelo dataContrato, dataExpirar;
		
		
		public PainelCentro()
		{
			setLayout( new GridLayout(6, 4, 10, 4) );
			
			contrFile = new ContratoFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("ID") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000" + contrFile.getProximoCodigo() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Funcionario") );
			add( nomeJCB = UInterfaceBox.createJComboBoxsTabela2("Nome.tab") );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			add( new JLabel("Departamento") );
			add( departContratoJCB = UInterfaceBox.createJComboBoxsTabela2("Departamento.tab") );
			add( new JLabel("Cargo") );
			add( cargoJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Tipo de Contrato") );
			add( tipoContratoJCB = new JComboBox( tipoContratoArray ) );
			add( new JLabel("Jornada Trabalhista / Horario") );
			add( horarioJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha4
			add( new JLabel("            ") );
			add( new JLabel("Banco") );
			add( bancoJTF = new JTextField() );
			add( new JLabel("Conta Bancaria") );
			add( contaBancariaJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha5
			add( new JLabel("            ") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			add( new JLabel("Data de Inicio") );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);
			
			JPanel painelData1 = new JPanel( new GridLayout(1, 1) );
			add( new JLabel("Data de Fim") );
			txtDataEnd = new JTextFieldData("Data?");
			painelData1.add( txtDataEnd.getDTestField() );
			painelData1.add( txtDataEnd.getDButton() );
			add(painelData1);
			add( new JLabel("            ") );
			
			//linha6
			add( new JLabel("            ") );
			add( new JLabel("            ") );
			add( new JLabel("Salario") );
			add( salarioJTF = new JTextField() );
		}
		
		public PainelCentro(ContratoModelo modelo)
		{
			setLayout( new GridLayout(7, 6, 10, 6) );
		
				contrFile = new ContratoFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("ID") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000" + contrFile.getProximoCodigo() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Funcionario") );
			add( nomeJCB = UInterfaceBox.createJComboBoxsTabela2("Nome.tab") );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			add( new JLabel("Departamento") );
			add( departContratoJCB = UInterfaceBox.createJComboBoxsTabela2("Departamento.tab") );
			add( new JLabel("Cargo") );
			add( cargoJTF = new JTextField() );
			cargoJTF.setText( modelo.getcargoContrato() );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Tipo de Contrato") );
			add( tipoContratoJCB = new JComboBox( tipoContratoArray ) );
			add( new JLabel("Jornada Trabalhista / Horario") );
			add( horarioJTF = new JTextField() );
			horarioJTF.setText( modelo.getHorario() );
			add( new JLabel("            ") );
			
			//linha4
			add( new JLabel("            ") );
			add( new JLabel("Banco") );
			add( bancoJTF = new JTextField() );
			bancoJTF.setText( modelo.getBanco() );
			add( new JLabel("Conta Bancaria") );
			add( contaBancariaJTF = new JTextField() );
			contaBancariaJTF.setText( modelo.getContaBancaria() );
			add( new JLabel("            ") );
			
			//linha5
			add( new JLabel("            ") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			add( new JLabel("Data de Inicio") );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);
			txtData.getDTestField().setText( modelo.getDataInicio() );
			
			JPanel painelData1 = new JPanel( new GridLayout(1, 1) );
			add( new JLabel("Data de Fim") );
			txtDataEnd = new JTextFieldData("Data?");
			painelData1.add( txtDataEnd.getDTestField() );
			painelData1.add( txtDataEnd.getDButton() );
			add(painelData1);
			txtDataEnd.getDTestField().setText( modelo.getDataFim() );
			add( new JLabel("            ") );
			
			//linha6
			add( new JLabel("            ") );
			add( new JLabel("            ") );
			add( new JLabel("Salario") );
			add( salarioJTF = new JTextField() );
			salarioJTF.setText( modelo.getSlarioContrato() );
		}
		
		//METODO GETTERS
		public int getID()
		{
			return Integer.parseInt( idJTF.getText().trim());
		}
		
		public String getNome()
		{
			return String.valueOf( nomeJCB.getSelectedItem() );
		}
		
		public String getTipoContrato()
		{
			return String.valueOf( tipoContratoJCB.getSelectedItem() );
		}
		
		public String getDepartContrato()
		{
			return String.valueOf( departContratoJCB.getSelectedItem() );	
		}

		public String getHorario()
		{
			return horarioJTF.getText().trim();
		}
		
		public String getBanco()
		{
			return bancoJTF.getText().trim();
		}
		
		public String getContaBancaria()
		{
			return contaBancariaJTF.getText().trim();
		}
		
		public String getSlarioContrato()
		{
			return salarioJTF.getText().trim();
		}
		
		public String getDataInicio()
		{
			return txtData.getDTestField().getText();
		}
		
		public String getDataFim()
		{
			return txtDataEnd.getDTestField().getText();
		}
		
		public String getcargoContrato()
		{
			return cargoJTF.getText().trim();
		}
		
		
		
		//METODOS SETTERS
		public void setIDContrato (int id)
		{
			idJTF.setText("" + id);
		}
		
		public void setNomeContrato (String nome)
		{
			nomeJCB.setSelectedItem( nome );
		}
		
		public void setTipoContrato (String tipoContrato)
		{
			tipoContratoJCB.setSelectedItem( tipoContrato );
		}
		
		public void setDepartContrato (String departamento)
		{
			departContratoJCB.setSelectedItem( departamento );
		}
		
		public void setHorario (String horario)
		{
			horarioJTF.setText( horario );	
		}
		
		public void setBanco (String banco)
		{
			bancoJTF.setText( banco );
		}
		
		public void setContaBancaria (String contaBancaria)
		{
			contaBancariaJTF.setText(contaBancaria);
		}
		
		public void setDataContrato (String dataContrato)
		{
			txtData.getDTestField().setText(dataContrato);
		}
		
		public void setDataExpirar(String dataExpirar)
		{
			txtDataEnd.getDTestField().setText(dataExpirar);
		}
		
		public void setCargoContrato (String cargoContrato)
		{
			cargoJTF.setText(cargoContrato);
		}
		
		
		// --- salvar
		public void guardarDados()
		{			
			ContratoModelo modelo = new ContratoModelo(getID(), getNome(),
			getTipoContrato(), getDepartContrato(), getHorario(),
			getBanco(), getContaBancaria(), getSlarioContrato(), 
			getDataInicio(),getDataFim(), getcargoContrato(),true );

					
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
	//		modelo.guardarDados();			
			dispose();
		}
		
		//--- alterar
		public void alterar()
		{			
			ContratoModelo modelo = new ContratoModelo(getID(), getNome(),
			getTipoContrato(), getDepartContrato(), getHorario(),
			getBanco(), getContaBancaria(), getSlarioContrato(), 
			getDataInicio(),getDataFim(), getcargoContrato(),true ); 
					
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
		//	modelo.alterarDados();			
			dispose();
		}
		
	}
	
	class PainelSul extends JPanel implements ActionListener
	{
		JButton salvarJB, cancelarJB;
		
		public PainelSul()
		{
			add(salvarJB = new JButton("Salvar", new ImageIcon("/home/gildo/Documentos/GildoKondi33049/Image/save24.png") ) );
			add(cancelarJB = new JButton("Cancelar") );
			
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
    
 
   public static void main (String [] args)
	{
		new NovoContratoVisao(false, new ContratoModelo() );	
		
	}
}
