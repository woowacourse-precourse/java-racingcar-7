package racingcar.model;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;

public class Car {
    private final String name;
    private Integer distance = 0;

    public Car(String name) {
        this.name = name;
    }

    public String formatName() {
        return this.name;
    }

    public String formatDistance() {
        return "-".repeat(this.distance);
    }

    public void randForward() {
        if (Randoms.pickNumberInRange(0, 9) >= 4) {
            this.distance++;
        }
    }

    public boolean isFarther(Car car) {
        return this.distance > car.distance;
    }

    public static ArrayList<String> parseWinnerNames(ArrayList<Car> cars) {
        Car farthestCar = cars.getFirst(); // 가장 distance 값이 큰 Car를 저장할 변수

        for (Car car : cars) {
            if (car.isFarther(farthestCar)) { // 순회중인 Car의 distance가 현재까지 가장 distance가 큰 Car보다 크다면
                farthestCar = car; // 가장 distance가 큰 Car로 지정
            }
        }

        Integer farthestDistance = farthestCar.distance; // 가장 큰 distance 값을 저장
        ArrayList<String> names = new ArrayList<>();

        for (Car car : cars) {
            if (car.distance == farthestDistance) { // 순회중인 Car의 distance가 가장 큰 값과 같다면
                names.add(car.name); // 이름 배열에 현재 Car의 이름을 추가함
            }
        }

        return names;
    }
}
