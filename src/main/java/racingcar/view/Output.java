package racingcar.view;

import racingcar.DTO;

public class Output {
    public static final String forwardDelimiter = "-";

    public static void gameResult(DTO[] player) {
        System.out.println("실행 결과");

        for (DTO dto : player) {
            System.out.print(dto.getCarName() + " : ");
            System.out.println(forwardDelimiter.repeat(dto.getForwardCount()));
        }
        System.out.println();
    }

    public static void gameWinners(int max, DTO[] participants) {
        System.out.print("최종 우승자 : ");
        int count = 0;
        for (DTO participant : participants) {
            if (count == 0 && participant.getForwardCount() == max) {
                System.out.print(participant.getCarName());
                count++;
            } else if (count >= 1 && participant.getForwardCount() == max) {
                System.out.print(", " + participant.getCarName());
            }
        }

    }
}
