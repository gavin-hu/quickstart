package com.github.gavinhu.quickstart.disruptor;

import com.lmax.disruptor.EventFactory;
import com.lmax.disruptor.RingBuffer;
import com.lmax.disruptor.dsl.Disruptor;

import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;

/**
 * @author gavin
 * @create 16/2/18
 */
public class DataEventMain {

    public static void main(String[] args) {
        // Executor that will be used to construct new threads for consumers
        ThreadFactory threadFactory = Executors.defaultThreadFactory();

        // The factory for the event
        EventFactory eventFactory = new DataEventFactory();

        // Specify the size of the ring buffer, must be power of 2.
        int bufferSize = 1024;

        // Construct the Disruptor
        Disruptor<DataEvent> disruptor = new Disruptor<DataEvent>(eventFactory, bufferSize, threadFactory);

        // Connect the handler
        disruptor.handleEventsWith(new DataEventHandler("A"))
                .then(new DataEventHandler("D"), new DataEventHandler("E"), new DataEventHandler("F"), new DataEventHandler("G"), new DataEventHandler("H"))
                .then(new DataEventHandler("B"))
                .then(new DataEventHandler("C"));

        // Start the Disruptor, starts all threads running
        disruptor.start();

        // Get the ring buffer from the Disruptor to be used for publishing.
        RingBuffer<DataEvent> ringBuffer = disruptor.getRingBuffer();
        //
        int i = 0;
        //for(int i=0; i<10000; i++) {
            long sequence = ringBuffer.next();
            DataEvent dataEvent = ringBuffer.get(sequence);
            dataEvent.setName("name" + i);
            dataEvent.setData("data" + i);
            //
            ringBuffer.publish(sequence);
        //}
        //
        disruptor.shutdown();
    }

}
