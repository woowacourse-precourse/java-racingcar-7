package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Stadium {

    private String inputNames;

    private final Integer count;
    private final List<Car> carList = new ArrayList<>();

    public Stadium() {
        input();
        this.count = inputCount();
    }

    public int input(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        inputNames = Console.readLine();
        for (String name : tokenization()) {
            carList.add(new Car(name));
        }
    }

    private String[] tokenization(){
        String[] names = inputName.split(",");
        validateNameLength(names);
        return names;
    }

    private void validateNameLength(String[] names) {
        for (String name : names) {
            if (name.trim().length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하로 입력해야 합니다.");
            }
        }
    }

    // 실행 출력
    public void printResult() {
        for (Car car : carList) {
            System.out.println(car);
        }

        System.out.println();
    }
}
