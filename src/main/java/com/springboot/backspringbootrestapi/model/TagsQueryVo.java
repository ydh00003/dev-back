package com.springboot.backspringbootrestapi.model;

import java.util.List;

import lombok.Data;

@Data
public class TagsQueryVo {

    private List<String> projectId;
    private List<String> resourceId;
    private List<TagsItemVo> tags;
    
}