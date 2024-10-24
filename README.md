# java-racingcar-precourse

# 자동차 경주

# 자동차 경주 게임 기능 목록 및 요구 사항 정리

## 1. 입력 기능
### 1.1 자동차 이름 입력
- [x] 쉼표(,)를 기준으로 구분된 자동차 이름들을 입력 받는다
- [x] 입력값 유효성 검증
   - 이름이 5자 이하인지 검증
   - 이름이 공백이 아닌지 검증
   - 이름에 특수문자가 포함되어 있는지 검증
   - 중복된 이름이 있는지 검증
   - 최소 1개 이상의 이름이 입력되었는지 검증

### 1.2 시도 횟수 입력
- [x] 자동차 경주 시도 횟수를 입력 받는다
- [x] 입력값 유효성 검증
   - 숫자가 아닌 값이 입력된 경우 예외처리
   - 음수가 입력된 경우 예외처리
   - 0이 입력된 경우 예외처리

## 2. 자동차 경주 게임 핵심 로직
### 2.1 자동차 이동 처리
- [x] 0-9 사이의 무작위 값 생성
- [x] 무작위 값이 4 이상인 경우 전진
- [x] 각 차수별 실행 결과 저장

### 2.2 우승자 판별
- [x] 가장 멀리 이동한 거리 계산
- [x] 가장 멀리 이동한 자동차들을 우승자로 선정
- [x] 동률 우승자 처리

## 3. 출력 기능
### 3.1 실행 결과 출력
- [x] 각 차수마다 각 자동차의 이동 거리를 출력
   - 자동차 이름과 함께 출력
   - 이동 거리는 '-'로 표시

### 3.2 최종 우승자 출력
- [x] 단독 우승자인 경우 출력 형식: "최종 우승자 : {이름}"
- [x] 공동 우승자인 경우 출력 형식: "최종 우승자 : {이름1}, {이름2}"

## 4. 예외 처리
### 4.1 자동차 이름 관련 예외
- [x] 이름이 5자를 초과하는 경우 IllegalArgumentException 발생
- [x] 이름이 공백인 경우 IllegalArgumentException 발생
- [x] 이름에 특수문자가 포함된 경우 IllegalArgumentException 발생
- [x] 중복된 이름이 있는 경우 IllegalArgumentException 발생
- [x] 이름이 입력되지 않은 경우 IllegalArgumentException 발생

### 4.2 시도 횟수 관련 예외
- [x] 숫자가 아닌 값 입력 시 IllegalArgumentException 발생
- [x] 음수 입력 시 IllegalArgumentException 발생
- [x] 0 입력 시 IllegalArgumentException 발생

## 5. 기타 요구사항
### 5.1 코드 컨벤션
- [x] 인덴트 뎁스 2까지만 허용
- [x] 3항 연산자 사용 금지
- [x] 메서드가 한 가지 일만 수행하도록 구현
- [x] Java 코드 컨벤션 준수

### 5.2 테스트
- [x] JUnit 5와 AssertJ를 사용한 단위 테스트 구현
   - 자동차 이름 유효성 검증 테스트
   - 시도 횟수 유효성 검증 테스트
   - 자동차 이동 로직 테스트
   - 우승자 선정 로직 테스트
   - 예외 처리 테스트

### 5.3 기술적 제약사항
- [x] JDK 21 사용
- [x] 외부 라이브러리 사용 금지 (제공된 라이브러리 제외)
- [x] System.exit() 사용 금지
- [x] 패키지 구조 유지
- [x] camp.nextstep.edu.missionutils의 Randoms와 Console API 사용

```

# 커밋 메시지 작성 가이드

## 기본 형식

```
<타입>(<범위>): <제목>

<본문>

<꼬리말>
```

## 타입

- feat: 새로운 기능 추가
- fix: 버그 수정
- docs: 문서 수정
- style: 코드 포맷팅, 세미콜론 누락, 코드 변경이 없는 경우
- refactor: 코드 리팩토링
- test: 테스트 코드, 리팩토링 테스트 코드 추가
- chore: 빌드 업무 수정, 패키지 매니저 수정

## 제목 규칙

- 제목은 50자를 넘기지 않습니다.
- 첫 글자는 대문자로 시작합니다.
- 마지막에 마침표(.)를 붙이지 않습니다.
- 명령문으로 작성합니다. ("추가하다", "변경하다" 등)

## 본문 규칙

- 각 줄은 72자를 넘기지 않습니다.
- 어떻게 변경했는지보다 무엇을, 왜 변경했는지 설명합니다.

## 꼬리말 규칙

- Resolve : 기능목록
- BREAKING CHANGE가 있을 경우 명시합니다.

## 예시

```
feat(로그인): 소셜 로그인 기능 추가

카카오와 네이버 소셜 로그인 기능을 추가했습니다.
사용자 편의성을 높이고 회원가입 절차를 간소화하기 위한 목적입니다.

BREAKING CHANGE: 기존 로그인 API의 응답 형식이 변경되었습니다.
```

# MVC 아키텍처

## 🧩 구성 요소 및 예제 코드

### Application
- 프로그램의 시작점

```java
public class Application {
    public static void main(String[] args) {
        InputView inputView = new ConsoleInputView();
        OutputView outputView = new ConsoleOutputView();
        InputValidator inputValidator = new InputValidator();
        ModelFactory modelFactory = new ModelFactory();
        
        Controller controller = new Controller(inputView, outputView, inputValidator, modelFactory);
        controller.run();
    }
}
```

### 컨트롤러 (Controller)
- 주요 게임 루프 관리
- 사용자 입력 처리 및 모델 프로세싱
- 뷰와 모델 컴포넌트 간 조정

```java
public class Controller {
    private final InputView inputView;
    private final OutputView outputView;
    private final InputValidator inputValidator;
    private final ModelFactory modelFactory;

    public Controller(InputView inputView, OutputView outputView,
                      InputValidator inputValidator, ModelFactory modelFactory) {
        this.inputView = inputView;
        this.outputView = outputView;
        this.inputValidator = inputValidator;
        this.modelFactory = modelFactory;
    }

    public void run() {
        try {
            String input = getValidInput();
            Model model = modelFactory.createModel(input);
            String result = model.process();
            outputView.printResult(result);
        } catch (Exception e) {
            outputView.printError(e.getMessage());
        }
    }

    private String getValidInput() {
        while (true) {
            try {
                String input = inputView.readInput();
                inputValidator.validate(input);
                return input;
            } catch (IllegalArgumentException e) {
                outputView.printError(e.getMessage());
            }
        }
    }
}
```

### 뷰 (View)
- **입력뷰 (InputView)**: 사용자 입력 읽기 인터페이스
- **출력뷰 (OutputView)**: 출력 표시 인터페이스

```java
public interface InputView {
    String readInput();
}

public class ConsoleInputView implements InputView {
    @Override
    public String readInput() {
        return camp.nextstep.edu.missionutils.Console.readLine();
    }
}

public interface OutputView {
    void printResult(String result);
    void printError(String error);
}

public class ConsoleOutputView implements OutputView {
    @Override
    public void printResult(String result) {
        System.out.println(result);
    }

    @Override
    public void printError(String error) {
        System.out.println("[ERROR] " + error);
    }
}
```

### 모델 (Model)
- **모델 (Model)**: 게임 로직 인터페이스
- **모델팩토리 (ModelFactory)**: 적절한 모델 인스턴스 생성

```java
public interface Model {
    String process();
}

public class DefaultModel implements Model {
    private final String input;

    public DefaultModel(String input) {
        this.input = input;
    }

    @Override
    public String process() {
        return "처리된 결과: " + input;
    }
}

public class ModelFactory {
    public Model createModel(String input) {
        return new DefaultModel(input);
    }
}
```

### 유틸리티
- **입력검증기 (InputValidator)**: 사용자 입력 유효성 검사

```java
public class InputValidator {
    public void validate(String input) {
        if (input == null || input.trim().isEmpty()) {
            throw new IllegalArgumentException("입력이 비어있습니다.");
        }
        // 추가적인 검증 규칙을 여기에 구현
    }
}
```
## 프로젝트 구조

```
src
├── main
│   └── java
│       └── com
│           └── example
│               ├── Application.java
│               ├── controller
│               │   └── Controller.java
│               ├── model
│               │   ├── Model.java
│               │   ├── DefaultModel.java
│               │   └── ModelFactory.java
│               ├── view
│               │   ├── input
│               │   │   ├── InputView.java
│               │   │   └── ConsoleInputView.java
│               │   └── output
│               │       ├── OutputView.java
│               │       └── ConsoleOutputView.java
│               └── util
│                   └── InputValidator.java
└── test
    └── java
        └── com
            └── example
                ├── controller
                ├── model
                ├── view
                └── util
```

## 패키지 설명

1. `com.example`: 프로젝트의 루트 패키지
    - `Application.java`: 프로그램의 진입점

2. `com.example.controller`: 컨트롤러 관련 클래스
    - `Controller.java`: 주요 게임 로직을 관리하고 Model과 View를 조정

3. `com.example.model`: 모델 관련 클래스
    - `Model.java`: 모델 인터페이스
    - `DefaultModel.java`: 기본 모델 구현
    - `ModelFactory.java`: 모델 객체 생성을 담당하는 팩토리 클래스

4. `com.example.view`: 뷰 관련 클래스
    - `input`: 입력 관련 클래스
        - `InputView.java`: 입력 뷰 인터페이스
        - `ConsoleInputView.java`: 콘솔 기반 입력 뷰 구현
    - `output`: 출력 관련 클래스
        - `OutputView.java`: 출력 뷰 인터페이스
        - `ConsoleOutputView.java`: 콘솔 기반 출력 뷰 구현

5. `com.example.util`: 유틸리티 클래스
    - `InputValidator.java`: 사용자 입력 유효성 검사 클래스

## ✨ 주요 특징

1. **모듈성**: 관심사의 명확한 분리로 유지보수 용이
2. **확장성**: 새로운 기능이나 모델 추가가 쉬움
3. **테스트 용이성**: 의존성 주입을 통한 단위 테스트 용이
4. **유연성**: 인터페이스를 통한 다양한 입출력 구현 가능
5. **오류 처리**: 중앙집중식 오류 관리
6. **재사용성**: 모델팩토리를 통한 다양한 게임 모델 관리

## 📅 개발 계획

| 단계 | 초점 |
|----|------|
| 1  | 기본 구조 구현 및 입출력 테스트 |
| 2  | 입력검증기 구현 및 유효성 검사 규칙 |
| 3  | 모델팩토리 및 기본 모델 구현 |
| 4  | 다양한 모델 구현 및 게임 로직 |
| 5  | 예외 처리 및 엣지 케이스 관리 |
| 6  | 시스템 통합 및 최적화 |

## 🚀 시작하기

1. 저장소 클론
2. 프로젝트 디렉토리로 이동
3. `Application.java` 실행하여 애플리케이션 시작


## 🛠️ 확장 및 커스터마이징

- 새로운 모델 추가: `Model` 인터페이스를 구현하고 `ModelFactory`에 추가
- 다른 입출력 방식: `InputView`와 `OutputView` 인터페이스의 새로운 구현 제공
- 추가 유효성 검사: `InputValidator`에 새로운 검증 규칙 추가

## 🤝 기여하기

깃 팔로우를 걸어주세요!
