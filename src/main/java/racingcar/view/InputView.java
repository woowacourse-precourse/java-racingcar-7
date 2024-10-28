package racingcar.view;

import camp.nextstep.edu.missionutils.Console;
import racingcar.common.IOMessage;
import racingcar.common.Symbol;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

public class InputView {

    public List<String> readCars(){
        System.out.println(IOMessage.INPUT_CAR_NAMES);
        return tokenizeCarsName(Console.readLine());
    }

    public List<String> tokenizeCarsName(String carNamesString){
        return Arrays.stream(carNamesString.split(Symbol.SEPARATE_MARKER.getSymbol()))
                .map(String::trim)
                .toList();
    }



}
