package racingcar.util;

public class Converter {

    public String[] parseCarList(String input) {
        String[] inputArr = input.split(",");
        Validator.validateCarNames(inputArr);
        return inputArr;
    }

    public int convertTryCnt(String input) {
        Validator.validateTryCnt(input);
        return Integer.parseInt(input);
    }
}
