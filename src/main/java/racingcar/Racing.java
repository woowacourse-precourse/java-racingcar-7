package racingcar;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.stream.Collectors;

/**
 * 경주 관련 로직 처리를 담당하는 클래스
 */
class Racing {
    /**
     * 이름 arraylist를 입력받아 car object를 반환
     * @param carNames 차 이름의 arraylist
     * @return 이름이 각 arraylist의 원소이고 위치가 0인 차들의 arraylist
     */
    static ArrayList<Car> generateCars(ArrayList<String> carNames) {
        ArrayList<Car> cars = new ArrayList<Car>();
        for (String name : carNames) {
            cars.add(new Car(name, 0));
        }
        return cars;
    }

    /**
     * 차가 움직이는 조건을 구현
     * @return 움직인다면 true
     */
    static boolean moveCondition() {
        int random = Randoms.pickNumberInRange(0, 9);
        return random >= 4;
    }

    /**
     * 차의 움직임을 구현 (한 칸 전진)
     * @param car 차 object
     */

    static void move(Car car) {
        car.position += 1;
    }

    /**
     * 1회의 움직임을 구현
     * moveCondition을 만족하면 move 수행한 뒤
     * 각각의 위치를 print
     * 구분을 위해 한 줄 띄어쓰기
     * @param cars 차 object의 arraylist
     */
    static void race(ArrayList<Car> cars) {
        for (Car car : cars) {
            if (moveCondition()) {
                move(car);
            }
            Print.position(car);
        }
        Print.newLine();
    }

    /**
     * position의 arraylist에서 최댓값 반환
     * @param positions position의 arraylist
     * @return max(positions)
     */
    static Integer getMaxPosition(ArrayList<Integer> positions) {
        return positions.stream()
                .max(Comparator.comparing(x -> x))
                .orElse(0);
    }

    /**
     * 차 arraylist에서 우승자 목록을 arraylist로 반환
     * @param cars 차 arraylist
     * @return 우승자 목록 arraylist
     */
    static ArrayList<String> getWinners(ArrayList<Car> cars) {
        ArrayList<Integer> positions = new ArrayList<Integer>();
        for (Car car : cars) {
            positions.add(car.position);
        }

        Integer maxPosition = Racing.getMaxPosition(positions);

        ArrayList<String> winners = cars.stream()
                .filter(x -> x.position == maxPosition)
                .map(x -> x.name)
                .collect(Collectors.toCollection(ArrayList::new));

        return winners;
    }

}
