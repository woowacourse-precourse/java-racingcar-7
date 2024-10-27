package racingcar.controller;

import racingcar.domain.Car;
import racingcar.service.CarService;

import java.util.List;

public class CarController {

    private final CarService carService;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    public void startRace() {
        createRace();
        raceRound(getCount());
        raceOver();
    }

    private void createRace() {
        List<String> carsName = null; //inputView에서 차량 이름 받는 부분

        carsName.forEach(name -> {
            Car car = new Car(name);
            carService.joinCar(car);
        });
    }

    private int getCount() {
        return 0; // inputView에서 count 받는 부분
    }

    private void raceRound(int count) {
        //실행결과 출력

        for (int i = 0; i < count; i++) {
            carService.moveCar();
            // 매 라운드 결과 출력
        }
    }

    private void raceOver() {
        List<String> winners = carService.findWinners();
        //승자 출력 (List 형태로 매개변수 사용)
    }

}
