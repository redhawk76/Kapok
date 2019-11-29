package xyz.redhawk.kapok.service;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.springframework.stereotype.Service;
import xyz.redhawk.kapok.common.ServerResponse;
import xyz.redhawk.kapok.mapper.TestMapper;
import xyz.redhawk.kapok.pojo.Test1;

import javax.annotation.Resource;

/**
 * @Author: Wang bin
 * @date: Created in 13:20 2019/11/29
 */
@Service
public class TestServiceImpl {

    @Resource
    private TestMapper testDao;

    public ServerResponse selectTest(Test1 test, int pageNo, int pageSize){
        Page<Test1> p = new Page<>(pageNo, pageSize);
        p.setSearchCount(false);
        Page<Test1> test1Page = p.setRecords(testDao.selectTest(p, test));
        p.hasNext(); //是否有下一页
        p.getRecords(); //是否有上一页
        p.isSearchCount();//是否开启count查询 ...
        return ServerResponse.createBySuccess(test1Page);
    }
}
