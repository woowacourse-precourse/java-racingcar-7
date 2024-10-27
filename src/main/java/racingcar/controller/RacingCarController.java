package racingcar.controller;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;
import racingcar.validator.CarNameValidator;

import java.util.ArrayList;
import java.util.List;

public class RacingCarController {
    public void run(){
        String input = Console.readLine();
        String[] tokens = input.split(",");
        CarNameValidator carNameValidator = new CarNameValidator();
        List<Car> cars = new ArrayList<>();

        int totalCars = 0;
        for(String token : tokens){
            if(carNameValidator.validate(token)){
                Car car = new Car(token);
                cars.add(car);
            }
        }


    }


}
