package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();

        System.out.println("시도할 횟수는 몇 회인가요?");
        int n = Integer.parseInt(Console.readLine());
        System.out.println();

        // 문자열 분리 후 리스트에 저장
        List<String> carList = splitWithComma(input);

        // game 객체 생성, carList 전달
        Game game = new Game(carList);

        // 게임 횟수를 지정하면서 게임 시작
        System.out.println("실행 결과");
        game.play(n);

    }

    // 콤마로 분리, 불필요한 공백 제거, 리스트에 담는 기능
    public static List<String> splitWithComma(String input) {

        return Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

    }

    // 시도 횟수를 정수로 변환, 예외처리
    public static int changeN(String input) {
        try {
            int count = Integer.parseInt(input);
            if (count <= 0) {
                throw new IllegalArgumentException("한 라운드 이상 게임을 진행해야 합니다.");
            }
            return count;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("정수를 입력하세요.");
        }
    }
}
