package racingcar.controller;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarList;

public class RacingGameController {
    private final CarList carList;
    public RacingGameController(){
        this.carList = new CarList();
    }

    public void addCars(String input){
        String[] carNames = input.split(",");
        for(String name: carNames) {
            Car car = new Car(name.trim());
            carList.add(car);
        }
    }

    public void race(){
        for(Car car: carList.getCars()){
            car.move(Randoms.pickNumberInRange(0, 9));
        }
    }

}
