# ✏️자동차 경주 게임 입력값 규칙

안녕하세요! 자동차 경주 게임에 오신 여러분들을 환영합니다.

자동차 경주 게임 진행에 앞서, 게임의 입력값에 대한 규칙을 설명해 드리려고 합니다.

## 📝자동차 이름에 대하여

구분자(,) 를 기준으로 자동차의 이름을 입력해주시면 됩니다.

출전하는 자동차는 반드시 2대 이상이어야 합니다. 우승자의 자리를 두고 다퉈야 하니 두 대 이상이 당연히 출전해야겠죠?!

- ex) `토끼,` 와 같은 입력값은 한 대로 간주되어 잘못된 입력값으로 인해 게임이 종료되니 주의해주세요!

이름의 각 양쪽의 공백은 제거됩니다.

- ex) `토끼, 거북이` → 토끼와 거북이가 출전하는 것으로 입력됩니다. 거북이 앞의 공백이 제거됩니다.

자동차의 이름은 자유롭게 입력해주시면 됩니다! 단, 숫자와 한글, 알파벳만을 입력하실 수 있습니다.

- ex) `토a끼,거1북이` 는 가능합니다.
- ex) `토끼,**거북이` 는 불가능합니다.

구분자(,) 로 끝내거나 구분자(,) 만 존재하는 것은 불가능합니다!

- ex)`토끼,거북이,` 는 불가능합니다.
- ex) `,,,,` 는 불가능합니다.

자동차의 이름은 반드시 5자 이하여야 합니다! 그러나 이 때 이름 양쪽 끝 공백은 글자 수로 간주하지 않습니다.

- ex) `토끼깡총, 거북이` 는 가능합니다.
- ex) `토끼깡총, 거북이`          는 가능합니다.
- ex) `토끼깡총, 거   북이` 는 불가능합니다.
- ex) `토끼깡총, 거북이엉금엉금` 은 불가능합니다.

## 📝시도 횟수에 대하여

입력하신 시도 횟수만큼 게임을 진행하실 수 있습니다. 이는 `라운드` 라고 하겠습니다.

그러나 라운드는 10번 이하여야 합니다. 너무 오랜 시간 동안의 게임 진행은 게임 중독 위험이 있습니다! 😓

라운드는 반드시 0보다 큰 정수여야 합니다.

즉, 0이거나 음수, 소수일 수 없습니다. 게임을 -1 회만큼 진행할 수 있을까요? 0번 진행하는 건 게임이 아니겠죠! 2.3회 게임 진행 해보셨나요?

- ex) `0` , `-1` , `2.3` 은 불가능합니다.

당연히 숫자 이외의 값은 입력하실 수 없습니다.

- ex) `d` , `rabbit` 은 불가능합니다.

그럼 모두 입력값을 잘 입력해 재밌는 게임 시간 보내시길 바라겠습니다! 🙇🏻

---

# 🚗 자동차 경주 기능 명세서💭

## 자동차는 움직일 수 있다.

- [x] 무작위 값이 4 이상인 경우 자동차는 움직인다.
- [x] 주어진 라운드 동안 움직이거나 멈춰있을 수 있다.

## 자동차는 이름을 가질 수 있다.

- [x] 이름은 5자 이하만 가능하다.
- [x] 중복된 이름은 가질 수 없다.

## 숫자는 무작위로 구해질 수 있다.

- [x] 0에서 9 사이까지 무작위로 구해진다.

## 자동차는 우승할 수 있다.

- [x] 가장 멀리 나간 자동차는 우승자가 된다.

## 사용자는 입력할 수 있다.

### 사용자는 자동차의 이름과 총 라운드를 입력할 수 있다.

- [x] 경주할 자동차 이름은 쉼표(,) 로 구분된다.
  ```pobi,woni,jun```

- [x] 총 라운드를 입력할 수 있다.
  ```5```

### 사용자는 잘못된 형태를 입력할 수 없다.

다음과 같은 경우들에는 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 공통

- [x] 빈 값을 입력해서는 안된다.

### 자동차의 이름

- [x] 5자를 초과해서 입력해서는 안된다.

- 직접 추가한 규칙들
    - [x] , 쉼표만 입력되어서는 안된다.
    - [x] , 쉼표로 끝나서는 안된다.
    - [x] 이름의 양쪽의 공백은 제거된다. 즉, 5자 초과 조건에 들어가지 않는다.
        - [x] 입력값 중간의 공백은 제거되지 않는다.
    - [x] 이름은 숫자, 한글, 영어만 입력할 수 있다.
    - [x] 2대 이상 출전해야 한다.

### 총 라운드

- 직접 추가한 규칙들
- [ ] 총 라운드는 0보다 큰 정수여야 한다.
    - [ ] 문자열이 포함될 수 없다.
    - [ ] 음수일 수 없다.
    - [ ] 0일 수 없다.
    - [ ] 소수일 수 없다.
- [x] 총 라운드는 10회 이하여야 한다.

## 사용자는 결과를 볼 수 있다.

### 우승자를 확인할 수 있다.

- [x] 단독 우승자인 경우에는 다음과 같이 출력되어야 한다.
  ```최종 우승자 : pobi```
- [x] 공동 우승자가 존재하는 경우에는 다음과 같이 출력되어야 한다.
  ```최종 우승자 : pobi, jun```

## 차수마다 자동차의 이동 결과를 확인할 수 있다.

- [x] 다음과 같은 형태로 차수마다의 이동 결과가 출력되어야 한다.
  ```
  pobi : --
  woni : ----
  jun : ---
  ```

# 프로그래밍 요구사항

- [ ] JDK 21 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 Application의 main()이다.
- [ ] build.gradle 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.
- [ ] 프로그램 종료 시 System.exit()를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] 자바 코드 컨벤션을 지키면서 프로그래밍한다.
- [ ] 기본적으로 Java Style Guide를 원칙으로 한다.

# 프로그래밍 요구사항 2

- [ ] indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
- [ ] 3항 연산자를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- [ ] JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
