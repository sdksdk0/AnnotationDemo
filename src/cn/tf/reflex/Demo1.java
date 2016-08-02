package cn.tf.reflex;

public class Demo1 {
	
	@MyTest(timeout=1000)
	public void testAdd(){
		System.out.println("add执行了");
	}
	
	@MyTest
	public void testUpdate(){
		System.out.println("update执行了");
	}

}
