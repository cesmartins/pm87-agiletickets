package br.com.caelum.agiletickets.models;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.experimental.theories.suppliers.TestedOn;

public class SessaoTest {
	
	Sessao sessao = null;
	
	
	@Before
	private void prepara(){
		sessao = new Sessao();
	}

	@Test
	public void podeVenderTodasVagasDisponiveis() throws Exception{
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(10));
	}
	
	@Test
	public void deveVender1ingressoSeHa2vagas() throws Exception {
		
        sessao.setTotalIngressos(2);

        Assert.assertTrue(sessao.podeReservar(1));
	}
	
	@Test
	public void deveVender5ingressosSeHa10vagas() throws Exception {
		sessao.setTotalIngressos(10);
		
		Assert.assertTrue(sessao.podeReservar(5));
	}

	@Test
	public void naoDeveVender3ingressoSeHa2vagas() throws Exception {
		sessao.setTotalIngressos(2);

		Assert.assertFalse(sessao.podeReservar(3));
	}

	@Test
	public void reservarIngressosDeveDiminuirONumeroDeIngressosDisponiveis() throws Exception {
		sessao.setTotalIngressos(5);

		sessao.reserva(3);
		Assert.assertEquals(2, sessao.getIngressosDisponiveis().intValue());
	}
	
	@Test
	public void naoPodeReservarSessaoSemVagasDisponiveis() throws Exception{
		 Sessao sessao = new Sessao();
	}
	
}
