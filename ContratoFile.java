/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: ContratoFile.java
Data: 01.06.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class ContratoFile extends ObjectsFile
{
	public ContratoFile()
	{
		super("ContratoFile.dat", new ContratoModelo());
	}

	public void guardarDados (ContratoModelo modelo)
	{
		try
		{
			//Coloca o ponteiro no fim do .dat
			stream.seek (stream.length ());

			//Permite  esrever no ficheiro .dat
			modelo.write(stream);
			JOptionPane.showMessageDialog(null, "Os Dados foram Salvos!");
		}

		catch (IOException ex)
		{
			ex.printStackTrace();
			JOptionPane.showMessageDialog(null, "Os Dados nao salvos, tente novamente");
		}
	}
	
	
	public void alterarDados(ContratoModelo modelo_novo)
	{
		ContratoModelo modelo_antigo = new ContratoModelo();
		
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
	
	
	public void eliminarDados(ContratoModelo modelo_novo)
	{
		ContratoModelo modelo_antigo = new ContratoModelo();
		
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
	
	public static void verContratos()
	{
		ContratoFile ficheiro = new ContratoFile();
		ContratoModelo modelo = new ContratoModelo();
		String output = "Lista Dos Contratos Assinados\n\n";
		
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
	
	public static ContratoModelo getContratobyName(String nomeProcurado)
	{
		ContratoFile ficheiro = new ContratoFile();
		ContratoModelo modelo = new ContratoModelo();
		
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
		ContratoFile ficheiro = new ContratoFile();
		ContratoModelo modelo = new ContratoModelo();
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
	
	public static void pesquisarContratoByName(String nomeProcurado)
	{
		ContratoFile ficheiro = new ContratoFile();
		ContratoModelo modelo = new ContratoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
				if (modelo.getNome().equalsIgnoreCase( nomeProcurado ) && modelo.getStatus() == true)
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
	
	public static void pesquisarContratoByID(String idProcurado)
	{
		ContratoFile ficheiro = new ContratoFile();
		ContratoModelo modelo = new ContratoModelo();
		
		try
		{
			ficheiro.stream.seek(4);
			
			for (int i = 0; i < ficheiro.getNregistos(); ++i)
			{
				modelo.read( ficheiro.stream );
				
			/*	if (modelo.getID().equalsIgnoreCase( cargoProcurado ) && modelo.getStatus() == true)
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

