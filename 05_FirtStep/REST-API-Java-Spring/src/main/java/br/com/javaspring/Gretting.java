package br.com.javaspring;

public class Gretting {
	
	private final long id;
	private final String content;
	
	public Gretting(long id, String content) {
		super();
		this.id = id;
		this.content = content;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}
	
	
	
	
}
