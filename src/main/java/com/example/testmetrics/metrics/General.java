package com.example.testmetrics.metrics;

public abstract class General<REQ, RESP> {
    abstract public RESP doAction(REQ request);

    public String actionName() {
        return this.getClass().getSimpleName();
    }
}
