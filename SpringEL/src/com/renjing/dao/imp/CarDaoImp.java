package com.renjing.dao.imp;

import com.renjing.bean.Car;
import com.renjing.dao.CarDao;

import java.util.List;

public class CarDaoImp implements CarDao {

//    @Resource(name = "car")
    private Car car;
//    @Resource(name = "list")
    private List list;

    public CarDaoImp() {

    }

    @Override
    public void show() {
        list.add("rr");
        list.add("ee");
        System.out.println(car.toString());
    }

    public CarDaoImp(Car car, List list) {
        this.car = car;
        this.list = list;
    }

    public Car getCar() {
        return car;
    }

    public void setCar(Car car) {
        this.car = car;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "CarDaoImp{" +
                "car=" + car +
                ", list=" + list +
                '}';
    }
}
