package com.example.springbootdynamicquartz.controller;

import com.example.springbootdynamicquartz.entity.Test;
import com.example.springbootdynamicquartz.mapper.TestMapper;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wxl
 */
@RestController
@RequestMapping("/test")
@AllArgsConstructor
@Slf4j
public class TestController {
    private TestMapper testMapper;


    @PostMapping
    public void insert(Test test) {

        testMapper.insert(test);
        log.info("id {}", test.getId());
    }

    @PutMapping
    public void update(Test test) {
        testMapper.updateById(test);
    }


}
