package dev.pp.gifty;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Import;

@SpringBootApplication
@Import(WebConfig.class)
public class GiftyApplication {
    public static void main(String[] args) {
        SpringApplication.run(GiftyApplication.class, args);
    }
}
