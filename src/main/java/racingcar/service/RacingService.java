package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.Cars;

public class RacingService {

    public static void doRacing(Cars cars){
        for (Car car: cars.getRacingCars()) {
            moveCar(car,isMove(getRandomNumber()));
        }
    }

    public static void moveCar(Car car,boolean state){
        if (state){
            car.moveForward();
            car.displayNowResult();
        }
    }

    public static boolean isMove(int randomValue){
        return randomValue >= 4;
    }

    private static int getRandomNumber(){
        return Randoms.pickNumberInRange(0, 9);
    }


}
