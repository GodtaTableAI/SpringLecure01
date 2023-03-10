package hello.core.autowired;

import hello.core.AutoAppConfig;
import hello.core.discount.DiscountPolicy;
import hello.core.member.Grade;
import hello.core.member.Member;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;
import java.util.Map;

public class AllBeanTest {


    @Test
    void findAllBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AutoAppConfig.class,DiscountService.class);

        DiscountService discountService = ac.getBean(DiscountService.class);
        Member member = new Member(1L, "UserA", Grade.VIP);
        int discountPiorice= discountService.discount(member,10000,"fixDiscountPolicy");
        Assertions.assertThat(discountService).isInstanceOf(DiscountService.class);
        Assertions.assertThat(discountPiorice).isEqualTo(1000);

    }

    static class DiscountService {

        private final Map<String, DiscountPolicy> policyMap;
        private final List<DiscountPolicy> discountPolicyList;

        @Autowired
        public DiscountService(Map<String, DiscountPolicy> policyMap, List<DiscountPolicy> discountPolicyList) {
            this.policyMap = policyMap;
            this.discountPolicyList = discountPolicyList;
            System.out.println("policyMap = " + policyMap);
            System.out.println("discountPolicyList = " + discountPolicyList);
        }


        public int discount(Member member, int price, String discountCode) {
            DiscountPolicy discountPolicy= policyMap.get(discountCode);

            return discountPolicy.discount(member,price);
        }
    }

}
