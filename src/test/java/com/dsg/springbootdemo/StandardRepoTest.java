package com.dsg.springbootdemo;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.NoSuchElementException;

import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.junit.jupiter.api.MethodOrderer;

@DataJpaTest
@AutoConfigureTestDatabase(replace=Replace.NONE)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class StandardRepoTest {
	@Autowired
	private TestEntityManager entityManager;
	
	@Autowired
	private StandardRepo repo;

	
	@Test
	@Order(3)
	public void testInsert() throws RuntimeException{
		Standard standard = new Standard();
		standard.setSection("A");
		standard.setStd(1);
		
		repo.save(standard);
		
		assertNotNull(entityManager.find(Standard.class, new Standard.StandardPK(standard.getStd(), standard.getSection())));
		
		/*standard = repo.findById(new Standard.StandardPK(standard.getStd(), standard.getSection()))
				.orElseThrow(RuntimeException::new);*/
	}
	
	@Test
	@Order(1)
	public void testEntityManagerNotNull() {
		assertNotNull(entityManager);
	}

	@Test
	@Order(2)
	public void testRepoNonNull() {
		assertNotNull(repo);
	}
	
	@Test
	@Order(4)
	public void testDelete() throws RuntimeException{
		//testInsert();
		Standard standard = new Standard();
		standard.setSection("A");
		standard.setStd(1);

		
		/*repo.save(standard);*/
		entityManager.persist(standard);
		
		/*final Standard std = repo.findById(new Standard.StandardPK(standard.getStd(), standard.getSection()))
				.orElseThrow(RuntimeException::new);*/
		
		
		repo.delete(standard);
		
		assertThrows(NoSuchElementException.class, ()->repo.findById(new Standard.StandardPK(standard.getStd(), standard.getSection())).get());				
	}
}
