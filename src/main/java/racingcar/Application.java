package racingcar;

import java.util.ArrayList;

public class Application {
    public static void main(String[] args) {
        InputOutputHandler.initInput();

        ArrayList<String> carNames = InputOutputHandler.getCarName();
        int racingCounter = InputOutputHandler.getRacingCounter();


        ArrayList<RacingCar> racingCars = new ArrayList<>();
        for (String name : carNames) {
            racingCars.add(new RacingCar(name));
        }

        RacingController.printRacing(racingCars, racingCounter);

        ArrayList<String> winners = RacingController.judgeWinner(racingCars);
        System.out.print("최종 우승자 : " + String.join(", ", winners));

    }
}
