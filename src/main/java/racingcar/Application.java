package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {
    private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
    private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";
    private static final String VALID_NAME_PATTERN = "^(?!_)[a-zA-Z0-9가-힣_]+(?<!_)$";
    
    public static void main(String[] args) {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();

        // 각 이름에 trim() 적용 후 공백 포함 여부와 중복 검사
        List<String> carNames = new ArrayList<>();
        for (String name : input.split(",")) {
            name = name.trim();

            if (name.contains(" ")) {
                throw new IllegalArgumentException("자동차 이름에 공백이 포함될 수 없습니다.");
            }

            if (name.length() > 5) {
            	throw new IllegalArgumentException("자동차 이름은 5자를 초과할 수 없습니다.");
            }
            
            if (!name.matches(VALID_NAME_PATTERN)) {
                throw new IllegalArgumentException("자동차 이름은 영문자, 숫자, 한글만 포함하고, 언더바(_)는 처음이나 끝에 위치할 수 없습니다.");
            }
            
            if (carNames.contains(name)) {
                throw new IllegalArgumentException("자동차 이름은 중복될 수 없습니다.");
            }
            
            carNames.add(name);
        }

        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
    }
}
