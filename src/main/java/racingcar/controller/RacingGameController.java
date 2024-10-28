package racingcar.controller;
import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;
import racingcar.domain.CarList;

import java.util.List;

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
    // 판마다의 결과 보여주기
    public String[] getResult(){
        List<Car> racingCars = carList.getCars();
        String[] cur_results = new String[racingCars.size()];

        for(int i = 0; i < racingCars.size(); i++){
            Car car = racingCars.get(i);
            cur_results[i] = car.getName() + " : " + car.getPositionDisplay();
        }
        return cur_results;
    }
    public String[] getWinners() {
        List<String> winners = carList.getWinners();
        return winners.toArray(new String[0]);
    }
}
