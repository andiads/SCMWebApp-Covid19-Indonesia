package com.nusacamp.app.constarint;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.ElementType.TYPE;
import static java.lang.annotation.RetentionPolicy.RUNTIME;


import javax.validation.Constraint;
import javax.validation.Payload;

@Target({TYPE, ANNOTATION_TYPE})
@Retention(RUNTIME)
@Constraint(validatedBy = FieldMatchValidator.class)
@Documented
public @interface FieldMatch {//creating custom annotation
	
	String message() default "{constaraints.field-match}";
	Class<?>[]groups()default{};
	Class<? extends Payload>[] payload() default{};
	String first();
	String second();
	
	@Target ({TYPE,ANNOTATION_TYPE})
	@Retention(RUNTIME)
	@Documented
	@interface List{
		FieldMatch[] value();
	}
	
	

}
