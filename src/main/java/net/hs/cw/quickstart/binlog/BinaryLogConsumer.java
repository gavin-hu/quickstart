package net.hs.cw.quickstart.binlog;

import com.github.shyiko.mysql.binlog.BinaryLogClient;
import com.github.shyiko.mysql.binlog.event.Event;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author gavin
 * @create 16/2/24
 */
public class BinaryLogConsumer {

    private static final Logger logger = LogManager.getLogger(BinaryLogConsumer.class);

    public static void main(String[] args) throws Exception {
        //
        final BinaryLogClient binaryLogClient = new BinaryLogClient("localhost", 3306, "root", "");
        binaryLogClient.setBlocking(false);
        binaryLogClient.setBinlogPosition(4);
        binaryLogClient.setBinlogFilename("mysql-bin.000001");
        binaryLogClient.registerEventListener(new BinaryLogClient.EventListener() {
            public void onEvent(Event event) {
                logger.info(event);
            }
        });
        binaryLogClient.connect();
        //
        //TimeUnit.SECONDS.sleep(1);
        //
        System.out.println(binaryLogClient.getBinlogFilename());
        System.out.println(binaryLogClient.getBinlogPosition());
        System.out.println(binaryLogClient.getConnectionId());
        //
        binaryLogClient.disconnect();
    }

}
