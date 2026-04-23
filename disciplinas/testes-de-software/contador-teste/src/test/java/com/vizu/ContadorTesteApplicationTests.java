package com.vizu;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ContadorTesteApplicationTests {

	//@Test
	void contextLoads() {
	}
	
	@Test
	@DisplayName("0 > 2 > 9")
	void deveRetornarMenosUmQuandoNaoComecaComA() {
	    ContadorTesteApplication app = new ContadorTesteApplication();
	    String[] e1 = {"X", "\n"};	    
	    assertEquals(-1, app.contador(e1));
	}
	
	
	@Test
	@DisplayName("0 > 1 > 3 > 4 > 5 > 3 > 4 > 8 > 3 > 9")
	void deveRetornarZeroUmASeguidoPorB() {
	    ContadorTesteApplication app = new ContadorTesteApplication();
	    String[] e3 = {"A", "B", "\n"};
	    assertEquals(0, app.contador(e3));
	}
	
	@Test
	@DisplayName("0 > 1 > 3 > 4 > 6 > 3 > 4 > 8 > 3 > 9")
	void deveRetornarZeroUmASeguidoPorBSeguidoPorC() {
	    ContadorTesteApplication app = new ContadorTesteApplication();
	    String[] e4 = {"A", "B", "C", "\n"};
	    assertEquals(1, app.contador(e4));
	}
	
	@Test
	@DisplayName("0 > 1 > 3 > 4 > 7 > 3 > 4 > 8 > 3 > 9")
	void deveRetornarZeroUmASeguidoPorD() {
		ContadorTesteApplication app = new ContadorTesteApplication();
		String[] e5 = {"A", "D", "\n"};
		assertEquals(0, app.contador(e5));
	}
	
	@Test
	@DisplayName("0 > 1 > 3 > 4 > 8 > 3 > 9")
	void deveRetornarZeroUmA() {
		ContadorTesteApplication app = new ContadorTesteApplication();
		String[] e5 = {"A", "\n"};
		assertEquals(0, app.contador(e5));
	} 

}
