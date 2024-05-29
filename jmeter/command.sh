#!/usr/bin/env sh
jmeter -n -t testplan/TestPlan.jmx -l results/result.jtl -j logs/log.log
