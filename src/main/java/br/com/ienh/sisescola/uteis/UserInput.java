package br.com.ienh.sisescola.uteis;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserInput {
	
	private String s;
	private InputStreamReader i = new InputStreamReader (System.in);
	private BufferedReader d = new BufferedReader(i);

	/**
		Read an integer.
		@return int
	 */
	public int readInt ()
	{   
		int a = 0;
		try{
			s = d.readLine();
			a = Integer.parseInt(s);
		}
		catch (IOException e){
			System.out.println ("Erro de I/O: " + e);
		}
		catch (NumberFormatException e){
			System.out.println ("o valor digitado deve ser inteiro: "+e );
		}
		return (a);
	}

	/**
		Read an integer, with a message.
		@return int
	 */
	public int readInt (String msg)
	{ 
	
		int a = 0;
		System.out.println(msg);
		try
		{
			s = d.readLine();
			a = Integer.parseInt(s);
		}
		catch (IOException e)
		{
			System.out.println ("Erro de I/O: "+e );
		}
		catch (NumberFormatException e)
		{
			System.out.println ("o valor digitado deve ser inteiro: "+e );
		}
		return (a);
     
	}

	/**
		Read a double.
		@return double
	 */
	public double readDouble()
	{ 
		double a = 0;
		try
		{
			s = d.readLine();
			a = Double.parseDouble(s);
		}
		catch (IOException e)
		{
			System.out.println ("Erro de I/O: " + e);
		}
		catch (NumberFormatException e)
		{
			System.out.println ("o valor digitado deve ser numero: "+e );
		}
		return (a);
	}

	/**
		Read a double, with a message.
		@return double
	 */
	public double readDouble(String msg)
	{   
		double a = 0;
		System.out.println(msg);
		try
		{
			s = d.readLine();
			a = Double.parseDouble(s);
		}
		catch (IOException e)
		{
			System.out.println ("Erro de I/O: " + e);
		}
		catch (NumberFormatException e)
		{
			System.out.println ("o valor digitado deve ser numero: "+e );
		}
		return (a);
	}

	/**
		Read a string.
		@return String
	 */
	public String readText()
	{ 
		s = "";
		try
		{
			s = d.readLine();
            
		}
		catch (IOException e)
		{
			System.out.println ("Erro de I/O: " + e);
		}
		return (s);
	}

	/**
		read a String, with a message.
		@return String
	 */
	public String readText(String msg)
	{   
		s = "";
		System.out.println(msg);
		try
		{
			s = d.readLine();
		}
		catch (IOException e)
		{
			System.out.println ("Erro de I/O: " + e);
		}
		return (s);
	}
        
    /**
        Read a char.
        @return char
     */
     public char readChar()
     {  
         s = "";
         char c=' ';
         try
         {
            s = d.readLine();
            c = s.charAt(0);
         }
         catch (IOException e)
         {
            System.out.println ("Erro de I/O: " + e);
         }
         return (c);
     }
          
     /**
		Read a char, with a message.
		@return char
      */
     public char readChar(String msg)
     {   
    	 s = "";
    	 char c=' ';
    	 System.out.println(msg);
    	 try
    	 {
    		 s = d.readLine();
    		 c = s.charAt(0);
    	 }
    	 catch (IOException e)
    	 {
    		 System.out.println ("Erro de I/O: " + e);
    	 }
    	 return (c);
     }
	
}