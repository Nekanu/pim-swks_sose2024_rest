#!/usr/bin/env sh
timestamp=$(date +%Y-%m-%d_%H-%M-%S)
jmeter -n -t TestPlan.jmx \
    -l "results/result_$timestamp.jtl" \
    -j "logs/log_$timestamp.log" \
    -efo reports/ \
    -Jjmeter.reportgenerator.overall_granularity=5000 \
    -Jjmeter.reportgenerator.exporter.html.series_filter="^Test:" \
    -Jport=18080
