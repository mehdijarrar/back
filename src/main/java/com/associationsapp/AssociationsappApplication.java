package com.associationsapp;
import com.associationsapp.property.FileStorageProperties ;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

@SpringBootApplication
@EnableConfigurationProperties({
        FileStorageProperties.class
})
public class AssociationsappApplication {

    public static void main(String[] args) {
        SpringApplication.run(AssociationsappApplication.class, args);
    }

}
