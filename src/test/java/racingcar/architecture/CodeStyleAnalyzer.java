package racingcar.architecture;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CodeStyleAnalyzer {
    private static final int DEFAULT_MAX_INDENT_DEPTH = 2;
    private static final int DEFAULT_MAX_METHOD_LINES = 15;

    private boolean checkIndentDepth = false;
    private boolean checkTernaryOperator = false;
    private boolean checkMethodSize = false;

    private int maxIndentDepth = DEFAULT_MAX_INDENT_DEPTH;
    private int maxMethodLines = DEFAULT_MAX_METHOD_LINES;

    public static class CodeViolation {
        private final String fileName;
        private final int lineNumber;
        private final String message;

        public CodeViolation(String fileName, int lineNumber, String message) {
            this.fileName = fileName;
            this.lineNumber = lineNumber;
            this.message = message;
        }

        @Override
        public String toString() {
            return String.format("%s:%d - %s", fileName, lineNumber, message);
        }
    }

    public CodeStyleAnalyzer checkIndentDepth(int maxDepth) {
        this.checkIndentDepth = true;
        this.maxIndentDepth = maxDepth;
        return this;
    }

    public CodeStyleAnalyzer checkTernaryOperator() {
        this.checkTernaryOperator = true;
        return this;
    }

    public CodeStyleAnalyzer checkMethodSize(int maxLines) {
        this.checkMethodSize = true;
        this.maxMethodLines = maxLines;
        return this;
    }

    public CodeStyleAnalyzer checkAll() {
        return checkIndentDepth(DEFAULT_MAX_INDENT_DEPTH)
                .checkTernaryOperator()
                .checkMethodSize(DEFAULT_MAX_METHOD_LINES);
    }

    public List<CodeViolation> analyzeDirectory(String directoryPath) throws IOException {
        List<CodeViolation> violations = new ArrayList<>();
        List<Path> javaFiles = findJavaFiles(directoryPath);

        for (Path file : javaFiles) {
            violations.addAll(analyzeFile(file));
        }
        return violations;
    }

    private List<Path> findJavaFiles(String directoryPath) throws IOException {
        return Files.walk(Paths.get(directoryPath))
                .filter(path -> path.toString().endsWith(".java"))
                .toList();
    }

    private List<CodeViolation> analyzeFile(Path filePath) {
        try {
            List<String> lines = Files.readAllLines(filePath);
            String fileName = filePath.getFileName().toString();
            return runSelectedChecks(fileName, lines);
        } catch (IOException e) {
            return List.of(new CodeViolation(filePath.toString(), 0,
                    "파일 분석 중 오류 발생: " + e.getMessage()));
        }
    }

    private List<CodeViolation> runSelectedChecks(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();

        if (checkIndentDepth) {
            violations.addAll(checkIndentDepth(fileName, lines));
        }
        if (checkTernaryOperator) {
            violations.addAll(checkTernaryOperator(fileName, lines));
        }
        if (checkMethodSize) {
            violations.addAll(checkMethodSize(fileName, lines));
        }

        return violations;
    }

    private List<CodeViolation> checkIndentDepth(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();
        int currentDepth = 0;

        for (int i = 0; i < lines.size(); i++) {
            if (shouldSkipLine(lines.get(i))) {
                continue;
            }

            currentDepth = calculateCurrentDepth(lines.get(i), currentDepth);

            if (currentDepth > maxIndentDepth) {
                violations.add(new CodeViolation(fileName, i + 1,
                        String.format("제어문의 깊이가 허용된 최대 깊이(%d)를 초과했습니다: 현재 깊이 %d",
                                maxIndentDepth, currentDepth)));
            }
        }
        return violations;
    }

    private boolean shouldSkipLine(String line) {
        String trimmedLine = line.trim();
        return trimmedLine.isEmpty() || isComment(trimmedLine);
    }

    private boolean isComment(String line) {
        return line.startsWith("//") ||
                line.startsWith("/*") ||
                line.startsWith("*");
    }

    private int calculateCurrentDepth(String line, int currentDepth) {
        String trimmedLine = line.trim();
        if (isBlockEnd(trimmedLine)) {
            return Math.max(0, currentDepth - 1);
        }
        if (isControlStructure(trimmedLine)) {
            return currentDepth + 1;
        }
        return currentDepth;
    }

    private boolean isBlockEnd(String line) {
        return line.startsWith("}");
    }

    private boolean isControlStructure(String line) {
        return line.contains("if ") ||
                line.contains("for ") ||
                line.contains("while ") ||
                line.contains("switch ") ||
                line.contains("try ") ||
                line.startsWith("} else ") ||
                line.startsWith("} catch ");
    }

    private List<CodeViolation> checkTernaryOperator(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();
        Pattern ternaryPattern = Pattern.compile(".*\\?.*:.*");

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i);
            if (!shouldSkipLine(line) && containsTernaryOperator(line, ternaryPattern)) {
                violations.add(new CodeViolation(fileName, i + 1, "삼항 연산자 사용이 감지되었습니다"));
            }
        }
        return violations;
    }

    private boolean containsTernaryOperator(String line, Pattern pattern) {
        return pattern.matcher(line.trim()).matches();
    }

    private List<CodeViolation> checkMethodSize(String fileName, List<String> lines) {
        List<CodeViolation> violations = new ArrayList<>();
        MethodAnalyzer analyzer = new MethodAnalyzer(maxMethodLines);

        for (int i = 0; i < lines.size(); i++) {
            String line = lines.get(i).trim();
            analyzer.analyzeLine(line, i);

            if (analyzer.isMethodTooLong()) {
                violations.add(new CodeViolation(fileName, analyzer.getMethodStartLine(),
                        String.format("메서드가 너무 깁니다 (%d줄). 최대 허용 길이: %d줄",
                                analyzer.getMethodLineCount(), maxMethodLines)));
                analyzer.reset();
            }
        }
        return violations;
    }

    private static class MethodAnalyzer {
        private boolean inMethod = false;
        private int methodStartLine = 0;
        private int methodLineCount = 0;
        private final int maxLines;

        public MethodAnalyzer(int maxLines) {
            this.maxLines = maxLines;
        }

        public void analyzeLine(String line, int lineNumber) {
            if (isMethodStart(line)) {
                startNewMethod(lineNumber);
            } else if (inMethod) {
                processMethodLine(line);
            }
        }

        private void startNewMethod(int lineNumber) {
            inMethod = true;
            methodStartLine = lineNumber + 1;
            methodLineCount = 0;
        }

        private void processMethodLine(String line) {
            if (line.startsWith("}")) {
                inMethod = false;
            } else if (!shouldSkipLine(line)) {
                methodLineCount++;
            }
        }

        private boolean shouldSkipLine(String line) {
            return line.isEmpty() || line.startsWith("//") || line.startsWith("/*");
        }

        public boolean isMethodTooLong() {
            return !inMethod && methodLineCount > maxLines;
        }

        public void reset() {
            inMethod = false;
            methodLineCount = 0;
        }

        public int getMethodStartLine() {
            return methodStartLine;
        }

        public int getMethodLineCount() {
            return methodLineCount;
        }
    }

    private static boolean isMethodStart(String line) {
        return (containsAccessModifier(line) && line.contains("(") && line.endsWith("{"));
    }

    private static boolean containsAccessModifier(String line) {
        return line.contains("public") ||
                line.contains("private") ||
                line.contains("protected");
    }
}
