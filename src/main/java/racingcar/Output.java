package racingcar;

import java.util.List;

public class Output {

    public void printRoundResult(List<Car> cars){
        for (Car car: cars){
            System.out.println(car);
        }
        System.out.println();
    }

}
