package SwingComponents;
/**
 * @  Title:        GestaoCandidaturaMilitante
 * @  Version:
 * @  Copyright:    Copyright (c) 2003
 * @  Author:       Ruben Paxi Quissanga
 * @  Company:      ucan
 * @  Description:  Projecto final (Intera�ao Homem Maquina
 * @                / Fundamentos de Programa�ao III)
 */



import java.io.*;

public class MyFile extends File
{
  public MyFile(String f)
  {
    super(f);
  }
  public static boolean existe(String f)
  {
    File Stream = new File(f);
    return ((true == Stream.exists()) && (true == Stream.isFile()));
  }
} 