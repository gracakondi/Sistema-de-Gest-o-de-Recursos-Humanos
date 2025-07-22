package Calendario;


import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.event.*;
import java.util.Vector;

public class JTextFieldData
{
	JLabel dLabel;
	JTextField dTestField;
	JButton dButton;
	
	public JTextFieldData(String lb)
	{
		dLabel = new JLabel(lb);
		dTestField = new JTextField(11); // formato dd-mmm-aaaa  mmm em string
    	dTestField.setEditable(false);
		dButton = new JButton("Seleccionar");
		dButton.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent ev)
			{
				new Data(dTestField);
			}
		});
	}
	public JLabel getDLabel()
		{ return dLabel; }
	public JTextField getDTestField()
		{ return dTestField; }
	public JButton getDButton()
		{ return dButton; }
}
