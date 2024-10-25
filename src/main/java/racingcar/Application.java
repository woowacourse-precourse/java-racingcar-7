package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNamesInput = Console.readLine();
        Validator.validateNameEmpty(carNamesInput);

        String[] names = carNamesInput.split(",");
        List<String> nameList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            String trimName = name.trim(); // 이름 양 끝 공백 제거
            Validator.validateNameLength(trimName);
            Validator.validateNameDuplicate(trimName, nameList);
            nameList.add(trimName);
            cars.add(new Car(trimName, ""));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        String attemptCountInput = Console.readLine();
        int attemptCount = Validator.validateAndParseInteger(attemptCountInput);
        Validator.validatePositive(attemptCount);

        System.out.println("\n실행 결과");

        for (int i = 0; i < attemptCount; i++) {
            for (Car car : cars) {
                int random = Randoms.pickNumberInRange(0, 9);
                if (random >= 4) {
                    car.forward();
                }
            }

            for (Car car : cars) {
                System.out.println(car.getName() + " : " + car.getProgress());
            }
            System.out.println();
        }

        int max = 0;
        for (Car car : cars) {
            max = Math.max(car.getProgress().length(), max);
        }

        List<String> winners = new ArrayList<>();
        for (Car car : cars) {
            if (max == car.getProgress().length()) {
                winners.add(car.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}
