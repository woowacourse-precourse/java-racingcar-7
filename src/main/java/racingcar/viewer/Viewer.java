package racingcar.viewer;

import racingcar.utils.Output;

public class Viewer {

    private final Output output;

    public Viewer(Output output) {
        this.output = output;
    }

    public void print() {
        System.out.println(output);
    }
}
