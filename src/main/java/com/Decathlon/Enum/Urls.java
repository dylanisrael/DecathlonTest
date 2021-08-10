package com.Decathlon.Enum;

import java.io.FileReader;
import java.util.Properties;

public enum Urls {

    PRODUCTION,
    INTEGRATION;

    private final static String CONFIG_URLS = "config/urls.properties";

    private String environmentUrl;

    public static Urls parse(String value){
        return Urls.valueOf(value);
    }

    public String getUrl(){
        if(this.environmentUrl == null ){
            this.initEnv();
        }
        return this.environmentUrl;
    }

    private void setUrl(String url){ this.environmentUrl=url; }

    public void initEnv(){
        try{
             Properties prop = new Properties();
             prop.load(new FileReader(CONFIG_URLS));
             prop.forEach((key, value)->{
                 Urls.valueOf(key.toString().toUpperCase()).setUrl(value.toString());
             });

        }catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
