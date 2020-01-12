package producer;

public class Greeting {

	private final long id;
	private final String content;
	private final String template;

	public Greeting(long id, String content, String template) {
		this.id = id;
		this.content = content;
		this.template = template;
	}

	public long getId() {
		return id;
	}

	public String getContent() {
		return content;
	}

	public String getTemplate() {
		return template;
	}
}
