package com.github.gavinhu.quickstart.disruptor;

import com.lmax.disruptor.EventFactory;

/**
 * @author gavin
 * @create 16/2/18
 */
public class DataEventFactory implements EventFactory<DataEvent> {

    public DataEvent newInstance() {
        return new DataEvent();
    }

}
