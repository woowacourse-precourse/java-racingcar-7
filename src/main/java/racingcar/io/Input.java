package racingcar.io;

import camp.nextstep.edu.missionutils.Console;

public class Input {
    public String carNames() {
        String carNames = Console.readLine().trim();
        isCarNamesInputValid(carNames);
        return carNames;
    }



    private void isCarNamesInputValid(String carNames) {
        isCarNameInputBlank(carNames);
        isCommaSeparated(carNames);
    }

    private void isCommaSeparated(String carNames) {
        String[] names = carNames.split(",");
        for (String name : names) {
            if(name.isEmpty()){
                throw new IllegalArgumentException("Write valid comma between names");
            }
        }
    }

    private void isCarNameInputBlank(String carNames) {
        if(carNames.trim().isEmpty()) {
            throw new IllegalArgumentException("Input is Blank");
        }
    }
}
