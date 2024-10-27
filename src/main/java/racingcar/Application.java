package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {
        String carName = Console.readLine();
        List<String> splitName = List.of(carName.split(","));

        for (int i = 0; i < splitName.size(); i++) {
            if (splitName.get(i).length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 최대 5자입니다.");
            }
        }
    }
}