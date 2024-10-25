package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class RacingGame {

    public void run() {
        // TODO 구현 필요
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String carNames = Console.readLine();
        String[] carNameArray = splitAndValidateCarNames(carNames);

        System.out.println("시도할 횟수는 몇 회인가요?");
        String tryTime = Console.readLine();
        int tryTimeInt = parseAndValidateTryTime(tryTime);
    }

    private String[] splitAndValidateCarNames(String carNames) {
        String[] carNameArray = carNames.split(",");
        for(String carName : carNameArray) {
            validateCarName(carName);
        }
        return carNameArray;
    }

    private void validateCarName(String carName) {
        if(carName.length() > 5) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
        }
    }

    private int parseAndValidateTryTime(String tryTime) {
        try{
            int tryTimeInt = Integer.parseInt(tryTime);
            if(tryTimeInt < 1) {
                throw new IllegalArgumentException("시도 횟수는 1 이상만 가능합니다.");
            }
            return tryTimeInt;
         } catch(NumberFormatException e) {
            throw new IllegalArgumentException("시도 횟수는 숫자만 가능합니다.");
        }
    }

}
