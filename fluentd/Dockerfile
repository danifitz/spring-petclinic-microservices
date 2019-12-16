FROM fluent/fluentd:v1.7.4-1.0
# Specify the volume where fluentd will pickup logs from other containers
VOLUME /fluentd/log

# For New Relic API Key to send logs to New Relic
ARG INSIGHTS_INSERT_KEY
ENV INSIGHTS_INSERT_KEY=${INSIGHTS_INSERT_KEY}

# Install the fluentd new relic plugin
USER root
RUN fluent-gem install fluent-plugin-newrelic
USER fluent

COPY fluent.conf /fluentd/etc/