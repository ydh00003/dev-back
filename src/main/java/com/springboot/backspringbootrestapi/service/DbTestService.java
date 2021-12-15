package com.springboot.backspringbootrestapi.service;

import java.util.List;

import com.springboot.backspringbootrestapi.model.ResponseVO;
import com.springboot.backspringbootrestapi.model.TagsParamVo;
import com.springboot.backspringbootrestapi.model.TagsResultVo;

public interface DbTestService {
    
    ResponseVO<List<TagsResultVo>> getData(TagsParamVo tagsVo) throws Exception;
    
}
