/*------------------------------------
Tema do Projecto: Gestão de Recursos Humanos
Nome: Gildo Graça Kondi
Numero: 1000033049
Ficheiro: FolhaPagamentoModelo.java
Data: 20.05.2024
--------------------------------------*/

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import SwingComponents.*;
import Calendario.*;
import java.io.*;

public class FolhaPagamentoModelo implements RegistGeneric {
 
    //Atributos
	private DataModelo dataInicio, dataFim;
	private int horaExtra, faltas;
   	 private double salarioBruto, salarioFinal;
    
    public FolhaPagamentoModelo() 
    {
        dataInicio = new DataModelo();
        dataFim = new DataModelo();
        horaExtra = 0;
        faltas = 0;
        this.salarioBruto = salarioBruto;
        this.salarioFinal = salarioFinal;
    }
	
    public FolhaPagamentoModelo(String dataInicio, String dataFim, int horaExtra, int faltas, double salarioBruto, double salarioFinal
) 
    {
        this.dataInicio = new DataModelo(dataInicio);
        this.dataFim = new DataModelo(dataFim);
        this.horaExtra = horaExtra;
        this.faltas = faltas;
        this.salarioBruto = salarioBruto;
        this.salarioFinal = salarioFinal;
    }
    
	//METODOS GETTERS
    public String getDataInicio ()
    {
        return dataInicio.toString();
    }

    public String getDataFim ()
    { 
        return dataFim.toString();
    }

    public int getHoraExtra ()
    {
        return horaExtra;
    }
    
    public int getFaltas ()
    {
        return faltas;
    }

    public double getSalarioBruto ()

    {
        return salarioBruto;
    }

    public double getSlarioFinal ()
    {
        return salarioFinal;
    }


     // METODO SETTERS
	public void setDataInicio (String dataInicio)
	{
		this.dataInicio = new DataModelo (dataInicio);
	}

	public void setDataFim (String dataFim)
	{
		this.dataFim = new DataModelo (dataFim);
	}

	public void setHoraExtra (int horaExtra)
	{
		this.horaExtra = horaExtra;
	}

	public void setFaltas (int faltas)
	{
		this.faltas = faltas;
	}

	public void setSalarioBruto (double salarioBruto)
	{
		this.salarioBruto = salarioBruto;
	}

    public void setSalarioFinal (double salarioFinal)
	{
		this.salarioFinal = salarioFinal ;
	}
		//METODO TOSTRNG
	public String toString ()
	{
		String info = "Folha de Pagamento";
		info += "Data Inicio de Pagamento:" + getDataInicio() + "\n";
		info += "Dta de Fim de Pagamento:" + getDataFim() + "\n";
		info += "Horas Extras de Trabalho:" + getHoraExtra () + "\n";
		info += "Numero de Faltas:" + getFaltas() + "\n";
		info += "Salario Bruto:" + getSalarioBruto() + "\n";
		info += "SalarioFinal:" + getSlarioFinal() + "\n";
		
		return info;
	}
	
	public long sizeof()
	{
		try 
		{
			return 95 * 2 + 4 + 12 + 12; // 218
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
		{	dataInicio.write(stream);
		        dataFim.write(stream);
		        stream.writeInt(horaExtra);
		        stream.writeInt(faltas);
		//        this.salarioBruto = salarioBruto;
		//        this.salarioFinal = salarioFinal;

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

			dataInicio.read(stream);
		        dataFim.read(stream);
		        horaExtra = stream.readInt();
		        faltas = stream.readInt();
	//	        this.salarioBruto = salarioBruto;
	//	        this.salarioFinal = salarioFinal;
		}

		catch (IOException ex)
		{
			ex.printStackTrace(); //metodo que mostra o erro ao ler
			JOptionPane.showMessageDialog(null, "Falha ao Ler, tente Novamente"); 
		}
	}
	/*
	public void guardar()
	{
		 FolhaPagamentoFile file = new FolhaPagamentoFile();
		 file.guardarDados(this);
	}*/

}
