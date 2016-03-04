package net.hs.cw.quickstart.disruptor;

import com.lmax.disruptor.EventHandler;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * @author gavin
 * @create 16/2/18
 */
public class DataEventHandler implements EventHandler<DataEvent> {

    private static final Logger logger = LogManager.getLogger(DataEventHandler.class);

    private String name;

    public DataEventHandler() {
    }

    public DataEventHandler(String name) {
        this.name = name;
    }

    public void onEvent(DataEvent event, long sequence, boolean endOfBatch) throws Exception {
        if(name!=null) {
            event.getHandlers().add(name);
        }
        //
        logger.trace("Handler {} Event {} {}", name, event.getName(), event.getData());
    }

}
