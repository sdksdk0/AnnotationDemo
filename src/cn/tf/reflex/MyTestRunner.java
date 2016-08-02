package cn.tf.reflex;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class MyTestRunner {

	public static void main(String[] args) throws Exception {
		//test1();
		test2();
	}

	// 反射注解中的属性
	private static void test2() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		Class clazz = Demo1.class;
		Method methods[] = clazz.getMethods();
		for (Method m : methods) {
			MyTest myTest = m.getAnnotation(MyTest.class);
			if (myTest != null) {
				// 获取注解的timeout属性
				long time = myTest.timeout();// -1 或者 大于0的值
				if (time < 0) {
					// 不需要测试效率
					m.invoke(clazz.newInstance(), null);// 执行方法
				} else {
					// 需要测试效率

					long startTime = System.nanoTime();
					m.invoke(clazz.newInstance(), null);// 执行方法
					long costTime = System.nanoTime() - startTime;// 执行实际用的时间
					if (costTime > time) {
						System.out.println(m.getName() + "超时");
					}

				}
			}
		}
	}

	// 反射注解类
	private static void test1() throws IllegalAccessException,
			InvocationTargetException, InstantiationException {
		// 模拟单元测试，SomeDaoImplTest类的方法上，谁有@MyTest就执行谁
		Class clazz = Demo1.class;
		// 得到指定类上的所有方法：含继承下来的方法
		Method methods[] = clazz.getMethods();
		for (Method m : methods) {
			// 判断当前方法上面有没有@MyTest注解
			boolean isMyTestExists = m.isAnnotationPresent(MyTest.class);
			if (isMyTestExists) {
				// 谁有注解执行谁
				m.invoke(clazz.newInstance(), null);
			}
		}
	}

}
