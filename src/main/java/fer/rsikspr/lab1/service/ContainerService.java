package fer.rsikspr.lab1.service;

import fer.rsikspr.lab1.model.Container;
import fer.rsikspr.lab1.repository.ContainersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContainerService {

    private final ContainersRepository containersRepository;

    @Autowired
    public ContainerService(ContainersRepository containersRepository) {
        this.containersRepository = containersRepository;
    }

    public Iterable<Container> get() {
        return containersRepository.findAll();
    }

    public Container get(long id) {
        return containersRepository.findById(id).orElse(null);
    }

    public Container save(String name, String image) {
        Container container = new Container();
        container.setName(name);
        container.setImage(image);
        containersRepository.save(container);
        return container;
    }

    public void remove(long id) {
        containersRepository.deleteById(id);
    }


}
