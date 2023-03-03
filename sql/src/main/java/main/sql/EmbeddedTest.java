package main.sql;

import com.google.gson.Gson;

public class EmbeddedTest {
	private static Embedded emb;
	private static Gson gson;
	
	public static void main(String[] args) {
		emb = new Embedded();
		gson = new Gson();
		String print = null;
		gson.fromJson(print, Embedded.class);
		System.out.println(print);
		while(true)
		{
			
		}
	}
}
