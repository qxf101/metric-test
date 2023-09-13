package com.example.testmetrics.metrics;

import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Tags;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;

@Component
@Slf4j
public class Metrics {
    private final MeterRegistry meterRegistry;

    @Autowired
    public Metrics(MeterRegistry meterRegistry) {
        this.meterRegistry = meterRegistry;
    }

    @PostConstruct
    public void init() {
        // 注册第一个指标
        meterRegistry.gauge("abc.test", Tags.of("region", "north"), 6227072.0);
        // 注册第二个指标
        meterRegistry.gauge("abc.test", Tags.of("region", "south"), 6227072.0);

        meterRegistry.getMeters().forEach(meter -> {
            String name = meter.getId().getName();
            double val = meter.measure().iterator().next().getValue();
            log.info("name: {}, value: {}", name, val);
        });
    }
}
