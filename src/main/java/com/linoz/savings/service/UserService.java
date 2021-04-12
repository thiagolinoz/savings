package com.linoz.savings.service;

import com.linoz.savings.dto.UserPostDTO;
import com.linoz.savings.dto.UserPutDTO;
import com.linoz.savings.entity.User;
import com.linoz.savings.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityExistsException;
import javax.ws.rs.BadRequestException;
import java.util.List;

/**
 * Created by linoz on 2/15/21
 */
@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository repository;

    public User addUser(UserPostDTO userPostDTO) {
        if (findUserByEmail(userPostDTO.getEmail()) != null) {
            throw new EntityExistsException("e-mail existente na base");
        }
        User user = User.builder()
                .name(userPostDTO.getName())
                .email(userPostDTO.getEmail())
                .cellphone(userPostDTO.getCellphone())
                .build();
        return repository.save(user);
    }

    public List<User> findAllUsers() {
         return repository.findAll();
    }

    public User findUserByIdOrThrowBadRequestException(long id) {
        return repository.findById(id)
                .orElseThrow(BadRequestException::new);
    }

    public User updateUser(UserPutDTO userPutDTO) {
        User savedUser = findUserByIdOrThrowBadRequestException(userPutDTO.getId());
        User user = User.builder()
                .id(savedUser.getId())
                .name(userPutDTO.getName())
                .email(userPutDTO.getEmail())
                .cellphone(userPutDTO.getCellphone())
                .build();
        return repository.save(user);
    }

    public void delete(long id) {
        repository.delete(findUserByIdOrThrowBadRequestException(id));
    }

    private User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
}
