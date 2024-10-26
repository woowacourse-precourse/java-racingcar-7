package racingcar;

import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class outputView {

    public static void printResult(Car car) {
        System.out.printf("%s : ",car.getCarName());
        for(int i=0; i< car.getPosition(); i++) {
            System.out.print("-");
        }
        System.out.println();
    }
    public static void printWinners(List<Car> carList) {
        System.out.print("최종 우승자 : ");
        String output = carList.stream().map(Car::getCarName).collect(Collectors.joining(", "));
        System.out.println(output);
    }

}
