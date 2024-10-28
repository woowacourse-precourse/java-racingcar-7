package study;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.Objects;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class MethodParameterCallByValueReferenceTest {

    @Test
    @DisplayName("새로운 객체를 반환하는 경우 원본에 영향 없음")
    void 메서드_파라미터_새로운_객체_반환() {
        String input = "hello";

        assertThat(input).isEqualTo("hello");
        assertThat(join(input)).isEqualTo("hello world");
        assertThat(finalJoin(input)).isEqualTo("hello world");
    }

    @Test
    @DisplayName("기본값: 메서드에 값을 복사해 넘기기 때문에 변경이 일어나도 원본에 영향 X")
    void 메서드_파라미터_기본값_변경() {
        int num = 1;

        toTen(num);

        assertThat(num).isEqualTo(1); // 값 복사, 원본 영향은 없음
    }

    @Test
    @DisplayName("String + Wrapper(Integer, Long 등): 참조 값을 복사해 넘겨 재할당해도 새로운 String 객체가 생성(새로운 참조)")
    void 메서드_파라미터_문자열_변경() {
        String input = "hello";

        toUpper(input);

        assertThat(input).isEqualTo("hello");
    }

    @Test
    @DisplayName("객체 상태(필드) 변경: 원본 객체의 상태에 영향을 줌, 불변 객체가 필요한 이유")
    void 메서드_파라미터_객체_상태_변경() {
        Member kim = new Member("kim");

        toPark(kim);

        assertThat(kim.name).isEqualTo("park");
    }

    @Test
    @DisplayName("객체 참조 변경: 새로운 객체를 생성하는 경우 원본 객체에 영향을 주지 않음")
    void 메서드_파라미터_객체_참조_변경() {
        Member kim = new Member("kim");

        changeLee(kim);

        assertThat(kim.name).isEqualTo("kim");
    }

    // join()은 new String()로 새로운 객체를 만들어 반환하기 때문에 둘의 차이는 없음
    private String join(String input) {
        return String.join(" ", input, "world");
    }

    private String finalJoin(final String input) {
        return String.join(" ", input, "world");
    }

    private void toTen(int num) {
        num = 10;
    }

    private void toTenFinal(final int num) {
        // num = 10; // 기본값 변경 불가능
    }

    private void toUpper(String input) {
        input = input.toUpperCase();
    }

    private void toUpperFinal(final String input) {
        // input = input.toUpperCase(); // 참조값 변경(재할당) 불가능
    }

    private void toPark(Member member) {
        member.name = "park";
    }

    private void changeLee(Member member) {
        member = new Member("lee");
    }

    static class Member {

        private String name;

        public Member(final String name) {
            this.name = name;
        }

        @Override
        public boolean equals(final Object o) {
            if (this == o) {
                return true;
            }
            if (!(o instanceof Member member)) {
                return false;
            }
            return Objects.equals(name, member.name);
        }

        @Override
        public int hashCode() {
            return Objects.hashCode(name);
        }

    }

}
