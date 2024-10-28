package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Game {

    public Game() {
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();

        // 핵심 로직
        List<Car> cars = new ArrayList<>();

        // 1. 객체 생성
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        // 2. 반복문 돌면서 실행 한번씩 하기
        for(int i = 0; i < times; i++) {

            for(int j = 0; j < cars.toArray().length; j++) {

                Car car = cars.get(j);

                // 2-1. 각 객체에 대해 랜덤값 구하기
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                // 2-2. 값이 4 이상이면 count 필드 1 증가
                if (randomNumber >= 4) {
                    car.increaseCount();
                }
            }

        }

    }
}
