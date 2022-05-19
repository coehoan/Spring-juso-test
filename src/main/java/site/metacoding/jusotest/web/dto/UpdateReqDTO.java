package site.metacoding.jusotest.web.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class UpdateReqDTO {
    private String email;
    private String zipNo;
    private String address;
}
