package br.sceweb.teste;

import static org.junit.Assert.*;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.model.Convenio;
import br.sceweb.model.ConvenioDAO;
import br.sceweb.model.Empresa;
import br.sceweb.model.EmpresaDAO;

public class UC05CadastrarConvenio {
	static ConvenioDAO convenioDAO;
	static Convenio convenio;
	static Convenio novoConvenio;
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static String cnpj;

	//a
	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa y");
		empresa.setCnpj("00776574000660");
		empresa.setNomeFantasia("empresa y");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("3333");
		empresaDAO.adiciona(empresa);
		convenioDAO = new ConvenioDAO();
		convenio = new Convenio("00776574000660", "03/05/2016", "20/05/2016");
	}

	@Test
	public void CT01UC05FBCadastrar_convenio_com_sucesso() {
		assertEquals(1, convenioDAO.adiciona(convenio));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		empresaDAO.exclui("00776574000660");
		convenioDAO.exclui("81965361000174");
	}

}
