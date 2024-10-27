package racingcar;

import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;

public class CarRacing {

    public List<Car> settingCar(String[] carNames){
        List<Car> carList = new ArrayList<>();

        for (String carName : carNames) {
            Car car = new Car(carName);
            carList.add(car);
        }

        return carList;
    }

    public int racing(List<Car> carList, int numberOfMoves) {
        int maxLocation = 0;
        for (int i = 0; i < numberOfMoves; i++) {
            for (Car car : carList) {
                moveCar(car);
                printCarLocation(car);
                maxLocation = Math.max(maxLocation, car.getLocation());
            }
            System.out.println();
        }
        return maxLocation;
    }

    public void moveCar(Car car) {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            car.move();
        }
    }

    public void printCarLocation(Car car) {
        int location = car.getLocation();
        System.out.print(car.getName() + " : ");
        for (int i = 0; i < location; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    public List<String> getCarNamesAtLocation(List<Car> carList, int location){
        List<String> carNames = new ArrayList<>();
        for (Car car : carList) {
            if (car.getLocation() == location) {
                carNames.add(car.getName());
            }
        }
        return carNames;
    }
}
