package racingcar;


public class Car {
    CarList carList = new CarList();

    public void addCar(String carNames) {
        for(String carName : carNames.split(",")) {
            carList.add(carName);

        }
    }
}
