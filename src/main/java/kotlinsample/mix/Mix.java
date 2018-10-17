package kotlinsample.mix;

import java.lang.reflect.Field;

public class Mix {

	public static void main(String[] args) {
		JavaPerson javaPerson = new JavaPerson("Ladybug", 15);
		KotlinPerson kotlinPerson = new KotlinPerson("Ladybug", 15);

		Field[] javaFields = JavaPerson.class.getDeclaredFields();
		Field[] kotlinFields = KotlinPerson.class.getDeclaredFields();
		
		System.out.println(javaFields.equals(kotlinFields));
	}
}
