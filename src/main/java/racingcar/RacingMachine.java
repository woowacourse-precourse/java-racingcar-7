package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RacingMachine {
    List<Car> cars;
    int round;

    public RacingMachine() {}

    void run() {
        initialization();
        racing();
        printResult();
    }

    private void initialization() {
        initCars();
        initRound();
    }

    private void racing() {
        System.out.println("실행 결과");
        for ( int i = 0; i < round; i++ ) {
            rollTheDice();
            printScore();
        }
    }

    private void printResult() {
        List<Car> winners = getResult();

        StringBuilder racingResult = new StringBuilder("최종 우승자 : ");
        boolean isFirst = true;
        for (Car car : winners) {
            if (isFirst) {
                racingResult.append(car.getName());
                isFirst = false;
            } else {
                racingResult.append(", ").append(car.getName());
            }
        }

        System.out.println(racingResult);
    }

    private void initCars() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        cars = new ArrayList<>();
        String[] names = InputHandler.readInputName();
        for ( String name : names ) {
            this.cars.add(new Car(name));
        }
    }

    private void initRound() {
        System.out.println("시도할 횟수는 몇 회인가요?");

        round = InputHandler.readInputRound();
    }

    private void rollTheDice() {
        for ( Car car : cars ) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.goAhead();
            }
        }
    }

    private void printScore() {
        for ( Car car : cars ) {
            StringBuilder roundResult = new StringBuilder(car.getName()).append(" : ");
            roundResult.append("-".repeat(car.getPos()));
            System.out.println(roundResult);
        }
        System.out.println();
    }

    private List<Car> getResult() {
        int winnerPos = Collections.max(cars, Comparator.comparingInt(Car::getPos)).getPos();
        List<Car> winners = new ArrayList<>();

        for ( Car car : cars ) {
            if ( car.getPos() == winnerPos ) {
                winners.add(car);
            }
        }

        return winners;
    }
}
