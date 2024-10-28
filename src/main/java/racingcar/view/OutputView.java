package racingcar.view;

import java.util.List;
import racingcar.model.Car;

public class OutputView {

    /**
     * 차수별 결과 출력
     */
    public void showRoundResult(List<Car> racingCars) {
        racingCars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(Math.max(0, car.getTotalDistance())));
        });
        System.out.println();
    }

    /**
     * 최종 우승자 출력
     */
    public void showFinalWinner(List<Car> finalWinners) {
        List<String> finalWinnerNames = finalWinners.stream().map(Car::getName).toList();
        String joinedFinalWinnerNames = String.join(", ", finalWinnerNames);
        System.out.println("최종 우승자 : " + joinedFinalWinnerNames);
    }

}
