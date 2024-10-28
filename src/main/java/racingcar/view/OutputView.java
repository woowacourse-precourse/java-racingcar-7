package racingcar.view;

import java.util.List;
import java.util.Map;
import racingcar.controller.CarDTO;

public class OutputView {

    public void printCarNameInputMessage() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
    }

    public void printTrialCountInputMessage() {
        System.out.println("시도할 횟수는 몇 회인가요?");
    }

    public void printRaceProcedure(Map<Integer, List<CarDTO>> raceProcedure) {
        System.out.println();
        System.out.println("실행 결과");
        raceProcedure.entrySet().stream()
                .sorted(Map.Entry.comparingByKey())
                .forEach(entry -> printRaceStatus(entry.getValue()));
    }

    private void printRaceStatus(List<CarDTO> carDTOs) {
        carDTOs.forEach(carDTO -> System.out.println(carDTO.name() + " : " + "-".repeat(carDTO.location())));
        System.out.println();
    }

    public void printWinner(List<String> winners) {
        System.out.println("최종 우승자 : " + String.join(", ", winners));
    }
}