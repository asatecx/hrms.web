package niucaocao.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.boot.test.autoconfigure.MybatisTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.test.context.junit4.SpringRunner;

import niucaocao.dao.HeroMapper;
import niucaocao.domain.Hero;

@RunWith(SpringRunner.class)//spring-boot-starter-test   for DI

@AutoConfigureTestDatabase(replace = Replace.NONE)//mybatis-spring-boot-starter-test

@MybatisTest//mybatis-spring-boot-starter-test
public class TestMybatis {

	@Autowired
	private HeroMapper todoMapper;
	@Test
	public void testSQL2() {
		System.out.println("hello i am test2");
//		List<Hero> employees = todoMapper.findbyInput("yna");
//
//		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//			Hero employee = (Hero) iterator.next();
//			System.out.println(employee);
//
//		}
		Hero hero = new Hero();
		hero.setName("XXXXX");
		int id=todoMapper.save(hero);
		System.out.println("ddddd="+hero.getId());
	}
//	@Test //mybatis-spring-boot-starter-test
//	public void testSQL() {
//		
//		
//		
//		System.out.println("hello i am test");
//		List<Employee> employees = todoMapper.findAll();
//
//		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//			Employee employee = (Employee) iterator.next();
//			System.out.println(employee.getName());
//
//		}
//	}
//	
//	@Test
//	public void testSQL2() {
//		System.out.println("hello i am test2");
//		List<Employee> employees = todoMapper.employee2rirekis("");
//
//		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//			Employee employee = (Employee) iterator.next();
//			System.out.println(employee);
//
//		}
//	}
//	@Test
//	public void testSQL3() {
//		System.out.println("hello i am test3");
//		List<Employee> employees = todoMapper.employee2level("456");
//
//		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//			Employee employee = (Employee) iterator.next();
//			System.out.println(employee);
//
//		}
//	}
////employee2rirekis2project
//	@Test
//	public void testSQL4() {
//		System.out.println("hello i am test4");
//		List<Employee> employees = todoMapper.employee2rirekis2project("456");
//
//		for (Iterator iterator = employees.iterator(); iterator.hasNext();) {
//			Employee employee = (Employee) iterator.next();
//			System.out.println(employee);
//
//		}
//	}
}
