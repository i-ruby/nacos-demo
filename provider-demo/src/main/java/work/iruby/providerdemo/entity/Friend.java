package work.iruby.providerdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 宋扬
 * @since 2021/7/15
 */
@Data
@ApiModel(value = "友人", reference = "Friend")
public class Friend {

    @ApiModelProperty(value = "名字")
    private String name;

    @ApiModelProperty(value = "年龄")
    private Integer age;

}
