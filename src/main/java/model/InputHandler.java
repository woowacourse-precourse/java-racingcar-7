package model;

import java.util.Arrays;
import java.util.List;

public class InputHandler {

    public List<String> splitCarNames(String input) {
        // TODO: 에러 처리
        return Arrays.asList(input.split(","));
    }

    public int toInt(String input) {
        // TODO: 양수만 받아야하는 등의 추가적인 에러처리
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Invalid input");
        }
    }

}
