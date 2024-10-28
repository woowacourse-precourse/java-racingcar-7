package racingcar;

import racingcar.feature.InputInfo;
import racingcar.feature.ProduceCar;
import racingcar.feature.Race;
import racingcar.feature.Winner;
import racingcar.obj.Car;

import java.util.List;

public class RacingCar {

    InputInfo inputInfo;
    ProduceCar produceCar;
    Race race;
    Winner winner;

    public RacingCar() {
        inputInfo = new InputInfo();
        produceCar = new ProduceCar();
        race = new Race();
        winner = new Winner();
    }

    public void run() {
        String[] carsName = inputInfo.getCarsName();
        int time = inputInfo.getTime();
        List<Car> cars = produceCar.getCars(carsName);
        race.startRace(cars,time);
        winner.getWinner(cars);
    }

}
