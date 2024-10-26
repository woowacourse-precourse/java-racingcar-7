package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.List;

public class Application {
	private static final String INPUT_CAR_NAMES_MESSAGE = "경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)";
	private static final String INPUT_TRY_COUNT_MESSAGE = "시도할 횟수는 몇 회인가?";
	
    public static void main(String[] args) {
        System.out.println(INPUT_CAR_NAMES_MESSAGE);
        String input = Console.readLine();
        
        // 각 이름에 trim() 적용 후 List에 저장
        List<String> carNames = Arrays.stream(input.split(","))
        		.map(String::trim)
        		.collect(Collectors.toList());
        
        System.out.println(carNames);

        
        System.out.println(INPUT_TRY_COUNT_MESSAGE);
        int count = Integer.parseInt(Console.readLine());
    }
}
