package com.renjing.service.imp;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import com.renjing.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/*
业务层实现类
 */
@Service("studentService")//注入业务层实现类
@Transactional(propagation = Propagation.REQUIRED,readOnly = false)//配置事务，读写型
//@Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//只读型，不能控制增删改的事务
public class StudentServiceImp implements IStudentService {
	//自动装配
    @Autowired
    private IStudentDao studentDao;

    @Override
    @Transactional(propagation = Propagation.SUPPORTS,readOnly = true)//配置只读型事务，对于查找来说，效率要高一些
    public Student findStudentById(Integer studentId) {
        return studentDao.fingStudentById(studentId);
    }
	//转账操作
    @Override	
    public void transfer(String sourceName, String targetName, Integer money) {
//        1.根据名称查询账户信息
        Student source = studentDao.findStudentByName(sourceName);
        Student target = studentDao.findStudentByName(targetName);
//        2.转出账户减钱，转入账户加钱
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
//        3.更新账户信息
        studentDao.updateStudent(source);
        int i = 1/0;
        studentDao.updateStudent(target);
    }
}
