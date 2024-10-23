package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {

    public void printGame(ArrayList<Car> cars) {
        System.out.println("실행 결과");
        for (Car car : cars) {
            System.out.println(car.name + "-".repeat(car.position));
        }

    }

    public void printWinner() {
        System.out.println("최종 우승자 : ");
    }

}
