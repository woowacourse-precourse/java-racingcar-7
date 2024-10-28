package racingcar.view;

import racingcar.domain.CarDTO;
import racingcar.domain.InputDTO;
import racingcar.domain.RoundTimeDTO;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import static camp.nextstep.edu.missionutils.Console.readLine;


public class RacingCarView {

    public InputDTO getInputCarName() {
        String input = readLine();

        return new InputDTO(input);
    }

    public RoundTimeDTO getInputRoundTime() {
        String input = readLine();
        if (input.isEmpty()) {
            return new RoundTimeDTO(-1);
        }
        try {

            return new RoundTimeDTO(Integer.parseInt(input));

        } catch (NumberFormatException e) {
            // NumberFormatException을 IllegalArgumentException으로 변경
            throw new IllegalArgumentException("올바른 숫자를 입력해 주세요: " + input);
        }


    }

    public void showCarInputInfo() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void showRoundTimeInfo() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void showResultInfo() {
        System.out.println("\n실행 결과");
    }

    // 각 라운드의 결과를 출력
    public void showRoundResult(List<CarDTO> cars) {
        for (CarDTO car : cars) {
            System.out.println(car.getCarName() + " : " + "-".repeat(car.getGoStraight()));
        }
        System.out.println();
    }


    public void printWinners(List<CarDTO> winners) {
        List<String> winnerNames = winners.stream()
                .map(CarDTO::getCarName)
                .collect(Collectors.toList());


        System.out.println("최종 우승자 : " + String.join(", ", winnerNames));
    }

}


