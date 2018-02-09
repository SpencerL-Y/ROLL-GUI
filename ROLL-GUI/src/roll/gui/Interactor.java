package roll.gui;

import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class Interactor {
	private Algorithm a;
	private Approach push;
	private DataStructure ds;
	private char[] alphabetLetters;
	private Integer alphabetNumber;
	private PipedInputStream intIn;
	private PipedOutputStream intOut;
	
	public Interactor() {
		this.a = Algorithm.PERIODIC;
		this.push = Approach.UNDER;
		this.ds = DataStructure.TABLE;
	}
	
	public void assignValue(Integer num, char[] letters, Algorithm ago, Approach ap, DataStructure dataStruct) {
		this.alphabetNumber = num;
		this.alphabetLetters = new char[num];
		for(int i = 0; i < num; i++) {
			this.alphabetLetters[i] = letters[i];
		}
		this.a = ago;
		this.push = ap;
		this.ds = dataStruct;
		System.out.println("assign end");
	}
	
	public String startLearning() {
		//TODO add the first interaction and return result to the front end
		return this.a.toString() + " " + this.push.toString() + " " + this.ds.toString() + " " + this.alphabetNumber;
	}
	
	public String answerMemQuery(Boolean isMember) {
		//TODO add interaction and return next interaction string to the front end
		return null;
	}
	
	public String answerEquiQuery(Boolean isEqual, String ce) {
		//TODO add interaction. return the next interaction if isEqual is false, otherwise end the learning procedure
		return null;
	}
	
	public String equiSyncAck() {
		//TODO this function tell roll that the first line of equivalence check has been received. Return the hypothesis to the front end.
		
		return null;
	}
}
