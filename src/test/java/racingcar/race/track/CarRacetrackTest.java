package racingcar.race.track;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racingcar.race.MockCar;
import racingcar.race.racer.car.Car;
import racingcar.race.track.cartrack.CarRaceUtils;
import racingcar.race.track.cartrack.CarRacetrack;

class CarRacetrackTest {

    CarRacetrack carRacetrack;
    CarRaceUtils carRaceUtils;

    @BeforeEach
    void 경기장_생성() {
        String[] names = {"pobi,woni,jun"};
        int repeat = 6;
        carRacetrack = new CarRacetrack(names, repeat);
        carRaceUtils = new CarRaceUtils();
    }

    @Test
    void 모든_전진_시도() {
        boolean hasMoved = false;

        // 이동하기 이전 위치 저장
        ArrayList<Integer> beforePosition = new ArrayList<>();
        for (Car car : carRacetrack.getCars()) {
            beforePosition.add(car.getDistance().length());
        }

        // 모든 객체 6번 이동
        for (int i=0; i<carRacetrack.getRepeat(); i++){
            carRaceUtils.moveAll(carRacetrack.getCars());
        }

        // 이동한 이후 위치 저장
        ArrayList<Integer> afterPosition = new ArrayList<>();
        for (Car car : carRacetrack.getCars()) {
            afterPosition.add(car.getDistance().length());
        }

        // 이동하기 이전 위치와 이후 위치를 비교했을 때 한 객체라도 위치가 달라졌으면 테스트 통과
        for (int i=0; i<beforePosition.size(); i++) {
            if (beforePosition.get(i) != afterPosition.get(i)) {
                hasMoved = true;
            }
        }
        assertTrue(hasMoved);
    }

    @Test
    void 우승자_찾기() {
        List<Car> cars = new ArrayList<>();
        cars.add(new MockCar("pobi", "----"));
        cars.add(new MockCar("woni", "--"));
        cars.add(new MockCar("jun", "----"));

        List<String> winner = carRaceUtils.findWinner(cars);

        List<String> expected = new ArrayList<>();
        expected.add("pobi");
        expected.add("jun");

        assertEquals(expected, winner);

    }

}