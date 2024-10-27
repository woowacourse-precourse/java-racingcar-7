package racingcar;

import camp.nextstep.edu.missionutils.Console;
import racingcar.car.RacingCar;

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
        List<String> carNameList = Arrays.stream(carNameListInput.split(","))
                .collect(Collectors.toList());

        // validate carName input
        String charRegex = "^[ㄱ-ㅎ|가-힣|a-z|A-Z]*$";
        for(String carName : carNameList) {
            if(!Pattern.matches(charRegex, carName) || carName.length()>5) {
                throw new IllegalArgumentException();
            }
        }

        List<RacingCar> racingCarList = new ArrayList<>();
        for(String carName : carNameList) {
            racingCarList.add(new RacingCar(carName));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryCountInput = Console.readLine();

        // validate trying move count
        String numRegex = "^[0-9]*$";
        if(!Pattern.matches(numRegex, tryCountInput)) {
            throw new IllegalArgumentException();
        }
        int tryCount = Integer.parseInt(tryCountInput);

        System.out.println("실행 결과");
        for(int i=0; i<tryCount; i++) {
            for(RacingCar racingCar : racingCarList) {
                racingCar.move();
                racingCar.showRacingStatus();
                System.out.println();
            }
        }

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
