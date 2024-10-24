package racingcar;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

class StringParserTest {
	@Test
	void parseCarNames() {
		assertThat(StringParser.parseCarNames("apple,bear,cider")).containsExactly("apple", "bear", "cider");

		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames(""))).isInstanceOf(IllegalArgumentException.class);

		assertThat(StringParser.parseCarNames("a")).containsExactly("a");
		assertThat(StringParser.parseCarNames("names")).containsExactly("names");
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("longer"))).isInstanceOf(IllegalArgumentException.class);

		assertThat(StringParser.parseCarNames("a,b")).containsExactly("a", "b");
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("a,"))).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames(",b"))).isInstanceOf(IllegalArgumentException.class);
		assertThatThrownBy(() -> assertThat(StringParser.parseCarNames("a,,b"))).isInstanceOf(IllegalArgumentException.class);
	}
}