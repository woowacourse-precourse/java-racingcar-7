package racingcar.notice;

import java.util.List;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.regex.Pattern;

public class Notice {
    static public List<String> inputName(Supplier<String> read, List<Predicate<String>> policies) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String content = read.get();

        List<String> result = Pattern.compile(",")
                .splitAsStream(content)
                .map((name) -> isValid(name, policies))
                .toList();


        if(result.size() != content.chars().filter((c) -> c == ',').count() + 1) {
            throw new IllegalArgumentException("some car's name is empty");
        }

        return result;
    }
    static public Integer inputGameTime(Supplier<String> read) {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String content = read.get();

        String reg = "\\d+";
         if(! content.matches(reg)) {
             throw new IllegalArgumentException("invalid input: " + content);
         }

         return Integer.parseInt(content);
    }
    static private String isValid(String content, List<Predicate<String>> policies) {
        for (Predicate<String> policy : policies) {
            if (!policy.test(content)) {
                throw new IllegalArgumentException("invalid content: " + content);
            }
        }
        return content;
    }
}
