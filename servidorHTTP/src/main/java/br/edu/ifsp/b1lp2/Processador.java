package br.edu.ifsp.b1lp2;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

public class Processador 
{
	//Método para retornar o content type adequado
	public String verificaExtensao(String caminho)
	{
		if (caminho.endsWith(".html") || caminho.endsWith(".htm")) 
            return "text/html";
        else if (caminho.endsWith(".txt")) 
            return "text/plain";
        else if (caminho.endsWith(".gif")) 
            return "image/gif";
        else if (caminho.endsWith(".jpg") || caminho.endsWith(".jpeg"))
            return "image/jpeg";
        else if (caminho.endsWith(".png"))
        	return "image/png";
        else if (caminho.endsWith(".xml"))
        	return "application/xml";
        else if(caminho.endsWith(".pdf"))
        	return "application/pdf";
        else    
            return "text/plain";
	}
	
	public void escreveConteudo(File f, OutputStream out, FileInputStream in) 
	{
		try
		{
			int lidos;
			byte[] buffer = new byte[(int) f.length()];
		    while ((lidos = in.read(buffer)) > 0) 
		    {  
		        out.write(buffer, 0, lidos);        
		    }  
		}
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
}
