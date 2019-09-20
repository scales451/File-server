package br.edu.ifsp.b1lp2;

import java.io.IOException;
import java.net.ServerSocket;
import java.util.Scanner;

public class Servidor implements Runnable
{
	private int porta;
	private ServerSocket ssock;
	private Response response = new Response();
	private Scanner sc = new Scanner(System.in);
	private Cliente cliente = new Cliente();
	
	public void disparaThread()
	{
		new Thread(this).start();
	}
	
	//Porta configurável
	public void requisitaPorta()
	{
		System.out.println("Digite a porta do servidor: ");
		setPorta(sc.nextInt());
	}
	
	//Inicia a porta, o diretório e o servidor
	public void inicia() 
	{
		try
		{
			this.requisitaPorta();
			this.getCliente().requisitaDiretorio();
			
			setSsock(new ServerSocket(porta));
			System.out.println("Servidor iniciado e aguardando conexão");
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	//Método que fica aguardando a requisição e dispara Threads
	public void aceitaConexao(Cliente cliente)
	{
		try
		{
			while(true)
			{
				cliente.sock = ssock.accept();
				System.out.println("Conexão aceita pelo servidor na porta " + getPorta());
				this.disparaThread();
			}
		}
		catch(IOException e)
		{
			System.out.println(e);
		}
	}
	
	@Override
	public void run() 
	{
		try 
		{
			cliente.requisita("get");
			response.respondeCliente(cliente.getF(), cliente.getSock(), cliente.getCaminho());
		} 
		catch (IOException e)
		{
			System.out.println(e);
		}
	}
	
	//Getters e Setters
	public int getPorta() 
	{
		return porta;
	}
	
	public void setPorta(int porta) 
	{
		this.porta = porta;
	}
	
	public ServerSocket getSsock() 
	{
		return ssock;
	}
	
	public void setSsock(ServerSocket ssock) 
	{
		this.ssock = ssock;
	}

	public Cliente getCliente() 
	{
		return cliente;
	}

	public void setCliente(Cliente cliente) 
	{
		this.cliente = cliente;
	}

	public Response getResponse() {
		return response;
	}

	public void setResponse(Response response) {
		this.response = response;
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
