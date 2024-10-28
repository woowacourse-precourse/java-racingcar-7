package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.Car;

import java.util.ArrayList;

public class GameService {
    private GameService() {}

    // 0 ~ 9 사이의 난수를 발생시킨다
    public static double makeRandNumberZeroToNine() {
        return Randoms.pickNumberInRange(0, 9);
    }

    // 발생된 난수를 매개변수로 받아 4 이상이라면 true 를 반환하여 자동차가 움직일 수 있음을 알린다
    public static boolean isAbleToMove(double randomNumber) {
        return randomNumber >= 4;
    }

    public static ArrayList<String> makeWinnerList(ArrayList<Car> carList) {
        ArrayList<String> winnerList = new ArrayList<>();
        int maxMileage = getMaxMileage(carList);
        chooseHighestMileageCars(winnerList, carList, maxMileage);

        return winnerList;
    }

    private static int getMaxMileage(ArrayList<Car> carList) {
        int max = 0;
        for(Car car : carList) {
            max = Math.max(max, car.getMileage());
        }

        return max;
    }

    private static void chooseHighestMileageCars(ArrayList<String> winnerList, ArrayList<Car> carList, int maxMileage) {
        for(Car car : carList) {
            putToWinnerListIfMax(winnerList, car, maxMileage);
        }
    }
    private static void putToWinnerListIfMax(ArrayList<String> winnerList, Car car, int maxMileage) {
        if(car.getMileage() == maxMileage) {
            winnerList.add(car.getCarName());
        }
    }
}