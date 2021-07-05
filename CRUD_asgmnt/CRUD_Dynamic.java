package com.te.CRUD_asgmnt;

import java.util.Scanner;

public class CRUD_Dynamic {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Dynamic CRUD Operations");
		System.out.println(" Enter your choice of Operation :");
		System.out.println("1. Create /n 2. Read /n 3. Update /n 4. Delete /n");
		int ch = scanner.nextInt();
		
		switch (ch) {
		case 1:
			Dynamic_Create.insertDynamicQuery();
			break;
		
		case 2:
			Dynamic_Read.selectDynamicQuery();
			break;
			
		case 3:
			System.out.println("What do you want to update:");
			System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
			String option=scanner.next();
			Dynamic_Update.updateDyanmicQuery(option);
			break;
	
		case 4:
			Dynamic_Delete.deleteDynamicQuery();
			break;	
			
		default:
			System.out.println("Invalid Choice");
			break;
		}

	}

}
