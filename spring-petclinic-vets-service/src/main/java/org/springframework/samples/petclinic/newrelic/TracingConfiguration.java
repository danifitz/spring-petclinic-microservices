package org.springframework.samples.petclinic.newrelic;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import zipkin2.Span;
import zipkin2.reporter.AsyncReporter;
import zipkin2.reporter.Sender;
import zipkin2.reporter.okhttp3.OkHttpSender;

/**
 * This adds tracing configuration to any web mvc controllers or rest template clients.
 *
 * <p>This is a {@link Initializer#getRootConfigClasses() root config class}, so the
 * {@linkplain DelegatingTracingFilter} added in {@link Initializer#getServletFilters()} can wire up
 * properly.
 */
@Configuration
public class TracingConfiguration {

  /** Configuration for how to send spans to Zipkin */
  @Bean Sender sender() {
    String apiKey = System.getenv("INSIGHTS_INSERT_KEY");
    String newRelicTracingUri = System.getenv("NEW_RELIC_TRACE_URI");
    return OkHttpSender.create(newRelicTracingUri + "?Api-Key=" + apiKey + "&Data-Format=zipkin&Data-Format-Version=2");
  }

  /** Configuration for how to buffer spans into messages for Zipkin */
  @Bean AsyncReporter<Span> spanReporter() {
    return AsyncReporter.create(sender());
  }
}
