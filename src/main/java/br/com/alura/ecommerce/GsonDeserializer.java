package br.com.alura.ecommerce;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import org.apache.kafka.common.serialization.Deserializer;

public class GsonDeserializer<T> implements Deserializer<T> {

    public static final String TYPE_CONFIG = "br.com.alura.ecommerce.type_conifg";
    private final Gson gson = new GsonBuilder().create();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        String typeName = String.valueOf(configs.get(TYPE_CONFIG));

        try {
            Class type = Class.forName(typeName);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public T deserialize(String topic, byte[] data) {

        return gson.fromJson(data, type);
    }
}
