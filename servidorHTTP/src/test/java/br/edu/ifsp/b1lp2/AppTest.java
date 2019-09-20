package br.edu.ifsp.b1lp2;

import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }
    
    public void testMIME()
    {
    	 Processador p = new Processador();
    	 assertEquals("text/plain", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\lero.txt"));
    	 assertEquals("image/png", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\logomarca.png"));
    	 assertEquals("text/html", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\web.html"));
    	 assertEquals("application/pdf", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\what.pdf"));
    	 assertEquals("image/jpeg", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\image.jpg"));
    	 assertEquals("application/xml", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\file.xml"));
    	 assertEquals("image/gif", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\megaman.gif"));
    	 assertEquals("text/plain", p.verificaExtensao("C:\\Users\\aluno\\Documents\\Arquivos\\AppTest.java"));
    }
}
