/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Kondi
Numero: 33049
Ficheiro: NovoFuncionarioVisao.java
Data: 24.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import javax.swing.UIManager.*;

public class NovoFuncionarioVisao extends JFrame
{
	PainelNorte norte;
	PainelCentro centro;
	PainelSul sul;
	boolean editar;
	
	public NovoFuncionarioVisao (boolean alterar, FuncionarioModelo modelo)
	{
		super("Cadastro de Novo Funcionario");
		
		editar = alterar;
		
	//	definirTema();
		
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
			
			/*add( new JScrollPane( areaPrincipal = new JTextArea(40, 30) ) );
			areaPrincipal.setFocusable(false);
			areaPrincipal.setText("\t SISTEMA DE GESTAO DE RECURSOS HUMANOS\n\n" +
			
			"\t ATENCAO!!!Este sistema foi concebido para facilitar o controlo e \n" + 
			"\t Preencher os Campos de forma corecta para poderem ser guardados de forma correcta");
			
		//	add( concordarJCB = new JCheckBox("concordo com os termos de uso!") );
			
		//	concordarJCB.addActionListener( this );*/
		}
	}
	
	class PainelCentro extends JPanel
	{
		private JTextField idJTF, nomeJTF, moradaJTF, emailJTF, contactoJTF,cargoJTF, data_nascJTF;
		private JComboBox nacionalidadeJCB, estadoCivilJCB, generoJCB, academicoJCB, departamentoJCB;
		private JComboBoxPersonal provinciasJCB, municipiosJCB, bairroJCB;
		private JComboBoxTabela3_Tabela3 provMunCom;
		private String [] generosArray = {"Masculino", "Feminino", "Personalisado"};
		private String [] academicoArray = {"Engenheiro","Lincenciado", "Universitario", "Doutor", "N/ Mencionado"};
		private String [] departamentoArray = {"Departamento da Limpeza", "Departamento da Seguranca"};
		private JTextFieldData txtData;
		private FuncionarioFile funcFile;
		
		
		public PainelCentro()
		{
			setLayout( new GridLayout(8, 6, 10, 6) );
			
			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Bairro.tab");
			funcFile = new FuncionarioFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("ID") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000" + funcFile.getProximoCodigo() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Funcionario") );
			add( nomeJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			add( new JLabel("Data de Nascimento") );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);
			add( new JLabel("Genero") );
			add( generoJCB = new JComboBox( generosArray ) );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Morada") );
			add( moradaJTF = new JTextField() );
			add( new JLabel("Estado Civil") );
			add( estadoCivilJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoCivil.tab") );
			add( new JLabel("            ") );
			
			//linha4
			add( new JLabel("            ") );
			add( new JLabel("email") );
			add( emailJTF = new JTextField() );
			add( new JLabel("Contacto") );
			add( contactoJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha5
			add( new JLabel("            ") );
			add( new JLabel("Nacionalidade") );
			add( nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab") );
			add( new JLabel("Provincia") );
			add( provinciasJCB = provMunCom.getComboBoxFather() );
			add( new JLabel("            ") );
			
			//linha6
			add( new JLabel("            ") );
			add( new JLabel("Municipio") );
			add( municipiosJCB = provMunCom.getComboBoxSun() );
			add( new JLabel("Bairro") );
			add( bairroJCB = provMunCom.getComboBoxNeto() );
			add( new JLabel("            ") );
			
			//linha7
			add( new JLabel("            ") );
			add( new JLabel("Departamento") );
			add( departamentoJCB = UInterfaceBox.createJComboBoxsTabela2("Departamento.tab") );
			add( new JLabel("Cargo") );
			add( cargoJTF = new JTextField() );
			add( new JLabel("            ") );
			
			//linha8
			add( new JLabel("            ") );
			add( new JLabel("            ") );
			add( new JLabel("Nivel Academico") );
			add( academicoJCB = new JComboBox( academicoArray ) );
			add( new JLabel("            ") );
		}
		
		public PainelCentro(FuncionarioModelo modelo)
		{
			setLayout( new GridLayout(8, 6, 10, 6) );
			
			provMunCom = new JComboBoxTabela3_Tabela3("Provincias.tab", "Municipios.tab", "Bairro.tab");
			funcFile = new FuncionarioFile();
			
			//linha1
			add( new JLabel("            ") );
			add( new JLabel("Id") );
			add( idJTF = new JTextField() );
			idJTF.setText( "000"+ modelo.getID() );
			idJTF.setFocusable(false);
			add( new JLabel("Nome do Funcionario") );
			add( nomeJTF = new JTextField() );
			nomeJTF.setText( modelo.getNome() );
			add( new JLabel("            ") );
			
			//linha2
			add( new JLabel("            ") );
			add( new JLabel("Data de Nascimento") );
			JPanel painelData = new JPanel( new GridLayout(1, 1) );
			txtData = new JTextFieldData("Data?");
			painelData.add( txtData.getDTestField() );
			painelData.add( txtData.getDButton() );
			add(painelData);	
			txtData.getDTestField().setText( modelo.getData_nasc() );
			add( new JLabel("Genero") );
			add( generoJCB = new JComboBox( generosArray ) );
			generoJCB.setSelectedItem( modelo.getGenero() );
			add( new JLabel("            ") );
			
			//linha3
			add( new JLabel("            ") );
			add( new JLabel("Morada") );
			add( moradaJTF = new JTextField() );
			moradaJTF.setText( modelo.getMorada() );
			add( new JLabel("Estado Civil") );
			add( estadoCivilJCB = UInterfaceBox.createJComboBoxsTabela2("EstadoCivil.tab") );
			estadoCivilJCB.setSelectedItem( modelo.getEstadoCivil() );
			add( new JLabel("            ") );
			
			//linha4
			add( new JLabel("            ") );
			add( new JLabel("E-mail") );
			add( emailJTF = new JTextField() );
			emailJTF.setText( modelo.getEmail() );
			add( new JLabel("Contacto") );
			add( contactoJTF = new JTextField() );
			contactoJTF.setText( modelo.getContacto() );
			add( new JLabel("            ") );
			
			//linha5
			add( new JLabel("            ") );
			add( new JLabel("Nacionalidade") );
			add( nacionalidadeJCB = UInterfaceBox.createJComboBoxsTabela2("Nacionalidades.tab") );
			nacionalidadeJCB.setSelectedItem( modelo.getNacionalidade() );
			add( new JLabel("Provincia") );
			add( provinciasJCB = provMunCom.getComboBoxFather() );
			provinciasJCB.setSelectedItem( modelo.getProvincia() );
			add( new JLabel("            ") );
			
			//linha6
			add( new JLabel("            ") );
			add( new JLabel("Municipio") );
			add( municipiosJCB = provMunCom.getComboBoxSun() );
			municipiosJCB.setSelectedItem( modelo.getMunicipio() );
			add( new JLabel("Bairro") );
			add( bairroJCB = provMunCom.getComboBoxNeto() );
			bairroJCB.setSelectedItem( modelo.getBairro() );
			add( new JLabel("            ") );			
			
			//linha7
			add( new JLabel("            ") );
			add( new JLabel("Departamento") );
			add( departamentoJCB = UInterfaceBox.createJComboBoxsTabela2("Departamento.tab") );
			departamentoJCB.setSelectedItem( modelo.getEstadoCivil() );
			add( new JLabel("Cargo") );
			add( cargoJTF = new JTextField() );
			cargoJTF.setText( modelo.getCargo() );
			add( new JLabel("            ") );
			
			//linha8
			add( new JLabel("            ") );
			add( new JLabel("            ") );
			add( new JLabel("Nivel Academico") );
			add( academicoJCB = new JComboBox( academicoArray ) );
			academicoJCB.setSelectedItem( modelo.getAcademico() );
			add( new JLabel("            ") );
			
		}
		
		//METODO GETTERS
		public int getID()
		{
			return Integer.parseInt( idJTF.getText().trim());
		}
		
		public String getNome()
		{
			return nomeJTF.getText().trim();
		}
		
		public String getMorada()
		{
			return moradaJTF.getText().trim();
		}
		
		public String getData_nasc ()
		{
			return txtData.getDTestField().getText();
		}

		public String getEmail()
		{
			return emailJTF.getText().trim();
		}
		
		public String getContacto()
		{
			return contactoJTF.getText().trim();
		}
		
		public String getCargo()
		{
			return cargoJTF.getText().trim();
		}
		
		public String getDepartamento()
		{
			return String.valueOf( departamentoJCB.getSelectedItem() );
		}
		
		public String getAcademico()
		{
			return String.valueOf( academicoJCB.getSelectedItem() );
		}
		
		public String getEstadoCivil()
		{
			return String.valueOf( estadoCivilJCB.getSelectedItem() );
		}
		
		public String getGenero()
		{
			return String.valueOf( generoJCB.getSelectedItem() );
		}
		
		public String getNacionalidade()
		{
			return String.valueOf( nacionalidadeJCB.getSelectedItem() );
		}
		
		public String getProvincia()
		{
			return String.valueOf( provinciasJCB.getSelectedItem() );
		}
		public String getMunicipio()
		{
			return String.valueOf(municipiosJCB.getSelectedItem() );
		}
		public String getBairro()
		{
			return String.valueOf( bairroJCB.getSelectedItem() );
		}

		
		//METODOS SETTERS
		public void setID (int id)
		{
			idJTF.setText("" + id);
		}
		public void setNome (String nome)
		{
			nomeJTF.setText(nome);
		}
		
		public void setMorada (String morada)
		{
			moradaJTF.setText( morada );
		}
		
		public void setData_nasc(String data_nasc)
		{
			txtData.getDTestField().setText(data_nasc);
		}
		
		public void setEmail (String email)
		{
			emailJTF.setText( email );
		}
		
		public void setContacto(String contacto)
		{
			contactoJTF.setText(contacto);
		}
		
		public void setcargoJTF (String cargo)
		{
			cargoJTF.setText(cargo);
		}
		
		public void setDepartamento (String departamento)
		{
			departamentoJCB.setSelectedItem( departamento );
		}
		
		public void setAcademico (String academico)
		{
			academicoJCB.setSelectedItem(academico);
		}
		
		public void setEstadoCivil(String estadoCivil)
		{
			estadoCivilJCB.setSelectedItem( estadoCivil );
		}
		
		public void setGenero(String genero)
		{
			generoJCB.setSelectedItem(genero);
		}
		
		public void setNacionalidade(String nacionalidade)
		{
			nacionalidadeJCB.setSelectedItem( nacionalidade );
		}
		
		public void setProvincia(String provincia)
		{
			provinciasJCB.setSelectedItem(provincia);
		}
		
		public void setMunicipio(String municipio)
		{
			municipiosJCB.setSelectedItem(municipio);
		}
		
		public void setbairro (String bairro)
		{
			bairroJCB.setSelectedItem(bairro);
		}
		
		


		// --- salvar
		public void guardar()
		{			
			FuncionarioModelo modelo = new FuncionarioModelo(getID(), getNome(),
			getMorada(), getData_nasc(), getEmail(),
			getContacto(), getEstadoCivil(), getGenero(), getNacionalidade(),  
			getProvincia(), getMunicipio(), getBairro() , getAcademico(), getDepartamento(), getCargo(), true);
	
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
			modelo.guardar();			
			dispose();
		}
		
		//--- alterar
		public void alterar()
		{			
			FuncionarioModelo modelo = new FuncionarioModelo(getID(), getNome(),
			getMorada(), getData_nasc(), getEmail(),
			getContacto(), getEstadoCivil(), getGenero(), getNacionalidade(),  
			getProvincia(), getMunicipio(), getBairro(),getAcademico(), getDepartamento(), getCargo(), true);
			
					
			JOptionPane.showMessageDialog(null, modelo.toString() );
			
			modelo.guardarDados();			
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
					centro.guardar();
			else
				dispose();
		}
	}
	
	/* public void definirTema() 
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
    }*/
}
