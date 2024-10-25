package racingcar;

import racingcar.controller.RaceGameController;

public class Application {
    public static void main(String[] args) {
        RaceGameController controller = new RaceGameController();
        controller.run();
    }
}
// pobi,woni,jun  -> o
// pobibi,woni,jun -> x
// pobi, woni,jun -> x
// pobi,woni;jun -> x
