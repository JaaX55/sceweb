package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC02ConsultarEmpresa {

	static EmpresaDAO empresaDAO;
    static Empresa empresa;
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		//89.424.232/0001-80
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("89424232000180");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
	}
	/**
	 * obj - verificar o comportamento do sistema na consulta de empresa com sucesso 
	 */
	@Test
	public void CT01UC02FBCosultarEmpresa_com_sucesso() {
		empresaDAO.adiciona(empresa);
		assertTrue(empresa.equals(empresaDAO.consultaEmpresa("89424232000180")));
		empresaDAO.exclui("89424232000180");
	}
	/**
	 * obj - verificar o comportamento do sistema na consulta de empresa com sucesso 
	 */
	@Test
	public void CT02UC02A1CosultarEmpresa_cnpj_invalido() {
		assertNull(empresaDAO.consultaEmpresa("11111"));
		
	}
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}

