package racingcar.utils;

import java.util.ArrayList;
import java.util.List;

public class Parser {

    public List<String> parsingCarNames(String input){
        input = input.replace(" ", ""); //문자열 공백 제거

        List<String> names = new ArrayList<>();

        for(String name: input.split(",")){
            names.add(name);
        }

        return names;
    }
}
