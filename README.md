# java-racingcar-precourse

## 구현 기능

### CONFIG
- [X] bean 등록을 위한 project scan 기능
- [X] bean 등록 대상으로 지정하기 위한 annotation
- [X] IoC를 위한 DI 기능
- [X] FrontController

### INPUT
- [X] 자동차 이름 입력
- [X] 시행할 횟수 입력

### PARSING
- [X] 자동차 이름
- [X] 시행할 횟수

### VALIDATION
- [X] 자동차 이름 길이
- [X] 자동차 이름 중복
- [X] 시행할 횟수 음수

### SERVICE
- [X] 랜덤 이동 기능
- [X] 레이싱 결과 계산
- [X] 승자 선정

### OUTPUT
- [X] 레이싱 결과 출력
- [X] 승자 출력

---

## 추가 설명

### 추가 구현 기능 설명
1. **bean 등록을 위한 project scan 기능**
    - `@Controller`, `@Service` 어노테이션이 적용된 클래스를 찾아서 반환한다.
    - `@Component`로 등록할 수 있었으나, 추후를 대비하여 `@Controller`, `@Service`로 분리하였다.
2. **bean container**
    - 지정한 클래스를 bean으로 등록하고, 의존성 주입을 통해 객체를 생성한다.
    - 의존성 주입 시 순환 참조를 감지하여 예외를 발생시킨다.
    - bean container에서 bean을 가져올 때, 싱글톤 패턴을 적용하여 동일한 객체를 반환한다.
    - bean container에서 bean을 가져올 때, 해당 class와 interface를 통해 가져올 수 있다.

### 고려했던 점
1. **view의 역할**
   - view의 역할을 일반적인 frontEnd의 역할로 정의하고, 그에 따른 역할을 하도록 구현했습니다.
   - 다만, view에서 json을 전송하고 dto에 mapping하는 과정은 현재 코드에서는 불필요한 연산만 진행하는 것이라 생략하고 dto로 대체했습니다.
2. **파싱과 검증**
    - 파싱과 검증을 어느 단계에서 진행해야 하는지에 대한 고민이 있었습니다. 이런 구현이 잘 되어있는 spring의 구조를 참고해서 코드를 작성했습니다. <br>
      - 파싱은 frontEnd가 입력을 받아 json으로 가공하여 backEnd에게 전송하듯이 view에서 진행했습니다. <br>
      - 검증은 @Valid를 참고하여 frontController에서 view에게서 정보를 받고, 검증한 후에 Controller로 넘겨주는 방식으로 진행했습니다.
3. **프로젝트의 진입점과 bean 관리의 주체**
   - 프로젝트의 진입점은 frontController로 설정하고, bean container에서 bean을 관리하는 것은 ApplicationContext로 설정했습니다.

### 커스텀 제약사항
1. 자동차 이름 길이는 1자 이상, 5자 이하
2. 자동차 이름 중복 불가
3. 시행할 횟수는 0 이상