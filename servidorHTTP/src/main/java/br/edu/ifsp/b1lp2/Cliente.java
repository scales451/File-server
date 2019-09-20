package br.edu.ifsp.b1lp2;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.util.Scanner;

public class Cliente
{
	protected Socket sock;
	private File f;
	private String diretorio;					
	private String caminho;
	private Request request = new Request();
	private Scanner sc = new Scanner(System.in);
	
	//Diretório configurável
	public void requisitaDiretorio()
	{
		System.out.println("Digite o diretorio a ser servido: ");
		setDiretorio(sc.nextLine());
	}
	
	//Método que pega o caminho da requisição e imprime o corpo da requisição na tela
	public void getExtensao()
	{
		try
		{
			String requisicao;
			String corpo;
			
			InputStreamReader inputStreamReader = new InputStreamReader(this.sock.getInputStream());
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			
			requisicao = bufferedReader.readLine();
			int espaco = requisicao.lastIndexOf(" ");
			if(espaco > 0)
			{
				this.caminho = requisicao.substring(0, espaco);
				this.caminho = caminho.substring(caminho.indexOf("/") + 1);
				this.caminho = diretorio + caminho;
				System.out.println(this.caminho);
			}
			
			while((corpo = bufferedReader.readLine()).length() > 0)
			{
				System.out.println(corpo);
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	public void requisita(String metodo) throws IOException 
	{		
		if(metodo == "get")
		{
			getExtensao();
			setF(request.httpGET(f, this.getSock(), caminho));
		}
		if(metodo == "post")
		{
			getExtensao();
			setF(request.httpPOST(f, this.getSock(), caminho));
		}
	}
	
	//Getters e Setters
	public Socket getSock() 
	{
		return sock;
	}
	
	public void setSock(Socket sock) 
	{
		this.sock = sock;
	}

	public File getF() {
		return f;
	}
	
	public void setF(File f) 
	{
		this.f = f;
	}

	public String getCaminho() 
	{
		return caminho;
	}

	public void setCaminho(String caminho) 
	{
		this.caminho = caminho;
	}

	public String getDiretorio() 
	{
		return diretorio;
	}

	public void setDiretorio(String diretorio) 
	{
		this.diretorio = diretorio;
	}

	public Request getRequest() {
		return request;
	}

	public void setRequest(Request request) 
	{
		this.request = request;
	}

	public Scanner getSc() 
	{
		return sc;
	}

	public void setSc(Scanner sc) 
	{
		this.sc = sc;
	}
}
