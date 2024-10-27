package racingcar;

import camp.nextstep.edu.missionutils.Console;
import camp.nextstep.edu.missionutils.Randoms;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분");
        String inputString = Console.readLine();

        String regex = "[^,]{1,5}(,[^,]{1,5})+";
        String regexCount = "[0-9]+";
        if(!inputString.matches(regex) || inputString.isEmpty()) throw new IllegalArgumentException("잘못된 입력값을 사용했습니다.");

        String[] users = inputString.split(",");
        List<Player> players = new ArrayList<>();
        for(String user: users) {
            players.add(new Player(user.trim(), 0));
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        String inputCount = Console.readLine();

        if(!inputCount.matches(regexCount)) throw new IllegalArgumentException("잘못된 횟수를 입력했습니다.");

        int count = Integer.parseInt(inputCount);

        while(count != 0) {

            for(int i = 0; i < users.length; i++) {
                if(Randoms.pickNumberInRange(0, 9) >= 4) {
                    players.get(i).count++;
                }
            }

            for(int i = 0; i < users.length; i++) {
                System.out.println(users[i] + " : " + "-".repeat(players.get(i).count));
            }
            System.out.println();
            count--;
        }

         int max = players.stream().mapToInt(i -> i.count).max().orElse(0);

        String result = players.stream().filter(i -> i.count == max).map(i -> i.name).collect(Collectors.joining(", "));
        System.out.println("최종 우승자 : " + result);
    }
}

class Player {
    String name;
    int count;

    public Player(String name, int count) {
        this.name = name;
        this.count = count;
    }
}
