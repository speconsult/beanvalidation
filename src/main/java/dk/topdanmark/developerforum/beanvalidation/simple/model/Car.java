package dk.topdanmark.developerforum.beanvalidation.simple.model;

import javax.validation.Valid;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import dk.topdanmark.developerforum.beanvalidation.types.InsuranceType;

import java.util.Date;

public class Car extends Vehicle {


    @Min(value = 100)
    @Max(value = 600)
    private int length;


    @NotNull
    private InsuranceType insured;

    @Past
    private Date registered;

    @Valid
    private Motor motor;

    public Motor getMotor() {
        return motor;
    }

    public void setMotor(Motor motor) {
        this.motor = motor;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public InsuranceType getInsured() {
        return insured;
    }

    public void setInsured(InsuranceType insured) {
        this.insured = insured;
    }

    public Date getRegistered() {
        return registered;
    }

    public void setRegistered(Date registered) {
        this.registered = registered;
    }
}
