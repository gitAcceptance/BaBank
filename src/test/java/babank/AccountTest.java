package babank;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import static org.junit.jupiter.api.Assertions.fail;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

class AccountTest {
	
	static Account acc1;
	static Account acc2;

	@BeforeAll
	static void setUp() throws Exception {
		acc1 = new Account(1001, 7.00, LocalDateTime.now(), AccountType.CHECKING, null, null);
		acc2 = new Account(1002, 700.00, LocalDateTime.now(), AccountType.CHECKING, true, null);
	}
	
	@Test
	void testIsPendingApproval() {
		assertTrue(acc1.isPendingApproval());
		assertFalse(acc2.isPendingApproval());
	}
	
	@Test
	void testApprove() {
		acc1.approve();
		assertTrue(acc1.isOpen);
	}
	
	
	@Test
	void testDeposit() {
		double b = acc2.getBalance();
		acc2.deposit(100.00);
		assertEquals(b + 100.0, acc2.getBalance());
	}
	
	@Test
	void testWithdraw() {
		double b = acc2.getBalance();
		acc2.withdraw(50.0);
		assertEquals(b-50.0, acc2.getBalance());
	}
	
	@Test
	void testTransfer() {
		double b1 = acc1.getBalance();
		double b2 = acc2.getBalance();
		acc2.transfer(50.0, acc1);
		assertEquals(acc1.getBalance(), b1 + 50.0);
		assertEquals(acc2.getBalance(), b2 - 50.0);
	}
	
	@Test
	void testClose() {
		acc2.close();
		assertFalse(acc2.isOpen);
	}

	
}
