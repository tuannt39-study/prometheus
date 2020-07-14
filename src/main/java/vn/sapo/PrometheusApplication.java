package vn.sapo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PrometheusApplication {
//    @Bean
//    public TimedAspect timedAspect(MeterRegistry registry) {
//        return new TimedAspect(registry);
//    }
    public static void main(String[] args) {
        SpringApplication.run(PrometheusApplication.class, args);
    }

}
