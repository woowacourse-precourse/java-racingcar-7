package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String carNames() {
        String carNames = Console.readLine().trim();
        validateCarNamesInput(carNames);
        return carNames;
    }

    private void validateCarNamesInput(String carNames) {
        validateCarNameInputBlank(carNames);
        validateNotEndingWithComma(carNames);
        validateCommaSeparated(carNames);
    }

    private void validateCommaSeparated(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if(name.isEmpty()){
                throw new IllegalArgumentException("Write valid comma between names");
            }
        }
    }

    private void validateNotEndingWithComma(String carNames) {
        if(carNames.endsWith(",")){
            throw new IllegalArgumentException("Write valid comma between names");
        }
    }

    private void validateCarNameInputBlank(String carNames) {
        if(carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
    }
}
