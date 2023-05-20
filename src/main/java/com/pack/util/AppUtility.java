package com.pack.util;

import java.util.UUID;

public class AppUtility {
	public static final String DIRECTORY_PATH = "F://movies/";
	public static String getRandomeId()
	{
		return UUID.randomUUID().toString();
	}
	private AppUtility() {
		super();
		
	}
}
