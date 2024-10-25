package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;
import racingcar.domain.Car;

public class UserInputManager {
    private int repeat;
    private List<String> carNameList;

    public UserInputManager() {
        this.repeat = 0;
        this.carNameList = new ArrayList<>();
    }

    public void close() {
        Console.close();
    }

    public List<Car> createCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String carNameLine = Console.readLine();
        String[] carNames = carNameLine.split(",");
        for (String carName : carNames) {
            carNameValidate(carName);
            this.carNameList.add(carName);
        }

        return this.carNameList.stream()
                .map(Car::new)
                .toList();
    }

    private void carNameValidate(String carName) {
        if (carNameList.contains(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
        }
    }

    public int createRepeat() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        String userInput = Console.readLine();
        repeatValidate(userInput);
        this.repeat = Integer.parseInt(userInput);

        return this.repeat;
    }

    private void repeatValidate(String userInput) {
        if (userInput == null || userInput.isEmpty() || !userInput.matches("^[1-9][0-9]*$")) {
            throw new IllegalArgumentException("자연수만 입력할 수 있습니다.");
        }

        if (userInput.length() > 5) {
            throw new IllegalArgumentException("입력 값이 10만 미만이어야합니다.");
        }
    }
}
