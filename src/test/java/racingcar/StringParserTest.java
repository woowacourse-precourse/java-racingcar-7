package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class StringParserTest {
	@Test
	void parseCarNames() {
		assertThat(StringParser.parseCarNames("apple,bear,cider")).containsExactly("apple", "bear", "cider");

		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames(""))).isInstanceOf(
			IllegalArgumentException.class);

		assertThat(StringParser.parseCarNames("a")).containsExactly("a");
		assertThat(StringParser.parseCarNames("names")).containsExactly("names");
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("longer"))).isInstanceOf(
			IllegalArgumentException.class);

		assertThat(StringParser.parseCarNames("a,b")).containsExactly("a", "b");
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("a,"))).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames(",b"))).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("a,,b"))).isInstanceOf(
			IllegalArgumentException.class);
	}

	@Test
	void parsePositiveNumber() {
		assertThat(StringParser.parsePositiveNumber("12")).isEqualTo(12);
		assertThat(StringParser.parsePositiveNumber("1")).isEqualTo(1);

		assertThatThrownBy(() -> StringParser.parsePositiveNumber("")).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> StringParser.parsePositiveNumber("no_number")).isInstanceOf(
			IllegalArgumentException.class);
		assertThatThrownBy(() -> StringParser.parsePositiveNumber("-1")).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> StringParser.parsePositiveNumber("0")).isInstanceOf(IllegalArgumentException.class);
	}
}