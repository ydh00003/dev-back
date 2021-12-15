
package com.springboot.backspringbootrestapi.model;

import lombok.Data;

@Data
public class TagsQueryReturnVo {

    private String projectId;
    private String resourceId;
    private String tags;
    
}