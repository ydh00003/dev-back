package com.springboot.backspringbootrestapi.model;

import java.util.List;

import lombok.Data;

@Data
public class TagsResultVo {

    private String projectId;
    private String resourceId;
    private List<TagsItemVo> Tags;
    
}