package fer.rsikspr.lab1.configuration;

import fer.rsikspr.lab1.model.Container;
import fer.rsikspr.lab1.repository.ContainersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDatabase {

    private final ContainersRepository containersRepository;

    @Autowired
    public LoadDatabase(ContainersRepository containersRepository) {
        this.containersRepository = containersRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            containersRepository.save(new Container(1L, "Postgres1", "Postgres"));
            containersRepository.save(new Container(2L, "Nginx3", "Nginx"));
            containersRepository.save(new Container(3L, "Mongo2", "Mongo"));
            containersRepository.save(new Container(4L, "Alpine8", "Alpine"));
        };
    }

}
