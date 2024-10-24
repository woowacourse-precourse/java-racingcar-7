package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
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
            if (token.length() > 5) throw new IllegalArgumentException("이름은 5자 이내여야해요.");
            this.cars.add(new Car(token));
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        round = Integer.parseInt(Console.readLine());
    }


    void run() {
        initMachine();


    }
}
