package site.metacoding.jusotest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class PasswordUpdateReqDto {
    private String prePassword;
    private String uptPassword;
}
