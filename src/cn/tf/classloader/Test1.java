package cn.tf.classloader;

import java.sql.Connection;

public class Test1 {


	public static void main(String[] args) {
		ClassLoader cl = Connection.class.getClassLoader();
		System.out.println(cl);  //null

	}

}
