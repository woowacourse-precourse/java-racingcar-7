package racingcar.controller;

import static camp.nextstep.edu.missionutils.Console.readLine;
import static camp.nextstep.edu.missionutils.Randoms.pickNumberInRange;

import java.util.ArrayList;
import java.util.List;
import racingcar.repository.CarRepository;

public class MainController {
    public static void run() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름을 쉼표(,) 기준으로 구분");
        CarController.saveCarNames();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int repeat = Integer.parseInt(readLine());

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 1; i <= repeat; i++) {
            for (int j = 1; j <= CarRepository.carList.size(); j++) {
                int randomValue = pickNumberInRange(0, 9);

                if (randomValue >= 4) {
                    CarRepository.carList.get(j - 1).go();
                }
            }
            for (int j = 1; j <= CarRepository.carList.size(); j++) {
                CarRepository.carList.get(j - 1).printStatus();
                System.out.println();
            }
            System.out.println();
        }

        List<String> winnerList = new ArrayList<>();
        int maxStatus = CarRepository.carList.get(0).getRacingStatus();
        for (int i = 1; i < CarRepository.carList.size(); i++) {
            if (maxStatus < CarRepository.carList.get(i).getRacingStatus()) {
                maxStatus = CarRepository.carList.get(i).getRacingStatus();
            }
        }
        for (int i = 0; i < CarRepository.carList.size(); i++) {
            if (maxStatus == CarRepository.carList.get(i).getRacingStatus()) {
                winnerList.add(CarRepository.carList.get(i).getName());
            }
        }

        String winner = String.join(", ", winnerList);
        System.out.println("최종 우승자 : " + winner);

    }
}
