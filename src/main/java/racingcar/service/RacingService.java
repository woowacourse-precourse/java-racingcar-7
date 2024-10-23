package racingcar.service;

import racingcar.model.Car;

public class RacingService {
    private static Car[] carList; // 자동차 목록을 저장할 배열

    public static void setupRacing(String cars, String moveCount) {
        String[] racingCars = cars.split(",");
        carList = new Car[racingCars.length];
        int count = 0;
        for (String carName : racingCars) {
            if (!carName.isEmpty()) {
                carList[count] = new Car(carName, moveCount); // 배열에 자동차 추가
                count++;
            }
        }
    }

    private static Car[] getCars() {
        // 현재 자동차 배열을 반환
        return carList; // 자동차 배열 반환
    }

}