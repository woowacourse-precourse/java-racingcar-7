package racingcar.utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Parser {

    public List<String> parsingCarNames(String input){
        //input = input.replace(" ", ""); //문자열 공백 제거

        List<String> names = new ArrayList<>();

        names.addAll(
                Arrays.stream(input.split(","))
                        .map(String::trim)
                        .collect(Collectors.toList())
        );

        return names;
    }
}
