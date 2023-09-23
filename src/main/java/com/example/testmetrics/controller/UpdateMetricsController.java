package com.example.testmetrics.controller;

import com.example.testmetrics.metrics.CounterMetrics;
import com.example.testmetrics.metrics.RefreshMetrics;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UpdateMetricsController {

    @Autowired
    private RefreshMetrics refreshMetrics;

    @Autowired
    private CounterMetrics counterMetrics;

    @GetMapping("/update/metrics")
    public String updateMetrics(@RequestParam Long metricsValue) {
        return refreshMetrics.updateMetrics(metricsValue);
    }

    @GetMapping("/get/metrics")
    public double getMetrics() {
        return refreshMetrics.getMetrics();
    }

    @GetMapping("/update/counter")
    public double updateCounterMetrics(@RequestParam Double val) {
        return counterMetrics.registry(val);
    }

    @GetMapping("/get/counter")
    public double getCounter() {
        return counterMetrics.getCounter();
    }
}
