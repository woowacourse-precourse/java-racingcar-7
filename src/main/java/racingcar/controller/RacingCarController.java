package racingcar.controller;

import racingcar.model.Car;
import racingcar.view.RacingCarView;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import camp.nextstep.edu.missionutils.Randoms;

public class RacingCarController {
    private final RacingCarView view;

    public RacingCarController(RacingCarView racingCarView) {
        this.view = racingCarView;
    }

    public void play() {
        try {
            List<String> carNameList = view.getCarInput();
            List<Car> carList = createCarList(carNameList);

            int tryCount = view.getTryCountInput();

            for (int i = 0; i < tryCount; i++) {
                takeTurnOnce(carList);
            }
            List<Car> winners = setWinner(carList);
            view.printLastWinner(winners);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    private List<Car> setWinner(List<Car> carList) {
        List<Car> maxCar = new ArrayList<>();
        maxCar.add(carList.getFirst());
        for(int i = 1; i < carList.size(); i++) {
            if (carList.get(i).getPosition() > maxCar.getFirst().getPosition()) {
                maxCar.clear();
                maxCar.add(carList.get(i));
            } else if (carList.get(i).getPosition() == maxCar.getFirst().getPosition()) {
                maxCar.add(carList.get(i));
            }
        }
//        int maxPosition = carList.stream()
//                .mapToInt(Car::getPosition)
//                .max()
//                .orElse(0);
//
//        // 2. 최댓값과 같은 위치에 있는 자동차들을 maxCar에 추가
//        for (Car car : carList) {
//            if (car.getPosition() == maxPosition) {
//                maxCar.add(car);
//            }
//        }
        return maxCar;
    }

    private void takeTurnOnce(List<Car> carList) {
        for(Car car : carList) {
            int randomValue = Randoms.pickNumberInRange(0, 9);
            car.move(randomValue);
            view.printRaceStatus(car);
        }
        System.out.println();
    }

    // Car 객체 리스트 생성 함수
    private static List<Car> createCarList(List<String> carNames) {
        Set<String> checkUniqueName = new HashSet<>(); // 중복 이름 체크를 위함
        List<Car> cars = new ArrayList<>();

        for (String name : carNames) {
            if (!checkUniqueName.add(name)) { // 추가되지 않으면 중복 발생
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다: " + name);
            }
            cars.add(new Car(name));
        }
        return cars;
    }
}
