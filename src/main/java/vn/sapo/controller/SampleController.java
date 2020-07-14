package vn.sapo.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import io.micrometer.core.instrument.Timer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//import vn.sapo.service.SampleService;

import java.time.Duration;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.stream.LongStream;

@RestController
@RequestMapping(path = "/sample")
public class SampleController {

//    private final Timer timer;
//
//    public SampleController(Timer timer) {
//        this.timer = timer;
//    }
private final MeterRegistry registry;

    public SampleController(MeterRegistry registry) {
        this.registry = registry;
    }

//    @Autowired
//    private SampleService sampleService;

//    @Timed("sample.controller")
//    @Timed(value = "b1", percentiles = {0.5, 0.95, 0.99, 1.0}, histogram = true, description = "b11")
//    @Timed("social.a0")
    @GetMapping("/call-rest-template")
    public Map<String, Object> callRestTemplate222222222() throws InterruptedException {
        Timer.Builder builder = Timer.builder("social.a002")
                .publishPercentiles(0, 0.5, 0.75, 0.95, 0.99, 1.0)
//                .publishPercentileHistogram()
                .serviceLevelObjectives(Duration.ofMillis(100),Duration.ofMillis(500),Duration.ofMillis(700))
                .minimumExpectedValue(Duration.ofMillis(1))
                .maximumExpectedValue(Duration.ofMinutes(1))
                .tag("uri", "call-rest-template");
        Timer.Sample sample = Timer.start(registry);

//        Timer timer = Timer.builder("social.a002")
//            .publishPercentiles(0, 0.5, 0.75, 0.95, 0.99, 1.0)
//            .publishPercentileHistogram()
//            .minimumExpectedValue(Duration.ofMillis(1))
//            .maximumExpectedValue(Duration.ofMinutes(5)).register(registry);
//        Timer.Sample sample = Timer.start(registry);
//        Map<String, Object> map = sampleService.callRestTemplate2();
        int leftLimit = 1000;
        int rightLimit = 10000;
        int generatedInteger = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
        Thread.sleep(generatedInteger);
        Timer timer = builder.register(registry);
        sample.stop(timer);
        return new HashMap<>();
    }
}