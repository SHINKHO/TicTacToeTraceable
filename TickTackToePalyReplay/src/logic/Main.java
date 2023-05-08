package logic;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import database.service.T3GameService;
import database.service.T3LocationService;
import database.service.T3NotationService;
import database.service.T3UserService;
import database.vo.T3LocationVO;
import database.vo.T3UserVO;

public class Main {
	
	T3UserService us = T3UserService.getInstance();
	T3LocationService ls = T3LocationService.getInstance();
	T3GameService	gs = T3GameService.getInstance();
	T3NotationService ns = T3NotationService.getInstance();
	
	static Scanner scan   = new Scanner(System.in);
	String userName;
	HashMap<T3LocationVO,T3LocationVO> timeline;
	
    public static boolean playMove(char[][] board, char team, int row, int col) {
        if (String.valueOf(board[row][col]).matches("[0-9]")) {
            board[row][col] = team;
            return true;
        } else {
            return false;
        }
    }
	
	public static void main(String[] args) {
		
		System.out.println(" Welcome to TICTACTOE ! ");
		
		while(true) {
			System.out.print("please type your name (max 5letters)\n>>>");
				
			String userName="";
			String userId;
			String gameId;
			while(userName.length()<6) {	
				try {
					scan.nextLine();
				} catch (Exception e) {
					System.out.println("ERROR: Something went wrong while setting your name");
					continue;
				}
			}
			
			userId = String.valueOf(System.currentTimeMillis()).substring(0,7)+userName.substring(0,3);
			T3UserVO player = new T3UserVO(userId,userName);
			System.out.println("Player successfully generated!");
			
	        char[] team = {'X', 'O'};
	        Random rand = new Random();
	        char current_team = team[rand.nextInt(2)];
	        System.out.println("team " + current_team + " goes first");
			
	        
	        char[][] map = new char[][]{{'1','2','3'},{'4','5','6'},{'7','8','9'}};
	        int[][] bind = new int[][]{{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
	        
	        while(true) {
	        	TicTacToe.printBoard(map);
	        	System.out.println("==================================================");
	        	System.out.println("please choose the area by select a number\n>>>");
	        	int userinput =0;
	        	try {
	        		int userinput=scan.nextInt();
	        		scan.nextLine();
	        	}catch (Exception e){
	        		System.out.println("please check if your input was correct");
	        		continue;
	        	}
				playMove(map,player,bind[userinput][0],bind[userinput][1]);
	        	
	        }
		}
		

		
		
	}

}
