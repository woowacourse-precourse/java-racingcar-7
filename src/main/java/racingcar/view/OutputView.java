package racingcar.view;

import java.util.ArrayList;
import racingcar.model.Car;

public class OutputView {
    private static final String RESULT = "실행 결과";
    private static final String HYPE = ":";
    private static final String MOVE = "-";
    private static final String WINNER = "최종 우승자 : ";

    public void printRaceResultHeader() {
        System.out.println(RESULT);
    }

    public void printCarPositions(ArrayList<Car> cars) {
        for(Car car : cars){
            System.out.print(car.getName() + " ");
            System.out.print(HYPE + " ");
            System.out.println(MOVE.repeat(car.getPosition()));
        }
    }

    public void printWinners(ArrayList<String> winners) {
        System.out.print(WINNER);
        for (int i = 0; i < winners.size(); i++) {
            if(i < winners.size() - 1) {
                System.out.print(winners.get(i) + ", ");
            } else if (i == winners.size()-1) {
                System.out.println(winners.get(i));
            }
        }
    }
}
