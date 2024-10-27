package racingcar;

import java.util.ArrayList;
import java.util.List;
import camp.nextstep.edu.missionutils.Console;


public class RacingGame {
    private final CarNameParser carNameParser;
    private final AttemptCountParser attemptCountParser;
    private int attemptCount;

    // 경주에 참가한 자동차 리스트
    private final List<Car> cars = new ArrayList<>();

    public RacingGame(CarNameParser carNameParser, AttemptCountParser attemptCountParser){
        this.carNameParser = carNameParser;
        this.attemptCountParser = attemptCountParser;
    }

    /**
     * 자동차 객체들을 생성하고 자동차 리스트에 추가하는 객체
     * */
    public void addCars(List<String> validatedCarNames){
        for(String carName : validatedCarNames){
            cars.add(new Car(carName));
        }
    }


    /**
     * 사용자가 시도할 횟수를 입력받는 메서드
     **/
    public void getAttemptCount(){
        this.attemptCount = attemptCountParser.getAttemptCount();
    }

    /**
     * 입력받은 자동차 이름 리스트를 반환하는 메서드
     * */
    public List<String> getValidatedCarNames(){
        String input = carNameParser.inputCarNames();
        String[] splitCarName = carNameParser.splitCarNamesByComma(input);

        return carNameParser.getValidatedCarNames(splitCarName);
    }

    public List<Car> getCars() {
        return cars;
    }
}
