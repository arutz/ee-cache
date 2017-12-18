package org.slashdev.cache.manager;

import org.ehcache.CacheManager;
import org.ehcache.config.builders.CacheManagerBuilder;
import org.ehcache.xml.XmlConfiguration;
import org.slashdev.App;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.annotation.PostConstruct;
import javax.ejb.Singleton;
import javax.ejb.Startup;
import javax.ejb.Stateless;
import java.net.URL;

@Startup
@Singleton
public class DefaultCacheManager implements ICacheManager {

    private static Logger LOGGER = LoggerFactory.getLogger(App.class);

    private CacheManager cacheManager;

    @PostConstruct
    public void init() {
        LOGGER.info("Creating cache manager from xml file");
        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
        URL xmlConfigFile = classLoader.getResource("config/cache/ehcache.xml");
        XmlConfiguration xmlConfiguration = new XmlConfiguration(xmlConfigFile);
        cacheManager = CacheManagerBuilder.newCacheManager(xmlConfiguration);
        LOGGER.info("cache manager initialized");
    }

    @Override
    public CacheManager getCacheManager() {
        return cacheManager;
    }

    public void setCacheManager(CacheManager cacheManager) {
        this.cacheManager = cacheManager;
    }
}
