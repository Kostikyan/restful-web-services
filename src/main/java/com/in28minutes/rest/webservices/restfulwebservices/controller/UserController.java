package com.in28minutes.rest.webservices.restfulwebservices.controller;

import com.in28minutes.rest.webservices.restfulwebservices.entity.User;
import com.in28minutes.rest.webservices.restfulwebservices.exception.UserNotFoundException;
import com.in28minutes.rest.webservices.restfulwebservices.service.UserService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.hateoas.EntityModel;
import org.springframework.hateoas.server.mvc.WebMvcLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {
        return ResponseEntity.ok().body(userService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable int id) {
        User byId = userService.findById(id);
        if (byId == null) throw new UserNotFoundException("id: " + id);
        return ResponseEntity.ok().body(byId);
    }

    @PostMapping
    public ResponseEntity<String> create(@Valid @RequestBody User user) {
        User save = userService.save(user);

        URI location = ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(save.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<User> deleteById(@PathVariable int id) {
        userService.deleteById(id);
        return ResponseEntity.ok().build();
    }


    @GetMapping("with-links/{id}")
    public EntityModel<User> userEntityModel(@PathVariable int id) {
        User byId = userService.findById(id);

        if (byId == null) throw new UserNotFoundException("id: " + id);

        EntityModel<User> entityModel = EntityModel.of(byId);
        WebMvcLinkBuilder link = WebMvcLinkBuilder.linkTo(WebMvcLinkBuilder.methodOn(this.getClass()).findAll());
        entityModel.add(link.withRel("all-users"));

        return entityModel;
    }
}
