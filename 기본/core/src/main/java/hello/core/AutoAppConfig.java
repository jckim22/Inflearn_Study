package hello.core;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.FilterType;


@Configuration
@ComponentScan(
//        basePackages  = "hello.core",
//        basePackageClasses = AutoAppConfig.class,
//        //디폴트는 ComponentScan 패키지 포함 하위 패키지를 다 스캔한다.
        excludeFilters =  @ComponentScan.Filter(type = FilterType.ANNOTATION, classes = Configuration.class)
)
public class AutoAppConfig {

}
