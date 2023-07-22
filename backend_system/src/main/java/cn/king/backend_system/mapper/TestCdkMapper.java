package cn.king.backend_system.mapper;

import cn.king.backend_system.pojo.TestCdk;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Repository
@Mapper
public interface TestCdkMapper extends BaseMapper<TestCdk> {
}
