package racingcar.domain.car;

import racingcar.domain.member.Member;

public class Car {

    private static final long INITIAL_RACING_DISTANCE = 0L;
    private final Member member;
    private final long racingDistance;

    public Car(Member member, long racingDistance) {
        this.member = member;
        this.racingDistance = racingDistance;
    }

    public static Car of(Member member) {
        return new Car(member, INITIAL_RACING_DISTANCE);
    }

    public Member getMember() {
        return member;
    }

    public long getRacingDistance() {
        return racingDistance;
    }
}
