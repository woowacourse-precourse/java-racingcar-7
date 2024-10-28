package racingcar.view;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import racingcar.model.car.Car;

public class OutputView {

    public void printResultTitleView() {
        System.out.println("\n실행 결과");
    }

    public void printUnitResult(Map<Car, Integer> resultInfo) {
        for (Map.Entry<Car, Integer> entry : resultInfo.entrySet()) {
            Car car = entry.getKey();
            Integer moves = entry.getValue();
            System.out.println(car.getName() + " : " + "-".repeat(moves));
        }
        System.out.println();
    }

    public void printFinalResultView(List<Car> maxCars) {
        String finalResult = formatFinalResult(maxCars);

        System.out.println("최종 우승자 : " + finalResult);
    }

    private static String formatFinalResult(List<Car> maxCars) {
        return maxCars.stream()
                .map(Car::getName)
                .collect(Collectors.joining(", "));
    }

}
