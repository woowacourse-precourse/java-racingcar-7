package racingcar.util;

import java.util.Arrays;
import java.util.List;

public class Converter {

    public String[] parseCarList(String input) {
        // 유효성 검사 추가 필요
        String[] inputArr = input.split(",");
        return inputArr;
    }

    public int convertTryCnt(String input) {
        // 유효성 검사 추가 필요
        return Integer.parseInt(input);
    }
}
