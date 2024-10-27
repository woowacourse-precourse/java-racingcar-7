package racingcar.view;

import racingcar.model.Car;

import java.util.List;
import java.util.stream.Collectors;

import static racingcar.util.Constants.*;

public class OutputView {
    public void printInputCarName(){
        System.out.println(INPUT_CAR_NAME);
    }
    public void printInputMoveCount(){
        System.out.println(INPUT_MOVE_COUNT);
    }
    public void printResult(){
        System.out.println(OUTPUT_RESULT);
    }
    public void printWinners(List<Car> winners) {
        String winnerNames = winners.stream()
                .map(Car::getName) // Car 객체에서 이름만 추출
                .collect(Collectors.joining(", ")); // 쉼표로 이름을 연결
        System.out.println("최종 우승자 : " + winnerNames);
    }

}
