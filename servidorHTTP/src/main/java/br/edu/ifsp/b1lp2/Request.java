package br.edu.ifsp.b1lp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.Socket;
import java.io.IOException;

public class Request 
{
	private Processador pro = new Processador();
	
	public File httpGET(File f, Socket cliente, String caminho) throws IOException 
	{
		try
		{	
			f = new File(caminho);
			
			if(f.exists() == false)
			{
				throw new FileNotFoundException("404 - Recurso não encontrado");
			}
		}
		catch(FileNotFoundException ex)
		{
				System.out.println(ex.getMessage());
		}
		return f;
	}

	public File httpPOST(File f, Socket cliente, String caminho)
	{
		String post = "C:\\Users\\aluno\\Documents\\arquivos_post\\" + caminho.substring(caminho.lastIndexOf("\\") + 1);
		try
		{
			f = new File(caminho);
			
			if(f.exists() == false)
			{
				throw new FileNotFoundException("404 - Recurso não encontrado");
			}
			
			OutputStream out = new FileOutputStream(post);
			PrintStream pout = new PrintStream(out);
			FileInputStream in = new FileInputStream(f);
			
			System.out.println("POST /" + caminho + " HTTP/1.1\nHost: localhost\nConnection: keep-alive\nContent-type: " + pro.verificaExtensao(caminho) + "\nContent-length: " + f.length() + "\n\n");
			pout.print("POST /" + caminho + " HTTP/1.1\nHost: localhost\nConnection: keep-alive\nContent-type: " + pro.verificaExtensao(caminho) + "\nContent-length: " + f.length() + "\n\n");
			
			pro.escreveConteudo(f, out, in);
		    
		    out.flush();
		    out.close();
		    in.close();
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
		return f;
	}
}
