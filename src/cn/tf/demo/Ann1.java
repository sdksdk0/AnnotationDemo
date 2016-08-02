package cn.tf.demo;

public @interface  Ann1 {
	
	//定义注解的属性
	int age();
	
	//定义注解属性时给定默认值
	String name() default "";
	
	//注解类型必须是：基本类型、String、注解类型、枚举类型、Class类型及以上类型的一维数组。

	Class clazz() default Object.class;
	
	String value() default "";

}


