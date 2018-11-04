package com.kb.org;

public interface DBConnection {
	String db_addr = "jdbc:oracle:thin:@localhost:1521:xe";
	String db_user = "hr";
	String db_pw = "1234";
	String oracle_class = "oracle.jdbc.driver.OracleDriver";
}