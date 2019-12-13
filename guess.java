
public class guess {
private String name;
private int Guess;

	public guess(String pname, int pguess) {
		name = pname; //sets incoming String name = to private String name
		Guess = pguess;
	}

	public int getGuess() {
		return Guess;
	}
	
	public String toString() {
		return name + " guessed "+ Guess;
	}
}
