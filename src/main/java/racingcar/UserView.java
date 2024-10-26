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

        int round;

        try {
            round = Integer.parseInt(Console.readLine());
            if (round < 1) {
                throw new IllegalArgumentException("시도할 횟수는 1이상의 자연수이어야 합니다.");
            }
        }
        catch (Exception e) {
            throw new IllegalArgumentException("시도할 횟수는 숫자로 입력되어야 합니다.");
        }


        return round;
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
