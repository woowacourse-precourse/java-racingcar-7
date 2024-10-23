package service;

import camp.nextstep.edu.missionutils.Randoms;
import domain.Car;
import java.util.ArrayList;
import java.util.List;

public class RacingService {
    public List<Car> getCarsList(String input) {
        String[] names = input.split(",");

        List<Car> carsList = new ArrayList<>();
        for (String name : names) {
            carsList.add(new Car(name));
        }

        return carsList;
    }


    public void moveCars(List<Car> carsList) {
        for (Car car : carsList) {
            int randomNumber = getRandomNumber();
            if (randomNumber >= 4) {
                car.addScore();
            }
        }
    }

    private int getRandomNumber() {
        return Randoms.pickNumberInRange(0, 9);
    }

}
