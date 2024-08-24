#!/usr/bin/env sh
timestamp=$(date +%Y-%m-%d_%H-%M-%S)
jmeter -n -t TestPlan.jmx -l "results/result_$timestamp.jtl" -j "logs/log_$timestamp.log"
