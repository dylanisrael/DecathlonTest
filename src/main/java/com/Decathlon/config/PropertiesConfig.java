package com.Decathlon.config;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.Properties;

public class PropertiesConfig {

    private static PropertiesConfig INSTANCE = new PropertiesConfig();

    private static final String PROPERTIES_FILENAME = "config.properties";
    private static final String PROPERTIES_LOCATION = "config/" + PROPERTIES_FILENAME;

    private Properties properties = new Properties();

    public PropertiesConfig(){
        try(BufferedReader reader = new BufferedReader(new FileReader(PROPERTIES_LOCATION))){
            properties.load(reader);
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public Object get(String key, Object defaultValue){
        if( properties.getProperty( key ) == null ) return defaultValue;
        return properties.getProperty( key );
    }

    public Object get(String key){ return properties.getProperty(key, null); }

    public Boolean getBool(String key){ return Boolean.valueOf((String)get(key)); }

    public static PropertiesConfig getInstance(){
        return INSTANCE;
    }

}
