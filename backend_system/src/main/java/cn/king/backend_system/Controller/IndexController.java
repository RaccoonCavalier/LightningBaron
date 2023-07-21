package cn.king.backend_system.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/index")
public class IndexController {
    private int num = 10;

    @GetMapping("/test")
    public void test01(){
        if (num > 0) {
            --num;
            System.out.printf("目前火麒麟的cdk还有%d张%n",num);
        }
    }

    @GetMapping("/test02")
    public String test02( ){
        return String.valueOf(num);
    }
}
