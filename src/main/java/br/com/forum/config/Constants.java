package br.com.forum.config;

public final class Constants {

	public static final String EMPTY = "";
	public static final String BLANK = " ";
	public static final String PACKAGE = "br.com.forum";
	
	public static final String APPLICATION_JSON_UTF_8 = "application/json;charset=utf-8";
	public static final String APPLICATION_XML_UTF_8 = "application/xml;charset=utf-8";
	
	public static final String V1 = "/v1";
	public static final String ROOT_URL = "/api";
	
	public static final String TOPICOS = Constants.ROOT_URL + Constants.V1 + "/topicos";
	public static final String AUTH = Constants.ROOT_URL + Constants.V1 + "/auth";
	
	public static final String DEFAULT_PAGE = "0";
	public static final String DEFAULT_SIZE = "5";
	public static final String DEFAULT_DIRECTION_ASC = "asc";
	public static final String DEFAULT_DIRECTION_DESC = "desc";
	
	public static final String DEFAULT_SORT_COLUMN = "id";
	public static final int DEFAULT_INT_PAGE = 0;
	public static final int DEFAULT_INT_SIZE = 5;
	
}
