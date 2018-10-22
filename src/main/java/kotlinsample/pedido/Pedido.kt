package kotlinsample.pedido

import java.time.LocalDate
import java.lang.IllegalArgumentException

class Pedido(val numero: String, val criacao: LocalDate, val conclusao: LocalDate?) {
	var estado = Estado.ABERTO
		set (value) {
			if (!estado.podeTransitarPara(value)) {
				throw IllegalArgumentException("Transição não permitida de $estado para $value")
			}
			field = value
		}
	
	fun isEncerrado(): Boolean{
        return estado.isEncerrado() || isAntigoDemais()
    }

    fun isAntigoDemais()= LocalDate.now().isAfter(criacao.plusYears(1))
}