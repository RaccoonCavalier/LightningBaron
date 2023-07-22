package cn.king.backend_system.Controller;

import cn.king.backend_system.Service.TestCdkService;
import cn.king.backend_system.pojo.TestCdk;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    @Autowired
    private TestCdkService testCdkService;

    @GetMapping("/test")
    public String test01(){
        //随机返回一条没有被删除的数据
        QueryWrapper<TestCdk> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("LIMIT 1");
        TestCdk one = testCdkService.getOne(wrapper);
        //修改次数
        testCdkService.updateById(new TestCdk(one.getId(), one.getName(),one.getCdkId(),one.getIsDelete(),one.getCount() + 1));
        //删除这个数据
        testCdkService.removeById(one.getId());
        //返回给用户
        String format = String.format("这是%s：%s%n", one.getName(), one.getCdkId());
        //hello,world
        return format;
    }

    //查询所以的
    @GetMapping("/test02")
    public String test02( ){
        return null;
    }
}
