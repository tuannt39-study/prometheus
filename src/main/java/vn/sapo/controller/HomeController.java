package vn.sapo.controller;

import io.micrometer.core.instrument.Counter;
import io.micrometer.core.instrument.MeterRegistry;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/home")
public class HomeController {
    private final MeterRegistry registry;

    public HomeController(MeterRegistry registry) {
        this.registry = registry;
    }


    @GetMapping("/{name}")
    public String home (@PathVariable("name") String name) throws InterruptedException {
        Thread.sleep(1000);
        getName(name);
        return name;
    }

    private void getName(String name) {
        Counter counter = Counter
                .builder("getNameHome")
                .baseUnit("beans") // optional
                .description("a description of what this counter does") // optional
                .tags("region", "test") // optional
                .register(registry);
//        Counter counter = registry.counter("getName-home");
        System.out.println(name);
        counter.increment();
    }
}
