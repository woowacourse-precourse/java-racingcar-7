package racingcar.viewer;

import camp.nextstep.edu.missionutils.Console;
import racingcar.utils.Output;

public class Viewer {

    private final Output output;

    public Viewer(Output output) {
        this.output = output;
    }

    public void print() {
        System.out.println(output);
    }

    public void printInputCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTryCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public String readCarNames() {
        return Console.readLine();
    }

    public String readTryCount() {
        return Console.readLine();
    }
}
