package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;

public class Race {

    private final Car[] cars;

    public Race(Car[] cars) {
        this.cars = cars;
    }

    public void start() {
        for (Car car : cars) {
            if (Randoms.pickNumberInRange(0, 9) >= 4) {
                car.advance();
            }
        }
    }


    public Car[] getCars() {
        return cars;
    }

    public String findWinners() {
        StringBuilder winner = new StringBuilder();
        int maxDistance = 0;

        for (Car car : cars) {
            int currentDistance = car.getDistance().length();
            if (currentDistance > maxDistance) {
                maxDistance = currentDistance;
                winner.setLength(0);
                winner.append(car.getName());
            } else if (currentDistance == maxDistance) {
                winner.append(",").append(car.getName());
            }
        }

        //최대거리가 0일 때는 공동 우승자 첫번째 사람앞에 ,이 붙으므로 삭제해준다.
        if (maxDistance == 0) {
            winner.deleteCharAt(0);
        }

        return winner.toString();
    }
}
