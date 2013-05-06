package ua.pp.chuprin.web100.cinema.tools.crud.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CRUD {
	String cssClass() default "";

	boolean edit() default true;

	boolean list() default true;

	Class joinType() default Void.class;

	short order() default 0;

	boolean view() default true;
}
