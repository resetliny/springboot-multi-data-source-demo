package qtzt.link.annotation;

/**
 * @author: yuanlin
 * @date: 2021-06-01 15:22:30
 * @description:
 */

import java.lang.annotation.*;

/**
 * 自定义数据源注解
 * 在需要切换数据源的Service层方法上添加此注解，指定数据源名称
 * @author yuan
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface MyDataSource {
    String name() default "";
}
