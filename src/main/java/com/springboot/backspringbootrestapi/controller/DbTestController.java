package com.springboot.backspringbootrestapi.controller;

import java.util.List;

import com.springboot.backspringbootrestapi.model.ResponseVO;
import com.springboot.backspringbootrestapi.model.TagsParamVo;
import com.springboot.backspringbootrestapi.model.TagsResultVo;
import com.springboot.backspringbootrestapi.service.DbTestService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/tags")
public class DbTestController {

    @Autowired
    private DbTestService dbTestService;

    @GetMapping("/all")
    public ResponseVO<List<TagsResultVo>> allTags(
        @RequestParam(required=true, value="projectId") List<String> projectId,
        @RequestParam(required=false, value="resourceId") List<String> resourceId,
        @RequestParam(required=false, value="tags") List<String> tags
    ) throws Exception {
        log.info("===============");

        TagsParamVo tagsVo = TagsParamVo.builder()
                    .projectId(projectId)
                    .resourceId(resourceId)
                    .tags(tags)
                    .build();

        ResponseVO<List<TagsResultVo>> result = dbTestService.getData(tagsVo);

        return result;
    }
/* 
    @GetMapping("/test")
    public ResponseVO<List<TagsResultVo>> getData() throws Exception {
        // 파라메터 가공
        List<TagsParamVo> list = new ArrayList<TagsParamVo>();
        TagsParamVo vo = new TagsParamVo();
        vo.setProjectId("pro_111");
        vo.setProjectId("pro_111");
        vo.setResourceId("A001");
        vo.setTags("NAME:홍길동");
        list.add(vo);

        TagsParamVo vo2 = new TagsParamVo();
        vo2.setProjectId("pro_222");
        vo2.setResourceId("AAA001");
        vo2.setTags("NAME:소주");
        list.add(vo2);

        // 서비스 전달
        ResponseVO<List<TagsResultVo>> result = dbTestService.getData(list);

        // 서비스에서 받은 데이터 리턴
        return result;
    }
 */
}