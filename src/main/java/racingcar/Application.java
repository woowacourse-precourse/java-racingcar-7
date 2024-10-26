package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        List<String> carNameList;
        List<Car> carList = new ArrayList<>();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        carNameList = Arrays.stream(Console.readLine()
                .split(","))
                .toList();

        for (String s: carNameList) {
            carList.add(new Car(s));
        }

    }
}
