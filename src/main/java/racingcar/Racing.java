package racingcar;

import java.util.List;

public class Racing {

    public void race() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        List<Car> carList = Cars.getCarList();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int tryNumber = User.getTryNumber();

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < tryNumber; i++) {
            printPosition(carList);
            System.out.println();
        }

        System.out.println("최종 우승자 : " + Winner.printWinner(carList));
    }

    private static void printPosition(List<Car> carList) {
        for (Car car : carList) {
            car.move();
            String output = "-";
            System.out.println(car.getCarName() + " : " + output.repeat(car.getPosition()));
        }
    }
}
