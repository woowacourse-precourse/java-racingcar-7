package racingcar.domain;

/**
 * NumberGenerator 인터페이스는 난수를 생성하는 메서드를 정의한다.
 * - 이동 여부를 결정하기 위한 난수 생성에 사용된다.
 */
@FunctionalInterface
public interface NumberGenerator {

    /**
     * 난수를 생성하는 메서드.
     */
    int generate();
}
