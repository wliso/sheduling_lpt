package com.company;

import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        ArrayList<Integer> test_jobs = new ArrayList<Integer>(
                Arrays.asList(3,4,6,2,2,8));
                //Arrays.asList(7,7,6,6,5,5,4,4,4));
        Integer n_machines = 3;
        Scheduler scheduler = new Scheduler(test_jobs,n_machines);
        System.out.println("schedule: " + scheduler.schedule());
    }
}
