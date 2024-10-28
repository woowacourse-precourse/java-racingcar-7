package racingcar;

import java.util.List;

import camp.nextstep.edu.missionutils.Console;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

class InputHandler {
    public List<String> getCarNames() throws IllegalArgumentException {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        List<String> carNames = parseCarNames(input);
        validateCarNames(carNames, input);
        return carNames;
    }

    private void validateCarNames(List<String> carNames, String input) throws IllegalArgumentException {
        final long carNameCount = input.chars().filter(c -> c == ',').count() + 1;

        if (carNameCount != carNames.size()) {
            throw new IllegalArgumentException("이름을 입력해야 합니다.");
        }

        if (carNames.isEmpty()) {
            throw new IllegalArgumentException("빈 문자열은 입력할 수 없습니다.");
        }

        for (String name : carNames) {
            if (name.length() > 5) {
                throw new IllegalArgumentException("자동차 이름은 5자 이하만 가능합니다.");
            }
            if (name.isEmpty()) {
                throw new IllegalArgumentException("이름을 입력해야 합니다.");
            }

            String regex = "[^a-zA-Z0-9가-힣ㄱ-ㅎㅏ-ㅣ]";
            Pattern pattern = Pattern.compile(regex);
            Matcher matcher = pattern.matcher(name);

            if (matcher.find()) {
                throw new IllegalArgumentException("특수문자는 허용되지 않습니다.");
            }
        }
    }

    private List<String> parseCarNames(String input) {
        return List.of(input.split(","));
    }


    public int getNumberOfAttempts() throws IllegalArgumentException {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        try {
            int attempts = Integer.parseInt(input);
            if (attempts <= 0) {
                throw new IllegalArgumentException("시도 횟수는 1 이상이어야 합니다.");
            }
            return attempts;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("올바른 숫자를 입력하세요.");
        }
    }
}
