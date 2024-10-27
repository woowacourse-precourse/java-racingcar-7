package racingcar;
import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;
import java.util.*;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        Map<String, Integer> race = new HashMap<String, Integer>();
        try {
            getNames(race, input);
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

        System.out.println("실행 결과");

        for(int i=0; i<num; i++) {
            Iterator<Map.Entry<String, Integer>> entry = race.entrySet().iterator();
            while(entry.hasNext()) {
                Map.Entry<String, Integer> element = entry.next();
                int r = randomNum();
                move(element, goStop(r));
            }
            Iterator<Map.Entry<String, Integer>> newEntry = race.entrySet().iterator();
            printRace(newEntry);
        }

        List<String> winners = new ArrayList<>();
        winner(race, winners);
        printWinner(winners);
    }

    public static void getNames(Map<String, Integer> race, String input) throws IllegalArgumentException {
        if(input.isBlank()) {
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
            race.put(name, 0);
        }
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

    public static int randomNum() {
        return Randoms.pickNumberInRange(0, 9);
    }

    public static boolean goStop(int n) {
        if(n >= 4) {
            return true;
        }
        return false;
    }

    public static void move(Map.Entry<String, Integer> element, boolean goStop) {
        if(goStop) {
            element.setValue(element.getValue() + 1);
        }
    }

    public static void printRace(Iterator<Map.Entry<String, Integer>> entry) {
        while(entry.hasNext()) {
            Map.Entry<String, Integer> element = entry.next();
            String result = "";
            result += element.getKey() + " : ";
            for(int i = 0; i < element.getValue(); i++) {
                result += "-";
            }
            System.out.println(result);
        }
        System.out.println("");
    }

    public static void winner(Map<String, Integer> race, List<String> winners) {
        Integer max = Collections.max(race.values());
        Iterator<Map.Entry<String, Integer>> entry = race.entrySet().iterator();
        while(entry.hasNext()) {
            Map.Entry<String, Integer> element = entry.next();
            if(element.getValue() == max) {
                winners.add(element.getKey());
            }
        }
    }

    public static void printWinner(List<String> winners) {
        String result = "최종 우승자 : ";
        for(String winner : winners) {
            result += winner + ", ";
        }
        System.out.println(result.substring(0, result.length() - 2));
    }
}
