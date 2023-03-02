package hello.core.discount;

import hello.core.memeber.Member;

public interface DiscountPolicy {


    int discount(Member member, int price);

}
