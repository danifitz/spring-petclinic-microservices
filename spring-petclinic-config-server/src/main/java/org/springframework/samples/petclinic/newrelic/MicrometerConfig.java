// package org.springframework.samples.petclinic.newrelic;

// import com.newrelic.telemetry.Attributes;
// import io.micrometer.NewRelicRegistryConfig;
// import io.micrometer.core.instrument.util.NamedThreadFactory;
// import io.micrometer.newrelic.NewRelicRegistry;
// import java.net.InetAddress;
// import java.net.UnknownHostException;
// import java.time.Duration;
// import org.springframework.boot.actuate.autoconfigure.metrics.CompositeMeterRegistryAutoConfiguration;
// import org.springframework.boot.actuate.autoconfigure.metrics.MetricsAutoConfiguration;
// import org.springframework.boot.actuate.autoconfigure.metrics.export.simple.SimpleMetricsExportAutoConfiguration;
// import org.springframework.boot.autoconfigure.AutoConfigureAfter;
// import org.springframework.boot.autoconfigure.AutoConfigureBefore;
// import org.springframework.boot.autoconfigure.SpringBootApplication;
// import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;

// @Configuration
// @AutoConfigureBefore({
//     CompositeMeterRegistryAutoConfiguration.class,
//     SimpleMetricsExportAutoConfiguration.class
// })
// @AutoConfigureAfter(MetricsAutoConfiguration.class)
// @ConditionalOnClass(NewRelicRegistry.class)
// @SpringBootApplication(scanBasePackages = {"org.springframework.samples.petclinic"})
// public class MicrometerConfig {

//     @Bean
//     public NewRelicRegistryConfig newRelicConfig() {
//         return new NewRelicRegistryConfig() {
//             @Override
//             public String get(String key) {
//                 return null;
//             }

//             @Override
//             public String apiKey() {
//                 System.out.println(System.getenv("INSIGHTS_INSERT_KEY"));
//                 return System.getenv("INSIGHTS_INSERT_KEY");
//             }

//             @Override
//             public String uri() {
//               return System.getenv("NEW_RELIC_METRIC_URI");
//             }

//             @Override
//             public Duration step() {
//                 return Duration.ofSeconds(5);
//             }
//         };
//     }

//     @Bean
//     public NewRelicRegistry newRelicMeterRegistry(NewRelicRegistryConfig config)
//         throws UnknownHostException {
//         NewRelicRegistry newRelicRegistry =
//             NewRelicRegistry.builder(config)
//                 .commonAttributes(
//                     new Attributes()
//                         .put("appName", "spring-petclinic-config-server")
//                         .put("host", InetAddress.getLocalHost().getHostName()))
//                 .build();
//         newRelicRegistry.start(new NamedThreadFactory("newrelic.micrometer.registry"));
//         return newRelicRegistry;
//     }
// }