package racingcar.controller;

import java.util.ArrayList;
import racingcar.domain.Car;
import racingcar.model.Race;
import racingcar.view.RaceView;

public class RaceController {
    private RaceView raceView;
    private Race race;

    public RaceController() {
        this.raceView = new RaceView();
    }

    public void startRace() {
        // 사용자 입력을 받아 Car 리스트 생성
        ArrayList<String> carNameList = raceView.inputCarsName();
        ArrayList<Car> cars = new ArrayList<>();
        for (String carName : carNameList) {
            cars.add(new Car(carName));
        }

        // 시도 횟수 입력
        int N = raceView.inputTryTime();

        // 경기 시작
        race = new Race(cars);

        System.out.println("실행 결과");
        for (int i = 0; i < N; i++) {
            race.runRace();
            raceView.printRace(race.getCars());
        }

        raceView.printWinners(race.getWinners());
    }
}
