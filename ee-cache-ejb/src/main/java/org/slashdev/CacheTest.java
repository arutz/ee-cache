package org.slashdev;

import org.slashdev.cache.manager.ICacheManager;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Singleton;
import javax.ejb.Startup;

@Startup
@Singleton
public class CacheTest {

    @EJB
    private ICacheManager cacheManager;

    @PostConstruct
    public void init() {

    }

}
