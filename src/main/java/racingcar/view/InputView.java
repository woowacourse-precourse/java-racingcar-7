package racingcar.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

public class InputView {
    public String[] inputNames() {
        System.out.println("사용자 이름을 입력해주세요 ( , 로 구분)");
        return readLine().split(",");
    }

    public int inputTimes() {
        System.out.println("총 시도 횟수를 입력해주세요");
        return Integer.parseInt(readLine());
    }
}
