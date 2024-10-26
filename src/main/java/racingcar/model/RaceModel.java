package racingcar.model;

import java.util.ArrayList;
import java.util.List;

public class RaceModel {

    private CarRace carRace;

    /**
     * 자동차 이름 리스트를 받아 CarRace의 자동차를 초기화하는 메서드
     */
    public void initializeCars(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        for (String carName : carNames) {
            Car car = new Car(carName);
            cars.add(car);
        }
        // 의존성 주입
        this.carRace = new CarRace(cars);
    }

    /**
     * 경주를 시도하는 메서드. 각 자동차를 무작위로 이동시키고 결과를 반환.
     */
    public void executeRaceRound() {
        carRace.race();
    }

    /**
     * 현재 자동차들의 상태를 반환하는 메서드
     */
    public List<Car> getCurrentRaceStatus() {
        return carRace.getCars();
    }

    /**
     * 우승자 계산 및 반환
     */
    public List<String> getWinners() {
        return carRace.findWinners();
    }
}
