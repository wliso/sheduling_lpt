package com.company;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class Scheduler {
    public ArrayList<Job> jobs = new ArrayList<>();
    public Integer n_machines;
    public ArrayList<Machine> machines;

    public Scheduler(ArrayList<Integer> timeJobs, Integer n_machines) {
        Comparator c = Collections.reverseOrder();
        timeJobs.sort(c);
        for(Integer time:timeJobs){
            this.jobs.add(new Job(time));
        }
        this.n_machines = n_machines;
        this.machines = new ArrayList<>(n_machines);
        for(int i=0;i<n_machines;i++){
            machines.add(new Machine());
        }
    }

    public Integer schedule(){
        Integer timer = 0;
        for(Job job: jobs){
            do {
                for (int i = 0; i < n_machines; i++) {
                    if (machines.get(i).sumOfDoneJobs <= timer) {
                        job.assigned = true;
                        machines.get(i).doneJobs.add(job);
                        machines.get(i).sumOfDoneJobs+=job.time;
                        break;
                    }
                }
                if(!job.assigned)
                    timer++;
            } while(!job.assigned);
        }
        return calcMaxTime();
    }

    public Integer calcMaxTime(){
        ArrayList<Integer> times = new ArrayList<>();
        for(Machine mach: machines){
            times.add(mach.sumOfDoneJobs);
        }
        return Collections.max(times);
    }

    class Machine{
            ArrayList<Job> doneJobs = new ArrayList<>();
            Integer sumOfDoneJobs;

        public Machine() {
            this.sumOfDoneJobs = 0;
        }

    }
    public class Job{
        Integer time;
        Boolean assigned = false;

        public Job(Integer time) {
            this.time = time;
        }
    }
}
