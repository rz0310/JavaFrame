package com.renjing.service.imp;

import com.renjing.dao.IStudentDao;
import com.renjing.domain.Student;
import com.renjing.service.IStudentService;
/*
学生的业务层实现类
 */
public class StudentServiceImp implements IStudentService {
	//此处需要用到操作层的接口
    private IStudentDao studentDao;
	//因为要注入，故必须要有setter()方法
    public void setStudentDao(IStudentDao studentDao) {
        this.studentDao = studentDao;
    }
	//按照id查找（注：只是为了演示配置方法，故没有实现所有方法）
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
//        3.更新账户信息
        studentDao.updateStudent(source);
//        int i = 1/0;
        studentDao.updateStudent(target);
    }
}
