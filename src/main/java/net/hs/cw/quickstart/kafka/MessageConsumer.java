package net.hs.cw.quickstart.kafka;

import org.apache.kafka.clients.consumer.ConsumerConfig;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.apache.kafka.clients.consumer.ConsumerRecords;
import org.apache.kafka.clients.consumer.KafkaConsumer;

import java.util.Arrays;
import java.util.Properties;

/**
 * @author gavin
 * @create 16/2/26
 */
public class MessageConsumer {

    public static void main(String[] args) throws Exception {
        Properties config = new Properties();
        config.setProperty(ConsumerConfig.GROUP_ID_CONFIG, "testGroup");
        config.setProperty(ConsumerConfig.BOOTSTRAP_SERVERS_CONFIG, "localhost:9092");
        config.setProperty(ConsumerConfig.ENABLE_AUTO_COMMIT_CONFIG, "true");
        config.setProperty(ConsumerConfig.KEY_DESERIALIZER_CLASS_CONFIG,org.apache.kafka.common.serialization.ByteArrayDeserializer.class.getName());
        config.setProperty(ConsumerConfig.VALUE_DESERIALIZER_CLASS_CONFIG, org.apache.kafka.common.serialization.ByteArrayDeserializer.class.getName());
        //
        KafkaConsumer<byte[], byte[]> consumer = new KafkaConsumer<byte[], byte[]>(config);
        consumer.subscribe(Arrays.asList("test"));
        //
        while(true) {
            ConsumerRecords<byte[],byte[]> consumerRecords = consumer.poll(1000);
            for(ConsumerRecord<byte[], byte[]> consumerRecord : consumerRecords) {
                System.out.println(new String(consumerRecord.value()));
            }
        }

    }

}
