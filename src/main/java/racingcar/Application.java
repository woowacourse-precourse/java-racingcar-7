package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;


public class Application {
    public static void main(String[] args) {

        RaceManager raceManager = new RaceManager();
        List<String> strings = raceManager.setRacer();

        //입력한 문자열 리스트로 자동차 객체 리스트 만들기
        List<RacingCar> racingCars = new ArrayList<>();
        for (String carName : strings) {
            RacingCar newRacingCar = new RacingCar(carName);
            racingCars.add(newRacingCar);
        }

        int cycle = raceManager.setRaceCycle();

        raceManager.startRace(cycle, racingCars);

    }



}
