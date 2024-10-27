package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.List;

public class RaicingController {

    private InputView inputView;

    public void start() {
        //입력
        List<Car> cars = inputCars();
        //실행
        race(cars);


    }

    public List<Car> inputCars() {
        List<String> carNames = inputView.inputCarNames(); // 차이름 받기
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return cars;
    }

    public void race(List<Car> cars) {

        int maxRound = inputView.inputMaxRound();

        for (int round = 0; round <= maxRound; round++) {
            for (Car car : cars) {
                int num = Randoms.pickNumberInRange(0, 9);
                if (num >= 4) {
                    car.move();
                }


            }

        }
    }

    public void output() {

    }

}
