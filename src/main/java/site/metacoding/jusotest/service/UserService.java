package site.metacoding.jusotest.service;

import java.util.Optional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.RequiredArgsConstructor;
import site.metacoding.jusotest.domain.User;
import site.metacoding.jusotest.domain.UserRepository;
import site.metacoding.jusotest.web.dto.UpdateReqDTO;

@RequiredArgsConstructor
@Service
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    @Transactional
    public User 마이페이지(Integer id) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            User userEntity = userOp.get();
            return userEntity;
        } else {
            return null;
        }
    }

    @Transactional
    public void 회원가입(User user) {
        String rawPassword = user.getPassword();
        String encodedPassword = bCryptPasswordEncoder.encode(rawPassword);
        user.setPassword(encodedPassword);
        userRepository.save(user);
    }

    @Transactional
    public User 회원정보수정(Integer id, UpdateReqDTO updateReqDTO) {
        Optional<User> userOp = userRepository.findById(id);
        if (userOp.isPresent()) {
            User userEntity = userOp.get();
            if (updateReqDTO.getEmail() != userEntity.getEmail()) {
                userEntity.setEmail(updateReqDTO.getEmail());
            }
            if (updateReqDTO.getAddress() != userEntity.getAddress()) {
                userEntity.setZipNo(updateReqDTO.getZipNo());
                userEntity.setAddress(updateReqDTO.getAddress());
            }
            return userEntity;
        } else
            return null;
    }
}
