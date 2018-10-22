package kotlinsample.pedido

import java.time.LocalDate

import org.junit.Assert.assertTrue
import org.junit.Assert.assertFalse
import org.junit.Assert.fail
import org.junit.Test

class EstadoTest {

    @Test fun transicoeDoEstadoABERTO() {
        assertTrue(Estado.ABERTO.podeTransitarPara(Estado.FINALIZADO))
        assertTrue(Estado.ABERTO.podeTransitarPara(Estado.CANCELADO))
        assertFalse(Estado.ABERTO.podeTransitarPara(Estado.PAGO))
		assertFalse(Estado.ABERTO.podeTransitarPara(Estado.ABERTO))
	}

    @Test fun transicoeDoEstadoFINALIZADO() {
        assertTrue(Estado.FINALIZADO.podeTransitarPara(Estado.ABERTO))
        assertTrue(Estado.FINALIZADO.podeTransitarPara(Estado.PAGO))
        assertTrue(Estado.FINALIZADO.podeTransitarPara(Estado.CANCELADO))
        assertFalse(Estado.FINALIZADO.podeTransitarPara(Estado.EM_TRANSPORTE))
	}

    @Test fun transicoeDoEstadoPAGO() {
        assertTrue(Estado.PAGO.podeTransitarPara(Estado.EM_TRANSPORTE))
        assertFalse(Estado.PAGO.podeTransitarPara(Estado.CANCELADO))
        assertFalse(Estado.PAGO.podeTransitarPara(Estado.ENTREGUE))
	}

    @Test fun transicoeDoEstadoEM_TRANSPORTE() {
        assertTrue(Estado.EM_TRANSPORTE.podeTransitarPara(Estado.ENTREGUE))
        assertFalse(Estado.EM_TRANSPORTE.podeTransitarPara(Estado.PAGO))
	}

    @Test fun transicoeDoEstadoENTREGUE() {
        assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.ABERTO))
        assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.FINALIZADO))
		assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.PAGO))
		assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.EM_TRANSPORTE));
		assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.ENTREGUE));
		assertFalse(Estado.ENTREGUE.podeTransitarPara(Estado.CANCELADO));
	}

    @Test fun transicoeDoEstadoCANCELADO() {
        assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.ABERTO))
        assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.FINALIZADO))
		assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.PAGO))
		assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.EM_TRANSPORTE));
		assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.ENTREGUE));
		assertFalse(Estado.CANCELADO.podeTransitarPara(Estado.CANCELADO));
	}
	

}