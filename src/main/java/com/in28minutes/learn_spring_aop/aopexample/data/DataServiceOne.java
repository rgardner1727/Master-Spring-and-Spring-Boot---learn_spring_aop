package com.in28minutes.learn_spring_aop.aopexample.data;

import com.in28minutes.learn_spring_aop.aopexample.annotations.TrackTime;
import org.springframework.stereotype.Repository;

@Repository
public class DataServiceOne {

    @TrackTime
    public int[] retrieveData(){
        return new int[] {1, 2, 3, 4, 5};
    }
}
