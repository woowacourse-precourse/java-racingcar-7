package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.List;

public class Application {
    public static void main(String[] args) {

        //TODO: 다른 클래스로 분리할 수 있으면 분리하기
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carsInput = Console.readLine();
        List<String> cars = Arrays.asList(carsInput.split(","));

        //TODO: 다른 클래스로 분리할 수 있으면 분리하기
        System.out.println("시도할 횟수는 몇 회인가요?");
        int raceRounds = Integer.parseInt(Console.readLine());

    }

}
