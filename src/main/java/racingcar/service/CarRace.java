package racingcar.service;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.List;

public class CarRace {

    private final static Integer tryNumRange = 100;
    private final static Integer fowardRange = 4;

    public void carRace(List<Car> carList){
        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryNumString = Console.readLine();
        validateTryNumConvert(tryNumString);

        System.out.println("실행결과");
        for(Car car : carList){
            carPositionRandom(car);
            carPositionPrint(carList);
        }

    }

    private void carPositionPrint(List<Car> carList) {
        for(Car car : carList){
            System.out.println(car);
        }
    }

    private void carPositionRandom(Car car) {
        int random = Randoms.pickNumberInRange(0, 9);
        if(random >= fowardRange){
            int position = car.getPosition();
            car.setPosition(++position);
        }
    }

    private void validateTryNumConvert(String tryNumString) {
        int tryNum = Integer.parseInt(tryNumString);
        validateTryNumRange(tryNum);
    }

    private void validateTryNumRange(int tryNum) {
        if(tryNum > tryNumRange)
            throw new IllegalArgumentException("error: 시도횟수 범위를 초과했습니다");
    }


}
