package work.iruby.providerdemo.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import java.util.List;


@Data
@EqualsAndHashCode(callSuper = true)
@ToString
@ApiModel(value = "user", description = "用户实体")
public class User extends BaseEntity {

    @NotBlank(message = "firstName 不得为空")
    @ApiModelProperty(value = "名字", example = "ruby")
    private String firstName;

    @NotNull(message = "age 不得为空")
    @ApiModelProperty(value = "年龄", example = "10")
    private Integer age;

    @Email(message = "邮箱格式不正确")
    @ApiModelProperty(value = "邮箱", example = "ruby@qq.com")
    private String email;

    @ApiModelProperty(value = "挚友" , dataType = "object")
    private Friend realFriend;

    @ApiModelProperty(value = "好友" , dataType = "Lwork.iruby.providerdemo.entity.Friend;")
    private List<Friend> friends;

}