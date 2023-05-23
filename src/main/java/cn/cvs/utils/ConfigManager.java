package cn.cvs.utils;

import cn.cvs.controller.HelloController;
import org.jboss.logging.Logger;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

/**
 * @Author: SIYU
 * @Description: TODO
 * @DateTime: 2023/5/19 8:36
 **/
public class ConfigManager {
    private static Properties properties ;
    private static ConfigManager configManager = null;
//    SL7
//    private static ConfigManager configManager = new ConfigManager();
    Logger logger = Logger.getLogger(HelloController.class);

    private ConfigManager() {
        String configManager = "database.properties";
        properties = new Properties();
        InputStream is = ConfigManager.class.getClassLoader().getResourceAsStream(configManager);
        try {
            properties.load(is);
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
            logger.error(e.getMessage(), e);
        }
    }

//    SL7
//    public static ConfigManager getInstance() {
//        return configManager;
//    }
//



    public static synchronized ConfigManager getInstance() {
        if (configManager == null) {
            configManager = new ConfigManager();
        }
        return configManager;
    }

    public String getValue(String key) {
        return properties.getProperty(key);
    }
}
