package racingcar;
import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        String[] names;
        try {
            names = getNames(input);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
        System.out.println("시도할 횟수는 몇 회인가요?");
        int num;
        try {
            num = parseNumber(Console.readLine());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException(e.getMessage());
        }
    }

    public static String[] getNames(String input) throws IllegalArgumentException {
        if(input.isEmpty() || input.isBlank()) {
            throw new IllegalArgumentException("빈 문자열을 입력할 수 없습니다.");
        }
        String[] names = input.split(",");
        if(names.length <= 1) {
            throw new IllegalArgumentException("자동차는 2개 이상이어야 합니다.");
        }
        for(String name : names) {
            if(name.length() == 0) {
                throw new IllegalArgumentException("이름은 한 글자 이상이어야 합니다.");
            } else if(name.length() > 5) {
                throw new IllegalArgumentException("이름은 5자 이하만 가능합니다.");
            }
        }
        return names;
    }

    public static int parseNumber(String input) throws IllegalArgumentException {
        int num;
        try {
            num = Integer.parseInt(input);
        } catch(NumberFormatException e) {
            throw new IllegalArgumentException("숫자 형식이 아닙니다.");
        }
        if(num < 0) {
            throw new IllegalArgumentException("음수는 입력할 수 없습니다.");
        }
        return num;
    }
}
