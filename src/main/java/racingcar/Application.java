package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();
        Validator.validateNameEmpty(input);

        String[] names = input.split(",");
        List<String> nameList = new ArrayList<>();
        List<Car> cars = new ArrayList<>();
        for (String name : names) {
            String trim_name = name.trim(); // 이름 양 끝 공백 제거
            Validator.validateNameLength(trim_name);
            Validator.validateNameDuplicate(trim_name, nameList);
            nameList.add(trim_name);
            cars.add(new Car(trim_name, ""));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");

        String input2 = Console.readLine();
        int count = Validator.validateAndParseInteger(input2);
        Validator.validatePositive(count);

        System.out.println("\n실행 결과");

        for (int i = 0; i < count; i++) {
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
