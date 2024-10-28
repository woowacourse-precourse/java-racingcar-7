package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.RaceGame;

import java.util.List;

public class RaceController {

    private final RaceGame raceGame;

    public RaceController(List<Car> raceCars) {
        this.raceGame = new RaceGame(raceCars);
    }

    public void start(int count){
        for (int i = 0; i < count; i++) {
            raceGame.start();
            System.out.println();
        }
    }

    public void printWinningCar(){
        List<Car> winningCar = raceGame.getWinningCar();
        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winningCar.size() - 1; i++) {
            System.out.printf("%s, ", winningCar.get(i).getName());
        }
        System.out.println(winningCar.getLast().getName());
    }
}
