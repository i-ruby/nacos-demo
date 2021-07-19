package work.iruby.providerdemo.controller;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import io.swagger.v3.oas.annotations.parameters.RequestBody;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import work.iruby.providerdemo.config.NacosConfig;
import work.iruby.providerdemo.entity.User;

import javax.validation.Valid;

/**
 * @author 宋扬
 * @since 2021/7/15
 */
@Api(value = "user", tags = "用户管理模块")
@RestController
public class SwaggerDemoController {

    private final NacosConfig nacosConfig;

    public SwaggerDemoController(NacosConfig nacosConfig) {
        this.nacosConfig = nacosConfig;
    }

    @RequestMapping(value = "/custom", method = RequestMethod.GET)
    public String custom() {
        return nacosConfig.getUserName() + "-" + nacosConfig.getAge();
    }


    @ApiOperation(value = "增加用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true, dataType = "java.lang.Long"),
            @ApiImplicitParam(name = "firstName", value = "名字", required = true, dataType = "java.lang.String"),
            @ApiImplicitParam(name = "age", value = "年龄", required = true, dataType = "java.lang.Integer"),
            @ApiImplicitParam(name = "email", value = "邮箱", required = true, dataType = "java.lang.String")
//            @ApiImplicitParam(name = "realFriend", value = "挚友", required = false, dataType = "Friend"),
//            @ApiImplicitParam(name = "friends", value = "好友", required = false, dataType = "List")
    })
    @RequestMapping(value = "/user", method = RequestMethod.PUT)
    public User addUser(@Valid @RequestBody User user) {
        System.out.println("增加用户");

        return user;
    }

    @ApiOperation(value = "删除用户")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.DELETE)
    public User deleteUser(@PathVariable("id") Long id) {
        System.out.println("删除用户");
        User user = new User();
        user.setId(id);
        user.setFirstName("ika");
        user.setAge(10);
        user.setEmail("example@email");
        return user;
    }

    @ApiOperation(value = "修改用户")
    @RequestMapping(value = "/user", method = RequestMethod.PATCH)
    public User updateUser(@Valid @RequestBody User user) {
        System.out.println("修改用户");
        return user;
    }

    @ApiOperation(value = "根据id查询用户信息")
    @RequestMapping(value = "/user/{id}", method = RequestMethod.GET)
    public User getUserById(@PathVariable(name = "id") Long id) {
        System.out.println(id);
        User user = new User();
        user.setId(1L);
        user.setFirstName("ika");
        user.setAge(10);
        user.setEmail("example@email");
        return user;
    }
}
