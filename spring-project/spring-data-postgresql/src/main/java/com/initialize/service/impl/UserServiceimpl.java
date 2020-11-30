package com.initialize.service.impl;

import com.initialize.dto.UserDto;
import com.initialize.entity.Address;
import com.initialize.entity.User;
import com.initialize.repo.AddressRepository;
import com.initialize.repo.UserRepository;
import com.initialize.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceimpl implements UserService {

    private final UserRepository userRepository;
    private final AddressRepository addressRepository;

    @Override
    @Transactional
    public UserDto save(UserDto userDto) {
        User user = new User();
        user.setName(userDto.getName());
        user.setSurname(userDto.getSurname());
        User savedUser = userRepository.save(user);
        List<Address> addressList = new ArrayList<>();
        userDto.getAddress().forEach( item -> {
            Address address = new Address();
            address.setAddress(item);
            address.setAddressType(Address.AddressType.DEFAULT);
            address.setActive(true);
            address.setUser(savedUser);
            addressList.add(address);
        });
        addressRepository.saveAll(addressList);
        userDto.setId(savedUser.getId());
        return userDto;
    }

    @Override
    public void delete(UserDto userDto) {

    }

    @Override
    public List<UserDto> getAll() {
        List<User> users = userRepository.findAll();
        List<UserDto> userDtoList = new ArrayList<>();

        users.forEach( item ->{
            UserDto userDto = new UserDto();
            userDto.setName(item.getName());
            userDto.setSurname(item.getSurname());
            userDto.setId(item.getId());
            userDto.setAddress(item.getAddress().stream().map(Address::getAddress).collect(Collectors.toList()));

            userDtoList.add(userDto);
        });
        return userDtoList;
    }

    @Override
    public Page<UserDto> getAll(Pageable page) {
        return null;
    }
}
