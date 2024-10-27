package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class RacingCarView {
    public List<String> getCarInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameList = Console.readLine();
        return List.of(carNameList.split(","));
    }
    public int getTryCountInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryCount = Integer.parseInt(Console.readLine());
        if (tryCount <= 0) {
            throw new IllegalArgumentException("최소 한 번 이상 시도해야 합니다.");
        }
        // 게임 로직
        return tryCount;
    }
    public void printRaceStatus(Car car) {
        int index = car.getPosition();
        System.out.print(car.getName()+" : ");
        for (int i = 0; i < index; i++) {
            System.out.print("-");
        }
        System.out.println();
    }

    // 최종 우승자 출력
    public void printLastWinner(List<Car> winners) {
        System.out.print("최종 우승자 : ");
        System.out.println(String
                .join(", ", winners.stream()
                .map(Car::getName)
                .toArray(String[]::new)));
    }
}
