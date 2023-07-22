package cn.king.backend_system.Service.Impl;

import cn.king.backend_system.Service.TestCdkService;
import cn.king.backend_system.mapper.TestCdkMapper;
import cn.king.backend_system.pojo.TestCdk;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

@Service
public class TestCdkServiceImpl extends ServiceImpl<TestCdkMapper, TestCdk> implements TestCdkService {
}
