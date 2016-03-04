package net.hs.cw.quickstart.disruptor;

import java.util.ArrayList;
import java.util.List;

/**
 * @author gavin
 * @create 16/2/18
 */
public class DataEvent {

    private String name;
    private String data;
    private List<String> handlers = new ArrayList<String>();

    public DataEvent() {
    }

    public DataEvent(String name, String data) {
        this.name = name;
        this.data = data;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public List<String> getHandlers() {
        return handlers;
    }
}
