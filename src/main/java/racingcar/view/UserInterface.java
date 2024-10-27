package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.model.Car;

public class UserInterface {

    /**
     * 사용자로부터 경주 자동차 이름 입력 받기
     */
    public String getRacingCarNameInput() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        return Console.readLine();
    }

    /**
     * 사용자로부터 시도 횟수 입력 받기
     */
    public String getTotalRoundInput() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        return Console.readLine().trim();
    }

    /**
     * 차수별 결과 출력
     */
    public void showRoundResult(List<Car> racingCars) {
        racingCars.forEach(car -> {
            System.out.println(car.getName() + " : " + "-".repeat(Math.max(0, car.getTotalDistance())));
        });
        System.out.println();
    }

    /**
     * 최종 우승자 출력
     */
    public void showFinalWinner(List<Car> finalWinners) {
        StringBuilder finalWinnerNames = new StringBuilder(finalWinners.getFirst().getName());
        if (finalWinners.size() > 1) { // 공동 우승인 경우
            for (int i = 1; i < finalWinners.size(); i++) {
                finalWinnerNames.append(", ").append(finalWinners.get(i).getName());
            }
        }
        System.out.println("최종 우승자 : " + finalWinnerNames);
    }

}
