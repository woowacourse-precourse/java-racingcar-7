package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class RacingController {
    private final RacingInputView inputView;
    private final RacingOutputView outputView;

    public RacingController(RacingInputView inputView, RacingOutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }
    public String[] splitCarNames(String RacingCarNames) {
        return RacingCarNames.split(",");
    }
    private String[] trimCarNames(String[] carNames) {
        String[] trimNames = new String[carNames.length];
        for(int i = 0 ; i < carNames.length ;i++) {
            trimNames[i] = carNames[i].trim();
        }
        return trimNames;
    }

    public String[] finalGetCarsNames() {
        String inputCarNames = inputView.RacingCarNames();
        String[] carNames = splitCarNames(inputCarNames);
        return trimCarNames(carNames);
    }

    private int getRoundRacing() {
        return inputView.RacingRoundCount();
    }
    private void validateCarNames(String[] carNames) {
        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름의 길이는 5글자 이하여야 합니다.");
            }
        }
    }
    public void RacingRun() {
        try {
            String[] carNames = finalGetCarsNames();
            int RacingRounds = getRoundRacing();
            validateCarNames(carNames);

            List<Car> cars = new ArrayList<>();

            for (String name : carNames) {
                cars.add(new Car(name, 0));
            }
            runRace(cars, RacingRounds);
        }catch (IllegalArgumentException e) {
            System.out.println("오류" + e.getMessage());
        }
    }
    private void runRace(List<Car> cars, int rounds) {
        for (int i = 0 ; i < rounds ; i++) {
            for (Car car : cars) {
                car.canMove();
            }
            outputView.printStatus(cars);
        }
    }
}
