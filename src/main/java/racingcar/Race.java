package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Race {

    private final List<Car> list;
    private final StringBuilder sb;

    public Race() {
        this.list = new ArrayList<>();
        this.sb = new StringBuilder("\n실행 결과");
    }

    public void run() {

        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String cars = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        String count = Console.readLine();

        if (!inputCheck(cars, count)) {
            throw new IllegalArgumentException();
        }

        String[] names = cars.split(",");
        int n = Integer.parseInt(count);

        for (String name : names) {
            list.add(new Car(name, 0));
        }

        sb.append("\n");
        for (int i = 0; i < n; i++) {
            moveCars();
        }

        findWinners();

        System.out.println(sb);
    }

    private boolean inputCheck(String cars, String count) {

        String pattern = "^[a-zA-Z가-힣0-9]{1,5}(,[a-zA-Z가-힣0-9]{1,5})*$";

        return cars.matches(pattern) && count.matches("\\d");
    }

    private void moveCars() {

        for (Car car : list) {
            car.move();
            sb.append(car.getExecutionResult()).append("\n");
        }

        sb.append("\n");
    }

    private void findWinners() {

        int maxPosition = 0;

        for (Car car : list) {

            if (car.getPosition() > maxPosition) {
                maxPosition = car.getPosition();
            }
        }

        sb.append("최종 우승자 : ");
        for (Car car : list) {
            if (car.getPosition() == maxPosition) {
                sb.append(car.getName()).append(", ");
            }
        }
        sb.delete(sb.length() - 2, sb.length());
    }
}
