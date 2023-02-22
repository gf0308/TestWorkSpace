package com.work.testworkspace;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;

/**
 * @목적 :롬복(Lombok) 사용시 발생할 수 있는 버그상황을 직접 만들고 확인한다.
 * @상세: 롬복 애노테이션 중 @AllArgsConstructor, @RequiredArgsConstructor 를 사용시 발생할 수 있는 버그를 직접 구현하고 확인한다.
 * @설명:
 *         @AllArgsConstructor, @RequiredArgsConstructor 는 이를 적용한 클래스에서 각각
 *         '해당 클래스의 전 필드를 초기화해주는 생성자를 생성',
 *         '해당 클래스의 final 필드, 혹은 @NonNull 처리된 필드를 초기화해주는 생성자를 생성'
 *         하는 기능을 한다.
 *         그리고 이로 인해 만들어지는 '생성자의 파라미터 순서'는 "클래스에 작성되어있는 필드의 순서대로" 만들어진다.
 *         근데 만약 개발자가 의도적으로, 혹은 어쩌다가 우연한 상황으로 해당 필드들의 순서를 변경하게 됐을 경우
 *         해당 클래스 객체 생성시 각 파라미터 순서 역시 바뀌어버리게 된다.
 *         이러면 비즈니스 로직적으로 명백한 오류며 심각한 문제가 될 수가 있다.  (해당 클래스 인스턴스를 생성하는 코드는 원래 파라미터 순서대로 초기화를 해주고 있는 상태일텐데)
 *         (파라미터 별로 데이터타입이 다르거나 하면 바로 컴파일에러 표시가 떠서 알 수 있겠지만,
 *          만약 파라미터들이 모두 데이터타입도 같고 순서가 바뀌게 들어가도 compile error 가 발생하지 않는 상황이라면,
 *          대체 어디서 뭐가 문제인건지 발견하기조차 힘들 것임)
 *
 *         => 이렇기 때문에 이런 문제를 방지하고자 한다면
 *            @AllArgsConstructor, @RequiredArgsConstructor 를 아예 사용하지 않고
 *            해당 클래스 생성자에 @Builder 를 적용해서 해당 클래스 인스턴스 생성시 빌더패턴 식으로
 *            각 투입인자가 명시적으로 보이도록 사용하는 방법이 있다.
 *
 *            그게 아닌 굳이 @AllArgsConstructor, @RequiredArgsConstructor 가 사용된 경우라면
 *            클래스 필드들의 순서가 변경되는 일이 없도록 각별히 신경써야 한다.
 *
 * */

public class LombokBugTest {

    @Test
    void testAllArgsConstructor() {
        // 주문 금액 50,000,000 과 취소 금액 15,000,000 을 세팅하는 주문 객체 생성
        Order1 order = new Order1(50000000, 15000000);
    }
    @AllArgsConstructor
    class Order1 {
        private int orderAmount;       // 주문금액
        private int cancelAmount;      // 취소금액
    }

    @Test
    void testRequiredArgsConstructor() {
        // 주문 금액 50,000,000 과 취소 금액 15,000,000 을 세팅하는 주문 객체 생성
        Order2 order = new Order2(50000000, 15000000);
    }
    @RequiredArgsConstructor
    class Order2 {
        private final int orderAmount;       // 주문금액
        private final int cancelAmount;      // 취소금액
    }

    @Test
    void testBuilder() {
        // 주문 금액 50,000,000 과 취소 금액 15,000,000 을 세팅하는 주문 객체 생성
        Order3 order = Order3.builder()
                        .orderAmount(50000000)
                        .cancelAmount(15000000)
                        .build();
    }
}

// @Builder 애노테이션은 중첩클래스(nested class : 이너 클래스)엔 적용되지 않기 때문에, 테스트 클래스 Order3 를 밖으로 뺌.
class Order3 {
    private int orderAmount;       // 주문금액
    private int cancelAmount;      // 취소금액

    @Builder
    public Order3(int orderAmount, int cancelAmount) {
        this.orderAmount = orderAmount;
        this.cancelAmount = cancelAmount;
    }
}
