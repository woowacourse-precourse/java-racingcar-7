package racingcar.architecture;

import static org.assertj.core.api.Assertions.assertThat;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;
import racingcar.architecture.CodeStyleAnalyzer.CodeViolation;

@DisplayName("코드 스타일 분석기 테스트")
class CodeStyleAnalyzerTest {

    @Test
    void 들여쓰기_깊이가_제한을_초과하면_위반_사항을_감지한다(@TempDir Path tempDir) throws IOException {
        // given
        String code = """
                public class Test {
                    public void method() {
                        if (true) {
                            for (int i = 0; i < 10; i++) {
                                while (true) {
                                    System.out.println("Too deep!");
                                }
                            }
                        }
                    }
                }
                """;
        Path file = createJavaFile(tempDir, code);

        // when
        List<CodeViolation> violations = new CodeStyleAnalyzer()
                .checkIndentDepth(2)
                .analyzeDirectory(tempDir.toString());

        assertThat(violations)
                .hasSize(2)
                .extracting("message")
                .contains("제어문의 깊이가 허용된 최대 깊이(2)를 초과했습니다: 현재 깊이 3");
    }

    @Test
    void 삼항_연산자_사용을_감지한다(@TempDir Path tempDir) throws IOException {
        // given
        String code = """
                public class Test {
                    public String method() {
                        return true ? "yes" : "no";
                    }
                }
                """;
        Path file = createJavaFile(tempDir, code);

        // when
        List<CodeViolation> violations = new CodeStyleAnalyzer()
                .checkTernaryOperator()
                .analyzeDirectory(tempDir.toString());

        // then
        assertThat(violations).hasSize(1)
                .extracting("message")
                .contains("삼항 연산자 사용이 감지되었습니다");
    }

    @Test
    void 메서드_길이가_제한을_초과하면_위반_사항을_감지한다(@TempDir Path tempDir) throws IOException {
        // given
        StringBuilder code = new StringBuilder("public class Test {\n");
        code.append("    public void longMethod() {\n");
        // 16줄의 코드 생성
        for (int i = 0; i < 16; i++) {
            code.append("        System.out.println(\"line ").append(i).append("\");\n");
        }
        code.append("    }\n");
        code.append("}\n");

        Path file = createJavaFile(tempDir, code.toString());

        // when
        List<CodeViolation> violations = new CodeStyleAnalyzer()
                .checkMethodSize(15)
                .analyzeDirectory(tempDir.toString());

        // then
        assertThat(violations)
                .hasSize(1)
                .extracting("message")
                .contains("메서드가 너무 깁니다 (16줄). 최대 허용 길이: 15줄");
    }

    private Path createJavaFile(Path directory, String code) throws IOException {
        Path file = directory.resolve("Test.java");
        Files.writeString(file, code);
        return file;
    }
}