## **자동차 경주**

**작성자 :** 이찬형  
**프로젝트** : 우아한 테크코스 프리코스 7기 - 2주차 과제
&nbsp;

## 📋 목차

- [📌프로젝트 소개](#프로젝트-소개)
- [🚀️기능](#기능)
- [🖥️입출력 예시](#입출력-예시)
    - [입력](#입력)
    - [출력](#출력)
    - [실행 결과 예시](#실행-결과-예시)
- [🚨예외 사항](#예외-사항)
- [⭐사전 요구 사항](#사전-요구-사항)
    - [과제 진행 요구 사항](#과제-진행-요구-사항)
    - [프로그래밍 요구 사항 1](#프로그래밍-요구-사항-1)
    - [프로그래밍 요구 사항 2](#프로그래밍-요구-사항-2)
- [📦라이브러리 사용 안내](#라이브러리-사용-안내)

## 📌**프로젝트 소개**

**자동차들이 경주를 하여 우승자를 가리는 게임 프로젝트입니다.**

![Java Version](https://img.shields.io/badge/Java-21-blue?style=for-the-badge)  
![Gradle](https://img.shields.io/badge/build%20with-Gradle-green?style=for-the-badge)  
&nbsp;

## 📂 프로젝트 구조

⚠️ 아래 구조는 지속적으로 수정/보완될 예정입니다!

```java
└──src/
        ├──main/
        │   └──java/
        │       └──racingcar/
        │           ├──view/
        │           │   └──View.java
    │           └──Application.java
    └──test/
        └──java/
        └──racingcar/
        └──ApplicationTest.java
├──README.md
├──build.gradle
```

&nbsp;

## 🚀**기능**

- 사용자로부터 입력받은 자동차 이름을 기준으로 경주를 진행합니다.
- 각 차수마다 전진 결과가 출력되며, 우승자를 가립니다.
- 잘못된 값이 입력된 경우 오류가 발생하여 애플리케이션이 종료됩니다.  
  &nbsp;

## 🖥️**입출력 예시**

### **입력**

- 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)

```java
pobi,woni,jun
```

- 시도할 횟수

```java
5
```

### **출력**

- 차수별 시행 결과

```java
pobi :--
woni :----
jun :---
```

- 단독 우승자 안내 문구

```java
최종 우승자 :pobi
```

- 공동 우승자 안내 문구

```java
최종 우승자 :pobi,jun
```

### **실행 결과 예시**

```java
경주할 자동차
이름을 입력하세요.(

이름은 쉼표(,) 기준으로 구분)
pobi,woni,jun
시도할 횟수는
몇 회인가요?
        5

실행 결과
pobi :-
woni :
jun :-

pobi :--
woni :-
jun :--

pobi :---
woni :--
jun :---

pobi :----
woni :---
jun :----

pobi :-----
woni :----
jun :-----

최종 우승자 :pobi,jun
```

&nbsp;

## 🚨**예외 사항**

프로젝트에서 다음과 같은 경우 **예외**가 발생할 수 있습니다. 이 경우, 프로그램은 `IllegalArgumentException`을 발생시키며 종료됩니다.

1. **자동차 이름 입력 오류**
    - 자동차 이름이 **공백**이거나 **5자를 초과**한 경우.
    - 자동차 이름에 **쉼표**(,)로 구분되지 않은 경우.
    - 입력된 자동차 이름이 **중복된** 경우.

2. **시도 횟수 입력 오류**
    - 시도 횟수가 **1 미만**인 경우.
    - **숫자가 아닌 값**을 입력한 경우.

예외 발생 시, 해당 오류 메시지를 출력하고 프로그램을 종료합니다. 이를 통해 사용자가 잘못된 입력을 수정할 수 있도록 돕습니다.

&nbsp;

## ⭐**사전 요구 사항**

- [ ] **JDK 21**이 설치되어 있어야 합니다. [JDK 21 설치 가이드](https://openjdk.org/projects/jdk/21/)를 참고하세요.
- [ ] **Git**이 설치되어 있어야 합니다. [Git 설치 가이드](https://git-scm.com/book/en/v2/Getting-Started-Installing-Git)를 참고하세요.
- [ ] **Gradle**을 설치하거나, 프로젝트에 포함된 **Gradle Wrapper**를 사용할 수 있어야 합니다.
- [ ] 명령어를 실행할 수 있는 **터미널 또는 명령 프롬프트**가 필요합니다.  
  &nbsp;

### **과제 진행 요구 사항**

- [ ] 미션은 자동차 경주 저장소를 **포크하고 클론**하는 것으로 시작한다.
- [ ] 기능을 구현하기 전 **README.md**에 구현할 기능 목록을 정리해 추가한다.
- [ ] Git의 커밋 단위는 앞 단계에서 README.md에 정리한 기능 목록 단위로 추가한다.
- [ ] [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋
  메시지를 작성한다.
- [ ] 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.  
  &nbsp;

### **프로그래밍 요구 사항 1**

- [ ] **JDK 21** 버전에서 실행 가능해야 한다.
- [ ] 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- [ ] `build.gradle` 파일은 변경할 수 없으며, 제공된 라이브러리 이외의 **외부 라이브러리**는 사용하지 않는다.
- [ ] 프로그램 종료 시 **`System.exit()`**를 호출하지 않는다.
- [ ] 프로그래밍 요구 사항에서 달리 명시하지 않는 한 **파일, 패키지** 등의 이름을 바꾸거나 이동하지 않는다.
- [ ] **자바 코드 컨벤션**을 지키면서 프로그래밍한다.
    - 기본적으로 [Java Style Guide](https://google.github.io/styleguide/javaguide.html)를 원칙으로 한다.  
      &nbsp;

### **프로그래밍 요구 사항 2**

- [ ] `indent`(인덴트, 들여쓰기) depth를 **3이 넘지 않도록** 구현한다. 2까지만 허용한다.
    - 예를 들어 **`while`문** 안에 **`if`문**이 있으면 들여쓰기는 2이다.
    - 힌트: `indent`(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 **함수(또는 메서드)를 분리**하면 된다.
- [ ] **3항 연산자**를 쓰지 않는다.
- [ ] 함수(또는 메서드)가 **한 가지 일만** 하도록 최대한 작게 만들어라.
- [ ] **JUnit 5**와 **AssertJ**를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 **테스트 코드**로 확인한다.

&nbsp;

## 📦**라이브러리 사용 안내**

- [ ] `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
    - [ ] **Random 값 추출**: `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
    - [ ] **사용자가 입력하는 값**: `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.
