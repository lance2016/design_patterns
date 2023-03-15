package com.lance.entity;

import com.lance.annotation.MyAnno;
import com.lance.util.BeanUtil;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Car {

    @MyAnno(value = "benz")
    private String name;

    @MyAnno(value = "red1")
    private String color;

    public static void main(String[] args) {

            Car car = BeanUtil.getBean(Car.class);
            System.out.println(car.getColor());
            System.out.println(car.getName());

    }
}
