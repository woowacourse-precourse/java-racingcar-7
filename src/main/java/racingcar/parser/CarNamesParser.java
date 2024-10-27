package racingcar.parser;

import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class CarNamesParser implements Parser<String, List<String>> {

    @Override
    public List<String> parse(String input) {
        if (input == null || input.isBlank()) {
            return List.of("");
        }

        List<String> result = new ArrayList<>();
        StringTokenizer tokenizer = new StringTokenizer(input, ",");
        while (tokenizer.hasMoreTokens()) {
            String value = tokenizer.nextToken().trim();
            this.addWithoutDuplicated(result, value);
        }

        return result;
    }

    private void addWithoutDuplicated(List<String> list, String value) {
        // Set 타입 컬렉션을 사용하지 않는 이유는 입력된 순서대로 컬렉션에 저장되는 것을 보장하기 위함이다.
        for (String e : list) {
            if (e.equals(value)) {
                return;
            }
        }
        list.add(value);
    }
}
