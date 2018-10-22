package kotlinsample.pedido

import java.util.HashMap
import java.util.ArrayList
import java.lang.IllegalStateException

enum class Estado(val id: Int, val descricao: String, val encerrado: Boolean) {
	ABERTO(1, "Aberto", false),
	FINALIZADO(2, "Finalizado", false),
	PAGO(3, "Pago", false),
	EM_TRANSPORTE(4, "Em Transporte", false),
	ENTREGUE(5, "Entregue", true),
	CANCELADO(6, "Cancelado", true);


	fun isEncerrado(): Boolean {
		return encerrado
	}

	fun podeTransitarPara(proximo: Estado): Boolean {
		val permitidos = transicoesPermitidas.get(this)
		if (permitidos != null) {
			return permitidos.contains(proximo)
		}
		throw IllegalStateException("Transição não definida para $this")
	}

	companion object {
		val transicoesPermitidas = mapOf<Estado, Set<Estado>>(
				ABERTO to setOf(FINALIZADO, CANCELADO),
				FINALIZADO to setOf(ABERTO, PAGO, CANCELADO),
				PAGO to setOf(EM_TRANSPORTE),
				EM_TRANSPORTE to setOf(ENTREGUE),
				ENTREGUE to setOf(),
				CANCELADO to setOf()
		)
	}
}