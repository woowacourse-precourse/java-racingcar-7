package racingcar.view;

import racingcar.domain.Car;

import java.util.List;

public class OutputView {
    private static final String MOVE_MARK = "-";
    private static final String START_PLAY = "실행 결과";

    public void startPlay(){
        System.out.println(START_PLAY);
    }

    public void printPlayRoundResult(List<Car> cars){
        cars.forEach(car ->
            System.out.println(formatCurrentMoveCount(car))
        );

        System.out.println();
    }

    public void printWinners(List<String> winners){
        String result = String.join(", " , winners);

        System.out.println("최종 우승자 : " + result);
    }

    private String formatCurrentMoveCount(Car car){
        return car.getName() + " : " + MOVE_MARK.repeat(car.getMoveCount());
    }

}
