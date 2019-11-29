package xyz.redhawk.kapok.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import xyz.redhawk.kapok.common.ServerResponse;
import xyz.redhawk.kapok.pojo.Test1;
import xyz.redhawk.kapok.service.TestServiceImpl;

/**
 * @Author: Wang bin
 * @date: Created in 12:02 2019/11/29
 */
@RestController
@RequestMapping("/test/")
public class TestController {


    @Autowired
    private TestServiceImpl testService;

    @RequestMapping(value = "error",method = RequestMethod.GET)
    public void errorTest(){
        int a = 200/0;
    }

    @RequestMapping("queryTest")
    public ServerResponse<Test1> queryTest(){
        Test1 test = new Test1();
        int pageNo = 2; //当前页
        int pageSize = 4 ; //每页条数
       return  testService.selectTest(test, pageNo, pageSize);

    }
}
