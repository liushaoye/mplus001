package com.baidu.www.mplus.serviceImpl;

import com.baidu.www.mplus.bean.Employee;
import com.baidu.www.mplus.mapper.EmployeeMapper;
import com.baidu.www.mplus.service.IEmployeeService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author liuyangos8888
 * <p>
 * 业务实现类
 */
@Service
public class EmployeeServiceImpl extends ServiceImpl<EmployeeMapper, Employee> implements IEmployeeService {


    @Autowired
    private EmployeeMapper employeeMapper;

    public Object list() {

        return employeeMapper.selectList(null);
    }


}
