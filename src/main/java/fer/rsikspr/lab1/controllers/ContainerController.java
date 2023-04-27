package fer.rsikspr.lab1.controllers;

import fer.rsikspr.lab1.model.Container;
import fer.rsikspr.lab1.service.ContainerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.Map;

@RestController
@RequestMapping("/containers")
public class ContainerController {

    private final ContainerService containerService;

    @Autowired
    public ContainerController(ContainerService containerService) {
        this.containerService = containerService;
    }

    @GetMapping()
    public Iterable<Container> get() {
        return containerService.get();
    }

    @GetMapping("/{id}")
    public Container get(@PathVariable Integer id) {
        Container container = containerService.get(id);
        if (container == null) throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        return container;
    }

    @PostMapping()
    public Container create(@RequestBody Map<String, String> body) {
        return containerService.save(body.get("name"), body.get("image"));
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        containerService.remove(id);
    }


}
