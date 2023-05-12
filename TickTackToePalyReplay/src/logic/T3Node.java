package logic;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * @author sinborninkr@gmail.com
 *
 */
public class T3Node {
	static final int[] PURE_BLOCKS = new int[] {0,1,2,3,4,5,6,7,8};
	private int[] takenBlocks;
	private T3Node prevNode;
	int point;
	private Set<Integer> possibleBlocks = new HashSet<Integer>();
	private Set<T3Node> nextNodes = new HashSet<T3Node>();
	
	public T3Node() {}
	public T3Node(int[] takenBlocks,int point,T3Node prevNode) {
		this.takenBlocks = takenBlocks;
		generatePossibileMoves();
		this.point = point;
		this.prevNode = prevNode;
	}
	
	private void generatePossibileMoves() {
		for(int i=0;i<PURE_BLOCKS.length;i++) {
			for(int j=0; j<takenBlocks.length;j++) {
				if(PURE_BLOCKS[i] == takenBlocks[j]) {
					possibleBlocks.add(PURE_BLOCKS[i]);
					break;
				}
			}
		}
	}

	public T3Node getPrevNode() {
		return prevNode;
	}
	public void setPrevNode(T3Node prevNode) {
		this.prevNode = prevNode;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public Set<Integer> getPossibleBlocks() {
		return possibleBlocks;
	}
	public void setPossibleBlocks(Set<Integer> possibleBlocks) {
		this.possibleBlocks = possibleBlocks;
	}
	public Set<T3Node> getNextNodes() {
		return nextNodes;
	}
	public void setNextNodes(Set<T3Node> nextNodes) {
		this.nextNodes = nextNodes;
	}
	public static int[] getPureBlocks() {
		return PURE_BLOCKS;
	}
	@Override
	public String toString() {
		return "T3Node [takenBlocks=" + Arrays.toString(takenBlocks) + ", point=" + point + ", possibleBlocks="
				+ possibleBlocks + ", nextNodes=" + nextNodes + "]";
	}
	
	
}