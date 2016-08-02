package cn.tf.demo;

public class Demo1 {

	
	//抑制警告，如果有变量定义了但是未使用
	@SuppressWarnings("unused")
	public void m1(){
		int i=100;
		System.out.println("aaa");
	}
	public void aaa(){
		
	}

}
class Demo2 extends Demo1{
	public void m1(){
		
	}
	//检查子类是否覆盖了父类的方法，若未覆盖则报错
	@Override
	public void aaa(){
		
	}
	//表示该方法过时了
	@Deprecated
	public void cccc(){
		
	}
	
	
	
}