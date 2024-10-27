package racingcar.io;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.racer.car.Car;

public class CustomIO {

    private static final int NAME_LENGTH_LIMIT = 5;

    public String[] inputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String names = Console.readLine();
        String[] splitNames = names.split(",");
        for (String name : splitNames) {
            if (name.length() > NAME_LENGTH_LIMIT) {
                throw new IllegalArgumentException("이름은 5자 이하로만 입력 가능합니다.");
            }
        }
        return splitNames;
    }

    public int inputRepeatNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num = Integer.parseInt(Console.readLine());
        System.out.println();
        return num;
    }

    public void print(String message) {
        System.out.println(message);
    }

    public void printResult(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + car.getDistance());
        }
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.print("최종 우승자 : " + String.join(", ", winners));
    }
}
