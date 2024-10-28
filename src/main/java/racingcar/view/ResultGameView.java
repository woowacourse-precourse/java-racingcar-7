
package racingcar.view;

import racingcar.domain.Car;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ResultGameView {

    public static void midPrint(List<Car>cars){
        System.out.println();
        cars.forEach(car->
                System.out.printf("%s : %s\n", car.getName(),"-".repeat(car.getCount()))
        );
    }

    public static void finalPrint(List<String> carNames){
        System.out.printf("최종 우승자 : %s", String.join(", ",carNames));
    }
}
