package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.RacingCar;
import racingcar.domain.RaceStarter;
import racingcar.domain.RacingCarGenerator;
import racingcar.validator.InputValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNameListInput = Console.readLine();

        InputValidator.isStringOnly(carNameListInput);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryMoveCountInput = Console.readLine();

        InputValidator.isNumberOnly(tryMoveCountInput);

        List<RacingCar> racingCarList = RacingCarGenerator.generateRacingCarList(carNameListInput);

        System.out.println("실행 결과");
        RaceStarter.startRace(racingCarList, Integer.parseInt(tryMoveCountInput));

        // find max record of race
        String maxMoveRecord = "";
        for(RacingCar racingCar : racingCarList) {
            if(racingCar.getMoveRecord().length() > maxMoveRecord.length()) {
                maxMoveRecord = racingCar.getMoveRecord();
            }
        }

        // find racing cars have same record as max record of race
        List<String> winners = new ArrayList<>();
        for(RacingCar racingCar : racingCarList) {
            if(racingCar.getMoveRecord().equals(maxMoveRecord)) {
                winners.add(racingCar.getName());
            }
        }

        System.out.println("최종 우승자 : " + String.join(",", winners));
    }
}
