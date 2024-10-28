package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            RacingCarController racingCarController = new RacingCarController();
            racingCarController.racingStart();
        }
        catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        }
    }
}
