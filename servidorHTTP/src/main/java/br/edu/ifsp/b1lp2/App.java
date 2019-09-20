package br.edu.ifsp.b1lp2;

import java.io.IOException;

public class App 
{
    public static void main(String[] args) throws IOException
    {
    	Servidor servie = new Servidor();
    	servie.inicia();
    	servie.aceitaConexao(servie.getCliente());
    }
}
 