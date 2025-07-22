/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: FuncionarioFile.java
Data: 01.06.2024
--------------------------------------*/


import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class FuncionarioFile extends ObjectsFile
{
	
	public FuncionarioFile()
	{
		super("FuncionarioFile.dat", new FuncionarioModelo() );
	}
	
	public void guardarDados(FuncionarioModelo modelo)
	{
		try
		{
			//colocar o File Pointer no final do ficheiro
			stream.seek( stream.length() );
			
			//escrever os dados no ficheiro
			modelo.write(stream);
			
			JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao Criar Um Novo Funcionario");
		}
	}
	
	public void alterarDados(FuncionarioModelo modelo_novo)
	{
		FuncionarioModelo modelo_antigo = new FuncionarioModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getID() == modelo_novo.getID())
				{
					stream.seek(4); 
					modelo_novo.write(stream);
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getID() + 1 == modelo_novo.getID())
					{
						modelo_novo.write( stream);
						return;
					}
							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	
	public void eliminarDados(FuncionarioModelo modelo_novo)
	{
		FuncionarioModelo modelo_antigo = new FuncionarioModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read(stream);
				
				if (i == 0 && modelo_antigo.getID() == modelo_novo.getID())
				{
					stream.seek(4); 
					modelo_novo.write(stream);
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getID() + 1 == modelo_novo.getID())
					{
						modelo_novo.write(stream);
						return;
					}
							
				}			
			}			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
	}
	
	public static void verFuncionarios()
	{
		FuncionarioFile ficheiro = new FuncionarioFile();
		FuncionarioModelo modelo = new FuncionarioModelo();
		String output = "Lista Dos Funcionarios\n\n";
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getStatus() == true)
				{
					output += "---------------------------------\n";
					output += modelo.toString() + "\n";
				}
			}
						
			JTextArea area = new JTextArea(40, 60);
			area.setText( output );
			area.setFocusable(false);
			JOptionPane.showMessageDialog(null, new JScrollPane( area ), 
					"Area de RH", JOptionPane.INFORMATION_MESSAGE);
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	public static FuncionarioModelo getFuncionariobyName(String nomeProcurado)
	{
		FuncionarioFile ficheiro = new FuncionarioFile();
		FuncionarioModelo modelo = new FuncionarioModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNome().equalsIgnoreCase( nomeProcurado ) && modelo.getStatus() == true)
					return modelo;
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return modelo;	
	}
	
	
	
	public static StringVector getAllNames()
	{
		FuncionarioFile ficheiro = new FuncionarioFile();
		FuncionarioModelo modelo = new FuncionarioModelo();
		StringVector vector = new StringVector();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getStatus() == true)
					vector.add( modelo.getNome() );
			}
						
			vector.sort();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	
		return vector;
	}
	
	public static FuncionarioModelo getFuncByName(String nomeProcurado)
	{
		FuncionarioFile ficheiro = new FuncionarioFile();
		FuncionarioModelo modelo = new FuncionarioModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNome().equalsIgnoreCase( nomeProcurado ) && modelo.getStatus() == true)
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"Gestao de RH", JOptionPane.INFORMATION_MESSAGE);
					break;					
				}
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
		return modelo;	
	}
	
	public static void pesquisarFuncByID(String idProcurado)
	{
		FuncionarioFile ficheiro = new FuncionarioFile();
		FuncionarioModelo modelo = new FuncionarioModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				/*if (modelo.getID().equalsIgnoreCase( idProcurado ) && modelo.getStatus() == true)
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"Gestao de Morgue", JOptionPane.INFORMATION_MESSAGE);
					break;					
				}*/
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	
	
}
