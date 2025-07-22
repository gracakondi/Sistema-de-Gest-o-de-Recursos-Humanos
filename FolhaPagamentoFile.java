/*------------------------------------
Tema: Gestão de Recursos Humanos
Nome: Gildo Graca Kondi
Numero: 33049
Ficheiro: FolhaPagamentoFile.java
Data: 01.06.2024
--------------------------------------*/

import javax.swing.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class FolhaPagamentoFile extends ObjectsFile
{
	
	public FolhaPagamentoFile()
	{
		super("FolhaPagamentoFile.dat", new FolhaPagamentoModelo() );
	}
	
	public void salvarDados(FolhaPagamentoModelo modelo)
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
			JOptionPane.showMessageDialog(null, "Falha ao Salvar um Novo Cadaver");
		}
	}
}
