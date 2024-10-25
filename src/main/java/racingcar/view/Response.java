package racingcar.view;

import java.util.List;
import java.util.stream.Collectors;
import racingcar.car.Car;

public class Response {

    public static void outputStart() {
        System.out.println("실행 결과");
    }

    public static void outputExecute(List<Car> carList) {
        for (Car car : carList) {
            System.out.println(car.getName() + " : " + car.getForwardNumber());
        }
    }

    public static void outputFinalWinner(List<Car> carList) {
        List<String> carNameList = carList.stream()
                .map(Car::getName)
                .collect(Collectors.toList());

        System.out.println("최종 우승자 : " + String.join(", ", carNameList));
    }

}
