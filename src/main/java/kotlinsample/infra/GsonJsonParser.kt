package kotlinpoc.infra

import com.google.gson.Gson
import kotlin.reflect.KClass

class GsonJsonParser : JsonParser {

	val gson = Gson()

	override fun toJson(obj: Any): String {
		return gson.toJson(obj)
	}

	override fun <T : Any> fromJson(json: String, clazz: Class<T>): T {
		return gson.fromJson(json, clazz)
	}

}