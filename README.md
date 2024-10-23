🏎️ 자동차 경주
==========

💡 목표
------
### 학습 목표
* 여러 역할을 수행하는 큰 함수를 단일 역할을 수행하는 작은 함수로 분리한다.
* 테스트 도구를 사용하는 방법을 배우고 프로그램이 제대로 작동하는지 테스트한다.
* [1주 차 공통 피드백](https://docs.google.com/document/d/1MdiqBV5nhSfFB96-p5LlKrGM8uLopXslh1vEzwxR9Bo/edit?tab=t.0#heading=h.fyai3q8fe62f)을 최대한 반영한다.

### 회고
아래 질문에 대한 중간 회고를 진행하고 소감에 구체적인 결과를 작성한다. 소감은 텍스트로 작성해야 하며 외부 링크는 허용하지 않는다.

* 지원서에 작성한 목표를 얼마나 달성하고 있다고 생각하나요? 그 이유는 무엇인가요?
* 지원서에 작성한 목표를 변경해야 한다고 생각하시나요? 그렇다면 그 이유와 어떤 목표로 변경하고 싶으신가요?
* 프리코스를 진행하면서 눈에 띄는 변화나 깨달은 점이 있나요?

***

ℹ️ 과제 진행 요구사항
--------

* 미션은 [자동차 경주](https://github.com/woowacourse-precourse/java-racingcar-7) 저장소를 포크하고 클론하는 것으로 시작한다.
* 기능을 구현하기 전 `README.md`에 구현할 기능 목록을 정리해 추가한다.
* Git의 커밋 단위는 앞 단계에서 `README.md`에 정리한 기능 목록 단위로 추가한다.
  * [AngularJS Git Commit Message Conventions](https://gist.github.com/stephenparish/9941e89d80e2bc58a153)을 참고해 커밋 메시지를 작성한다.
* 자세한 과제 진행 방법은 프리코스 진행 가이드 문서를 참고한다.

📍 기능 요구 사항
-------

초간단 자동차 경주 게임을 구현한다.

* 주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
* 각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
* 자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
* 사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
* 자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
* 우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
* 사용자가 잘못된 값을 입력할 경우 `IllegalArgumentException`을 발생시킨 후 애플리케이션은 종료되어야 한다.

## 입출력 요구 사항

### 입력

* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
```
    pobi,woni,jun
```

* 시도할 횟수
```
    5
```

### 출력
* 차수별 실행 결과
```
    pobi : --
    woni : ----
    jun : ---
```

* 단독 우승자 안내 문구
```
    최종 우승자 : pobi  
```

* 공동 우승자 안내 문구
```
    최종 우승자 : pobi, jun
```

### 실행 결과 예시
```

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

💻 프로그래밍 요구 사항 1
-------

* JDK 21 버전에서 실행 가능해야 한다.
* 프로그램 실행의 시작점은 `Application`의 `main()`이다.
* `build.gradle` 파일은 변경할 수 없으며, **제공된 라이브러리 이외의 외부 라이브러리는 사용하지 않는다.**
* 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
* 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 등의 이름을 바꾸거나 이동하지 않는다.
* 자바 코드 컨벤션을 지키면서 프로그래밍한다.
    * 기본적으로 [Java Style Guide](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/java)를 원칙으로 한다.

💻 프로그래밍 요구 사항 2
-------
* indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 3항 연산자를 쓰지 않는다.
* 함수(또는 메서드)가 한 가지 일만 하도록 최대한 작게 만들어라.
* JUnit 5와 AssertJ를 이용하여 정리한 기능 목록이 정상적으로 작동하는지 테스트 코드로 확인한다.
  * 테스트 도구 사용법이 익숙하지 않다면 아래 문서를 참고하여 학습한 후 테스트를 구현한다.
    * [JUnit 5 User Guide](https://junit.org/junit5/docs/current/user-guide/)
    * [AssertJ User Guide](https://assertj.github.io/doc/)
    * [AssertJ Exception Assertions](https://www.baeldung.com/assertj-exception-assertion)
    * [Guide to JUnit 5 Parameterized Tests](https://www.baeldung.com/parameterized-tests-junit-5)

## 라이브러리
* `camp.nextstep.edu.missionutils`에서 제공하는 `Randoms` 및 `Console` API를 사용하여 구현해야 한다.
  * Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.
  * 사용자가 입력하는 값은 `camp.nextstep.edu.missionutils.Console`의 `readLine()`을 활용한다.

### 사용 예시
* 0에서 9까지의 정수 중 한 개의 정수 반환
```
    Randoms.pickNumberInRange(0, 9);
```

***
📍 과제 목표
=======
~~~
* 요구 사항에서 놓친 것이 없도록 꼼꼼히 체크하기 
* 테스트를 할 경우에 대해서 더 다양하게 생각하기
* 과도하게 주석 달지 않기
* 변수나 메소드 이름에 의도를 포함하기
* 깃 익히기
~~~

📍 기능 목록 체크리스트
=======

> **기능 목록**

### ☀️ 입력
* `camp.nextstep.edu.missionutils`에서 제공하는 `Console` API를 사용
* 경주할 자동차 이름(이름은 쉼표(,) 기준으로 구분)
* 시도 회수 입력

### ✨ 입력값 검사
* 시도 회수
  * 숫자가 아닌 값이 입력되었을 때 예외
  * 시도 회수가 빈값일 때 예외
* 경주할 자동차 이름
  * 자동차 이름이 5자 이상일 때 예외
  * 자동차 이름에 알파벳과 숫자 외의 문자가 있을 때 예외
  * 자동차 이름이 빈값일 때 예외

### ✨ 경주할 자동차 이름 분리
* 제대로 입력받은 자동차 이름들을 쉼표(,)를 기준으로 분리

### ✨ 자동차 경주하기
* 시도 회수 만큼 경주를 수행한다. 
* 자동차는 정지 혹은 전진할 수 있다. 
* 전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다. 
  * Random 값 추출은 `camp.nextstep.edu.missionutils.Randoms`의 `pickNumberInRange()`를 활용한다.

### 💭 출력
* 우승자는 우승을 가장 많이 한 자동차 이름 혹은 이름들을 출력한다. 
* 최종 우승자 : pobi, jun 의 예시처럼 결과 출력
* 결과 출력 후 종료

***

공통 피드백
=======
[공통 피드백](https://docs.google.com/document/d/1MdiqBV5nhSfFB96-p5LlKrGM8uLopXslh1vEzwxR9Bo/edit?tab=t.0#heading=h.y1mk3gfaf0q3)
* 요구 사항을 정확하게 준수한다. 
  * 제출 전 요구 사항을 다시 점검하자.
* 기본적인 Git 명령어를 숙지한다. 
  * 인프런의 Git 관련 강의를 볼 것이다. 
* Git으로 관리할 자원을 고려한다. (.gitignore)
* 커밋 메시지를 의미 있게 작성한다. 
  * [좋은 git 커밋 메시지를 작성하기 위한 7가지 약속](https://meetup.nhncloud.com/posts/106)
* 커밋 메시지에 이슈 또는 풀 리퀘스트 번호를 포함하지 않는다.
* 풀 리퀘스트를 만든 후에는 닫지 말고 추가 커밋을 한다. 
* 오류를 찾을 때 출력 함수 대신 디버거를 사용한다. 
  * System.out.println()이 아닌 디버거를 사용해서 출력을 확인해보자. 
* 변수나 메소드 이름을 통해 의도를 드러낸다. 축약하지 않는다.  
* 공백도 코딩 컨벤션이다. 공백라인을 의미 있게 사용한다. 
* 스페이스와 탭을 혼용하지 않는다. 
* 코드 포매팅을 사용한다. (Command + Alt + L)
* Java에서 제공하는 API를 적극 활용한다. 배열 대신 컬렉션을 사용한다. 
  * List, Set, Map 등
* 추가 학습 자료
  * [문자열 덧셈 계산기 피드백](https://drive.google.com/file/d/1yF0WkTOaJW5N6bFSkyUUBiT55LxvMq41/view)
