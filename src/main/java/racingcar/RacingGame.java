package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import racingcar.domain.Car;
import racingcar.repository.CarRepository;
import racingcar.repository.RacingCarRepository;
import racingcar.service.CarService;
import racingcar.service.RacingCarService;
import racingcar.util.CarNameValidator;
import racingcar.util.RacingCarInput;
import racingcar.util.RacingCarOutput;

public class RacingGame {

    // Todo: 생성자로 초기하는게 좋은 것인가?
    private final static CarRepository carRepository = new RacingCarRepository();
    private final static CarService carService = new RacingCarService(carRepository);
    private final static RacingCarInput racingCarInput = new RacingCarInput();
    private final static RacingCarOutput racingCarOutput = new RacingCarOutput();

    public void start() {

        // 입력
        String[] cars = racingCarInput.inputCarNames();
        if (cars.length == 0) {
            throw new IllegalArgumentException("자동차 이름이 없습니다.");
        }
        int tryCount = racingCarInput.inputTryCount();

        // 등록
        for (String car : cars) {
            // Todo: 검증을 Validator 안에서 하는게 좋은지
            if (CarNameValidator.isValid(car)) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
            }
            carService.register(new Car(car));
        }

        // 조회
        List<Car> carList = carService.getAllCars();

        System.out.println();
        System.out.println("실행 결과");

        // 실행
        for (int i = 0; i < tryCount; i++) {
            move();
            racingCarOutput.printRoundResult(carList);
        }

        // 우승자 출력
        racingCarOutput.printWinner(carList);
    }

    public void move() {

        for (Car car : carService.getAllCars()) {
            int moveCondition = Randoms.pickNumberInRange(0, 9);
            if (moveCondition >= 4) {
                car.move();
            }
        }
    }
}
