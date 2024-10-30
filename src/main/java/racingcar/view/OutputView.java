package racingcar.view;

import racingcar.dto.CarsDto;
import racingcar.model.Car;

import java.util.List;

public class OutputView {
    private OutputView() {
    }
    public static void outputBeforeRound() {
        System.out.println("\n실행 결과");
    }
    public static void outputEachRound(CarsDto carsDto) {
        for (Car car : carsDto.getCars()) {
            System.out.println(car.getName()+" : "+"-".repeat(car.getWinStack()));
        }
        System.out.println();
    }
    public static void outputRaceResult(List<String> raceResult) {
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < raceResult.size(); i++) {
            if (i > 0) {
                System.out.print(", ");
            }
            System.out.print(raceResult.get(i));
        }
    }
}
