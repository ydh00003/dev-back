package com.springboot.backspringbootrestapi.model;

import java.util.List;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class TagsParamVo {

    private List<String> projectId;
    private List<String> resourceId;
    private List<String> tags;
    
}