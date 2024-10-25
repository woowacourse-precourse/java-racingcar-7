package racingcar;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class OutputUtils {

    public static void printPosition(List<Car> carList){
        for(Car car: carList){
            System.out.println(car.getName() + " : " + IntStream.range(0,car.getPosition())
                    .mapToObj(i -> "-")
                    .collect(Collectors.joining()));
        }
    }
}
