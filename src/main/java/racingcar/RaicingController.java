package racingcar;

import java.util.List;

public class RaicingController {

    private InputView inputView;

    public void start() {
        //입력
        List<Car> cars = inputCars();
        //실행
        

    }

    public List<Car> inputCars() {
        List<String> carNames = inputView.inputCarNames(); // 차이름 받기
        List<Car> cars = carNames.stream()
                .map(Car::new)
                .toList();

        return cars;
    }

    public void execute() {

    }

    public void output() {

    }

}
