package dk.topdanmark.developerforum.beanvalidation.groups.model;

import dk.topdanmark.developerforum.beanvalidation.types.InsuranceType;
import org.apache.commons.lang.time.DateUtils;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.validation.ConstraintViolation;
import javax.validation.Validation;
import javax.validation.Validator;
import javax.validation.ValidatorFactory;
import java.util.Date;
import java.util.Locale;
import java.util.Set;

public class GroupsVehicleTest {


    private static Validator validator;

    @BeforeClass
    public static void setUp() {
        Locale.setDefault(Locale.ENGLISH);
        ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
        GroupsVehicleTest.validator = factory.getValidator();
    }

    @Test
    public void testWheels() throws Exception {
        Car car = new Car();
        car.setInsured(InsuranceType.HUS);
        Motor motor = new Motor();
        motor.setCcm(200);
        car.setMotor(motor);
        car.setRegistered(DateUtils.addDays(new Date(), 10));
        car.setLength(2000);

        Wheel leftFrontWheel = new Wheel();
        leftFrontWheel.setPosition("LEFT_FRONT");
        leftFrontWheel.setDiameter(10);

        car.addWheel(leftFrontWheel);

        Set<ConstraintViolation<Car>> violations = GroupsVehicleTest.validator.validate(car);

        for (ConstraintViolation<Car> constraintViolation : violations) {
            System.out.println(constraintViolation.getPropertyPath() + ", " + constraintViolation.getMessage());
        }

        Set<ConstraintViolation<Car>> insuranceViolations = GroupsVehicleTest.validator.validate(car, InsuranceCheck.class);

        for (ConstraintViolation<Car> constraintViolation : insuranceViolations) {
            System.out.println(constraintViolation.getPropertyPath() + ", " + constraintViolation.getMessage());
        }
    }
}
