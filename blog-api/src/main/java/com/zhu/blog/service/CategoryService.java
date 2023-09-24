package com.zhu.blog.service;

import com.zhu.blog.vo.CategoryVo;
import com.zhu.blog.vo.Result;

public interface CategoryService {

    CategoryVo findCategoryById(Long categoryId);

    Result findAll();

    Result findAllDetail();

    Result categoryDetailById(Long id);
}
