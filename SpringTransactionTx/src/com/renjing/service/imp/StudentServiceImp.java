package com.renjing.service.imp;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import com.renjing.service.IStudentService;
/*
学生的业务层实现类
 */
public class StudentServiceImp implements IStudentService {
	//此处要使用到操作层的接口
    private IStudentDao studentDao;

    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }
	//业务层：按照id查找
    @Override
    public Student findStudentById(Integer studentId) {
        return studentDao.fingStudentById(studentId);
    }

    @Override
    public void transfer(String sourceName, String targetName, Integer money) {
//        1.根据名称查询账户信息
        Student source = studentDao.findStudentByName(sourceName);
        Student target = studentDao.findStudentByName(targetName);
//        2.转出账户减钱，转入账户加钱
        source.setMoney(source.getMoney()-money);
        target.setMoney(target.getMoney()+money);
        System.out.println(source.getMoney());
        System.out.println(target.getMoney());
//        3.更新账户信息
        studentDao.updateStudent(source);
        int i = 1/0;//此处是为了模拟转账发生的异常
        studentDao.updateStudent(target);
    }
}
