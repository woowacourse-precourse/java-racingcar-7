package racingcar;

public class GameResult {
    // 게임의 결과 과정 처리, 라운드 출력, 우승자 결정
    static void printRoundResult(List<racingcar.Car> cars) {
        // 각 라운드 결과 출력
        for (racingcar.Car car : cars) {
            System.out.println(car.getName() + " : " + "-".repeat(car.getCount()));
        }
        System.out.println();
    }
}
