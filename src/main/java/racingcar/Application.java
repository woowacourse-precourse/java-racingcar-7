package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현

        System.out.println("경주할 자동차 이름을 입력하세요. (이름은 쉼표(,) 기준으로 구분");
        String carsString = Console.readLine().replaceAll(" ", "");

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine().replaceAll(" ", "");

        List<String> carNames = List.of(carsString.split(","));
        int tryNum = Integer.parseInt(tryNumString);

        if (carNames.stream().anyMatch(name -> name.length() > 5)) {
            throw new IllegalArgumentException("자동차의 이름은 5자 이하여야 합니다.");
        }
    }
}
