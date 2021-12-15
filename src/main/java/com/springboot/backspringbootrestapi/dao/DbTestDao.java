package com.springboot.backspringbootrestapi.dao;

import java.util.List;

import com.springboot.backspringbootrestapi.model.TagsQueryReturnVo;
import com.springboot.backspringbootrestapi.model.TagsQueryVo;

import org.springframework.stereotype.Repository;

@Repository("dbTestDao")
public interface DbTestDao {

    public List<TagsQueryReturnVo> getData(TagsQueryVo queryVo);

}
