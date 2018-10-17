package kotlinpoc.infra


import kotlinsample.mix.KotlinPerson
import org.junit.Test
import org.junit.Assert.assertEquals


class GsonJsonParserTest () {
    val parser = GsonJsonParser()
	val json = "{\"name\":\"Ladybug\",\"age\":15}"
	val person = KotlinPerson("Ladybug", 15)

	@Test
	fun testToJson() {
		val parsed = parser.toJson(person)	
		println(parsed)
		assertEquals(json, parsed)
	}
	
	@Test
	fun testFromJson() {
		val parsed = parser.fromJson(json, KotlinPerson::class.java)
		println(parsed)
		assertEquals(person, parsed)
	}
}
