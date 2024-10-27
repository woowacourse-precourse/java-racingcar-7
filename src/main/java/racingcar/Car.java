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
        tryNumber = Integer.parseInt(readLine());
    }

    public HashMap<String, Integer> getCar() {
        setCar();
        return cars;
    }

    public int getTryNumber() {
        setTryNumber();
        return tryNumber;
    }

    public void validateCarName(String carName){
        if (carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하로 입력 해야합니다.");
        }
    }
}
