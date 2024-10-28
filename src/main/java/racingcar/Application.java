package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;

public class Application {
    public static void main(String[] args) {

        Methods methods = new Methods();

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarNames = Console.readLine();
        List<String> nameList =  methods.nameCheck(inputCarNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputTryCount = Console.readLine();
        methods.carRacing(inputTryCount, nameList);

        methods.printWinners();

    }
}
