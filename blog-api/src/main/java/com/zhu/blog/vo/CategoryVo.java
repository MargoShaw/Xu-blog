package com.zhu.blog.vo;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)

public class CategoryVo {

    private String id;

    private String avatar;

    private String categoryName;

    private String description;
}
