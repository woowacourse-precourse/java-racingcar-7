package racingcar;

import camp.nextstep.edu.missionutils.Console;

import java.util.ArrayList;
import java.util.List;

public class Application {

    static List<String> players = new ArrayList<>();
    static int N;

    public static void main(String[] args) {
        // TODO: 프로그램 구현
        try {
            Input();
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 입력입니다: " + e.getMessage());
            throw e;
        }
    }

    private static void Input() throws IllegalArgumentException{
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String playerText = Console.readLine();

        String[] playerArray = playerText.split(",");
        try {
            playerListInput(playerArray);
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("자동차 이름은 5자 이하여야 합니다.");
        }

        System.out.println("시도할 횟수는 몇 회인가요?");
        try {
            N = Integer.parseInt(Console.readLine());
        }catch (NumberFormatException e) {
            throw new IllegalArgumentException("숫자를 입력해야 합니다.");
        }
    }

    static void playerListInput(String[] playerArray) throws IllegalArgumentException{
        for (String player : playerArray) {
            if(player.length() <= 5){
                players.add(player);
            }else{
                throw new IllegalArgumentException();
            }
        }
    }
}
