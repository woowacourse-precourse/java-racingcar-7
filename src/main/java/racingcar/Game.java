package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Game {

    private List<Car> cars;

    public Game() {
        OutputHandler.printInstructionForCarNames();
        List<String> carNames = InputHandler.getCarNames();

        OutputHandler.printInstructionForTimes();
        int times = InputHandler.getTimes();

        // 핵심 로직
        cars = new ArrayList<>();

        // 1. 객체 생성
        for(String carName : carNames) {
            cars.add(new Car(carName));
        }

        System.out.println();
        System.out.println("실행 결과");

        // 2. 반복문 돌면서 실행 한번씩 하기
        for(int i = 0; i < times; i++) {

            for(int j = 0; j < cars.toArray().length; j++) {

                Car car = cars.get(j);

                // 2-1. 각 객체에 대해 랜덤값 구하기
                int randomNumber = Randoms.pickNumberInRange(0, 9);

                // 2-2. 값이 4 이상이면 count 필드 1 증가
                if (randomNumber >= 4) {
                    car.increaseCount();
                }

                // 2-3. 현재 객체 결과 출력하기
                System.out.println(car.toString());
            }

            System.out.println();
        }

        // 3. 우승자 찾기
        List<Car> winnerCars = findWinnerCars();
        List<String> winnerNames = winnerCars.stream()
                .map(Car::getName)
                .collect(Collectors.toList());
        System.out.print("최종 우승자 : " + String.join(", ", winnerNames));

    }

    public List<Car> findWinnerCars() {
        List<Car> winnerCars = new ArrayList<>();
        int maxCount = Integer.MIN_VALUE;

        for (Car car : cars) {
            if (car.getCount() > maxCount) {
                maxCount = car.getCount();
                winnerCars.clear();
                winnerCars.add(car);
            } else if (car.getCount() == maxCount) {
                winnerCars.add(car);
            }
        }

        return winnerCars;
    }
}
