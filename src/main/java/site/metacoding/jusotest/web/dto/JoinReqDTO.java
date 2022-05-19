package site.metacoding.jusotest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import site.metacoding.jusotest.domain.User;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class JoinReqDTO {
    private String username;
    private String password;
    private String email;
    private String zipNo;
    private String address;

    public User toEntity() {
        User user = new User();
        user.setUsername(username);
        user.setPassword(password);
        user.setEmail(email);
        user.setZipNo(zipNo);
        user.setAddress(address);
        return user;
    }
}
