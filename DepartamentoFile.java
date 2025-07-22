/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: DepartamentoFile.java
Data: 01.06.2024
--------------------------------------*/


import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class DepartamentoFile extends ObjectsFile
{
	
	public DepartamentoFile()
	{
		super("DepartamentoFile.dat", new DepartamentoModelo() );
	}
	
	public void guardarDados(DepartamentoModelo modelo)
	{
		try
		{
			//colocar o File Pointer no final do ficheiro
			stream.seek( stream.length() );
			
			//escrever os dados no ficheiro
			modelo.write(stream);
			
			incrementarProximoCodigo();
			
			JOptionPane.showMessageDialog(null, "Dados Salvos com Sucesso!");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Falha ao Salvar um Novo Cadaver");
		}
	}
	
	
	public void alterarDados(DepartamentoModelo modelo_novo)
	{
		DepartamentoModelo modelo_antigo = new DepartamentoModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read( stream );
				
				if (i == 0 && modelo_antigo.getIDDept() == modelo_novo.getIDDept())
				{
					stream.seek(4); 
					modelo_novo.write(stream);
					JOptionPane.showMessageDialog(null, "Dados alterados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getIDDept() + 1 == modelo_novo.getIDDept())
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
	
	
	public void eliminarDados(DepartamentoModelo modelo_novo)
	{
		DepartamentoModelo modelo_antigo = new DepartamentoModelo();
		
		try
		{
			stream.seek(4);
			
			for(int i = 0; i < getNregistos(); ++i)
			{
				modelo_antigo.read(stream);
				
				if (i == 0 && modelo_antigo.getIDDept() == modelo_novo.getIDDept())
				{
					stream.seek(4); 
					modelo_novo.write(stream);
					JOptionPane.showMessageDialog(null, "Dados eliminados com sucesso!");
					return;
				}	
				else
				{
					if (modelo_antigo.getIDDept() + 1 == modelo_novo.getIDDept())
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
	
	public static void verDepartamentos()
	{
		DepartamentoFile ficheiro = new DepartamentoFile();
		DepartamentoModelo modelo = new DepartamentoModelo();
		String output = "Lista Dos Departamento Existentes\n\n";
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getStatusDept() == true)
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
	
	public static DepartamentoModelo getDeptbyName(String nomeProcurado)
	{
		DepartamentoFile ficheiro = new DepartamentoFile();
		DepartamentoModelo modelo = new DepartamentoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNomeDept().equalsIgnoreCase( nomeProcurado ) && modelo.getStatusDept() == true)
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
		DepartamentoFile ficheiro = new DepartamentoFile();
		DepartamentoModelo modelo = new DepartamentoModelo();
		StringVector vector = new StringVector();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getStatusDept() == true)
					vector.add( modelo.getNomeDept() );
			}
						
			vector.sort();
			
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}	
	
		return vector;
	}
	
	public static void pesquisarDeptByName(String nomeProcurado)
	{
		DepartamentoFile ficheiro = new DepartamentoFile();
		DepartamentoModelo modelo = new DepartamentoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNomeDept().equalsIgnoreCase( nomeProcurado ) && modelo.getStatusDept() == true)
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"Gestao de Morgue", JOptionPane.INFORMATION_MESSAGE);
					break;					
				}
			}					
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}		
	}
	
	public static void pesquisarDeptByID(String idProcurado)
	{
		DepartamentoFile ficheiro = new DepartamentoFile();
		DepartamentoModelo modelo = new DepartamentoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				/*if (modelo.getIDDept().equalsIgnoreCase( idProcurado ) && modelo.getStatusDept() == true)
				{
					JOptionPane.showMessageDialog(null, modelo.toString(), 
					"AREA RH", JOptionPane.INFORMATION_MESSAGE);
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
