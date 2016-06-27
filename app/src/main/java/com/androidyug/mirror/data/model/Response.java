
package com.androidyug.mirror.data.model;

import java.io.Serializable;

public class Response implements Serializable {

    private Data data;

    /**
     * 
     * @return
     *     The sagittarius
     */
    public Data getData() {
        return data;
    }
    public void setData(Data data) {
        this.data = data;
    }

}
