package racingcar;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {

    public String getName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return readLine();
    }

    public int getCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(readLine());
    }

}
