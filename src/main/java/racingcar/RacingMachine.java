package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class RacingMachine {
    List<Car> cars;
    int round;

    public RacingMachine() {
        this.cars = new ArrayList<>();
        round = 0;
    }

    private void initMachine() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String[] tokens = Console.readLine().split(",");
        for ( String token : tokens ) {
            if (token.length() > 5) throw new IllegalArgumentException("이름은 5자 이내여야 해요.");
            this.cars.add(new Car(token));
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        round = Integer.parseInt(Console.readLine());
    }

    private void racingStart() {
        for ( int i = 0; i < round; i++ ) {
            for ( Car car : cars ) {
                if ( Randoms.pickNumberInRange(0, 9) >= 4 ) {
                    car.goAhead();
                }
            }

            System.out.println("실행 결과");
            for ( Car car : cars ) {
                StringBuilder roundResult = new StringBuilder(car.getName()).append(" : ");
                roundResult.append("-".repeat(Math.max(0, car.getPos())));
                System.out.println(roundResult);
            }
            System.out.println();
        }
    }

    private void result() {
        StringBuilder racingResult = new StringBuilder("최종 우승자 : ");
        Collections.sort(cars);
        Car temp = cars.removeFirst();
        int max = temp.getPos();
        racingResult.append(temp.getName());
        for ( Car car : cars ) {
            if ( car.getPos() == max ) {
                racingResult.append(", ").append(car.getName());
            }
        }

        System.out.println(racingResult);
    }

    void run() {
        initMachine();
        racingStart();
        result();
    }
}
