package racingcar.service;

import java.util.ArrayList;
import java.util.List;

public class ExtractName {
    public List<String> extractName(String input){
        List<String> result = new ArrayList<>();
        String[] Names = input.split(",");
        for (String name : Names) {
            name = name.trim();
            result.add(name);
        }
        return result;
    }
}
