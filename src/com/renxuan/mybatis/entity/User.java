package com.renxuan.mybatis.entity;

/**
 * 
 * @author 灵均
 *
 */
public class User {
	private int id;
	private String name;
	private int age;
	private SEX sex;
	public User(int id, String name, int age, SEX sex) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.sex = sex;
	}

	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	} 
	
	public SEX getSEX() {
		return sex;
	}
	public void setSEX(SEX sex) {
		this.sex = sex;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return " [id=" + id + ", name=" + name + ", age=" + age + ", sex=" + sex + "]";
	}
	public User() {
		// 不知道为什么没这个就要出错
//		实体类中要么就有参无参构造方法都不写，要不就都要写，不能只写有参构造方法
//		mybatis为什么持久化类时必须提供一个不带参数的默认构造函数？
//
//		原因：因为mybatis框架会调用这个默认构造方法来构造实例对象。
//
//		即Class类的newInstance方法 这个方法就是通过调用默认构造方法来创建实例对象的 ，
//
//		另外再提醒一点，如果你没有提供任何构造方法，虚拟机会自动提供默认构造方法（无参构造器），但是如果你提供了其他有参数的构造方法的话，虚拟机就不再为你提供默认构造方法，这时必须手动把无参构造器写在代码里，否则new Xxxx()是会报错的，所以默认的构造方法不是必须的，只在有多个构造方法时才是必须的，这里“必须”指的是“必须手动写出来”。
//
//		当查询的时候返回的实体类是一个对象实例，是mybatis动态通过反射生成的
//
//		反射的Class.forName("className").newInstance();需要对应的类提供一个无参构造函数

//private Object createByConstructorSignature(ResultSetWrapper rsw, Class<?> resultType, List<Class<?>> constructorArgTypes, List<Object> constructorArgs,
//                                              String columnPrefix) throws SQLException {
//    final Constructor<?>[] constructors = resultType.getDeclaredConstructors();
//    final Constructor<?> annotatedConstructor = findAnnotatedConstructor(constructors);
//    if (annotatedConstructor != null) {
//      return createUsingConstructor(rsw, resultType, constructorArgTypes, constructorArgs, columnPrefix, annotatedConstructor);
//    } else {
//      for (Constructor<?> constructor : constructors) {
//        if (allowedConstructor(constructor, rsw.getClassNames())) {
//          return createUsingConstructor(rsw, resultType, constructorArgTypes, constructorArgs, columnPrefix, constructor);
//        }
//      }
//    }
//    throw new ExecutorException("No constructor found in " + resultType.getName() + " matching " + rsw.getClassNames());
//  }

	}
}
