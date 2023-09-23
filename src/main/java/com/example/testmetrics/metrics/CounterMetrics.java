package com.example.testmetrics.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.net.DatagramPacket;
import java.util.Random;

@Component
public class CounterMetrics {

    @Autowired
    private MeterRegistry meterRegistry;

    public double registry(double val) {
        meterRegistry.counter("test.counter", "name", "qxf").increment(val);
        return val;
    }

    public double getCounter() {
        return meterRegistry.get("test.counter").counter().count();
    }
}
