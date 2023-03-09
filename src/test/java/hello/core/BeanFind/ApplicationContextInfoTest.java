package hello.core.BeanFind;

import hello.core.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoTest {

    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모븐 빈 출력하기")
    void findAllBean()
    {
        String[] beanDefinitonNames = ac.getBeanDefinitionNames();

        for (String beanDefinitonName : beanDefinitonNames) {
            Object bean = ac.getBean(beanDefinitonName);
            System.out.println("name="+beanDefinitonName+"object="+bean);
        }

    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean()
    {
        String[] beanDefinitonNames = ac.getBeanDefinitionNames();

        for (String beanDefinitonName : beanDefinitonNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitonName);

            if(beanDefinition.getRole()==BeanDefinition.ROLE_APPLICATION)
            {
                Object bean = ac.getBean(beanDefinitonName);
                System.out.println("name="+beanDefinitonName+"object="+bean);
            }


        }

    }




}
