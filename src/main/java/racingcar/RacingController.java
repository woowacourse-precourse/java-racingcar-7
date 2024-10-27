package racingcar;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;
import static racingcar.View.*;

public class RacingController {
    // 자동차 등록
    public static List<Car> carRegistration() throws Exception {

        String[] carNames = enterCarNames().split(",");
        List<Car> cars = new ArrayList<>();

        for (String carName : carNames) {
            countingLettersForCars(carName);
            Car car = new Car(carName, "");
            cars.add(car);
        }
        return cars;
    }

    // 잘못된 자동차 등록 파악
    public static void countingLettersForCars(String carName) throws Exception {
        if(carName.length() > 5) throw new IllegalArgumentException();
    }

    // 시도 횟수 등록
    public static int registerNumberOfAttempts() throws Exception{
        return enterNumberOfAttempts();
    }

    // 전진 조건 설정
    public static boolean decidingWhetherToMoveForward() {
        return pickNumberInRange(0, 9) >= 4;
    }

    // 경주 진행 하기
    public static void raceProgress() throws Exception {
        List<Car> cars = carRegistration();
        int counts = registerNumberOfAttempts();

        outputExecutionResultComment();
        for(int i = 0; i < counts; i++) {
            for(Car car : cars) {
                if(decidingWhetherToMoveForward()) car.setCar(car.getTravelDistance() + "-");
            }

            for(Car car : cars) {
                gameProgressOutput(car);
            }
            System.out.println();
        }

        findingAWinner(cars);
    }

    // 최종 우승자 구하기
    public static void findingAWinner(List<Car> cars) {
        int finalDistance = 0;
        List<Car> winners = new ArrayList<>();
        for(Car car : cars) {
            if(finalDistance < car.getTravelDistance().length()) finalDistance = car.getTravelDistance().length();
        }

        for(Car car : cars) {
            if(car.getTravelDistance().length() == finalDistance) {
                winners.add(car);
            }
        }

        if(winners.size() > 1) {
            jointWinnersAnnounced(winners);
        } else soloWinnerAnnouncement(winners);
    }
}
