package racingcar.extractor;

public class RoundExtractor implements Extractor<Integer> {

    private static final String NUMBER_REGULAR_EXPRESSION = "\\d+";

    @Override
    public Integer extract(String input) {
        validateInput(input);
        return Integer.parseInt(input);
    }

    @Override
    public void validateInput(String input) {
        checkNull(input);
        checkNumber(input);
    }

    private void checkNumber(String input) {
        if (!input.matches(NUMBER_REGULAR_EXPRESSION)) {
            throw new IllegalArgumentException("라운드 입력은 숫자만 가능합니다.");
        }
    }
}
