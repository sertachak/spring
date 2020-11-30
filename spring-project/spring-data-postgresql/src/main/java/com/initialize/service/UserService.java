package com.initialize.service;

import com.initialize.dto.UserDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface UserService {
    UserDto save(UserDto userDto);

    void delete(UserDto userDto);

    List<UserDto> getAll();

    Page<UserDto> getAll(Pageable page);
}
