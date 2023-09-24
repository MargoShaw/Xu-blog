package com.zhu.blog.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class UserVo {

    private String nickname;

    private String avatar;

    private String id;
}
