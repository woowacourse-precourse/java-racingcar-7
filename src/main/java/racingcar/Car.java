package racingcar;

import java.util.HashMap;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class Car {

    private final HashMap<String, Integer> cars = new HashMap<String, Integer>();
    private int tryNumber;

    private void setCar() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] carNames = readLine().split(",");
        for (String carName : carNames) {
            validateCarName(carName);
            cars.put(carName, 0);
        }
    }

    private void setTryNumber() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String checkTryNumber = readLine();
        validateTryNumber(checkTryNumber);
        tryNumber = Integer.parseInt(checkTryNumber);
    }

    public HashMap<String, Integer> getCar() {
        setCar();
        return cars;
    }

    public int getTryNumber() {
        setTryNumber();
        return tryNumber;
    }

    private void validateCarName(String carName) {
        if (carName.isEmpty()) {
            throw new IllegalArgumentException("자동차 이름이 입력되지 않았습니다.");
        }
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 해야합니다.");
        }
        if (carName.contains(" ")) {
            throw new IllegalArgumentException("공백을 포함하면 안됩니다.");
        }
        if (cars.containsKey(carName)) {
            throw new IllegalArgumentException("자동차 이름은 중복되면 안됩니다.");
        }
    }

    private void validateTryNumber(String checkTryNumber) {
        if (Integer.parseInt(checkTryNumber) <= 0) {
            throw new IllegalArgumentException("시도 횟수는 양의 정수로 입력 해야합니다.");
        }
        if (checkTryNumber.isEmpty()) {
            throw new IllegalArgumentException("시도 횟수가 입력되지 않았습니다.");
        }
        if (checkTryNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("공백을 포함하면 안됩니다.");
        }
    }
}
