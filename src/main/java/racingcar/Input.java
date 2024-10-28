package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.Collections;

public class Input {
    private String carNames;
    private int rounds;
    private ArrayList<String> cars;

    public void setCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNames = Console.readLine();
        System.out.println(carNames);

        stringToArrayList(carNames);
        validateCarName(cars);
    }

    public void setRounds() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        rounds = Integer.parseInt(Console.readLine());
        System.out.println(rounds);
    }

    public ArrayList<String> getCarNames() {
        return cars;
    }

    public int getRounds() {
        return rounds;
    }

    private void stringToArrayList(String carNames) {
        cars = new ArrayList<>();
        String[] carNameList = carNames.split(",");
        Collections.addAll(cars, carNameList);
    }

    private void validateCarName(ArrayList<String> cars){
        for (String car : cars){
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }

    // only for test
    public void validateCarName1(ArrayList<String> cars){
        for (String car : cars){
            if (car.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
        }
    }
}
