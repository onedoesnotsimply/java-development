package com.pluralsight;

import java.time.LocalTime;

public class Employee {
    private int employeeId;
    private String name;
    private String department;
    private double payRate;
    private double hoursWorked;
    private double clockIn;

    public Employee(int employeeId, String name, String department, double payRate/*, double hoursWorked*/){
        this.employeeId=employeeId;
        this.name=name;
        this.department=department;
        this.payRate=payRate;
        //this.hoursWorked=hoursWorked;

    }

    public int getEmployeeId() {
        return employeeId;
    }

    public String getName() {
        return name;
    }

    public double getPayRate() {
        return payRate;
    }

    public String getDepartment() {
        return department;
    }

    public double getRegularHours() {
        if (hoursWorked>40){
            return 40;
        }
        return hoursWorked;
    }

    public double getOvertimeHours() {
        if (hoursWorked>40) {
            return hoursWorked-40;
        }
        return 0;
    }

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void punchIn(double time){
        this.clockIn=time;
    }

    public void punchIn() {
        LocalTime time = LocalTime.now();
        double hours = time.getHour();
        double minutes = (double) time.getMinute() /100;

        this.clockIn = hours+minutes;
    }

    public void punchOut(double time) {
        hoursWorked+=time-clockIn;
    }

    public void punchOut() {
        LocalTime time = LocalTime.now();
        double hours = time.getHour();
        double minutes = (double) time.getMinute() /100;
        double punchOutTime = hours+minutes;

        hoursWorked+=punchOutTime-clockIn;
    }

    public void punchTimeCard(double punchIn, double punchOut) {
        hoursWorked += (punchOut-punchIn);
    }

    public double getTotalPay() {
        double totalPay;
        if (getOvertimeHours()>0) {
            return (payRate * getRegularHours())+(((payRate*1.5))*getOvertimeHours());
        }
        return payRate*getRegularHours();
    }
}
