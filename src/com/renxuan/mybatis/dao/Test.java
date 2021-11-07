package com.renxuan.mybatis.dao;

import java.io.IOException;
import java.io.Reader;
import java.sql.Connection;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.ExecutorType;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.session.TransactionIsolationLevel;

import com.renxuan.mybatis.entity.SEX;
import com.renxuan.mybatis.entity.User;

public class Test {
	
	public static void main(String[]args) throws IOException {
		
		String resource ="conf.xml";
		//加载mybatis的配置文件
		Reader reader=Resources.getResourceAsReader(resource);
		
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		//SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader，"real");
		//可以在执行的时候指定environment
		//创建能执行映射文件中sql的sqlsession
		SqlSession session =sessionFactory.openSession();
		//映射sql的标识字符串
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".selectUserById";
		//执行查询返回一个唯一user对象的sql
		User user=session.selectOne(statement, 2);
		System.out.println("=====================查询==================\n"+user);
		session.close();
		
		User aUser=new User(2,"two",23,SEX.FEMALE);
		insertUser(aUser);
		insertUser(new User(3,"three",3,SEX.MALE));
		insertUser(new User(10,"three",3,SEX.UNKNOWN));
		selectAllUser();
		aUser.setName("newTwo");
		updateUserById(aUser);
		selectAllUser();
		deleteUserById(10);
		selectAllUser();
		
	}
	public static void selectUserById(int id) throws IOException {
	
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".selectUserById";
		User user=session.selectOne(statement, id);
		System.out.println("=====================查询==================\n"+user);	
		session.close();
	}
	public static void selectUserByIdWithConverter(int id) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".selectUserByIdWithConverter";
		User user=session.selectOne(statement, id);
		System.out.println("=====================转换器查询==================\n"+user);	
		session.close();
	}
	public static void selectAllUser() throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".selectAllUser";
		List<Object> users=session.selectList(statement);
		System.out.println("=====================查询全部==================\n"+users);
		
		session.close();
	}
	public static void insertUser(User aUser) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".insertUser";
		int cnt=session.insert(statement,aUser);
		System.out.println("=====================增加==================\n"+aUser+"增加完成");	
		session.commit();
		session.close();
	}
public static void deleteUserById(int id) throws IOException {
		
		Reader reader=Resources.getResourceAsReader("conf.xml");
		SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
		SqlSession session =sessionFactory.openSession();
		
		String statement="com.reunxuan.mybatis.entity.userMapper"+".deleteUserById";
		int cnt=session.delete(statement,id);
		System.out.println("=====================删除==================\n"+"id为"+id+"的"+cnt+"个删除完成");	
		session.commit();
		session.close();
	}
public static void updateUserById(User aUser) throws IOException {
	
	Reader reader=Resources.getResourceAsReader("conf.xml");
	SqlSessionFactory sessionFactory=new SqlSessionFactoryBuilder().build(reader);
	SqlSession session =sessionFactory.openSession();
	
	String statement="com.reunxuan.mybatis.entity.userMapper"+".updateUserById";
	int cnt=session.update(statement,aUser);
	System.out.println("=====================修改==================\n"+aUser+"修改完成");	
	session.commit();
	session.close();
}
}
