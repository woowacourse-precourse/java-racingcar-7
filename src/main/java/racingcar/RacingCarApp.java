package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class RacingCarApp {
    private ArrayList<Car> cars = new ArrayList<>();
    public String getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }
    public int getAttemptCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        try{
            return Integer.parseInt(Console.readLine());
        }catch (Exception e){ // 정수 변환 실패시
            throw new IllegalArgumentException();
        }
    }

    public void makeCar(String inputData) {
        for (String carName : inputData.split(",")) {
            validateCarName(carName);
            cars.add(new Car(carName));
        }
    }

    public void validateCarName(String carName) {
        if (carName.length() > 5) {
            throw new IllegalArgumentException();
        }
    }
}
