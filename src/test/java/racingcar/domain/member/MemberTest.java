package racingcar.domain.member;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MemberTest {

    @Test
    @DisplayName("Member객체 생성 테스트")
    void member_객체_생성_테스트() {
        Member member = new Member("member");
        Assertions.assertThat(member.getName()).isEqualTo("member");
    }
}