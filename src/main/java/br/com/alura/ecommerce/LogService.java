package br.com.alura.ecommerce;

import org.apache.kafka.clients.consumer.ConsumerRecord;

public class LogService {

    public static void main(String[] args) {
        var logService = new LogService();

        try (KafkaService service = new KafkaService(LogService.class.getSimpleName(), "ECOMMERCE.*",
                logService::parse, String.class)) {

            service.run();
        }

    }

    public void parse(ConsumerRecord<String, String> record) {
        System.out.println("LOG" + record.topic());
        System.out.println(record.key());
        System.out.println(record.value());
        System.out.println(record.partition());
        System.out.println(record.offset());
    }

}
