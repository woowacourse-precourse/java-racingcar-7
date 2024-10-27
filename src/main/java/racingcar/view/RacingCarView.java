package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.model.Car;

import java.util.List;

public class RacingCarView {

    public String[] readCarName() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine().split(",");
    }

    public int readNum() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Integer.parseInt(Console.readLine());
    }

    public void printStarting() {
        System.out.println("실행 결과");
    }

    public void printEachGame(List<Car> cars) {
        for (Car car : cars) {
            System.out.println(car.getName() + " : " + getStringPosition(car.getPosition()));
        }
        System.out.println();
    }

    private String getStringPosition(int position) {
        return "-".repeat(position);
    }

    public void printWinners(List<Car> cars) {
        System.out.print("최종 우승자 : ");

        StringBuilder winners = new StringBuilder();

        for (int i = 0; i < cars.size(); i++) {
            Car car = cars.get(i);
            winners.append(car.getName());

            if (i < cars.size() - 1) {
                winners.append(", ");
            }
        }

        System.out.println(winners);
    }

}
