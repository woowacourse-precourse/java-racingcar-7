package racingcar;

import java.util.ArrayList;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class OutputView {

    public void printFirst() {

        System.out.println("\n실행 결과 : ");

    }

    public void printGame(ArrayList<Car> cars) {

        for (Car car : cars) {
            System.out.println(car.name + " : " + "-".repeat(car.position));
        }

        System.out.println();

    }

    public void printWinner() {
        System.out.println("최종 우승자 : ");
    }

}
