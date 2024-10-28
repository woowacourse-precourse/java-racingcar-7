package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Racing {
    private List<Car> cars;
    private int attempts;

    public void start() {
        String namesInput = getUserName();
        attempts = getUserAttempts();
        cars = splitCarsName(namesInput);
    }

    private String getUserName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    private int getUserAttempts() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            return Integer.parseInt(Console.readLine());
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    private List<Car> splitCarsName(String namesInput) {
        String[] names = namesInput.split(",");
        List<Car> carList = new ArrayList<>();
        for (String name : names) {
            carList.add(new Car(name.trim()));
        }
        return carList;
    }
}
