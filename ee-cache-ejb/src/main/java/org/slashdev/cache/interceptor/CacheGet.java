package org.slashdev.cache.interceptor;


import org.ehcache.Cache;
import org.slashdev.cache.CachePolicy;
import org.slashdev.cache.annotation.AnnotationUtil;
import org.slashdev.cache.annotation.CacheGetAnnotation;
import org.slashdev.cache.manager.ICacheManager;

import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;
import java.io.Serializable;
import java.lang.annotation.Annotation;

@Stateful()
public class CacheGet implements Interceptor {

    @EJB
    private ICacheManager cacheManager;

    public Class<? extends Annotation> annotationType() {
        return CacheGetAnnotation.class;
    }

    @AroundInvoke
    public Object aroundInvoke(InvocationContext ctx) throws Exception {
        String key, name;
        CachePolicy cachePolicy;
        if (ctx.getMethod().isAnnotationPresent(CacheGet.class)) {
            key = getCacheKeyFromContext(ctx);
            name = getCacheNameFromContext(ctx);
            cachePolicy = getCachePolicyFromContext(ctx);
            Cache<String, Serializable> cache = cacheManager.getCacheManager().getCache(name, String.class, Serializable.class);
            if(cache.containsKey(key)) return cache.get(key);
            else  {
                Serializable proceed = (Serializable) ctx.proceed();
                if(cachePolicy.equals(CachePolicy.READ_THROUGH))
                    cache.put(key, proceed);
                return proceed;
            }
        }
        else {
            Object proceed = ctx.proceed();
            return proceed;
        }
    }

    protected String getCacheKeyFromContext(InvocationContext context) {
        String key = AnnotationUtil.getFromInvocationContext(context).key();
        return key;
    }

    protected String getCacheNameFromContext(InvocationContext context) {
        String cacheName = AnnotationUtil.getFromInvocationContext(context).cacheName();
        return cacheName;
    }

    protected CachePolicy getCachePolicyFromContext(InvocationContext context) {
        CachePolicy cachePolicy = AnnotationUtil.getFromInvocationContext(context).cacheType();
        return cachePolicy;
    }

}
