package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputMessage {

    public String[] inputCarNameReturnSplit(String separator) {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputCarName = Console.readLine();

        return inputCarName.split(separator);
    }

    public String inputNumberOfTries(){

        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine();
    }
}
