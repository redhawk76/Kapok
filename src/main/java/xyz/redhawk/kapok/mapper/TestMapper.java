package xyz.redhawk.kapok.mapper;

import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import xyz.redhawk.kapok.pojo.Test1;

import java.util.List;

/**
 * @Author: Wang bin
 * @date: Created in 13:13 2019/11/29
 */
@Mapper
public interface TestMapper {

    List<Test1> selectTest(Page<Test1> page, @Param("test")Test1 test);
}
