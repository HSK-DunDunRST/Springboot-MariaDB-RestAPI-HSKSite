package kr.co.ipdisk.dundunhsk.apiboard.data.entitySet;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import kr.co.ipdisk.dundunhsk.apiboard.data.enumSet.UserRoleType;
import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Table(name = "user_data")
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "user_uuid")
    private UUID userUuid;

    @Column(name = "user_id")
    private String userId;

    @Column(name = "user_pwd")
    private String userPwd;

    @Column(name = "user_name")
    private String userName;

    @Column(name = "user_email")
    private String userEmail;

    @Column(name = "user_signup_date")
    private LocalDateTime userSignupDate;

    @Column(name = "user_recent_login_date")
    private LocalDateTime userRecentLoginDate;

    @Enumerated(EnumType.STRING)
    @Column(name = "USER_ROLE")
    private UserRoleType userRoleType;

}
