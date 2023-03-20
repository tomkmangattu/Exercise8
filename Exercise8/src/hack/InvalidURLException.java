package hack;

public class InvalidURLException extends Exception{
	private String messageString = "the input url has invalid Exception";
	
	public InvalidURLException(String message) {
		this.messageString = message;
	}
	
	@Override
	public String getMessage() {
		return messageString;
	}
}
