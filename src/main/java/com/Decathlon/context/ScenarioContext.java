package com.Decathlon.context;

import java.util.HashMap;

public class ScenarioContext {

    private static final ScenarioContext INSTANCE = new ScenarioContext();

    private final HashMap<String, Object> buffer = new HashMap<>();

    public void set( String key, Object value ){
        this.buffer.put(key, value);
    }

    public <R> R get( String key ){
        return (R)this.buffer.get(key);
    }

    public static ScenarioContext getINSTANCE() { return INSTANCE; }
}
