package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public List<String> parsingCarNames(String input){

        List<String> names = new ArrayList<>();

        if (!input.matches("^[a-zA-Z0-9 ]+(,[a-zA-Z0-9 ]+)*$")) {
            throw new IllegalArgumentException("자동차 이름은 쉼표(,)로 구분 되어야 합니다.");
        }

        names.addAll(
                Arrays.stream(input.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList())
        );

        return names;
    }
}
