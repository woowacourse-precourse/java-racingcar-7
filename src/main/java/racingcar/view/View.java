package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import java.util.List;
import racingcar.dto.CarsDto;
import racingcar.model.Car;
import racingcar.utils.Utils;

public class View {

    public String[] inputNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String names = input.replace(" ", "");
        Utils.validateNames(names);
        return names.split(",");
    }

    public int inputTimes() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String times = Console.readLine();
        return Utils.parseNumber(times);
    }

    public void outputRaceResults(List<CarsDto> raceResults) {
        System.out.print("\n실행 결과\n");
        raceResults.forEach(this::outputOneRoundResult);
    }

    private void outputOneRoundResult(CarsDto cars) {
        for (Car car : cars.cars()) {
            System.out.printf("%s : %s\n", car.getName(), "-".repeat(car.getDistance()));
        }
        System.out.println();
    }

    public void outputFinalWinner(List<String> winners) {
        String result = String.join(", ", winners);
        System.out.printf("최종 우승자 : %s\n", result);
    }

}
