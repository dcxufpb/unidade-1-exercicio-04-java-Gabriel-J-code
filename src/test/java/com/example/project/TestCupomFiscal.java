package com.example.project;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class TestCupomFiscal {

	private String BREAK = System.lineSeparator();

	@Test
	public void lojaCompleta() {
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK + 
				"Av. Projetada Leste, 500 EUC F32/33/34" + BREAK + 
				"Br. Sta Genebra - Campinas - SP" + BREAK + 
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK + 
				"Loja 1317 (PDP)" + BREAK + 
				"CNPJ: 42.591.651/0797-34" + BREAK + 
				"IE: 244.898.500.113" + BREAK);
	}

	@Test
	public void nomeVazio() {
		CupomFiscal.NOME_LOJA = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo nome da loja é obrigatório", e.getMessage());		
		}
		CupomFiscal.NOME_LOJA = "Arcos Dourados Com. de Alimentos LTDA";
	}
	
	@Test
	public void logradouroVazio() {
		CupomFiscal.LOGRADOURO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo logradouro do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.LOGRADOURO = "Av. Projetada Leste";
	}

	@Test
	public void numeroZero() {
		CupomFiscal.NUMERO = 0;
		rodarTestarRetorno("Arcos Dourados Com. de Alimentos LTDA" + BREAK +
				"Av. Projetada Leste, s/n EUC F32/33/34" + BREAK +
				"Br. Sta Genebra - Campinas - SP" + BREAK +
				"CEP:13080-395 Tel (19) 3756-7408" + BREAK +
				"Loja 1317 (PDP)" + BREAK +
				"CNPJ: 42.591.651/0797-34" + BREAK +
				"IE: 244.898.500.113" + BREAK);

		CupomFiscal.NUMERO = 500;
	}
	
	@Test
	public void municipioVazio() {
		CupomFiscal.MUNICIPIO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo município do endereço é obrigatório", e.getMessage());
		}
		CupomFiscal.MUNICIPIO = "Campinas";
	}

	@Test
	public void estadoVazio() {
		CupomFiscal.ESTADO = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo estado do endereço é obrigatório", e.getMessage());
		}
	    CupomFiscal.ESTADO = "SP";
	}
	
	@Test
	public void cnpjVazio() {
		CupomFiscal.CNPJ = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo CNPJ da loja é obrigatório", e.getMessage());
		}
	    CupomFiscal.CNPJ = "42.591.651/0797-34";
	}

	@Test
	public void inscricaoEstadualVazia() {
		CupomFiscal.INSCRICAO_ESTADUAL = "";
		try {
			CupomFiscal.dadosLoja();
		} catch (RuntimeException e) {
			assertEquals("O campo inscrição estadual da loja é obrigatório", e.getMessage());
		}
		CupomFiscal.INSCRICAO_ESTADUAL = "244.898.500.113";
	}
	
	@Test
	public void exercicio02_Customizado() {
		//Defina seus próprios valores para as variáveis a seguir 
		CupomFiscal.NOME_LOJA = "Tropical";
		CupomFiscal.LOGRADOURO = "Rua siqueira Campos";
		CupomFiscal.NUMERO = 580;
		CupomFiscal.COMPLEMENTO = "";
		CupomFiscal.BAIRRO = "Centro";
		CupomFiscal.MUNICIPIO = "Paulista";
		CupomFiscal.ESTADO = "Pernambuco";
		CupomFiscal.CEP = "53401-320";
		CupomFiscal.TELEFONE = "(81) 3438-5714";
		CupomFiscal.OBSERVACAO = "";
		CupomFiscal.CNPJ = "37.886.772/0001-82";
		CupomFiscal.INSCRICAO_ESTADUAL = "4232303-79";
		
		//E atualize o texto esperado abaixo
		rodarTestarRetorno("Tropical" + BREAK + 
		"Rua siqueira Campos, 580" + BREAK + 
		"Centro - Paulista - Pernambuco" + BREAK + 
		"CEP:53401-320 Tel (81) 3438-5714" + BREAK + 
		"" + BREAK + 
		"CNPJ: 37.886.772/0001-82" + BREAK + 
		"IE: 4232303-79" + BREAK);
	}

	private void rodarTestarRetorno(String expected) {

		// action
		String retorno = CupomFiscal.dadosLoja();

		// assertion
		assertEquals(expected, retorno);
	}
}
