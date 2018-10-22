package kotlinsample.pedido

import java.time.LocalDate
import org.junit.Assert.assertTrue
import org.junit.Assert.fail
import org.junit.Test

class PedidoTest {

	@Test fun devePassarDeAbertoParaFinalizado() {
		val pedido = Pedido("123", LocalDate.now(), null)
		assertTrue(pedido.estado == Estado.ABERTO);
		pedido.estado = Estado.FINALIZADO
		assertTrue(pedido.estado == Estado.FINALIZADO)
	}
	
	@Test(expected=IllegalArgumentException::class)
	fun deveDarErroAoPassarDeAbertoParaEntregue() {
		val pedido = Pedido("123", LocalDate.now(), null)
		pedido.estado = Estado.ENTREGUE
	}

}