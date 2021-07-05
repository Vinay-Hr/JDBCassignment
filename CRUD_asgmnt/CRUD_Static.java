package com.te.CRUD_asgmnt;

import java.util.Scanner;

public class CRUD_Static {

	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		System.out.println("Welcome to Static CRUD Operations");
		System.out.println(" Enter your choice of Operation :");
		System.out.println("1. Create /n 2. Read /n 3. Update /n 4. Delete /n");
		int ch = scanner.nextInt();
		
		switch (ch) {
		case 1:
			Static_Create.insertStatic() ;
			break;
		
		case 2:
			Static_Read.selectStatic();
			break;
			
		case 3:
			System.out.println("Select field to Update:");
			System.out.println("n:Name\ts:Standard\tm:Marks\td:Date of Birth");
			String option=scanner.next();
			Static_Update.updateStatic(option);
			break;
	
		case 4:
			Static_Delete.deleteStatic();
			break;
	
			
		default:
			System.out.println("Invalid Choice");
			break;
		}

	}

}
