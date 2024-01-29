package com.Housing.Bias;

import com.Housing.Bias.controller.UserController;
import com.Housing.Bias.entity.User;
import com.Housing.Bias.repository.UserRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {
    private static final Logger log = LoggerFactory.getLogger(LoadDatabase.class);
    User bonie = new User("Bonie", "bias2@gmail.com", "pass012", "Appraiser");
    User mark = new User("Mark", "bias345@gmail.com", "pass345", "Lender");
    User mark2 = new User("Markenson", "bias001@gmail.com", "pass001", "Broker");
    @Bean
    CommandLineRunner initDatabase(UserRepository userRepository) {
        return args -> {
            log.info("Preloading " + userRepository.save(new User(
                    "Guerdy Lambert", "bias9@gmail.com", "pass123", "Lender")));
            log.info("preloading " + userRepository.save(new User(
                    "Ethan Lambert", "bias10@gmail.com", "pass456", "Appraiser")));
            log.info("preloading " + userRepository.save(new User(
                    "Alpay", "bias1@gmail.com", "pass789", "Lender" )));
        };
    }

    @Bean
    CommandLineRunner init2Database(UserController userController) {
        return args -> {
//            User bonie = new User("Bonie", "bias2@gmail.com", "pass012", "Appraiser");
//            User mark = new User("Mark", "bias345@gmail.com", "pass345", "Lender");
            log.info("Preloading " + userController.postUser(bonie));
            log.info(("Preloading " + userController.postUser(mark2)));
        };
    }

    @Bean
    CommandLineRunner retrieveUserObj(UserController userController) {
        return args -> {
            log.info("Get User " + userController.getUser(bonie));
            log.info("Get User " + userController.getUser(mark2));
        };
    }
}
