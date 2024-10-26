package racingcar;

import java.util.Scanner;

public class Application {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("");
        try {
            // 자동차 이름 입력 요청
            System.out.println("경주에 사용할 자동차 이름을 입력하시오.(이름은 쉼표(,) 기준으로 구분) ");
            String inputNames = scanner.nextLine(); // 자동차 이름  입력
            String[] carNames = inputNames.split(",");

            // 사용자에게 시도 횟수 입력 요청
            System.out.println("시도할 횟수는 몇 회 인가요?");
            int attempts = Integer.parseInt(scanner.nextLine());// 몇번 시도할것인지 횟수 입력

            if(attempts <= 0){
                throw new IllegalArgumentException("시도 횟수는 1회 이상이어야 합니다"); // 1 회 이상이 아닐경우 예외발생
            }

            //  게임 객체에서 가져온후 경주
            Game game = new Game(carNames, attempts);
            game.startRace(); // 경주 진행
            game.printWinners(); // 우승자 출력

        } catch (IllegalArgumentException e){
            System.out.println(e.getMessage());
        } finally {
            scanner.close();
        }

    }
}
