import com.baidu.www.mplus.bean.Employee;
import com.baidu.www.mplus.mapper.EmployeeMapper;
import com.baomidou.mybatisplus.core.conditions.Condition;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.google.gson.Gson;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * test
 */
public class TestWrapper {


    private ApplicationContext iocContext = new ClassPathXmlApplicationContext("applicationContext.xml");

    private EmployeeMapper employeeMapper = iocContext.getBean("employeeMapper", EmployeeMapper.class);

    private final static Logger logger = Logger.getLogger(TestWrapper.class);

    Gson gson = new Gson();

    /**
     * Wrapper用法
     *
     * @throws SQLException
     */
    @Test
    public void selectWrapper() throws SQLException {

        // 条件构造器使用

        // 1、全部查询,拼接一个where过滤条件，如果是多个可以map中put多个，多个字段如果有某个字段是空的，就会默认添加空查询条件
        // SELECT id,last_name,email,gender,age FROM tbl_employee WHERE gender = ? AND age IS NULL
        Employee employee = new Employee();
        employee.setGender(1);

        Map<String, Object> map = new HashMap<>(16);
        map.put("gender", employee.getGender());
//        map.put("age",employee.getAge());

//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().allEq(map));

        // 2、map添加的字段是否加到where的条件中，通过lambda表达式判断，如果是true就加入，反之，不加入，因为Map的key的String有gender，所以会过滤
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().allEq((String,Object)->String.equals("gender"),map));


        // 3、and使用

//               List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().and(true,i -> i.eq("last_name", "Betty0")));

//        4、apply使用
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().apply("last_name={0}","Betty0"));

//        5、between
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().between("age",20,50));


//          6、eq 等于
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().eq("last_name","Betty0"));

//        7、ge大于等于

//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().ge("age","40"));

//        8 、gt 大于
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().gt("age","40"));

//        9、分组操作
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().eq("id","25").groupBy("age","gender"));

//        10、having使用
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().eq("gender","1").having("age = {0}",30));

//        11、in 操作
//        List<Integer> idList = new ArrayList<>();
//        idList.add(31);
//        idList.add(32);

//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().in(true,"id",idList));

//         12、inSql使用
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().inSql("id", "12,22,23,24,25,26"));

//        13、字段值非空
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().isNotNull("age"));

//        14、字段值为空的
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().isNull("age"));

//        15、结尾拼接sql语句
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().last("and age >30"));

//        16、小于等于 <=
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().le("age", "20"));

//          17、小于
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().lt("age", "20"));

//         18、模糊查询Like
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().like("age", "20"));


//         19、 LikeLeft以什么结尾的查询
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().likeLeft("age", "20"));

//        20、likeRight以什么开头
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().likeRight("age", "20"));
//          21、ne不等于 <>用法
//         List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().ne("age", "20"));
//            22、嵌套的查询
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().nested(true,i -> i.eq("last_name", "Betty0")));

//             23、不在什么区间
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().notBetween("age",20,50));

//               24、不存在
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().notExists("select id from tbl_employee where age = 1"));

//                 25、存在
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().exists("select id from tbl_employee where age = 12"));

//              26、not in 不在区间内
//        List<Integer> idList = new ArrayList<>();
//        idList.add(31);
//        idList.add(32);
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().notIn("id",idList));

//        27、notSQL 不在区间内
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().notInSql("id","12,22"));

//          28、notLike 模糊查询没有这个关键字
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().notLike("age", "2"));

//        29、orderBy根据字段升序还是降序排序
//        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().orderBy(true, false, "age"));

//          30、or或者
        List<Employee> employeeList = employeeMapper.selectList(new QueryWrapper<Employee>().eq("id","25").or().eq("gender","1"));

        if (!employeeList.isEmpty()) {
            logger.info("++条件构造器查询员工信息+++++" + gson.toJson(employeeList));
        }


    }

    /**
     * Condition用法
     *
     * @throws SQLException
     */
    @Test
    public void selectCondition() throws SQLException {

        //Condition用法
        QueryWrapper condition = Condition.create().eq("age", "20");

        List employeeList = employeeMapper.selectList(condition);


        if (!employeeList.isEmpty()) {
            logger.info("++条件构造器查询员工信息+++++" + gson.toJson(employeeList));
        }

    }


}
