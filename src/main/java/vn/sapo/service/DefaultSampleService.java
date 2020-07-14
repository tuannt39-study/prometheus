//package vn.sapo.service;
//
//import io.micrometer.core.annotation.Timed;
//import io.micrometer.core.instrument.Timer;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Service;
//import org.springframework.web.client.RestTemplate;
//
//import java.time.Duration;
//import java.util.HashMap;
//import java.util.Map;
//
//@Service
//public class DefaultSampleService implements SampleService {
//
//    @Autowired
//    private RestTemplate restTemplate;
//
////    @Timed("sample.service")
//    @Override
////    @Timed("social.a3")
//    public Map<String, Object> callRestTemplate() {
//        Map<String, Object> map = new HashMap<>();
//        try {
//            Thread.sleep(2000);
//            return this.restTemplate.getForObject("https://spring.io/info", Map.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
//    @Override
////    @Timed("social.a4")
//    public Map<String, Object> callRestTemplate2() {
//
////        Timer.builder("social.a0")
////                .publishPercentiles(0.5, 0.95)
////                .publishPercentileHistogram()
////                .minimumExpectedValue(Duration.ofMillis(1))
////                .maximumExpectedValue(Duration.ofSeconds(10));
//
//        Map<String, Object> map = new HashMap<>();
//        try {
//            Thread.sleep(2000);
////            System.out.println(1/0);
//            return this.restTemplate.getForObject("https://spring.io/info", Map.class);
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return map;
//    }
//}