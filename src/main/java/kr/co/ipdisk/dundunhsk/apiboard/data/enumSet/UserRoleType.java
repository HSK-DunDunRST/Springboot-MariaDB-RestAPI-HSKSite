package kr.co.ipdisk.dundunhsk.apiboard.data.enumSet;

import lombok.Getter;

@Getter
public enum UserRoleType {

    ADMIN("ROLE_ADMIN"),
    USER("ROLE_USER");

    private String value;

    UserRoleType(String value){
        this.value = value;
    }
}
