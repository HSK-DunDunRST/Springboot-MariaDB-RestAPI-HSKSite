package kr.co.ipdisk.dundunhsk.apiboard.data.dtoSet;

import java.util.UUID;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;

@Getter
public class UserRegisterDTO {

    private UUID userUuid;
    @NotBlank(message = "아이디는 필수입니다.")
    private String userId;
    @NotBlank(message = "최소 8자 이상이어야합니다.")
    private String userPwd;
    @NotBlank(message = "사용자 이름은 필수입니다.")
    private String userName;
    @NotBlank(message = "이메일 형식으로 입력해주십오.")
    private String userEmail;
}
