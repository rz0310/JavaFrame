package com.renjing.service;

import com.renjing.domain.Student;

public interface IStudentService {
    public Student findStudentById( Integer studentId);
    public void transfer(String sourceName, String targetName, Integer money);
}
