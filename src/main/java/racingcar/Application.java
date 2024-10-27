/*
 * Application
 *
 * ver1
 *
 * 2024-10-24
 *
 * 저작권 주의
 */
package racingcar;

import racingcar.controller.RacingCarController;

public class Application {
    public static void main(String[] args) {
        RacingCarController racingCarController = new RacingCarController();
        racingCarController.start();
    }
}
