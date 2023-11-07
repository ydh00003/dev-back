package com.springboot.backspringbootrestapi.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.springboot.backspringbootrestapi.dao.DbTestDao;
import com.springboot.backspringbootrestapi.model.ResponseVO;
import com.springboot.backspringbootrestapi.model.TagsItemVo;
import com.springboot.backspringbootrestapi.model.TagsParamVo;
import com.springboot.backspringbootrestapi.model.TagsQueryReturnVo;
import com.springboot.backspringbootrestapi.model.TagsQueryVo;
import com.springboot.backspringbootrestapi.model.TagsResultVo;

@Service("dbTestServiceImpl")
public class DbTestServiceImpl implements DbTestService{

    @Autowired
    private DbTestDao dbTestDao;
    
    @Override
    public ResponseVO<List<TagsResultVo>> getData(TagsParamVo paramVo) throws Exception{
        TagsQueryVo queryVo = new TagsQueryVo();
        queryVo.setProjectId(paramVo.getProjectId());
        queryVo.setResourceId(paramVo.getResourceId());

        // List<String> keyList = new ArrayList<String>();
        // List<String> valueList = new ArrayList<String>();
        List<TagsItemVo> tagsList = new ArrayList<TagsItemVo>();
        for (int i=0; i<paramVo.getTags().size(); i++) {
            String str[] = paramVo.getTags().get(i).split(":");
            // keyList.add(str[0]);
            // valueList.add(str[1]);
            TagsItemVo tVo = new TagsItemVo();
            tVo.setKey(str[0]);
            tVo.setValue(str[1]);
            tagsList.add(tVo);
        }
        // queryVo.setKey(keyList);
        // queryVo.setValue(valueList);
        queryVo.setTags(tagsList);

        // db 갔다오고
        List<TagsQueryReturnVo> returnList = dbTestDao.getData(queryVo);
        // tags를 json형식으로 바꾼 후
        List<TagsResultVo> changeList = new ArrayList<TagsResultVo>();
        for (TagsQueryReturnVo item : returnList) {
            TagsResultVo vo = new TagsResultVo();
            vo.setProjectId(item.getProjectId());
            vo.setResourceId(item.getResourceId());

            ObjectMapper mapper = new ObjectMapper();
            List<TagsItemVo> tags;
            // type safety 경고 수정
            // tags = mapper.readValue(item.getTags(), ArrayList.class);
            tags = mapper.readValue(item.getTags(), new TypeReference<List<TagsItemVo>>(){});
            vo.setTags(tags);

            changeList.add(vo);
        }

        // db 갔다온 다음에는 ResponseVO에 다시 담아서 리턴해야 한다
        ResponseVO<List<TagsResultVo>> res = new ResponseVO<List<TagsResultVo>>();
        res.setMessage("return tags");
        res.setCheck(true);
        res.setResponse(changeList);
        return res;
    }

    /* 
    @Override
    public ResponseVO<List<TagsResultVo>> getData(TagsParamVo tagsVo) throws Exception{
        // 여기에서 DB에서 가져온 값을 담을 리스트<vo>를 만들어서 받아야 됨
        List<TagsQueryVo> queryList = new ArrayList<TagsQueryVo>();
        for (TagsParamVo item : list) {
            TagsQueryVo vo = new TagsQueryVo();
            vo.setProjectId(item.getProjectId());
            vo.setResourceId(item.getResourceId());

            String str[] = item.getTags().split(":");
            vo.setKey(str[0]);
            vo.setValue(str[1]);
            
            queryList.add(vo);
        }

        // db 갔다오고
        List<TagsParamVo> returnList = dbTestDao.getData(queryList);
        // tags를 json형식으로 바꾼 후
        List<TagsResultVo> changeList = new ArrayList<TagsResultVo>();
        for (TagsParamVo item : returnList) {
            TagsResultVo vo = new TagsResultVo();
            vo.setProjectId(item.getProjectId());
            vo.setResourceId(item.getResourceId());

            ObjectMapper mapper = new ObjectMapper();
            List<TagsItemVo> tags;
            tags = mapper.readValue(item.getTags(), ArrayList.class);
            vo.setTags(tags);

            changeList.add(vo);
        }

        // db 갔다온 다음에는 ResponseVO에 다시 담아서 리턴해야 한다
        ResponseVO<List<TagsResultVo>> res = new ResponseVO<List<TagsResultVo>>();
        res.setMessage("return tags");
        res.setCheck(true);
        res.setResponse(changeList);
        return res;
    }
     */
}
