package work.iruby.providerdemo.entity;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

/**
 * @author 宋扬
 * @since 2021/7/15
 */
@Data
public class BaseEntity {

    @ApiModelProperty(value = "主键")
    private Long id;
}
