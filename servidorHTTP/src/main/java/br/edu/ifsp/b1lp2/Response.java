package br.edu.ifsp.b1lp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;

public class Response 
{
	private Processador pro = new Processador();
	private Map<String,String> map = new HashMap<String,String>();
	
	//Corpo da Response e escreve o conteúdo na tela
	public void respondeCliente(File f, Socket cliente, String caminho) 
	{
		try
		{
			OutputStream out = cliente.getOutputStream();
			PrintStream pout = new PrintStream(out);
			
			if(f.exists() == false)
			{
				System.out.println("HTTP/1.1 404 Not Found");
				pout.print("HTTP/1.1 404 Not Found");
				
				pout.close();
				out.close();
			}
			
			else if(cliente.isConnected() == true)
			{
				System.out.println("HTTP/1.1 202 Accepted");
				pout.print("HTTP/1.1 202 Accepted");
				
				map.put("HTTP/1.1 200 OK\nContent-type: " + pro.verificaExtensao(caminho) + "", "\nServer-name: meuservidor\nContent-length: " + f.length() + "\n\n");
				System.out.println("\nHTTP/1.1 200 OK\nContent-type: " + pro.verificaExtensao(caminho) + "\nServer-name: meuservidor\nContent-length: " + f.length() + "\n\n");
				pout.print("HTTP/1.1 200 OK\nContent-type: " + pro.verificaExtensao(caminho) + "\nServer-name: meuservidor\nContent-length: " + f.length() + "\n\n");
				
				FileInputStream in = new FileInputStream(f);
				
				pro.escreveConteudo(f, out, in);
			    
			    out.flush();
				
				pout.close();
				out.close();
				in.close();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
}
