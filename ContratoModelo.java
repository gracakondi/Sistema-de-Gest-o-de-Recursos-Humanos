/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: ContratoModelo.java
Data: 27.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class ContratoModelo implements RegistGeneric
{
	//Atributo
	private StringBufferModelo nome, tipoContrato, departamento, horario, banco, contaBancaria, cargoContrato, salario;
	private int id;
	DataModelo dataContrato, dataExpirar;
	private boolean status;

	public ContratoModelo ()
	{
		id = 0;
		nome = new StringBufferModelo("", 20);
		tipoContrato = new StringBufferModelo("", 15);
		departamento = new StringBufferModelo("", 60);
		cargoContrato = new StringBufferModelo("", 20);
		horario = new StringBufferModelo("", 15);
		banco = new StringBufferModelo ("", 30);
		contaBancaria = new StringBufferModelo("",25);
		salario = new StringBufferModelo("", 10);
		dataContrato = new DataModelo();
		dataExpirar = new DataModelo();
		status = false;
	}

	public ContratoModelo (int id, String nome, String tipoContrato, String departamento, String horario, String banco, String contaBancaria, String salario, String  dataContrato, String dataExpirar, String cargoContrato, boolean estado)
	{
		this.id = id;
		this.nome = new StringBufferModelo(nome, 50);
		this.tipoContrato = new StringBufferModelo(tipoContrato, 15);
                this.departamento = new StringBufferModelo(departamento, 60);
                this.cargoContrato = new StringBufferModelo(cargoContrato, 20);
                this.horario = new StringBufferModelo(horario, 15);
                this.banco = new StringBufferModelo (banco, 30);
		this.contaBancaria = new StringBufferModelo(contaBancaria,25);
                this.salario = new StringBufferModelo(salario, 10);
                this.dataContrato = new DataModelo(dataContrato);
                this.dataExpirar = new DataModelo(dataExpirar);
                this.status = estado;
	}
	
	//METODO GETTERRR
	public int getID ()
	{
		return id;
	}
	
	public String getNome ()
	{
		return nome.toStringEliminatingSpaces();
	}
	
	public String getTipoContrato ()
	{
		return tipoContrato.toStringEliminatingSpaces();
	}

	public String getDepartContrato ()
	{
		return departamento.toStringEliminatingSpaces();
	}

	public String getHorario ()
	{
		return horario.toStringEliminatingSpaces();
	}
	
	public String getBanco ()
	{
		return banco.toStringEliminatingSpaces();
	}

	public String getContaBancaria ()
	{
		return contaBancaria.toStringEliminatingSpaces();
	}

	public String getSlarioContrato ()
	{
		return salario.toStringEliminatingSpaces();
	}
	
	public String getDataInicio ()
	{
		return dataContrato.toString();
	}

	public String getDataFim()
	{
		return dataExpirar.toString();
	}
	
	public String getcargoContrato ()
	{
		return cargoContrato.toStringEliminatingSpaces();
	}
	
	public boolean getStatus()
	{
		return status;
	}

	//METODO SETTER

	public void setIDCotrato (int id)
	{
		this.id = id;
	}
	
	public void setNomeContrato (String nome)
	{
		this.nome = new StringBufferModelo(nome, 50);
	}
	
	public void setTipoContrato (String tipoContrato)
        {
                this.tipoContrato = new StringBufferModelo(tipoContrato, 15);
        }

        public void setDepartContrato (String departamento)
        {
                this.departamento = new StringBufferModelo (departamento, 60);
        }

        public void setHorario (String horario)
        {
                this.horario= new StringBufferModelo (horario, 15);
        }
        
        public void setBanco (String banco)
        {
                this.banco = new StringBufferModelo(banco, 30);
        }

        public void setContaBancaria (String contaBancaria)
	{
                this.contaBancaria = new StringBufferModelo(contaBancaria, 25);
        }

        public void setSlarioContrato (String salario)
        { 
                this.salario = new StringBufferModelo(salario, 10);
        }
        
        public void setDataContrato (String dataContrato)
        {
                this.dataContrato = new DataModelo (dataContrato);
        }

        public void setDataExpirar(String dataExpirar)
        {
                this.dataExpirar = new DataModelo(dataExpirar);
        }
        
        public void setcargoContrato (String cargoContrato)
        {
        	this.cargoContrato = new StringBufferModelo(cargoContrato, 20);
        }

	public void setStatus(boolean new_status)
	{
		this.status = new_status;
	} 
		
	public String toString()
	{
		String info= "Dados do Contrato feito pelo Funcionario \n\n";
		info += "ID:" + getID() + "\n";
		info += "Nome:" + getNome() + "\n";
		info += "Tipo de Contrato:" + getTipoContrato() +"\n";
		info += "Departamento:" + getDepartContrato() +"\n";
		info += "Horario:" + getHorario() +"\n";
		info += "Banco:" + getBanco() +"\n";
		info += "Conta Bancaria:" + getContaBancaria() +"\n";
		info += "Salario:" + getSlarioContrato() +"\n";
		info += "Data:" + getDataInicio() +"\n";
		info += "Data Expirar:" + getDataFim() +"\n";
		info += "Cargo:" + getcargoContrato() + "\n";

		return info;
	}

	public long sizeof()
	{
		try 
		{
			return 145 * 2 + 4 + 12 + 12; // 320
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
			tipoContrato.write(stream);
			departamento.write(stream);
			horario.write(stream);
			banco.write(stream);
			contaBancaria.write(stream);
			salario.write(stream);
			dataContrato.write(stream);
			dataExpirar.write(stream);
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
			tipoContrato.read(stream);
			departamento.read(stream);
			horario.read(stream);
			banco.read(stream);
			contaBancaria.read(stream);
			salario.read(stream );
			dataContrato.read(stream);
			dataExpirar.read(stream);
			status = stream.readBoolean();
		}

		catch (IOException ex)
		{
			ex.printStackTrace(); //metodo que mostra o erro ao ler
			JOptionPane.showMessageDialog(null, "Falha ao Ler, tente Novamente"); 
		}
	}
	
	public void guardarDados()
	{
		 ContratoFile fileContrato = new ContratoFile();
		 fileContrato.guardarDados(this);
	}
	
	public void alterarDados()
	{
		 ContratoFile fileContrato = new ContratoFile();
		 fileContrato.alterarDados(this);
	}

}	

