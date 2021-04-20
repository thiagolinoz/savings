package com.linoz.savings.service;

import com.linoz.savings.dto.UserPostDTO;
import com.linoz.savings.dto.UserPutDTO;
import com.linoz.savings.entity.User;
import com.linoz.savings.exceptions.UserException;
import com.linoz.savings.mapper.UserMapper;
import com.linoz.savings.repository.UserRepository;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by linoz on 2/15/21
 */
@Service
@Log4j2
public class UserService {

    @Autowired
    private UserRepository repository;

    @Transactional
    public User addUser(UserPostDTO userPostDTO) {
        if (findUserByEmail(userPostDTO.getEmail()) != null) {
            throw new UserException("e-mail existente na base");
        }
        return repository.save(UserMapper.INSTANCE.toUser(userPostDTO));
    }

    public List<User> findAllUsers() {
         return repository.findAll();
    }

    public User findUserByIdOrThrowBadRequestException(long id) {
        return repository.findById(id)
                .orElseThrow(()-> new UserException("User not found"));
    }

    public User updateUser(UserPutDTO userPutDTO) {
        User savedUser = findUserByIdOrThrowBadRequestException(userPutDTO.getId());
        User user = UserMapper.INSTANCE.toUser(userPutDTO);
        user.setId(savedUser.getId());
        return repository.save(user);
    }

    public void delete(long id) {
        repository.delete(findUserByIdOrThrowBadRequestException(id));
    }

    private User findUserByEmail(String email) {
        return repository.findUserByEmail(email);
    }
}
