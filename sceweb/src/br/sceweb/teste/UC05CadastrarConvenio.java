package br.sceweb.teste;

import static org.junit.Assert.*;

import org.joda.time.DateTime;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;

import br.sceweb.modelo.Convenio;
import br.sceweb.modelo.ConvenioDAO;
import br.sceweb.modelo.Empresa;
import br.sceweb.modelo.EmpresaDAO;

public class UC05CadastrarConvenio {
	static ConvenioDAO convenioDAO;
	static Convenio convenio;
	static Convenio novoConvenio;
	static EmpresaDAO empresaDAO;
	static Empresa empresa;
	static String cnpj;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		empresaDAO = new EmpresaDAO();
		empresa = new Empresa();
		empresa.setNomeDaEmpresa("empresa x");
		empresa.setCnpj("81965361000174");
		empresa.setNomeFantasia("empresa x");
		empresa.setEndereco("rua taquari");
		empresa.setTelefone("2222");
		empresaDAO.adiciona(empresa);
		convenioDAO = new ConvenioDAO();
		convenio = new Convenio("81965361000174", "05/05/2016", "20/05/2016");
	}

	/**
	 * objetivo - Verificar o comportamento do sistema 
	 * na inclusao de convenio com sucesso
	 * Pre Condicao: o CNPJ 81965361000174 esgtar cadastrado
	 */
	@Test
	public void CT01UC05CadastrarConvenio_com_sucesso() {
		assertEquals(1, convenioDAO.adiciona(convenio));
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT06UC05A3CadastrarConvenio_cnpj_invalido() {
		cnpj = "11111";
		convenio.setCNPJ(cnpj);
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT03UC05A2Cadastrar_convenio_dti_invalida() {
		convenio.setDataInicio("42/05/2016");
	}
	
	@Test(expected = IllegalArgumentException.class)
	public void CT04UC05A2Cadastrar_convenio_dti_invalida() {
		convenio.setDataTermino("42/05/2016");
	}

	@Test
	public void CT02UC05A1Cadastrar_convenio_ja_cadastrado() {
		DateTime di = new DateTime(2016, 4, 5, 0, 0);
		DateTime df = new DateTime(2016, 5, 1, 0, 0);

		assertEquals(4, convenio.convenioJaCadastrado(df, di));
	}

	@Test(expected = IllegalArgumentException.class)
	public void CT06UC05A3Cadastrar_convenio_cnpj_nao_cadastrado() {
		Convenio novoConvenio = new Convenio("95754698523149", "20/05/2016", "27/05/2016");
		assertEquals(0, convenioDAO.adiciona(novoConvenio));
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		convenioDAO.exclui("81965361000174");
		empresaDAO.exclui("81965361000174");
	}
}
