package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        try {
            System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
            String input = Console.readLine();

            // 문자열 분리 후 리스트에 저장
            List<String> carList = splitWithComma(input);

            // 시도 횟수 입력 받고 예외 검사
            System.out.println("시도할 횟수는 몇 회인가요?");
            int n = changeN(Console.readLine());
            System.out.println();

            // game 객체 생성 및 게임 실행
            Game game = new Game(carList);
            System.out.println("실행 결과");
            game.play(n);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());

            /*
                테스트 클래스를 실행할 때 주석을 해제해야 한다.
                catch한 예외를 다시 throw하여 예외를 검증한다.
             */
            // throw e;
        }

    }

    // 콤마로 분리, 불필요한 공백 제거, 리스트에 담는 기능
    public static List<String> splitWithComma(String input) {
        List<String> catList = Arrays.stream(input.split(","))
                .map(String::trim)
                .collect(Collectors.toList());

        if (catList.isEmpty() || catList.contains("")) {
            throw new IllegalArgumentException("자동차 이름은 빈 값이 될 수 없습니다.");
        }

        for (String n : catList) {
            if (n.length() > 5) {
                throw new IllegalArgumentException("5자 이하의 이름을 입력해주세요.");
            }
        }

        return catList;
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
