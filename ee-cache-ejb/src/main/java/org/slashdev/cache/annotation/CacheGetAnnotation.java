package org.slashdev.cache.annotation;

import org.slashdev.cache.CachePolicy;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface CacheGetAnnotation {

    String key();
    String cacheName() default "default";
    CachePolicy cacheType() default CachePolicy.READ_THROUGH;
}
