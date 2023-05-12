package logic;

public class Minimactoe {
	private static Minimactoe instance = new Minimactoe();
	private Minimactoe() {}
	private T3Node firstNode = new T3Node(new int[] {},0,null);
	
	public static  Minimactoe getInstance() {
		return instance;
	}
	
	public int measureScore(int current,int next) {
		int score = 0;
		//	vertical, horizontal, diagonal checking, 
		// two dot in a row will make a score  						
		// three dot in a row will make a win						0 1 2 
		//	sort them first 											3 4 5 
		//																6 7 8
		// 012, 345 678 -> horizontal = x+1	in case next is not 0 when modular by 3
		// 036,147,258 -> vertical = x+3		in case there is 
		// 048, 246 -> diagonal x+4 or x+2
		if(current ){
		}else if() {
			
		}else if() {
			
		}
		
		score +=measureScore(next,next2)
		
		return score;
	}
	
	private void bubblesort(int[] target) {
		for(int i=0; i<target.length-1; i++) {
			for(int j =0 ; j < target.length-1;j++) {
				int dum;
				if(target[j]>target[j+1]) {
					dum=target[j];
					target[j]=target[j+1];
					target[j+1]=dum;
				}
			}
		}
	}
	

	
}
