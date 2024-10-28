package racingcar.service;

import racingcar.model.Car;
import racingcar.repository.CarRepository;
import racingcar.view.InputView;
import racingcar.view.OutputView;

import java.util.Arrays;
import java.util.regex.Pattern;

import static racingcar.util.RandomNumberGenerator.generate;

/**
 * 해당 클래스는 레이싱 게임의 서비스를 담당하는 클래스입니다.
 *
 * @version 1.0
 */
public class RacingService {
    private final InputView inputView;
    private final OutputView outputView;
    private final CarRepository carRepository;
    private static final String NAME_PATTERN = "^([^,]{1,5})(,([^,]{1,5}))*$";

    public RacingService(InputView inputView,
                         OutputView outputView,
                         CarRepository carRepository
    ) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.carRepository = carRepository;
    }

    /**
     * 레이싱 게임을 실행합니다.
     */
    public void run() {
        // 자동차 이름을 입력받습니다.
        String input = inputView.inputCarNames();
        // 시도 횟수를 입력받습니다.
        int round = inputView.inputTryCount();

        // 자동차 이름이 유효한지 검증합니다.
        if (!validateCarNames(input)) {
            throw new IllegalArgumentException("[ERROR] 자동차 이름은 1자 이상 5자 이하만 가능합니다.");
        }

        // 중복된 자동차 이름이 존재하는지 확인합니다.
        if (isDuplicateCarNames(input)) {
            throw new IllegalArgumentException("[ERROR] 중복된 자동차 이름이 존재합니다.");
        }

        // 자동차 객체를 저장소에 저장합니다.
        joinCars(input.split(","));

        // 레이싱 게임을 실행합니다.
        for(int i = 0; i < round; i++) {
            play();
            outputView.printCarNameWithPosition(carRepository.findAll());
            outputView.printNewLine();
        }

        // 최종 우승자를 출력합니다.
        outputView.printFinalWinnerGuide();
        outputView.printWinner(findWinner(round));

    }

    /**
     * 자동차 이름이 유효한지 검증합니다.
     *
     * @param carNames 자동차 이름
     * @return 유효한 자동차 이름인지 여부
     */
    private boolean validateCarNames(String carNames) {
        return Pattern.matches(NAME_PATTERN, carNames);
    }

    /**
     * 중복된 자동차 이름이 존재하는지 확인합니다.
     *
     * @param carNames
     * @return
     */
    private boolean isDuplicateCarNames(String carNames) {
        String[] names = carNames.split(",");

        return Arrays.stream(names)
                     .distinct()
                     .count() != names.length;
    }

    /**
     * 자동차 객체를 저장소에 저장합니다.
     *
     * @param carNames
     */
    private void joinCars(String[] carNames) {
        for (String name : carNames) {
            carRepository.save(new Car(name));
        }
    }

    /**
     * 최종 우승자를 찾습니다.
     *
     * @param maxPosition
     * @return
     */
    private String[] findWinner(int maxPosition) {
        return carRepository.findAll()
                            .stream()
                            .filter(car -> car.getPosition() >= maxPosition)
                            .map(Car::getName)
                            .toArray(String[]::new);
    }

    /**
     * 4 이상의 랜덤 숫자가 나오면 자동차를 이동시킵니다.
     */
    private void play() {
        carRepository.findAll()
                     .stream()
                     .filter(car -> generate() >= 4)
                     .forEach(Car::move);
    }

}
