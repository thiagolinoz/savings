package com.linoz.savings.api;

import com.linoz.savings.dto.UserPostDTO;
import com.linoz.savings.dto.UserPutDTO;
import com.linoz.savings.entity.User;
import com.linoz.savings.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by linoz on 2/8/21
 */
@RestController
@RequestMapping("users")
@RequiredArgsConstructor
public class UserResource {

    private UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody @Valid UserPostDTO userPostDTO) {
        return new ResponseEntity<>(service.addUser(userPostDTO), HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<Page<User>> getAll(Pageable pageable) {
        return ResponseEntity.ok(service.findAllUsers(pageable));
    }

    @GetMapping(path = "/user/{id}")
    public ResponseEntity<User> findById(@PathVariable long id) {
        return ResponseEntity.ok(service.findUserByIdOrThrowBadRequestException(id));
    }

    @PutMapping
    public ResponseEntity<User> update(@RequestBody UserPutDTO userPutDTO) {
        return new ResponseEntity<>(service.updateUser(userPutDTO), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(path = "/user/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
