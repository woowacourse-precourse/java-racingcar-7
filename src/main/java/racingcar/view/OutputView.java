package racingcar.view;

import racingcar.model.dto.Car;
import racingcar.model.dto.RacingResult;

import java.util.List;

public class OutputView {

    public void outputViewResult(List<RacingResult> racingResults){
        for (RacingResult racingResult : racingResults) {
            printRacingResultOnce(racingResult);
            System.out.println();
        }

    }

    private void printRacingResultOnce(RacingResult racing){
        List<Car> cars = racing.getCars();
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + printDashes(car.getMoveCount()));
        }
    }

    private String printDashes(int count){
        StringBuilder sb = new StringBuilder();
        for(int i=0; i<count; i++){
            sb.append("-");
        }
        return sb.toString();
    }

}
