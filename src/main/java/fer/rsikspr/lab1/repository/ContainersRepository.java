package fer.rsikspr.lab1.repository;

import fer.rsikspr.lab1.model.Container;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContainersRepository extends JpaRepository<Container, Long> {
}
