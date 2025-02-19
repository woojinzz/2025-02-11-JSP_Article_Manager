package com.koreaIT.jsp.config;

public class Config {
	public static String getDBUrl() {
		return "jdbc:mysql://localhost:3306/jsp_am?useUnicode=true&characterEncoding=utf8&autoReconnect=true&serverTimezone=Asia/Seoul&useOldAliasMetadataBehavior=true&zeroDateTimeNehavior=convertToNull";
	}
	public static String getDBUsr() {
		return "root";
	}
	public static String getDBPW() {
		return "qwer";
	}
	public static String getDBDriverName() {
		return "com.mysql.cj.jdbc.Driver";
	}

}
