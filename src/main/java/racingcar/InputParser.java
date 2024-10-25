package racingcar;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class InputParser {

    public List<String> parseInput(String input){
        return Arrays.stream(input.split(","))
                .map(String::trim)   // 각 문자열의 앞뒤 공백을 제거
                .collect(Collectors.toList());  // 결과를 리스트로 수집
    }
}
