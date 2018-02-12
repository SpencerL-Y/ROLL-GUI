package roll.gui;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import roll.main.ROLL;

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
		this.intIn = new PipedInputStream();
		this.intOut = new PipedOutputStream();
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
	
	public String startLearning() throws IOException {
		System.out.println("Interactor start learning");
		//TODO add the first interaction and return result to the front end
		String[] args = new String[4];
		args[0] = this.getMode();
		args[1] = this.getDataStructure();
		args[2] = this.getAlgorithm();
		args[3] = this.getApproach();
		for(int i = 0; i < 4; i++) {
			System.out.print(" " + args[i]);
		}
		System.out.println();
		ROLL rollInstance = new ROLL(args, this.intIn, this.intOut);
		System.out.println("ROLL instance");
		//rollInstance.run();
		this.intOut.write(this.alphabetLetters.toString().getBytes());
		System.out.println("send alphabet " + this.alphabetLetters.toString());
		byte[] alphaOK = new byte[1024];
		int len = this.intIn.read(alphaOK);
		String alphaOKString = new String(alphaOK, 0, len);
		System.out.println(alphaOKString);
		assert(alphaOKString != null && alphaOKString.equals("ALPHA OKAY"));
		this.intOut.write(this.alphabetNumber.toString().getBytes());
		System.out.println("send alphanum" + this.alphabetNumber.toString());
		byte[] buf = new byte[1024];
		len = this.intIn.read(buf);
		String returnedStr = new String(buf, 0, len);
		System.out.println("first returned str" + returnedStr);
		return returnedStr;
	}
	
	private String getApproach() {
		if(this.push == Approach.OVER) {
			return "-over";
		} else if(this.push == Approach.UNDER) {
			return "-under";
		} else {
			System.out.println("Approach Error!");
			return null;
		}
	}

	private String getAlgorithm() {
		if(this.a == Algorithm.PERIODIC) {
			return "-periodic";
		} else if(this.a == Algorithm.SYNTACTIC) {
			return "-syntactic";
		} else if(this.a == Algorithm.RECURRENT) {
			return "-recurrent";
		} else if(this.a == Algorithm.LDOLLAR) {
			return "-ldollar";
		} else {
			System.out.println("Algorithm Error!");
			assert(false);
			return null;
		}
	}

	private String getDataStructure() {
		if(this.ds == DataStructure.TABLE) {
			return "-table";
		} else if(this.ds == DataStructure.TREE) {
			return "-tree";
		} else {
			System.out.println("DataStructure Error!");
			assert(false);
			return null;
		}
	}

	private String getMode() {
		return "-int";
	}

	public String answerMemQuery(Boolean isMember) throws IOException {
		//TODO add interaction and return next interaction string to the front end
		String answerMem = isMember ? "1" : "0";
		this.intOut.write(answerMem.getBytes());
		byte[] buf = new byte[1024];
		int len = this.intIn.read(buf);
		String returnedStr = new String(buf, 0, len);
		return returnedStr;
	}
	
	public String answerEquiQuery(Boolean isEqual, String ce) {
		//TODO add interaction. return the next interaction if isEqual is false, otherwise end the learning procedure
		return null;
	}
	
	public String equiSyncAck() throws IOException {
		//TODO this function tell roll that the first line of equivalence check has been received. Return the hypothesis to the front end.
		this.intOut.write("A-EquiReady".getBytes());
		byte[] automata = new byte[8192];
		int len = this.intIn.read(automata);
		String automataStr = new String(automata, 0, len);
		return automataStr;
	}
}
