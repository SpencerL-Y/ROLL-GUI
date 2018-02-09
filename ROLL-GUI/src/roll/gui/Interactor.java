package roll.gui;

public class Interactor {
	private Algorithm a;
	private Approach push;
	private DataStructure ds;
	private char[] alphabetLetters;
	private Integer alphabetNumber;
	
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
		return this.a.toString() + " " + this.push.toString() + " " + this.ds.toString() + " " + this.alphabetNumber;
	}
}
