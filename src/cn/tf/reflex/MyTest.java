package cn.tf.reflex;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

//取值是一个枚举类型，改变注解的生命周期
@Retention(value=RetentionPolicy.RUNTIME)
public @interface MyTest {

	//模拟单元测试
	
	long  timeout() default -1;
}
