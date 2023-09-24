package com.zhu.blog.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TagVo {

    private String id;

    private String tagName;

    private String avatar;
}
