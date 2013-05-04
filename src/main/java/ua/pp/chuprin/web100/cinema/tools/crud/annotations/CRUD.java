package ua.pp.chuprin.web100.cinema.tools.crud.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CRUD
{
	boolean list() default true;
	boolean edit() default true;
	boolean view() default true;

	int order() default 0;
	String cssClass() default "";
	String template() default "";
}
