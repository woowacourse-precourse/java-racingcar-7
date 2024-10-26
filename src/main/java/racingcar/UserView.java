package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class UserView {

    public String[] createCars() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        return Console.readLine().split(",");
    }

    public int inputRoundCount() {

        System.out.println("시도할 횟수는 몇 회인가요?");

        return Integer.parseInt(Console.readLine());
    }

    public void displayRace(List<Car> cars) {

        System.out.println();

        for (Car car : cars) {
            System.out.println(car.getCarName() + " : " + car.getPosition());
        }

        System.out.println();
    }

    public void displayWinner(List<String> winners) {

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }

}
