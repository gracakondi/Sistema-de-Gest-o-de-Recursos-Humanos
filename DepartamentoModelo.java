/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 33049
Ficheiro: DepartamentoModelo.java
Data: 20.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import SwingComponents.*;
import java.io.*;

public class DepartamentoModelo implements RegistGeneric 
{
     //Atributos
  	private StringBufferModelo orcamento, nome, gerente, missao; 
	private int id, nmembros;
	private boolean status;
     
   // Construtor

	public DepartamentoModelo()
	{
		id = 0;
		nome = new StringBufferModelo("", 60);
		nmembros = 0;
		gerente = new StringBufferModelo("", 50);
		missao = new StringBufferModelo("", 20);
		orcamento = new StringBufferModelo("",15);
		status = false;
	}
	
	public DepartamentoModelo(String nome, int id, int nmembros, String gerente, String cargos, String orcamento, boolean estado)
        {
                this.id = id;
                this.nome = new StringBufferModelo(nome, 60);
                this.nmembros = nmembros;
                this.gerente = new StringBufferModelo(gerente, 50);
                this.missao = new StringBufferModelo(cargos, 20);
                this.orcamento = new StringBufferModelo(orcamento, 15);
                this.status = estado;
        }



   // METODO GETTER
	public int getIDDept ()
	{
		return id;
	}

	public String getNomeDept ()
	{
		return nome.toStringEliminatingSpaces();
	}

	public int getMembros()
	{
		return nmembros;
	}

	public String getGerente ()
	{
		return gerente.toStringEliminatingSpaces();
	}

	public String getMissao ()
	{
		return missao.toStringEliminatingSpaces();
	}
	
	public String getOrcamento ()
	{
		return orcamento.toStringEliminatingSpaces();
	}
	
	public boolean getStatusDept ()
	{
		return status;
	}

   // METODO SETTER
	public void setIDDept (int id)
	{
		this.id = id;
	}

	public void setNomeDept (String nome)
	{
		this.nome = new StringBufferModelo (nome, 60);
	}

	public void setMembros (int nmembros)
	{
		this.nmembros = nmembros;
	}

	public void setGerente (String gerente)
	{
		this.gerente = new StringBufferModelo (gerente, 50);
	}

	public void setMissao (String missao)
	{
		this.missao = new StringBufferModelo (missao, 20);
	}
	
	public void setOrcamento (String orcamento)
	{
		this.orcamento = new StringBufferModelo (orcamento, 15);
	}
	
	public void setStatusDept(boolean status)
	{
		this.status = status;
	}
	
	public String  toString ()
	{
		String info = "Dados do Departamento \n\n";
		info += "ID :" + getIDDept() + "\n";
		info += "Nome: " + getNomeDept() + "\n";
		info += "Numero de Membros: " + getMembros() + "\n";
		info += "Gerente: " + getGerente() + "\n";
		info += "Missao: " + getMissao() + "\n";
		info += "Orcamento: " + getOrcamento() + "\n";

		return info;
	}
	

	public long sizeof()
	{
		try 
		{
			return 145 * 2 + 4 + 4 + 1; // 301
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
			stream.writeInt(nmembros);
			gerente.write(stream);
			missao.write(stream);
			orcamento.write(stream);
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
			nmembros = stream.readInt();
			gerente.read(stream);
			missao.read(stream);
			orcamento.read(stream);
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
		 DepartamentoFile fileDepartamento = new DepartamentoFile();
		 fileDepartamento.guardarDados(this);
	}
	
	public void altera()
	{
		 DepartamentoFile fileDepartamento = new DepartamentoFile();
		 fileDepartamento.alterarDados(this);
	}

}
