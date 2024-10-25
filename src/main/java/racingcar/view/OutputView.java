package racingcar.view;

import java.util.List;
import racingcar.domain.Car;

public class OutputView {
    public void displayWinner(List<Car> winners) {
        String winnerNames = String.join(", ", winners.stream().map(Car::getCarName).toArray(String[]::new));

        /*
         * map 메서드를 통해 자동차의 이름을 담은 String Stream을 생성
         * toArray 메서드를 통해 각 자동차의 이름을 String 배열에 저장
         * String.join 메서드를 통해 저장된 String 배열을 쉼표를 구분자로 하여 하나의 문자열로 결합
         * */

        System.out.println("최종 우승자 : " + winnerNames);
    }

    public void displayRound(List<Car> cars) {
        cars.stream().map(car -> car.getCarName() + " : " + "-".repeat(car.getPresentLocation()))
                .forEach(System.out::println);
        System.out.println();
    }

    public void displayGameStart() {
        System.out.println("실행 결과");
    }
}
