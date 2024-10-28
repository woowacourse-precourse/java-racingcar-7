package racingcar.view;

import racingcar.model.RacingCar;

import java.util.List;
/*
* 실행 결과와 최종 우승자를 출력하는 기능을 수행하는 클래스
 */

public class OutputView {

    public static String userResultOutput(List<RacingCar> racingCars) {
        StringBuilder output = new StringBuilder();
        for(RacingCar racingCar : racingCars) {
            output.append(setResultOutput(racingCar.getCarName(), racingCar.getResultToMove())).append("\n");
        }
        return output.toString();
    }

    public static String setResultOutput(String carName, int resultToMove) {
        StringBuilder output = new StringBuilder(carName + " : ");
        for (int i = 0; i < resultToMove; i++) {
            output.append("-");
        }
        return output.toString();
    }

}
