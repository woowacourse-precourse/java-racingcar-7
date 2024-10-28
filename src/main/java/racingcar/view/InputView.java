package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.IOMessage;
import racingcar.common.Symbol;

import java.util.Arrays;
import java.util.List;

public class InputView {

    public List<String> readCars() {
        System.out.println(IOMessage.INPUT_CAR_NAMES);
        return tokenizeCarsName(Console.readLine());
    }

    private List<String> tokenizeCarsName(String carNamesString) {
        return Arrays.stream(carNamesString.split(Symbol.SEPARATE_MARKER.getSymbol()))
                .map(String::trim)
                .toList();
    }

    public int readRoundCount(){
        System.out.println(IOMessage.INPUT_ROUND_COUNT);
        int num = Integer.parseInt(Console.readLine());
        return num;
    }

}
