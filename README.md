# java-racingcar-precourse
# 자동차 경주

## 과제 진행 요구 사항

- 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
- **기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리**해 추가한다.
- Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
    - [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
- 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

## 기능 요구 사항

초간단 자동차 경주 게임을 구현한다.

- 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
- 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
- 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
- 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
- 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
- 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
- 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
- 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

### 입출력 요구 사항

#### 입력

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```autohotkey
pobi,woni,jun
```

- 시도할 횟수

```undefined
5
```

#### 출력

- 차수별 실행 결과

```ada
pobi : --
woni : ----
jun : ---
```

- 단독 우승자 안내 문구

```ada
최종 우승자 : pobi
```

- 공동 우승자 안내 문구

```ada
최종 우승자 : pobi, jun
```

#### 실행 결과 예시

```ada
경주할 자동차 이름을 입력하세요.(이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는 몇 회인가요?
5

실행 결과
pobi : -
woni : 
jun : -

pobi : --
woni : -
jun : --

pobi : ---
woni : --
jun : ---

pobi : ----
woni : ---
jun : ----

pobi : -----
woni : ----
jun : -----

최종 우승자 : pobi, jun
```

## 프로그래밍 요구 사항 1

- JDK 21 버전에서 실행 가능해야 한다.
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
- 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/blob/main/styleguide/java)를 원칙으로 한다.

## 프로그래밍 요구 사항 2

- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
    - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
    - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 3항 연산자를 쓰지 않는다.
- 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
- JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
    - 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
        - [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide)
        - [AssertJ User Guide](https://assertj.github.io/doc)
        - [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
        - [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 라이브러리

- `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

#### 사용 예시

- 0에서 9까지의 정수 중 한 개의 정수 반환

```java
Randoms.pickNumberInRange(0, 9);
```


[![우아한테크코스 로고](https://apply.techcourse.co.kr/assets/logo/logo_full_light.png)](https://woowacourse.github.io/)

[](https://github.com/woowacourse/)[](https://www.youtube.com/channel/UC-mOekGSesms0agFntnQang/featured?view_as=subscribe)[](https://instagram.com/wooteco?igshid=YmMyMTA2M2Y)

Copyright 우아한테크코스. All rights reserved.

[  
](https://pf.kakao.com/_budWj)

---

### 2주차 프리코스 목표

- 기본 요구사항을 충실히 반영하고 검토하기
- MVC 패턴을 도입하여 코드 구조를 개선하고 유지보수성을 높이기
- 1주차 과제에서 발견된 개선사항을 반영하여 프로젝트 완성도 향상하기
---
### 구현할 기능 목록

-[x] 자동차 이름들을 입력받는다.
-[x] 라운드 횟수를 입력받는다.
-[ ] 잘못된 값이 입력되면 IllegalArgumentException을 발생시킨다.
-[ ] , 를 통해 자동차 이름을 구분짓는다.
-[ ] 이름을 이용해 자동차 객체를 생성한다.
-[ ] 라운드가 시작되면 자동차를 주어진 조건에 따라 움직인다.
-[ ] 라운드가 끝날 때마다 현재 진행 결과를 출력한다.
-[ ] 라운드가 끝나면 우승자를 찾아낸다.
-[ ] 우승자가 여러 명이면 ,를 통해 구분한다.
-[ ] 우승자를 출력한다.

---
### 클래스 별 역할

main
- 컨트롤러 실행

RaceController
- 입력 값을 받기
- 입력 값을 검증하기
- 경주 서비스 시작하기
- 출력 값을 출력해주기

RaceService
- 입력 값을 파싱하기
- 파싱된 입력 값으로 자동차 객체 만들기
- 경주 시작하기
- 우승자 알아내기

Race
- 라운드 마다 차별로 주사위 돌리기
- 조건 맞으면 차를 이동시키기

InputValidater
- 입력 값이 없으면 오류
- 5자 초과된 이름이면 오류
- 입력횟수가 양수가 아니면 오류

CarNameParser
- ','를 기준으로 파싱하기

RandomNumberGenerator
- 랜덤 값 생성 후 결과 알려주기

CarManager

- 문자열을 사용해 자동차 객체 만들기 
- 리스트로 묶기

Car
- 이름
- 이름 넘겨주기
- 이동하기

WinnerFinder
- 1등 찾기
- 여러명일 경우 ","를 사용해 구분하기

InputView
- 자동차의 갯수 입력받기
- 자동차의 이름 입력받기
- 이동 횟수 입력받기

OutputView
- 안내 멘트 출력하기
- 이동결과 출력하기
- 우승자 출력하기
---

