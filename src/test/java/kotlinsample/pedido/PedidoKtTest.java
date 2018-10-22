package kotlinsample.pedido;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;

import java.time.LocalDate;

import org.junit.Test;

public class PedidoKtTest {

	@Test public void test() {
		Pedido pedido = new Pedido("123", LocalDate.now(), null);
		assertTrue(pedido.getEstado().equals(Estado.ABERTO));
		pedido.setEstado(Estado.FINALIZADO);
		assertTrue(pedido.getEstado().equals(Estado.FINALIZADO));
		try {
			pedido.setEstado(Estado.ENTREGUE);
			fail();
		} catch (IllegalArgumentException e) {
			assertTrue(e.getMessage().startsWith("Transição não permitida"));
		}
	}

}
