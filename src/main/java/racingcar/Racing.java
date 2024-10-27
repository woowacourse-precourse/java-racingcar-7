package racingcar;

import camp.nextstep.edu.missionutils.Console;
import java.util.ArrayList;
import java.util.List;

public class Racing {


    public void start() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String input = Console.readLine();

        String[] carNameList = input.split(",", -1);

        List<Car> carList = new ArrayList<>();

        for (String currentCarName : carNameList) {
            Car currentCar = new Car(new Name(currentCarName));
            carList.add(currentCar);
        }

        Cars cars = new Cars(carList);

        int roundNumber = 0;
        System.out.println("시도할 횟수는 몇 회인가요?");

        try {
            roundNumber = Integer.parseInt(Console.readLine());

            if (roundNumber < 1) {
                throw new IllegalArgumentException();
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }

        for (int i = 0; i < roundNumber; i++) {

            cars.moveForward();

            cars.printRacingProgress();
        }

        List<Car> winners = cars.getWinners();

        System.out.print("최종 우승자 : ");
        for (int i = 0; i < winners.size(); i++) {
            System.out.print(winners.get(i).name.getName());
            if (i < winners.size() - 1) {
                System.out.print(", ");
            }
        }
    }
}
