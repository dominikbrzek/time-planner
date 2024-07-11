package timeplanner;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = "timeplanner")
public class TimePlannerApplication {

    public static void main(String[] args) {
        SpringApplication.run(TimePlannerApplication.class, args);
    }

}
