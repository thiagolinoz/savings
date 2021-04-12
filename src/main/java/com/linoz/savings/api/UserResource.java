package com.linoz.savings.api;

import com.linoz.savings.dto.UserPostDTO;
import com.linoz.savings.dto.UserPutDTO;
import com.linoz.savings.entity.User;
import com.linoz.savings.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;

import javax.annotation.Resource;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

/**
 * Created by linoz on 2/8/21
 */
@Resource
@Path("/users")
public class UserResource {

    private UserService service;

    @Autowired
    public UserResource(UserService service) {
        this.service = service;
    }

    @POST
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<User> addUser(@RequestBody UserPostDTO userPostDTO) {
        return new ResponseEntity<>(service.addUser(userPostDTO), HttpStatus.CREATED);
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<List<User>> getAll() {
        return ResponseEntity.ok(service.findAllUsers());
    }

    @GET
    @Produces({MediaType.APPLICATION_JSON})
    @Path("/user/{id}")
    public ResponseEntity<User> findById(@PathParam("id") long id) {
        return ResponseEntity.ok(service.findUserByIdOrThrowBadRequestException(id));
    }

    @PUT
    @Consumes({MediaType.APPLICATION_JSON})
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<User> update(@RequestBody UserPutDTO userPutDTO) {
        return new ResponseEntity<>(service.updateUser(userPutDTO), HttpStatus.ACCEPTED);
    }

    @DELETE
    @Path("/user/{id}")
    @Produces({MediaType.APPLICATION_JSON})
    public ResponseEntity<Void> delete(@PathParam("id") long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
