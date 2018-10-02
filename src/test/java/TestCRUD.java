import com.baidu.www.mplus.bean.Employee;
import com.baidu.www.mplus.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.core.metadata.TableFieldInfo;
import com.baomidou.mybatisplus.extension.injector.methods.LogicDeleteByIdWithFill;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.apache.log4j.spi.LoggerFactory;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.*;


/**
 * test
 */
public class TestCRUD {


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    private final static Logger logger = Logger.getLogger(TestCRUD.class);

    Gson gson = new Gson();
    private Integer count;

    /**
     * 所有员工列表
     *
     * @throws SQLException
     */
    @Test
    public void list() throws SQLException {

        List<Employee> employeeList = employeeMapper.selectList(null);

        if (!employeeList.isEmpty()) {
            logger.info("所有员工：" + gson.toJson(employeeList));
        }
    }

    @Test
    public void selectMethod() throws SQLException {

        ///// 查询单条数据

//        // 1、根据ID获取一个对象的数据
//        Employee employee = employeeMapper.selectById(1);

        // 2、根据对象查找数据
//        Employee employee =employeeMapper.selectOne(new QueryWrapper<Employee>().eq("id","1"));
//
//        if (employee!=null) {
//            logger.info("++一个员工信息+++++"+gson.toJson(employee));
//        }

        // 查询多条数据
        // 1、select 要查询的字段
        // SELECT email FROM tbl_employee
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().select("email"));

        //2、 where 条件查询和and添加和orderby使用
        // SELECT age FROM tbl_employee WHERE email = ? AND age = ? ORDER BY id ASC
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().select("age").eq("email",employee.getEmail()).eq("age",employee.getAge()).orderBy(true,true,"id"));

        //3、多个ID值查询
//        List<Integer> idList = new  ArrayList<>();
//        idList.add(1);
//        idList.add(2);
//
//        List<Employee> employeeList =employeeMapper.selectBatchIds(idList);

        //4、Map封装字段查询
//        Employee employee = employeeMapper.selectById(1);
//
//        Map<String,Object> map = new HashMap<>(16);
//        map.put("email",employee.getEmail());
//        map.put("age",employee.getAge());
//        List<Employee> employeeList =employeeMapper.selectByMap(map);


        // 6、返回List<Map>查询
//        Employee employee = employeeMapper.selectById(1);
//
//
//        List<Map<String, Object>> employeeList =employeeMapper.selectMaps(new QueryWrapper<Employee>());

        // 7、selectObjs
//        Employee employee = employeeMapper.selectById(1);

//        List<Object> employeeList = employeeMapper.selectObjs(new QueryWrapper<Employee>().eq("email", employee.getEmail()));
//


        // 8、selectCount
//        Integer count = employeeMapper.selectCount(new QueryWrapper<Employee>().eq("email", employee.getEmail()));
//
//        if (count > 0) {
//            logger.info("++统计结果：+++++" + count);
//        }


//        9、分页查询

//        Integer count = employeeMapper.selectCount(new QueryWrapper<Employee>().between("age", 0, 100)
//                .eq("gender", 0));
//
//        IPage<Employee> employeeIPage = new Page<Employee>(1, 3,count);
//
//        IPage<Employee>  employeeList = employeeMapper.selectPage(employeeIPage,new QueryWrapper<Employee>()
//                .between("age", 0, 100)
//                .eq("gender", 0));
//
//        if (!employeeList.getRecords().isEmpty()) {
//            logger.info("++一个员工信息+++++" + gson.toJson(employeeList));
//        }


        // 10、分页查询Map结果返回
        Integer count = employeeMapper.selectCount(new QueryWrapper<Employee>().between("age", 0, 100)
                .eq("gender", 0));

        IPage<Employee> employeeIPage = new Page<Employee>(1, 3, count);

        IPage<Map<String, Object>> employeeList = employeeMapper.selectMapsPage(employeeIPage, new QueryWrapper<Employee>()
                .between("age", 0, 100)
                .eq("gender", 0));

        if (!employeeList.getRecords().isEmpty()) {
            logger.info("++一个员工信息+++++" + gson.toJson(employeeList));
        }

    }

    /**
     * 添加用户
     *
     * @throws SQLException
     */
    @Test
    public void add() throws SQLException {

        for (int i = 0; i < 20; i++) {
            Employee employee = new Employee();

            employee.setLastName("Betty"+i);
            employee.setAge(12+i);
            employee.setEmail("betty@163.com"+i);
            employee.setGender(1);

            Integer result = employeeMapper.insert(employee);


            if (result != null || result > 0) {
                logger.info("+++++++++++++++++添加成功+++++");
            }

            logger.info("获取主键值：" + employee.getId());
        }


    }


    /**
     * 修改用户
     *
     * @throws SQLException
     */
    @Test
    public void update() throws SQLException {

        Employee employee = new Employee();

        employee.setId(1);
        employee.setLastName("Marry");
        employee.setAge(55);
        employee.setEmail("marry@163.com");
        employee.setGender(0);

        //根据ID修改
//        Integer result = employeeMapper.updateById(employee);


        //全表修改一个字段的值
//        Integer result = employeeMapper.update(employee,new UpdateWrapper().set("email","marry@163.com"));

        // 判断重复的就修改
        // UPDATE tbl_employee SET last_name=?, gender=?, age=? WHERE id=? AND last_name=? AND gender=? AND age=？
//        Integer result = employeeMapper.update(employee,new UpdateWrapper().setEntity(employee));

        //拼接一个sql的值
        //UPDATE tbl_employee SET last_name=?, gender=?, age=?, email=1 where email=1 and age=12(注意where前的空格))
        Integer result = employeeMapper.update(employee, new UpdateWrapper().setSql("email=" + employee.getId() + " where email=1 and age=12"));


        if (result != null || result > 0) {
            logger.info("++++++++++++++++修改成功+++++");
        }
    }


    /**
     * 删除客户
     *
     * @throws SQLException
     */
    @Test
    public void deletedMethod() throws SQLException {

        // 1.根据ID删除一个员工
//        Integer result = employeeMapper.deleteById(1);

//        // 2.多个ID删除
//        List<Integer> idList = new  ArrayList<>();
//        idList.add(21);
//        idList.add(20);
//
//        Integer result = employeeMapper.deleteBatchIds(idList);
//
//        // 3.根据map条件删除
//        Employee employee = employeeMapper.selectById(19);
//
//        Map<String, Object> map = new HashMap<>(16);
//        map.put("email", employee.getEmail());
//        map.put("age", employee.getAge());
//
//        Integer result = employeeMapper.deleteByMap(map);
//
        // 4.根据条件构造器删除
        Integer result = employeeMapper.delete(new QueryWrapper<Employee>()
                .eq("gender", 1));



        if (result != null || result > 0) {
            logger.info("++++++++++++++++删除成功+++++");
        }

    }


}
