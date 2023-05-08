package logic;
import java.util.Scanner;

import database.service.T3GameService;
import database.service.T3LocationService;
import database.service.T3NotationService;
import database.service.T3UserService;

public class Main {
	T3UserService us = T3UserService.getInstance();
	T3LocationService ls = T3LocationService.getInstance();
	T3GameService	gs = T3GameService.getInstance();
	T3NotationService ns = T3NotationService.getInstance();
	Scanner scan   = new Scanner(System.in);
	String userName;
	HashMap<T3UserVO,T3LocationVO>
	public static void main(String[] args) {
		
		System.out.println("Welcome to TICTACTOE ! ");
		while(true) {
			System.out.print("please type your name :");
			
			try {
				
			}catch(Exception e){
				e.printStackTrace();
			}
		}
	}

}
