package com.example.testmetrics.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;

@Component
@Slf4j
public class RefreshMetrics {

    @Autowired
    private MeterRegistry meterRegistry;

    /**
     * 指标缓存，用于存储注册的指标
     */
    private static final Map<String, AtomicLong> metricsCache = new HashMap<>();

    public String updateMetrics(Long metricValue) {
        String metricName = "system.request.number";

        if (metricsCache.containsKey(metricName)) {
            metricsCache.get(metricName).set(metricValue);
        } else {
            AtomicLong metrics = meterRegistry.gauge(metricName, Tags.of("system", "windows"), new AtomicLong(metricValue));
            metricsCache.put(metricName, metrics);
        }

        return "registry success";
    }

    public double getMetrics() {
        return meterRegistry.get("system.request.number").gauge().value();
    }
}
