package lambdamagic.sql.mysql;

import static org.junit.Assert.*;

import java.sql.SQLException;

import org.junit.Test;

import lambdamagic.NullArgumentException;

public class MySQLConnectionTest {

	@Test(expected=NullArgumentException.class)
	public void MySQLConnection_mustThrowNullArgumentExceptionWhenNullUrlIsGiven() throws Exception {
		try(MySQLConnection connection = new MySQLConnection(null, "userName", "password")) {}
	}
	
	@Test(expected=NullArgumentException.class)
	public void MySQLConnection_mustThrowNullArgumentExceptionWhenNullUserNameIsGiven() throws Exception {
		try(MySQLConnection connection = new MySQLConnection("url", null, "password")) {}
	}
	
	@Test(expected=NullArgumentException.class)
	public void MySQLConnection_mustThrowNullArgumentExceptionWhenNullPasswordIsGiven() throws Exception {
		try(MySQLConnection connection = new MySQLConnection("url", "userName", null)) {}
	}
	
	@Test(expected=NullPointerException.class)
	public void MySQLConnection_mustThrowNullPointerExceptionWhenInvalidConnectionIsGiven() throws Exception {
		try(MySQLConnection connection = new MySQLConnection("url", "userName", "password")) {}
	}
	
	@Test
	public void MySQLConnection_() throws Exception {
		try(MySQLConnection connection = new MySQLConnection("url", "userName", "password")) {
			
		}
	}

}
