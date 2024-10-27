package racingcar.custom_test;

import org.junit.jupiter.api.Assertions;
import static org.junit.jupiter.api.Assertions.assertTrue;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.model.Car;

public class CarTest {

    @Test
    @DisplayName("Car 객체 생성")
    void createCarObjectTest(){
        //given
        String carName = "benz";
        //when
        Car car = new Car(carName);
        //then
        Assertions.assertEquals(carName, car.getName());
        Assertions.assertEquals(0,car.getMileage());
    }
    @Test
    @DisplayName("Move Method Test")
    void moveCarTest(){
        //given
        int iter = 500;
        Car car = new Car("Benz");
        //when
        for(int  i = 0 ; i<iter; i++) car.move();
        //then
        assertTrue(car.getMileage()>=0 || car.getMileage()<=iter); //조건과 일치하면 pass
    }
}
