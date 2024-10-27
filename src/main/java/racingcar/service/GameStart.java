package racingcar.service;

import camp.nextstep.edu.missionutils.Randoms;
import racingcar.domain.DTO;

public class GameStart {
    private static int max;

    public static int race(DTO[] player) {

        for (DTO dto : player) {
            int forward = Randoms.pickNumberInRange(0, 9);
            if (forward >= 4) {
                dto.setForwardCount(dto.getForwardCount() + 1);
            }
            maxForward(dto);
        }
        return max;
    }

    public static void maxForward(DTO player) {

        if(player.getForwardCount() > max) {
            max = player.getForwardCount();
        }
    }

}
