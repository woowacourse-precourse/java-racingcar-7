package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputHandler.initInput();

        ArrayList<String> carNames = InputHandler.getCarName();
        int racingCounter = InputHandler.getRacingCounter();


        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }

        RacingController.printRacing(racingCars, racingCounter);

        ArrayList<String> winners = RacingController.judgeWinner(racingCars);
        System.out.print("최종 우승자 : " + String.join(", ", winners));

    }
}
