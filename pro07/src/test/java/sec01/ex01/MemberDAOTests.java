package sec01.ex01;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.jupiter.api.Test;

class MemberDAOTests {
	
	private MemberDAO memberDAO = MemberDAO.getInstance();

	@Test
	void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testListMembers() {
		List<MemberVO> list = memberDAO.listMembers();
		System.out.println(list);
	}
	
	@Test
	public void testMap() {
		// Collection - list, map, set
		// list - 순서가 있다. 중복 데이터를 사용한다. Array Vector
		// list 에서 데이터 추가 add 사용
		// map - Dictionary(사전형) -> HashMap, HashTable
		// 키/값 1쌍 (key-value pair) 값은 중복 허용, 키는 중복 x
		Map<String, Integer> map = new HashMap<>();
		map.put("age", 20);
		map.put("grade", 3);
		map.put("heigt", 185);
		map.put("age", 200); // 20을 덮어쓰는 결과가 나옴
		map.put("adr", 185);
		System.out.println("map:" + map);
		
		//Set(집합) - 자연수의 집합 - {1,100,20,30, ....}
		// 순서 x , 데이터 중복 x
		Set<Integer> set = new HashSet<>();
		set.add(100);
		set.add(20);
		set.add(50);
		set.add(3);
		set.add(100);
		System.out.println("set:" + set);
	}
	
	

}
