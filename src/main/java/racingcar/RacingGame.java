package racingcar;

import java.util.ArrayList;
import java.util.List;

import camp.nextstep.edu.missionutils.Randoms;


public class RacingGame {

    private static final int MIN_RANDOM_DIGIT = 0;
    private static final int MAX_RANDOM_DIGIT = 9;

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
     * 실행결과 출력 기능
     * */
    public void outputRaceResult(Car car){
        System.out.println(car.getName() + " : "+ "-".repeat(car.getMoveCount()));
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
     * 경주에 참가한 자동차들(RacingGame의 cars) 전진 메서드
     *  - 랜덤 값이 4이상일때만
     *    매 전진 시 실행 결과 출력
     */
    public void moveCars(int randomNumber){
        for(Car car : cars){
            car.move(randomNumber);
            outputRaceResult(car);
        }
        System.out.println();
    }

    /**
     * 사용자가 입력한 시도횟수만큼 전진을 반복하는 메서드
     * */
    public void raceByAttemptCount(int attemptCount, int randomNumber){
        System.out.println("실행 결과");
        for(int i = 0; i<attemptCount; i++){
            moveCars(randomNumber);
        }
    }

    /**
     * @return 0~9 사이 무작위 값 리턴
     * */
    public int getRandomNumber(){
        return Randoms.pickNumberInRange(MIN_RANDOM_DIGIT, MAX_RANDOM_DIGIT);
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
