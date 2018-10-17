package kotlinpoc.infra

import kotlin.reflect.KClass

interface JsonParser{
	
	fun toJson(obj: Any): String
	
	fun <T :Any> fromJson(json: String, clazz:  Class<T>): T
}