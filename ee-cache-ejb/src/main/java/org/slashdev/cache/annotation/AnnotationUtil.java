package org.slashdev.cache.annotation;

import javax.interceptor.InvocationContext;
import java.lang.reflect.Method;

public class AnnotationUtil {

    public static CacheGetAnnotation getFromInvocationContext(InvocationContext context)  {
        Method method = context.getMethod();
        return method.getAnnotation(CacheGetAnnotation.class);
    }

}
