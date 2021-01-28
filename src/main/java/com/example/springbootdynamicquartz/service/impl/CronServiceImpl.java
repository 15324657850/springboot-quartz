package com.example.springbootdynamicquartz.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.springbootdynamicquartz.entity.Cron;
import com.example.springbootdynamicquartz.mapper.CronMapper;
import com.example.springbootdynamicquartz.service.CronService;
import org.springframework.stereotype.Service;
/**
 * @author wxl
 */ 
@Service
public class CronServiceImpl extends ServiceImpl<CronMapper, Cron> implements CronService{

}
