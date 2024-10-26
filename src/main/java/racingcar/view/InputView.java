package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

/*
 - [ ] 사용자는 몇 번의 이동을 할 것인지를 입력
 */
public class InputView {
    public String[] getCarNames() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");

        String userInput = Console.readLine();

        String[] carNames = userInput.split(",");

        if(!validateCarName(carNames)) {
            throw new IllegalArgumentException("입력된 자동차 이름이 올바르지 않습니다.");
        }

        return carNames;
    }

    private boolean validateCarName(String[] carNames){
        for (String carName : carNames) {
            if(carName.isBlank() || carName.length() > 5){
                return false;
            }
        }

        return true;
    }
}
