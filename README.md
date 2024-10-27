# java-racingcar-precourse

> 우아한테크코스 웹 백엔드 7기 프리코스 2주차

## 📚 목차
1. [💻 개발 환경](#-개발-환경)
2. [🎯 학습 목표](#-학습-목표)
   - [1️⃣ JUnit 5 사용법 숙지](#1-junit-5-사용법-숙지)
   - [2️⃣ 인텔리제이 디버깅 학습](#2-인텔리제이-디버깅-학습)
   - [3️⃣ Indent Depth 개선 및 코드 가독성 향상](#3-indent-depth-개선-및-코드-가독성-향상)
3. [📝 기능 요구 사항 분석](#-기능-요구-사항-분석)
   - [📄 기능 목록](#-기능-목록)
   - [✏ 기능 세부 사항](#-기능-세부-사항)
4. [📥 입출력 요구 사항](#-입출력-요구-사항)
5. [📊 디자인 및 흐름도](#-디자인-및-흐름도)

---

## 💻 개발 환경

| 항목             | 세부 사항              |
|------------------|------------------------|
| **IDE**          | IntelliJ               |
| **JDK**          | JDK 21                 |
| **Build Tool**   | Gradle                 |
| **Test**         | JUnit                  |
| **OS**           | Windows 10             |

---

## 🎯 학습 목표

### 1) JUnit 5 사용법 숙지
> 아래 문서를 참고하여 테스트 도구 사용법을 학습하고자 합니다.
- [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
- [AssertJ User Guide](https://assertj.github.io/doc/)
- [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
- [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

### 2) 인텔리제이 디버깅 학습
> 1주차 공통 피드백을 반영하여 아래 영상을 통해 `IDE`에서 디버깅하는 방법을 학습하고자 합니다.

- [[10분 테코톡] 🍟 웨지의 인텔리제이 디버깅](https://youtu.be/gkutTlwi70s)
- [[10분 테코톡] 오리의 Intellij Debugging](https://youtu.be/JSVvhwwOvAY)

### 3) Indent Depth 개선 및 코드 가독성 향상
> 자기소개서에 작성한 2주차 목표대로 코드의 가독성을 높이는 작업에 집중하겠습니다.
- indent(인덴트, 들여쓰기) depth를 3 이상으로 하지 않도록 하여, **최대 2단계의 들여쓰기**만 허용할 것입니다.
- **함수(또는 메서드)를 분리**하여 들여쓰기를 줄이고, 함수가 한 가지 일만 하도록 코드를 최대한 **작고 명확하게** 작성하겠습니다.
- **삼항 연산자**를 사용하지 않고, 명확한 조건문을 활용해 코드 가독성과 유지보수성을 높이겠습니다.

---

## 📝 기능 요구 사항 분석

### 📄 기능 목록
- [x] 자동차 이름 입력 및 처리
- [x] 시도할 횟수 입력
- [x] 경주 이동 로직 구현
- [x] 차수별 결과 출력
- [x] 최종 우승자 구하기
- [x] 최종 우승자 출력

### ✏ 기능 세부 사항

#### 1) 자동차 이름 입력 및 처리
> 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- **기능 설명**: 사용자로부터 경주할 자동차의 이름을 입력받는다.
- **세부 사항**:
  - 자동차 이름은 쉼표(,)로 구분된다.
  - 예) `pobi,woni,jun`
- **예외 발생**:
  - 사용자가 형식에 맞지 않게 입력할 경우 `IllegalArgumentException`를 발생시킨다.
  - 1. `,` 대신 다른 구분자를 사용할 경우
  - 2. 빈 값을 입력한 경우 (자동차 이름이 빈 값인 경우 포함)
  - 3. 실제 입력값이 2개 미만인 경우
  - 4. 자동차 이름이 5자 초과일 경우  

#### 2) 시도할 횟수 입력
> 입력은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

- **기능 설명**: 사용자로부터 경주를 시도할 횟수를 입력받는다.
- **세부 사항**:
  - 입력받은 값은 양수여야 한다.
  - 예) `5`
- **예외 발생**:
    - 사용자가 형식에 맞지 않게 입력할 경우 `IllegalArgumentException`를 발생시킨다.
    - 1. 사용자가 0 또는 음수를 입력할 경우
    - 2. 입력값이 숫자가 아닐 경우

#### 3) 경주 이동 로직 구현
> 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.

- **기능 설명**: 각 자동차가 이동하는 로직을 구현한다.
- **세부 사항**:
  - 랜덤 함수를 사용하여 자동차의 이동을 결정한다.
  - 랜덤 수치가 특정 조건을 만족할 경우 자동차의 거리를 증가시킨다.

#### 4) 차수별 결과 출력
- **기능 설명**: 각 차수별 자동차의 이동 결과를 출력한다.
- **세부 사항**:
  - 각 자동차의 이름과 이동 거리를 `-` 기호로 표시한다.
  - ex) 
    ```
    pobi : --
    woni : ----
    jun : ---
    ```

#### 5) 최종 우승자 구하기
- **기능 설명**: 최종 우승자를 결정하는 로직을 구현한다.
- **세부 사항**:
  - 모든 자동차의 이동 거리 중 최대값을 찾고, 해당 거리를 가진 자동차들을 우승자로 결정한다.

#### 6) 최종 우승자 출력
- **기능 설명**: 최종 우승자를 출력한다.
- **세부 사항**:
  - 우승자가 한 명일 경우: `최종 우승자 : pobi`
  - 공동 우승자가 있을 경우: `최종 우승자 : pobi, jun`

---

## 📥 입출력 요구 사항
- **입력**: 경주할 자동차

 이름, 시도할 횟수
- **출력**: 차수별 결과, 최종 우승자

- **실행 결과 예시**:
```java
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

---

## 📊 디자인 및 흐름도

```plaintext
+--------------------+
|  자동차 이름 입력   |
+--------------------+
          |
          v
+--------------------+
|   시도할 횟수 입력  |
+--------------------+
          |
          v
+--------------------+
|    경주 로직 실행   |
+--------------------+
          |
          v
+--------------------+
|   차수별 결과 출력  |
+--------------------+
          |
          v
+--------------------+
|   최종 우승자 출력   |
+--------------------+
```
