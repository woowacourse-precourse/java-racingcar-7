package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public String getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    public int getEpoch() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        // 공백이나 문자로 주어진다면 에러를 반환해야 한다. 수정 필요
        return Integer.parseInt(Console.readLine());
    }
}
