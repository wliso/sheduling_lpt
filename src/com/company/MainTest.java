package com.company;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import static org.junit.jupiter.api.Assertions.*;

@RunWith(Parameterized.class)
public class MainTest {
    ArrayList<Integer> timeJobs;
    Integer n_machines;
    Integer result;

    public MainTest(ArrayList<Integer> timeJobs, Integer n_machines, Integer result) {
        this.timeJobs = timeJobs;
        this.n_machines = n_machines;
        this.result = result;
    }


    @Parameterized.Parameters()
    public static Collection<Object[]> data() {
        Object[][] data = new Object[][]{{new ArrayList<>(Arrays.asList(3, 4, 6, 2, 2, 8)), 3, 9}, {new ArrayList<>(Arrays.asList(7,7,6,6,5,5,4,4,4)), 4, 15}};
        return Arrays.asList(data);
    }

    @Test
    public void test_schedule(){
        Scheduler scheduler = new Scheduler(timeJobs,n_machines);
        assertEquals(result,scheduler.schedule());
    }

}