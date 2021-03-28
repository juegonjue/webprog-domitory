package com.kit.domitory;


import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;

@Configuration
@ComponentScan(
        excludeFilters = @ComponentScan.Filter(type = FilterType.ANNOTATION,
        classes = Configuration.class)         // componentscan이라는 어노테이션이 붙은 타입은 ㅔ외하겠다는 말
)
public class ComAppConfig {

}
