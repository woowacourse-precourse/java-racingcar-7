package racingcar.Service;

import racingcar.Car;
import camp.nextstep.edu.missionutils.Randoms;

public class CarService {
    public Car[] convertToCar(String[] carNames){
        int carLen = carNames.length;
        Car[] cars = new Car[carLen];
        for(int i = 0; i < carLen; i++){
            Car car = new Car(carNames[i],0);
            cars[i] = car;
        }
        return cars;
    }

    public void startRace(Car[] cars){
        for(Car car: cars){
            int rnd = Randoms.pickNumberInRange(0,9);
            if(rnd>=4) car.goFront();
        }
    }


}
