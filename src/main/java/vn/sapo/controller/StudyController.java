package vn.sapo.controller;

import io.micrometer.core.annotation.Timed;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/study")
//@Timed
public class StudyController {
    private final MeterRegistry registry;

    public StudyController(MeterRegistry registry) {
        this.registry = registry;
    }

    @GetMapping("/{name}")
//    @Timed
//    @Timed(percentiles = {0.5, 0.95, 0.99, 1.0}, histogram = true, description = "study-home")
//    @Timed(value = "social.a0", percentiles = {0.5, 0.95, 0.99, 1.0}, histogram = true, description = "social.b0")
    public String home (@PathVariable("name") String name) {
        getName(name);
        System.out.printf("1");
        getName2(name);
        return name;
    }

//    @Timed(value = "aaaa", description = "vvvvvvv")
//    @Timed
//    @Timed(value = "social.a1", percentiles = {0.5, 0.95, 0.99, 1.0}, histogram = true, description = "social.b1")
    private void getName(String name) {
//        Counter counter = Counter.builder("beer.orders")    // 2 - create a counter using the fluent API
//                .tag("type", "ale")
//                .description("The number of orders ever placed for Ale beers")
//                .register(registry);
//        Timer timer = Timer
//                .builder("my.timer")
//                .description("a description of what this timer does") // optional
//                .tags("region", "test") // optional
//                .register(registry);
        System.out.println(name);
//        timer.
//        counter.increment();
    }

    //    @Timed(value = "aaaa", description = "vvvvvvv")
//    @Timed
//    @Timed(value = "social.a2", percentiles = {0.5, 0.95, 0.99, 1.0}, histogram = true, description = "social.b2")
    private void getName2(String name) {
        System.out.println(name);
    }
}
