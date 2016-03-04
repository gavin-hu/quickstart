package net.hs.cw.quickstart.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.clients.producer.ProducerRecord;

import java.util.Properties;

/**
 * @author gavin
 * @create 16/2/26
 */
public class MessageProducer {

    public static void main(String[] args) {
        Properties config = new Properties();
        config.setProperty(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.setProperty(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.ByteArraySerializer.class.getName());
        config.setProperty(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.ByteArraySerializer.class.getName());
        config.setProperty(ProducerConfig.BATCH_SIZE_CONFIG, "0");
        //
        KafkaProducer<byte[], byte[]> kafkaProducer = new KafkaProducer(config);
        //
        String topic = "test";
        //
        for(int i=0; i<1000; i++) {
            String value = topic + i;
            ProducerRecord<byte[], byte[]> record = new ProducerRecord<byte[], byte[]>(topic, value.getBytes());
            kafkaProducer.send(record);
        }
        //
        kafkaProducer.close();
    }

}
