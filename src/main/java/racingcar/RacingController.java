package racingcar;

public class RacingController {
    public static void temp() {
        for (int i = 0; i < Data.getRacingCount(); i++) {
            System.out.println(NumberMaker.makeRandomNumber());
        }
    }
}