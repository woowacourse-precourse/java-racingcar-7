package service;

import camp.nextstep.edu.missionutils.Randoms;

import static service.RandomGenerator.randomNumberGenerator;


// stateless, 디폴트 생성자로 충분.
public class RandomMoveStrategy implements MoveStrategy {
    private static final int MOVE_THRESHOLD = 4;

    @Override
    public boolean canMove() {
        int random = randomNumberGenerator();
        return random >= MOVE_THRESHOLD;
    }
}