package com.kit.domitory.IocContainer;

import com.kit.domitory.AppConfig;
import com.kit.domitory.member.MemberService;
import net.bytebuddy.implementation.bind.MethodDelegationBinder;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.assertj.core.api.Assert;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class IocContainerTest {
    @Test
    void findApplicationBean() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        String[] beanDefinitionNames = ac.getBeanDefinitionNames();

        for (String beanDefinitionName : beanDefinitionNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanDefinitionName);
            System.out.println("beanDefinition = " + beanDefinition);
        }
    }

    @Test
    void SingletonTest() {
        //Singleton singleton = new Singleton();
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);
        assertThat(instance1).isSameAs(instance2);

    }


    //싱글톤이 안될수도 있다는 것을 보여주는 test이다.
    @Test
    void ReflectionSingletonTest() throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Singleton instance1 = Singleton.getInstance();
        Singleton instance2 = Singleton.getInstance();

        System.out.println("instance1 = " + instance1);
        System.out.println("instance2 = " + instance2);

        Class<Singleton> singletonClass = Singleton.class;
        //강제로 들고오기
        Constructor<Singleton> declaredConstructor = singletonClass.getDeclaredConstructor();
        declaredConstructor.setAccessible(true);
        Singleton newSingleton = declaredConstructor.newInstance();
        System.out.println("newSingleton = " + newSingleton);
        assertThat(newSingleton).isNotSameAs(instance1);
        assertThat(newSingleton).isNotSameAs(instance2);
    }

    @Test
    void SpringSingletonTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        MemberService memberService1 = ac.getBean("memberService", MemberService.class);
        MemberService memberService2 = ac.getBean("memberService", MemberService.class);

        System.out.println("memberService1 = " + memberService1);
        System.out.println("memberService2 = " + memberService2);

        assertThat(memberService1).isSameAs(memberService2);
    }

    @Test
    void ThreadNotSafetyTest() {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(SingletonConfig.class);
        DeliveryService sharedService1 = ac.getBean("sharedService", DeliveryService.class);
        DeliveryService sharedService2 = ac.getBean("sharedService", DeliveryService.class);

        sharedService1.deliveryStart("디지털관");
        sharedService2.deliveryStart("글로벌관");

        System.out.println("sharedService1 = " + sharedService1.getAddress());  //디지털관
    }
}
