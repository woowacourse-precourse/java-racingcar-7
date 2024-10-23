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

    public String readCarNames() {
        return Console.readLine();
    }

    public String readTryCount() {
        return Console.readLine();
    }
}
