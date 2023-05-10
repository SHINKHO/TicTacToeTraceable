package logic;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Random;
import java.util.Scanner;

import database.service.T3GameService;
import database.service.T3LocationService;
import database.service.T3NotationService;
import database.service.T3UserService;
import database.vo.T3GameVO;
import database.vo.T3LocationVO;
import database.vo.T3NotationVO;
import database.vo.T3UserVO;

public class Main {
	
	static T3UserService us = T3UserService.getInstance();
	static T3LocationService ls = T3LocationService.getInstance();
	static T3GameService	gs = T3GameService.getInstance();
	static T3NotationService ns = T3NotationService.getInstance();
	static ArrayList<int[]> bind = new ArrayList<int[]>();
	static ArrayList<T3NotationVO> timeLine = new ArrayList<T3NotationVO>();
	
	static Scanner scan   = new Scanner(System.in);

    public static void printBoard(char[][] board) {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.println("| " + board[i][0] + " | " + board[i][1] + " | " + board[i][2] + " |");
            System.out.println("-------------");
        }
    }
    public static void printBoard(ArrayList<T3NotationVO> timeLine) {
    	 char [][] reviewMap = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};        char teamer ='O';
        for(int i=0; i<timeLine.size(); i++) {
            int loc = Integer.parseInt(timeLine.get(i).getLocationId());
            int row = loc / 3;
            int col = loc % 3;
            reviewMap[row][col] = teamer;
            teamer = (teamer == 'O') ? 'X' : 'O';

            System.out.println("-------------");
            for(int j=0; j<3; j++) {
                System.out.print("| " + reviewMap[j][0] + " " + reviewMap[j][1] + " " + reviewMap[j][2] + " |\n");
            }
            System.out.println("-------------");
        }
    }
    public static boolean playMove(char[][] board, char team, int row, int col) {
        if (String.valueOf(board[row][col]).matches("[0-9]")) {
            board[row][col] = team;
            return true;
        } else {
            return false;
        }
    }
    
    public static ArrayList<int[]> getPossibleMoves(char[][] board) {
        ArrayList<int[]> moves = new ArrayList<int[]>();
        for (int y = 0; y < 3; y++) {
            for (int x = 0; x < 3; x++) {
                if (String.valueOf(board[y][x]).matches("[0-9]")) {
                    moves.add(bind.get(board[y][x]));
                }
            }
        }
        return moves;
    }
    
    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == player && board[i][1] == player && board[i][2] == player) {
                return true;
            }
        }
        // Check columns
        for (int i = 0; i < 3; i++) {
            if (board[0][i] == player && board[1][i] == player && board[2][i] == player) {
                return true;
            }
        }
        // Check diagonals
        if (board[0][0] == player && board[1][1] == player && board[2][2] == player) {
            return true;
        }
        if (board[0][2] == player && board[1][1] == player && board[2][0] == player) {
            return true;
        }
        return false;
    }
    
    public static int userMove(char[][] map) {
    	printBoard(map);
    	System.out.println("==================================================");
    	System.out.println("please choose the area by select a number\n>>>");
    	int userinput =-1;
    	while(true) {
	    	try {
	    		userinput=scan.nextInt();
	    		scan.nextLine();
	        	return userinput;
	    	}catch (Exception e){
	    		System.out.println("please check if your input was correct");
	    		continue;
	    	}
    	}
    }
    
	
	public static void main(String[] args) {
		
		//biding for the map
		int[][]	binder = new int[][]{{0,0},{0,1},{0,2},{1,0},{1,1},{1,2},{2,0},{2,1},{2,2}};
		
		for(int i = 0 ; i<binder.length;i++) {
			bind.add(binder[i]);
		}
		//reset location database;
		ls.resetLocation();
	    for(int i = 0 ; i < bind.size(); i++) {
	        ls.setLocation(bind.get(i)[1],bind.get(i)[0], String.valueOf(i));
	    }

		
		//welcome
		System.out.println(" Welcome to TICTACTOE ! ");
		
		//type userName till it's correct
		while(true) {
			System.out.print("please type your name (min 3 max 5letters)\n>>>");
				
			String userName="";
			String userNameInput="";
			String userId;
			String gameId;
			
			 do{	
				try {
					userNameInput = scan.nextLine();
				} catch (Exception e) {
					System.out.println("ERROR: Something went wrong while setting your name\n type again\n>>>");
					continue;
				}
			}while(userNameInput.length()>6||userNameInput.length()<3);
			 
			 //log in 
			if(!(us.getUserId(userNameInput)==null)) {
				userName = userNameInput;
				userId = us.getUserId(userName);
			}else {
			 //register and login
			//userId generated , currentmill Stringed from index 0 to 7 + userName index 0 to 3;
			System.out.println(String.valueOf(System.currentTimeMillis()).substring(0,7));
			userId = String.valueOf(System.currentTimeMillis()).substring(0,7)+userNameInput.substring(0,2);
			System.out.println("Player successfully generated!");
			userName=userNameInput;
			 }
			
			//menu
			System.out.println("choose you action.\n 1 : review your game 2 : play new game 3: exit ");
			int userMenuInput = -1;
			while(userMenuInput>3||userMenuInput<0) {	
				try {
					userMenuInput = scan.nextInt();
					scan.nextLine();
					break;
				} catch (Exception e) {
					System.out.println("ERROR: Something went wrong with your input");
					continue;
				}
			}
			//review
			if(userMenuInput ==1) {
				ArrayList<T3GameVO> targetWinner = gs.searchGameByWinner(userId);
				System.out.println("here is your game won ");
				System.out.println("-------------------------------------------------------");
				for(T3GameVO one: targetWinner) {
					System.out.println(one);
				}
				ArrayList<T3GameVO> targetLoser = gs.searchGameByLoser(userId);
				System.out.println("here is your game defeated ");
				System.out.println("-------------------------------------------------------");
				for(T3GameVO one: targetLoser) {
					System.out.println(one);
				}
				System.out.println("==========================================================");
				System.out.println("choose game by gameID >>");
				String determinedGameId =null;
				try {
					determinedGameId = scan.nextLine();
				}catch(Exception e) {
					System.out.println("Input was incorrect");
				}
				T3GameVO foundGame=gs.searchGameByGameId(determinedGameId);
				if(foundGame==null) {
					System.out.println("there is no such game");
				}else {
					timeLine = ns.getNotationsByGame(foundGame.getGameId());
					printBoard(timeLine);
//					char [][] reviewMap = {{'-','-','-'},{'-','-','-'},{'-','-','-'}};
//					char teamer ='O';
//					for(int i=0; i<timeLine.size(); i++) {
//						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//						System.out.println(timeLine.get(i).getNotationId() + "phase,");
//						System.out.println(timeLine.get(i).getUserId() + "user");
//						System.out.println("placed at "+timeLine.get(i).getLocationId());
//						System.out.println("+++++++++++++++++++++++++++++++++++++++++++++");
//					}
					
				}
				
			}else if(userMenuInput ==2){
				//game part
				gameId = System.currentTimeMillis()+userId; // since winner and user is not set up , there should not be game object generated.
				//the O always goes first;
		        char[] team = {'X', 'O'};
		        
		        //player team 
		        Random rand = new Random();
		        char player_team = team[rand.nextInt(2)];
		        System.out.println("player got " + player_team + " symbol");
				
		        //computer got another symbol
		        char com_team = 'C';
		        for(int i=0; i<team.length;i++) {
					if(team[i]!=player_team) {
						com_team=team[i];
						break;
					}
				}
		        System.out.println("computer got " + com_team + " symbol");
		        
		        //map and game phase init
		        char[][] map = new char[][]{{'0','1','2'},{'3','4','5'},{'6','7','8'}};
		        
		        int gamePhase = 0;
		        
		        //init players vo for timeline;
		        T3UserVO user = new T3UserVO(userName,userId);
		        String winner,loser;
		        // if player took O symbol ( player goes first) 
		        if(player_team == 'O') {
			        while(true) {
			        	//player turn;
			        	int userInput = userMove(map);
			        	playMove(map,player_team,bind.get(userInput)[0],bind.get(userInput)[1]);
			        	T3NotationVO playerPhase= new T3NotationVO(String.valueOf(gamePhase++), gameId, userId, String.valueOf(userInput));
			        	timeLine.add(playerPhase);
			        	if(checkWin(map, player_team)) {
			        		System.out.println(player_team+" team won!");
			        		winner=userId;
			        		loser="0000000COM";
			        		break;
			        	}
			        	
			        	//computer turn
			        	int comInput = userMove(map);
			        	playMove(map,com_team,bind.get(comInput)[0],bind.get(comInput)[1]);
			        	T3NotationVO computePhase = new T3NotationVO(String.valueOf(gamePhase++), gameId, "COM", String.valueOf(comInput)); 
			        	timeLine.add(computePhase);
			        	if(checkWin(map, com_team)){
			        		System.out.println(com_team+" team won!");
			        		winner="0000000COM";
			        		loser=userId;
			        		break;
			        	}
			        }
		        }
		        //if computer took O symbo ( computer goes first)
		        else {
		        	while(true) {
			        	//reversed
		        		int comInput = userMove(map);
			        	playMove(map,com_team,bind.get(comInput)[0],bind.get(comInput)[1]);
			        	T3NotationVO computePhase = new T3NotationVO(String.valueOf(gamePhase++), gameId, "COM", String.valueOf(comInput)); 
			        	timeLine.add(computePhase);
			        	if(checkWin(map, com_team)){
			        		System.out.println(com_team+" team won!");
			        		winner="0000000COM";
			        		loser=userId;
			        		break;
			        	}
			        	
			        	int userInput = userMove(map);
			        	playMove(map,player_team,bind.get(userInput)[0],bind.get(userInput)[1]);
			        	T3NotationVO playerPhase= new T3NotationVO(String.valueOf(gamePhase++), gameId, userId, String.valueOf(userInput));
			        	timeLine.add(playerPhase);
			        	if(checkWin(map, player_team)) {
			        		System.out.println(player_team+" team won!");
			        		winner=userId;
			        		loser="0000000COM";
			        		break;
			        	}
		        	}
		        }
	
		        //save
		        if(us.getUserId(userName)==null)us.addUser(userId,userName);
		        gs.insertGame(new Timestamp(System.currentTimeMillis()), winner, loser, gameId);
		        
	
		        for(T3NotationVO node : timeLine) {
		        	System.out.println(node);
		        }
		        for(T3NotationVO node : timeLine) {
	        	ns.insertNotation(node.getNotationId(), node.getGameId(), node.getUserId(), node.getLocationId());
		        }
			}else if(userMenuInput==3){
				break;
			}
		}

		
		
	}

}
