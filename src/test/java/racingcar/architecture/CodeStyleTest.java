package racingcar.architecture;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.util.List;
import org.junit.jupiter.api.Test;
import racingcar.architecture.CodeStyleAnalyzer.CodeViolation;

class CodeStyleTest {
    private static final String BASE_PATH = "./src/main/java/racingcar";

    @Test
    void 들여쓰기_깊이는_2를_초과하면_안_된다() throws IOException {
        // given
        int maxDepth = 2;
        CodeStyleAnalyzer analyzer = new CodeStyleAnalyzer()
                .checkIndentDepth(maxDepth);

        // when
        List<CodeViolation> violations = analyzer.analyzeDirectory(BASE_PATH);

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 삼항_연산자를_사용하지_않아야_한다() throws IOException {
        // given
        CodeStyleAnalyzer analyzer = new CodeStyleAnalyzer()
                .checkTernaryOperator();

        // when
        List<CodeViolation> violations = analyzer.analyzeDirectory(BASE_PATH);

        // then
        assertThat(violations).isEmpty();
    }

    @Test
    void 메서드는_15_줄을_초과하지_않아야_한다() throws IOException {
        // given
        int maxLines = 15;
        CodeStyleAnalyzer analyzer = new CodeStyleAnalyzer()
                .checkMethodSize(maxLines);

        // when
        List<CodeViolation> violations = analyzer.analyzeDirectory(BASE_PATH);

        // then
        assertThat(violations).isEmpty();
    }
}