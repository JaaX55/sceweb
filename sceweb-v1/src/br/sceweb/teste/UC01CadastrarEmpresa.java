package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;


import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

/*
 * verifica o comportamento do sistema no cadastro de empresa
 */

public class UC01CadastrarEmpresa {
    static EmpresaDAO empresaDAO;
    static Empresa empresa;
    /**
     * cria os objetos que realizam o caso de uso cadastrar empresa
     * @throws Exception
     */
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
	 * obj - verificar o comportamento do sistema na inclusão de uma empresa com sucesso
	 */
	@Test
	public void CT01UC01FBCadastra_empresa_com_sucesso() {
		
		empresaDAO.exclui("89424232000180");
		assertEquals(1,empresaDAO.adiciona(empresa));
		//empresaDAO.exclui("89424232000180");
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj ja cadastrado
	 */
	@Test(expected = RuntimeException.class)
	public void CT02UC01A2Cadastra_empresa_cnpj_ja_cadastrado() {
		empresaDAO.adiciona(empresa);
		assertEquals(0,empresaDAO.adiciona(empresa));
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro com cnpj invalido
	 */
	@Test
	public void CT03UC01A3Cadastra_empresa_cnpj_invalido() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setCnpj("8942423200018");
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("CNPJ inválido!",e.getMessage());
		}
	}
	/**
	 * obj - verificar o comportamento do sistema no cadastro de uma empresa com dados invalidos
	 */
	@Test
	public void CT04UC01A4Cadastra_empresa_com_dados_invalidos() {
		Empresa empresa2 = new Empresa();
		try {
			empresa2.setNomeDaEmpresa("");
			fail("deveria disparar uma exception");
		} catch (Exception e) {
			assertEquals("nome da empresa inválido!",e.getMessage());
		}
	}
	
	@Test
	public void CT05UC01Cadastra_empresa_com_dados_validos(){
		
		
	}
	/**
	 * obj - exclui o cnpj ao finalizar o teste
	 * @throws Exception
	 */
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("89424232000180");
	}
}

