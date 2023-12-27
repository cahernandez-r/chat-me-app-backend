package com.chatmee.chatmee.domains.user;

import com.chatmee.chatmee.general.entities.User;
import com.chatmee.chatmee.general.repositories.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Override
    public Boolean validateUserNameExists(final String userName) {
        return userRepository.existsUserByUserNameAndActiveTrue(userName);
    }

    @Override
    public User createUser(final User user) {
        return userRepository.save(user);
    }

    @Override
    public User getUserByUserName(final String userName) {
        return userRepository.findByUserNameAndActiveTrue(userName);
    }
}
