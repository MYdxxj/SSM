import com.web.dao.*;
import com.web.model.Menu;
import com.web.model.Role;
import com.web.model.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


/**
 * @program:product
 * @description:testController
 * @author:YangXiaoJiao
 * @create:2019-01-16 14:47
 **/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:spring-mybatis.xml"})
public class TestController {

    @Autowired
    private UserDao userDao;
    @Autowired
    private UserRoleDao userRoleDao;
    private MenuDao menuDao;
    @Autowired
    private RoleMenuDao roleMenuDao;
    @Autowired
    private RoleDao roleDao;

    @Test
    public void testSelectUser() {
       /* List<Role> userRoles = roleDao.getUserRoleByUserId(1l);
        for (Role userRole : userRoles) {
            System.out.println(userRole);
        }*/
      /*  List<Menu> roleMenuByRoleId = menuDao.getRoleMenuByRoleId(1l);
        for (Menu menu : roleMenuByRoleId) {
            System.out.println(menu.getMenuName());
        }*/


    }

}
