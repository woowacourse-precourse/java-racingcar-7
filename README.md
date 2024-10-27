# java-racingcar-precourse

우아한테크코스 2주차 미션 : 자동차 경주

기능 요구 사항 정리 

요구사항
초간단 자동차 경주 게임을 구현한다.
주어진 횟수 동안 n대의 자동차는 전진 또는 멈출 수 있다.
각 자동차에 이름을 부여할 수 있다. 전진하는 자동차를 출력할 때 자동차 이름을 같이 출력한다.
자동차 이름은 쉼표(,)를 기준으로 구분하며 이름은 5자 이하만 가능하다.
사용자는 몇 번의 이동을 할 것인지를 입력할 수 있어야 한다.
전진하는 조건은 0에서 9 사이에서 무작위 값을 구한 후 무작위 값이 4 이상일 경우이다.
자동차 경주 게임을 완료한 후 누가 우승했는지를 알려준다. 우승자는 한 명 이상일 수 있다.
우승자가 여러 명일 경우 쉼표(,)를 이용하여 구분한다.
사용자가 잘못된 값을 입력할 경우 IllegalArgumentException을 발생시킨 후 애플리케이션은 종료되어야 한다.

@내가 생각하는 해당 미션의 주요사항
-클래스활용
-각 기능을 담당하는 메서드 분리


기능 개발 순서
-경주하는 자동차를 입력시 쉼표로 구분
문자열로 사용자에게 입력을 받고 쉼표로 분자열 분리
(빈 문자가 있을시 또는 쉼표가 아닌 다른 구분자가 있을시 에러 발생 후 프로그램 종료)

-자동차 경주 --> 자동차 클래스 생성(이름 인스턴스[5글자이하],전진현황 인스턴스)
분리된 문자들에 대한 자동차 클래스 생성

-자동차 경주를 위한 횟수를 사용자가 입력(0~9에서 랜던 숫자를 뽑는데 4이상 전진)
1. 경주 클래스 생성
2. 사용자가 입력한 경기 횟수를 입력는 메서드,경기를 진행하는 메서드 구현

-우숭자 출력시 여러자동차일경우 쉼표로 구분
최종우승자를 뽑는 메서드 구현


------------------------------------------------------------------------------------------------

클래스 구조 고민 
MVC? 단순 클래스?

MVC로 하기에는 저장해야하는 데이터를 핸들링하는 방식이 매순간 사용자 선택으로 이루어 지는것이 아닌 처음 시작부터 사용자가 정해진 횟수로 진행하므로 MVC패턴 보단 각 기능에 대한 클래스로 구현해 메모리로 데이터를 저장해 프로그래밍하는것이 유리함.

------------------------------------------------------------------------------------------------
요구 사항중 각 기능을 최소한의 단위로 만들어야 하는 요구사항이 있음.
모든 기능을 분리 해서 각기능이 하나의 기능으로 만드는것을 목표
------------------------------------------------------------------------------------------------

-자동차 클래스
자동차 객체 생성--이름,위치

-경기 클래스
경기 객체 생성--경기횟수,경기에 임하는 자동차 숫자

------------------------------------------------------------------------------------------------
코드 리뷰를 하며 내가 시도 해볼 부분이 무엇이 있을지 찾아본결과 하드코딩으로 된 값들이 굉장히 많은것을 느낌.
그래서 변하지 않는 값은 상수로 관리 하여 최대한 코드에 한글로 하드코딩하지 않는것을 목표! --> 기능 구현 완료 후 진행하는것으로 목료!--> 기능 구현이 제일 중요하다고 생각.

------------------------------------------------------------------------------------------------
구현 하면서 문득 드는 생각 --> 만약 앞으로만 가는것이 아닌 뒤로 가거나 두칸 앞서는 기능이 추가 된다면 어떻게 개발하는것이 좋을지 생각하면서 개발해보자.

------------------------------------------------------------------------------------------------
개발 구조를 고민하면서 드는 생각 --> 이번 2주차 자동차 경주 미션인 경우 1주차 미션과 다르게 경주 로직과 입출력 로직이 명확히 구분이 필요한 개발 구조이기에 추가 기능을 유지 보수하기에 용이한 MVC패턴으로 개발을 진행할려한다.
특히 1주차 덧셈계산기와 다르게 게임진행이라는 프로그램기능 구조가 추가되어 입력,진행,결과출력이라는 세가지 로직이 사용자에게 명확하게 보여줘야 하는것이 포인트라 생각해 해당 디자인패턴을 구상하였다.

그리고 개발주니어로써 MVC디자인패턴을 사용함으로써 DB와 같은 기능을 가지는 DAO를 만들기를 목표로 하였다.























