package roll.gui;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

import roll.main.ROLL;

public class InteractorLearn{
	private Algorithm a;
	private Approach push;
	private DataStructure ds;
	private String BAPath;
    private PipedInputStream intIn;
	private PipedOutputStream intOut;
	public static ROLL roll;
	
	public InteractorLearn(){
		this.a = Algorithm.PERIODIC;
		this.push = Approach.UNDER;
		this.ds = DataStructure.TABLE;
		this.intIn = new PipedInputStream();
		this.intOut = new PipedOutputStream();
		//TODO: change path when release
		this.BAPath = "C:\\Users\\10244\\Desktop\\inputBA.ba";
		InteractorLearn.roll = null;
	}
	
	public void assignValue(Algorithm ago, Approach ap, DataStructure dataStruct) {
		this.a = ago;
		this.push = ap;
		this.ds = dataStruct;
		System.out.println("assign end");
	}
	
	public String startLearning() throws IOException {
		System.out.println("Interactor start learning");
		String[] args = new String[5];
		args[0] = this.getPath();
		args[1] = this.getMode();
		args[2] = this.getDataStructure();
		args[3] = this.getAlgorithm();
		args[4] = this.getApproach();
		for(int i = 0; i < 5; i++) {
			System.out.print(" " + args[i]);
		}
		InteractorLearn.roll = new ROLL(args, this.intIn, this.intOut);
		System.out.println();
		System.out.println("ROLL instance");
		InteractorLearn.roll.start();
		return null;
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
		return "-learn";
	}
	
	private String getPath() {
		return this.BAPath;
	}	
}
