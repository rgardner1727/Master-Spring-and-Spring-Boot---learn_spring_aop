package com.in28minutes.learn_spring_aop.aopexample.business;

import com.in28minutes.learn_spring_aop.aopexample.data.DataServiceOne;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class BusinessServiceOne {

    @Autowired
    private DataServiceOne dataServiceOne;

    public int calculateMax(){
        //throw new RuntimeException("An exception occurred.");
        return Arrays.stream(dataServiceOne.retrieveData()).max().orElse(-1);
    }
}
