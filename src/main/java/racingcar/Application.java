package racingcar;

import java.util.Scanner;
import java.util.StringTokenizer;
import java.util.Map;
import java.util.HashMap;
public class Application {
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        Scanner scanner = new Scanner(System.in);
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String inputName = scanner.nextLine();
        playerNameSplit(inputName);

    }
    public static Map playerNameSplit(String inputName){
        StringTokenizer tokenizer = new StringTokenizer(inputName,",");
        Map<String, Integer> player = new HashMap<>();
        while (tokenizer.hasMoreTokens()){
            String token =tokenizer.nextToken();
            player.put(token,0);
        }
        return player;
    }

}
