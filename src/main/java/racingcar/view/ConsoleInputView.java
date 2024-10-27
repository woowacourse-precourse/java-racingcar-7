package racingcar.view;

import camp.nextstep.edu.missionutils.Console;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class ConsoleInputView implements InputView {
    public List<String> readNameList() {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }

        List<String> nameList = List.of(input.split(","));
        List<String> result = nameList.stream()
                .map(String::trim)
                .toList();

        checkDuplicate(result);

        return result;
    }

    public int readCount() {
        System.out.println("시도할 횟수는 몇 회인가요?");
        String input = Console.readLine();
        if (input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열이 입력되었습니다.");
        }

        try {
            int count = Integer.parseInt(input);
            if (count < 0) {
                throw new IllegalArgumentException("0 이상의 정수가 입력되어야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수가 입력되지 않았습니다.");
        } finally {
            Console.close();
        }
    }

    private void checkDuplicate(List<String> nameList) {
        Set<String> nameSet = new HashSet<>(nameList);
        if (nameSet.size() != nameList.size()) {
            throw new IllegalArgumentException("자동차 이름을 중복해서 입력할 수 없습니다.");
        }
    }
}
