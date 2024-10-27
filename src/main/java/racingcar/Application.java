package racingcar;

import camp.nextstep.edu.missionutils.Console;

public class Application {
    public static void main(String[] args) {
        System.out.println("경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)");
        String input = Console.readLine();
        System.out.println("시도할 횟수는 몇 회인가요?");
        int stage = Integer.parseInt(Console.readLine());

        String[] names = input.split(",");
        Game game = new Game();

        for (String name : names) {
            if (name.length() >= 5) throw new IllegalArgumentException();
            game.addCar(name);
        }

        System.out.println();
        System.out.println("실행 결과");
        for (int i = 0; i < stage; i++) {
            game.progress();
            for (Car car : game.getCars()) {
                System.out.println(statusStringOf(car));
            }
            System.out.println();
        }

        StringBuilder sb = new StringBuilder();
        for (Car car : game.getWinners()) {
            sb.append(car.getName() + ", ");
        }

        sb.delete(sb.length() - 2, sb.length());
        System.out.println("최종 우승자 : " + sb.toString());
    }

    private static String statusStringOf(Car car) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < car.getProgress(); i++) {
            sb.append('-');
        }
        return car.getName() + " : " + sb.toString();
    }
}
