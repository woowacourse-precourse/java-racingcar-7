package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분)");
        ArrayList<String> carNames = new ArrayList<>();
        SeparateCarNames(carNames);
    }

    public static void SeparateCarNames(ArrayList<String> carNames) {
        String[] names = Console.readLine().split(",");
        for (String name : names) {
            name = name.trim();
            if (name.length() <= 5) {
                carNames.add(name);
            } else {
                throw new IllegalArgumentException("5자 이하로 해주세요.");
            }
        }
    }
}
