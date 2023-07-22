package cn.king.backend_system;

import cn.king.backend_system.Service.TestCdkService;
import cn.king.backend_system.pojo.TestCdk;
import cn.king.backend_system.util.RandomStringGenerator;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@SpringBootTest
@Slf4j
class BackendSystemApplicationTests {

    @Autowired
    private TestCdkService testCdkService;

    @Test
    void test01() {
        System.out.println(testCdkService.getById(3));
    }

    //批量生成1000个随机的cdk
    @Test
    void test02(){
        List<TestCdk> list = new ArrayList<>();
        Set<String> strings = new RandomStringGenerator().NotRepeatingRandomString(50000, 16);
        for (String str : strings){
            list.add(new TestCdk("玫瑰精灵的cdk",str));
        }
        testCdkService.saveBatch(list);
    }

    //查询所以的cdk
    @Test
    void test03(){
        QueryWrapper<TestCdk> wrapper = new QueryWrapper<>();
        wrapper.select("id");
        List<TestCdk> list = testCdkService.list(wrapper);
        for (TestCdk testCdk : list){
            System.out.println(testCdk.toString());
        }
    }

    //随机给出一条数据
    @Test
    void test04(){
        QueryWrapper<TestCdk> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("LIMIT 1");
        TestCdk one = testCdkService.getOne(wrapper);
        System.out.println(one.toString());
    }

    //删除一条数据
    @Test
    void test05(){
        boolean b = testCdkService.removeById(2);

    }

    //调用一次，就会随机返回一条数据
    @Test
    void test06(){
        //随机返回一条没有被删除的数据
        QueryWrapper<TestCdk> wrapper = new QueryWrapper<>();
        wrapper.orderByAsc("RAND()").last("LIMIT 1");
        TestCdk one = testCdkService.getOne(wrapper);
        //返回给用户
        System.out.printf("这是%s：%s%n",one.getName(),one.getCdkId());
        //修改次数
        testCdkService.updateById(new TestCdk(one.getId(), one.getName(),one.getCdkId(),one.getIsDelete(),one.getCount() + 1));
        //删除这个数据
        testCdkService.removeById(one.getId());

    }
}
