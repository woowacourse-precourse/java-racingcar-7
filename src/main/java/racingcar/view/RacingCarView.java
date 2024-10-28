package racingcar.view;

import racingcar.domain.CarDTO;
import racingcar.domain.InputDTO;

import java.util.List;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class RacingCarView {

    public InputDTO getInputCarName() {
        String input = readLine();

        return new InputDTO(input);
    }

    public int getRoundTime(){
        String input = readLine();

        return Integer.parseInt(input);
    }

    public void showCarInputInfo(){
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundTimeInfo(){
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    // 각 라운드의 결과를 출력하는 메서드
    public void showRoundResult(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getGoStraight()));
        }
        System.out.println();
    }

}


