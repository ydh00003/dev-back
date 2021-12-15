package com.springboot.backspringbootrestapi.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.springboot.backspringbootrestapi.model.ResponseVO;
import com.springboot.backspringbootrestapi.model.UserVO;

import org.apache.commons.lang3.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/api/users")
public class UserController {
    // private final Logger logger = LoggerFactory.getLogger(this.getClass());
    // private static final org.slf4j.Logger log = org.slf4j.LoggerFactory.getLogger(UserController.class);

    @GetMapping
    public ResponseVO<?> getUsers() {
        ResponseVO<List<UserVO>> resp = new ResponseVO<>();
        List<UserVO> list = new ArrayList<>();
        list.add(new UserVO("테스터", "010-1111-2222"));
        list.add(new UserVO("tester", "010-1111-3333"));

        if (list.isEmpty()) {
            log.info("null");
        } else {
            log.info("not null");
        }

        String testAAA = "";
        String testBBB = new String();
        String testCCC = "123";

        if(StringUtils.isEmpty(testAAA))log.debug("empty");
        if(StringUtils.isEmpty(testBBB))log.warn("empty");
        if(StringUtils.isEmpty(testCCC))log.error("empty");

        if(StringUtils.isBlank(testAAA))log.error("empty");
        if(StringUtils.isBlank(testBBB))log.debug("empty");
        if(StringUtils.isBlank(testCCC))log.warn("empty");

        // UserVO uvo = new UserVO();
        // uvo.setName("name111");
        // uvo.setPhone("phone111");

        // System.out.println(resp);
        // System.out.println(uvo);
        
        resp.setResponse(list);
        resp.setMessage("ok");
        return resp;
    }

    @GetMapping("/testMapList")
    public Map<String,Object> testMapList(@RequestParam Map<String,Object>param, HttpServletRequest request, HttpServletResponse response) throws Exception {
        Map<String,Object> returnMap = new HashMap<String,Object>();

        if (param.get("checkValue") == null) {
            // throw new Exception("param이 null입니다.");
            returnMap.put("result", "checkValue가 null입니다.");
            return returnMap;
        }

        List<Map<String,Object>> list = new ArrayList<Map<String,Object>>();

        Map<String,Object> mapHash = new HashMap<String,Object>();
        Map<String,Object> mapTree = new TreeMap<String,Object>();

        String checkValue = param.get("checkValue").toString();
        if (StringUtils.equals("ok", checkValue)) {
            mapHash.put("name", "둘리");
            mapHash.put("age", "22");
            mapTree.put("name", "또치");
            mapTree.put("age", "11");
        } else {
            returnMap.put("result", "param이 null입니다.");
            return returnMap;
        }

        list.add(mapHash);
        list.add(mapTree);

        returnMap.put("result", list);

        log.debug("mapTree ==> " + mapTree);
        log.info("mapHash ==> " + mapHash);
        log.warn("list ==> " + list);
        log.error("returnMap ==> " + returnMap);

        return returnMap;
    }

    @GetMapping("/{id}")
    public ResponseVO<?> getUser(@PathVariable int id) {
        ResponseVO<UserVO> resp = new ResponseVO<>();
        
        List<UserVO> list = new ArrayList<>();
        list.add(new UserVO("테스터", "010-1111-2222"));
        list.add(new UserVO("tester", "010-1111-3333"));
        list.add(new UserVO("홍길동", "조선사람"));
        
        resp.setResponse(list.get(id));
        return resp;
    }

    @GetMapping("/main")
    public String MainController() {
        return "하하하";
    }

    @GetMapping("/one")
    public Map<String,Object> getUserOne(@RequestParam Map<String,Object>param, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> data = new HashMap<String,Object>();
        data.put("id", "1234");
        data.put("name", "hong");
        data.put("addr", "korea");
        return data;
    }
    
    @PostMapping("/two")
    public Map<String,Object> selectTwoUsers(@RequestBody Map<String,Object>param, HttpServletRequest request, HttpServletResponse response) {
        Map<String,Object> data = new HashMap<String,Object>();
        String oneName = param.get("userOneName").toString();
        int oneAge = (int) param.get("userOneAge");
        oneName = oneName + " ok";
        oneAge = oneAge + 1;
        data.put("oneUserName", oneName);
        data.put("oneUserAge", oneAge);
        return data;
    }
}