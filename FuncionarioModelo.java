/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: FuncionarioModelo.java
Data: 20.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class FuncionarioModelo implements RegistGeneric
{
     //Atributos
  	private StringBufferModelo nome, morada, email, contacto, cargo, departamento, academico, estadoCivil,
  	 genero, nacionalidade,  provincia, municipio, bairro;
  	private boolean status;
	private DataModelo data_nasc;
	private int id;


	// Construtor Vazio

	public FuncionarioModelo()
	{
		this.id = 0;
		nome = new StringBufferModelo("", 50);
		morada = new StringBufferModelo("", 15);
		data_nasc = new DataModelo();
		email = new StringBufferModelo("", 20);
		contacto = new StringBufferModelo ("", 13);
		cargo = new StringBufferModelo("", 15);
		departamento = new StringBufferModelo("", 60);
		academico = new StringBufferModelo("", 20);
		estadoCivil = new StringBufferModelo("", 15);
		genero = new StringBufferModelo("", 15);
		nacionalidade = new StringBufferModelo("", 20);
		provincia = new StringBufferModelo("", 20);
		municipio = new StringBufferModelo("", 20);
		bairro = new StringBufferModelo("", 20);
		status = false;
	}

	// Construtor
	public FuncionarioModelo(int id, String nome, String morada, String data_nasc, String email, String contacto, String academico,
	String estadoCivil, String cargo, String departamento, String genero, String nacionalidade, String provincia, String municipio, String bairro, boolean estado)
        {
                this.id = id;
                this.nome = new StringBufferModelo (nome, 50);
                this.morada = new StringBufferModelo (morada, 15);
                this.data_nasc = new DataModelo (data_nasc);
                this.email = new StringBufferModelo (email, 20);
                this.contacto = new StringBufferModelo (contacto, 13);
                this.cargo = new StringBufferModelo (cargo, 15);
                this.departamento = new StringBufferModelo (departamento, 60);
                this.academico = new StringBufferModelo (academico, 20);
		this.estadoCivil = new StringBufferModelo (estadoCivil, 15);
		this.genero = new StringBufferModelo(genero, 15);
		this.nacionalidade = new StringBufferModelo (nacionalidade, 20);
		this.provincia = new StringBufferModelo(provincia, 20);
		this.municipio = new StringBufferModelo(municipio, 20);
		this.bairro = new StringBufferModelo(bairro, 20);
		this.status = estado;
        }


	// METODO GETTER
	public int getID ()
	{
		return id;
	}

	public String getNome ()
	{
		return nome.toStringEliminatingSpaces();
	}

	public String getMorada()
	{
		return morada.toStringEliminatingSpaces();
	}

	public String getData_nasc ()
	{
		return data_nasc.toString();
	}

	public String getEmail()
	{
		return email.toStringEliminatingSpaces();
	}

	public String getContacto()
	{
		return contacto.toStringEliminatingSpaces();
	}
	
	public String getCargo()
	{
		return cargo.toStringEliminatingSpaces();
	}
	
	public String getDepartamento()
	{
		return departamento.toStringEliminatingSpaces();
	}
	
	public String getAcademico()
	{
		return academico.toStringEliminatingSpaces();
	}

	public String getEstadoCivil()
	{
		return estadoCivil.toStringEliminatingSpaces();
	}
	
	public String getGenero()
	{
		return genero.toStringEliminatingSpaces();
	}
	
	public String getNacionalidade()
	{
		return nacionalidade.toStringEliminatingSpaces();
	}
	
	public String getProvincia()
	{
		return provincia.toStringEliminatingSpaces();
	}
	public String getMunicipio()
	{
		return municipio.toStringEliminatingSpaces();
	}
	public String getBairro()
	{
		return bairro.toStringEliminatingSpaces();
	}
	public boolean getStatus()
	{
		return status;
	}
	

		// METODO SETTER
	public void setID (int  idFunc)
	{
		this.id = idFunc;
	}

	public void setNome (String nomeFunc)
	{
		this.nome = new StringBufferModelo (nomeFunc, 50);
	}

	public void setMorada (String moradaFunc)
	{
		this.morada = new StringBufferModelo (moradaFunc, 15);
	}

	public void setData_nasc (String data_nascFunc)
	{
		this.data_nasc = new DataModelo(data_nascFunc);
	}

	public void setEmail (String emailFunc)
	{
		this.email = new StringBufferModelo (emailFunc, 20);
	}

	public void setContacto (String contactoFunc)
	{
		this.contacto = new StringBufferModelo (contactoFunc, 13);
	}
	
	public void setCargo (String cargoFunc)
	{
		this.cargo = new StringBufferModelo (cargoFunc, 15);
	}
	
	public void setDepartamento (String DepartamentoFunc)
	{
		this.departamento = new StringBufferModelo (DepartamentoFunc, 60);
	}
	
	public void setAcademico (String academicoFunc)
	{
		this.academico = new StringBufferModelo (academicoFunc, 20);
	}
	
	public void setEstadoCivil (String estadoCivilFunc)
	{
		this.estadoCivil = new StringBufferModelo (estadoCivilFunc, 15);
	}
	
	public void setGenero(String generoFunc)
	{
		genero = new StringBufferModelo(generoFunc, 15);
	}
	
	public void setNacionalidade (String nacionalidadeFunc)
	{
		this.nacionalidade = new StringBufferModelo (nacionalidadeFunc, 20); 
	}	

	public void setProvincia(String provinciaFunc)
	{
		provincia = new StringBufferModelo(provinciaFunc, 20);
	}
	
	public void setMunicipio(String municipioFunc)
	{
		municipio = new StringBufferModelo(municipioFunc, 20);
	}
	
	public void setBairro(String bairroFunc)
	{
		bairro = new StringBufferModelo(bairroFunc, 20);
	}
	
	public void setStatus(boolean new_status)
	{
		this.status = new_status;
	} 

	// METODO TOSTRINGG	
	public String toString ()
	{
		String info = "Dados do Funcionario\n\n";
		
		info += "ID:" + getID() + "\n";
		info += "Nome:" + getNome() + "\n";
		info += "Sexo:" + getEstadoCivil() + "\n";
		info += "Data de Nascimento:" + getData_nasc() + "\n";
		info += "Nacionalidade:" +  getCargo()  + "\n";
		info += "Morada:" + getMorada() + "\n";
		info += "Estado Civil:" + getAcademico() + "\n";
		info += "Provincia:" + getDepartamento() + "\n";
		info += "Municipio" + getGenero()  + "\n";
		info += "Bairro:" + getNacionalidade() + "\n";
		info += "E-mail:" + getEmail() + "\n";
		info += "Contacto" + getContacto() + "\n";
		info += "Academico:" + getProvincia() + "\n";
		info += "Departamento:" + getMunicipio()  + "\n";
		info += "Cargo:" +getBairro()+ "\n";
		
		return info;
	}
	
	
	public long sizeof()
	{
		try 
		{
			return 298 * 2 + 4 + 12 + 12+ 1; // 625
		}
		
		catch(Exception ex)
		{
			return 0;
		}
	}
	
	//Chama a funcao write q permite escrever sob o .dat
	public void write(RandomAccessFile stream)
	{
		try 
		{
			stream.writeInt(id);
			nome.write(stream);
			morada.write(stream);
			data_nasc.write(stream);
			email.write(stream);
			contacto.write(stream);
			cargo.write(stream);
			departamento.write(stream);
			academico.write(stream);
			estadoCivil.write(stream);
			genero.write(stream);
			nacionalidade.write(stream);
			provincia.write(stream);
			municipio.write(stream);
			bairro.write(stream);
			stream.writeBoolean(status);
		}

		catch (IOException ex)
		{
			ex.printStackTrace(); //metodo que mostra o erro de gravacao
			JOptionPane.showMessageDialog(null, "Falha ao Guardar, tente Novamente"); 
		}
	}

	public void read(RandomAccessFile stream)
	{
		try 
		{
			id = stream.readInt();
			nome.read(stream);
			morada.read(stream);
			data_nasc.read(stream);
			email.read(stream);
			contacto.read(stream);
			cargo.read(stream); 
			departamento.read(stream); 
			academico.read(stream); 
			estadoCivil.read(stream);
			genero.read(stream);
			nacionalidade.read(stream);
			provincia.read(stream);
			municipio.read(stream);
			bairro.read(stream);
			status = stream.readBoolean();
		}

		catch (IOException ex)
		{
			ex.printStackTrace(); //metodo que mostra o erro ao ler
			JOptionPane.showMessageDialog(null, "Falha ao Ler, tente Novamente"); 
		}
	}
	
	public void guardar()
	{
		 FuncionarioFile fileFuncionario = new FuncionarioFile();
		 fileFuncionario.guardarDados(this);
	}
	
	public void guardarDados()
	{
		FuncionarioFile fileFuncionario = new FuncionarioFile();
		fileFuncionario.alterarDados(this);
	}

}
