package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    public String inputCarNames() {
        System.out.println("경주할 차량의 이름을 입력하세요. 이름은 (,) 기준으로 구분 됩니다.이름은 5자 이하만 가능합니다.");

        return Console.readLine();

    }

    public String inputMaxRound() {
        System.out.println("시도하실 횟수를 정해주세요");

        return Console.readLine();
    }
}
