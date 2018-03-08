package roll.gui;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
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
	public static ROLL roll;
	
	public Interactor() {
		this.alphabetNumber = new Integer(0);
		this.a = Algorithm.PERIODIC;
		this.push = Approach.UNDER;
		this.ds = DataStructure.TABLE;
		this.intIn = new PipedInputStream();
		this.intOut = new PipedOutputStream();
		Interactor.roll = null;
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
		Interactor.roll = new ROLL(args, this.intIn, this.intOut);
		System.out.println();
		System.out.println("ROLL instance");
		Interactor.roll.start();
		String alphabetStr = "";
		for(int i = 0; i < this.alphabetNumber; i++) {
			alphabetStr += alphabetLetters[i];
		}
		this.intOut.write(alphabetStr.getBytes());
		this.intOut.flush();
		System.out.println("send alphabet " + alphabetStr);
		byte[] alphaOK = new byte[1024];
		int len = this.intIn.read(alphaOK);
		String alphaOKString = new String(alphaOK, 0, len);
		System.out.println(alphaOKString);
		assert(alphaOKString != null);
		this.intOut.write(this.alphabetNumber.toString().getBytes());
		this.intOut.flush();
		System.out.println("send alphanum " + this.alphabetNumber.toString());
		byte[] buf = new byte[1024];
		len = this.intIn.read(buf);
		String returnedStr = new String(buf, 0, len);
		if(returnedStr.toCharArray()[0] == 'S') {
			returnedStr = "";
			this.intOut.write("A-acknowledged".getBytes());
			this.intOut.flush();
			byte[] returnedBytes = new byte[1024];
			this.intIn.read(returnedBytes);
			assert(new String(returnedBytes, 0, len).charAt(0) == 'E');
			String pathname = "C:\\Users\\10244\\Desktop\\testFile.txt";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename)
					);
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			System.out.println("read from file");
			while(line != null) {
				returnedStr +=  line;
				System.out.print(line);
				line = br.readLine();
			}
			System.out.println("first returned str" + returnedStr);
			return returnedStr;
		} else {
			System.out.println("first returned str" + returnedStr);
			return returnedStr;
		}
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
		return "-play";
	}

	public String answerMemQuery(Boolean isMember) throws IOException {
		//TODO add interaction and return next interaction string to the front end
		String answerMem = isMember ? "1" : "0";
		this.intOut.write(answerMem.getBytes());
		this.intOut.flush();
		System.out.println("answerMem");
		byte[] buf = new byte[4096];
		int len = this.intIn.read(buf);
		String returnedStr = new String(buf, 0, len);
		if(returnedStr.toCharArray()[0] == 'S') {
			returnedStr = "";
			this.intOut.write("A-acknowledged".getBytes());
			this.intOut.flush();
			byte[] returnedBytes = new byte[1024];
			this.intIn.read(returnedBytes);
			assert(new String(returnedBytes, 0, len).charAt(0) == 'E');
			//TODO: change the path when release
			String pathname = "testFile.txt";
			File filename = new File(pathname);
			InputStreamReader reader = new InputStreamReader(
						new FileInputStream(filename)
					);
			BufferedReader br = new BufferedReader(reader);
			String line = "";
			System.out.println("read from file");
			while(line != null) {
				returnedStr +=  line;
				System.out.print(line);
				line = br.readLine();
			}
			return returnedStr;
		} else {
			return returnedStr;
		}
		
	}
	
	public String answerEquiQuery(Boolean isEqual, String ce) throws IOException {
		//TODO add interaction. return the next interaction if isEqual is false, otherwise end the learning procedure
		String returnedStr = null;
		String answerEqui = isEqual ? "1" : "0";
		System.out.println("input number " + answerEqui);
		this.intOut.write(answerEqui.getBytes());
		this.intOut.flush();
		if(isEqual == false) {
			byte[] syncBytes = new byte[1024];
			byte[] returnedBytes = new byte[1024];
			int len = this.intIn.read(syncBytes);
			String syncStr = new String(syncBytes, 0, len);
			assert(syncStr.toCharArray()[0] == 'S');
			System.out.println(syncStr);
			System.out.println("counterexample: " + ce);
			this.intOut.write(ce.getBytes());
			this.intOut.flush();
			len = this.intIn.read(returnedBytes);
			returnedStr = new String(returnedBytes, 0, len);
			return returnedStr;
		} else {
			return returnedStr;
		}
	}
	
	public String answerEquiQueryAgain(String ce) throws IOException {
		byte[] returnedBytes = new byte[1024];
		String returnedStr = null;
		System.out.println("counterexample: " + ce);
		this.intOut.write(ce.getBytes());
		this.intOut.flush();
		int len = this.intIn.read(returnedBytes);
		return returnedStr;
		
	}
	
	public String equiSyncAck() throws IOException {
		//TODO this function tell roll that the first line of equivalence check has been received. Return the hypothesis to the front end.
		this.intOut.write("A-EquiReady".getBytes());
		this.intOut.flush();
		byte[] automata = new byte[8192];
		int len = this.intIn.read(automata);
		String automataStr = new String(automata, 0, len);
		return automataStr;
	}
}
