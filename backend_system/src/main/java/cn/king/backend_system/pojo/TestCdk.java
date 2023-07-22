package cn.king.backend_system.pojo;

import com.baomidou.mybatisplus.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@TableName("test_cdk")
public class TestCdk {
    @TableId(type = IdType.AUTO)
    private Long id;
    private String name;
    @TableField("cdk_id")
    private String cdkId;
    @TableLogic
    private int isDelete;
    private int count;

    public TestCdk(String name, String cdkId) {
        this.name = name;
        this.cdkId = cdkId;
    }
}
