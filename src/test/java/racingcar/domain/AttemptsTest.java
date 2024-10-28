package racingcar.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class AttemptsTest {

    private Attempts attempts;

    @BeforeEach
    void setUp() {
        // given: Attempts 객체 초기화 (시도 횟수 3으로 설정)
        attempts = Attempts.from("3");
    }

    @Test
    @DisplayName("초기 시도 횟수가 설정된 값인지 확인")
    void 초기_시도_횟수가_설정된_값인지_확인() {
        // then: 초기 시도 횟수가 3인지 확인
        assertThat(attempts.isLeft()).isTrue();
    }

    @Test
    @DisplayName("decrease() 호출 시 시도 횟수가 1 감소")
    void decrease_호출_시_시도_횟수가_1_감소() {
        // when: decrease 메서드를 호출하여 시도 횟수를 줄임
        attempts.decrease();

        // then: 시도 횟수가 남아 있는지 확인
        assertThat(attempts.isLeft()).isTrue();
    }

    @Test
    @DisplayName("decrease()를 시도 횟수만큼 호출 시 시도 횟수가 0이 됨")
    void 시도_횟수만큼_decrease_호출_시_시도_횟수가_0이_됨() {
        // when: 시도 횟수만큼 decrease 호출
        attempts.decrease();
        attempts.decrease();
        attempts.decrease();

        // then: 시도 횟수가 남아 있지 않은 상태 확인
        assertThat(attempts.isLeft()).isFalse();
    }

    @Test
    @DisplayName("시도 횟수가 0일 때 isLeft()가 false 반환")
    void 시도_횟수가_0일_때_isLeft가_false_반환() {
        // given: 시도 횟수가 1인 Attempts 객체 생성
        attempts = Attempts.from("1");

        // when: decrease를 호출하여 시도 횟수를 0으로 만듦
        attempts.decrease();

        // then: 남은 시도 횟수가 없으므로 isLeft()가 false를 반환
        assertThat(attempts.isLeft()).isFalse();
    }
}