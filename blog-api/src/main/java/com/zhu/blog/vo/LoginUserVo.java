package com.zhu.blog.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LoginUserVo {

    private String id;

    private String account;

    private String nickname;

    private String avatar;
}
