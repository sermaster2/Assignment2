import java.util.Scanner; //Sercan Cagatay, CS 0401 MoWed 3pm, Pie Ordering Program

import java.io.IOException;

public class Assignment2 {

    public static void main(String[] args) {

	Scanner sc = new Scanner(System.in);

	System.out.print("Hi, welcome to Pies, Pies and Pis! Is there a customer in line? Yes = 1, No = 2 >"); //Asks if customer is in line
	int option = sc.nextInt();

	switch (option) {
	case 1: 
		System.out.println("Do you have a Pie Card? Yes = 1, No = 2 >"); //Asks for Pie Card
		int pieCard = sc.nextInt();

		double numPlainD = 0, numPepperoniD = 0, numCharmD = 0, payment = 0, totalD = 0, totalDO = 0, total = 0; //Declares varibles and all set to 0 for scanner
		double change = 0;
		double numPlain = 0, numPepperoni = 0, numCharm = 0;
		int numCherry = 0, numCherryD = 0;

		switch (pieCard) { //One case leads to discounted prices, other leads to regular prices
			case 1: //This is for Pie Card Holders
				System.out.println("Awesome! Here are our discounted options:"); 
				System.out.println("A plain pie is $10");
				System.out.println("A pepporoni pie is $10");
				System.out.println("A cherry pie is $8 or $1.75 per slice");
				System.out.println("We have a special gold Pi charm for $45");
				System.out.println("And for our special Pie Card Holders, we give an additional 10 % off for any orders above $100");
				System.out.println(" ");
				boolean good = false; //boolean used for inputs with invalid responses
			do {
				System.out.println("Please choose an option:");
				System.out.println("1) Update Pizza Order");
				System.out.println("2) Update Cherry Pie Order");
				System.out.println("3) Update Pi Charm Order");
				System.out.println("4) Checkout");
				int choice = sc.nextInt();
			switch (choice) { //gives prompt to direct customers to buy pizza, pie, or the charms
				case 1:
					do {
						System.out.println("How many plain pies would you like? >");
						numPlainD = sc.nextInt();
							if (numPlainD >= 0) {
								good = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");
							}
					}
					while (!good);

					do {
						System.out.println("How many pepperoni pies would you like? >");
						numPepperoniD = sc.nextInt();
							if (numPepperoniD >= 0) {
								good = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");
							}
					}
					while (!good);
						good = false;
				break;
				case 2:
					good = false;
					do {
						System.out.println("How many cherry slices would you like? (6 slices is $8) >");
						numCherryD = sc.nextInt();
							if (numCherryD >= 0) {
								good = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");	
							}
					}
					while (!good);
					good = false;
				break;
				case 3:
					good = false;
					do {
						System.out.println("How many Pi charms would you like? >");
						numCharmD = sc.nextInt();
							if (numCharmD >= 0) {
								good = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");	
							}
					}	
					while (!good);
					good = false;
				break;
				case 4:
					int numCherryPieD = numCherryD/6; //reciept variables and the math declared in this case
					int numCherrySlicesD = numCherryD % 6;
					double costPlainD = 10, costPepperoniD = 10, costcherryPieD = 8, costcherrySliceD = 1.75, costCharmD = 45;
					double totPlainD = (costPlainD * numPlainD);
					double totPepperoniD = (costPepperoniD * numPepperoniD);
					double totCherryPieD = (costcherryPieD * (double) numCherryPieD);
					double totCherrySliceD = (costcherrySliceD * (double) numCherrySlicesD);
					double totCharmD = (costCharmD * numCharmD);
					double subtotalD = totPlainD + totCharmD + totPepperoniD + totCherrySliceD + totCherryPieD;
					double subtotalDO = subtotalD - (subtotalD * 0.1);
					double taxDO = subtotalDO * 0.07;
					totalDO = taxDO + subtotalDO;
					double taxD = subtotalD * 0.07;
					totalD = taxD + subtotalD;
					System.out.println("Here is your total:");
					System.out.println(" ");
					System.out.printf("		" + (int) numPlainD + " plain Pizzas at $10.00 each			$%.2f\n", totPlainD);
					System.out.printf("		" + (int) numPepperoniD + " pepperoni Pizzas at $10.00 each		$%.2f\n", totPepperoniD);
					System.out.printf("		" + (int) numCherryPieD + " cherry pies at $8.00 each			$%.2f\n", totCherryPieD);
					System.out.printf("		" + (int) numCherrySlicesD + " cherry slices at $1.75 each			$%.2f\n", totCherrySliceD);
					System.out.printf("		" + (int) numCharmD + " pi charms at $45.00 each			$%.2f\n", totCharmD);
					System.out.println("								--------");
					System.out.printf("		Subtotal:					$%.2f\n",subtotalD);
						if (subtotalD >= 100) {
							System.out.printf("		Your new total after 10%% discount!		$%.2f\n", subtotalDO);
							System.out.printf("		Tax:						$%.2f\n", taxDO);
							System.out.println("								--------");
							System.out.printf("		Total:						$%.2f\n", totalDO);
							System.out.println(" ");
							}
						if (subtotalD >= 0 && subtotalD < 100) {
							System.out.printf("		Tax:						$%.2f\n", taxD);
							System.out.println("								--------");
							System.out.printf("		Total:						$%.2f\n", totalD);
							System.out.println(" ");
							}
					do {
						System.out.println("Please enter your payment amount >");
						payment = sc.nextDouble();
						if (payment >= totalDO) {
							good = true;
							change = payment - totalDO;
							}
						if (payment >= totalD) {
							good = true;
							change = payment - totalD;
							}
						}
					while (!good);
					System.out.printf("		Your change:					$%.2f\n", change);
					System.out.println("		Thanks for stopping by Pies, Pies and Pis!");
					break;
				default:
					System.out.println("I didn't quite get that. Please try again");
					System.exit(0);
				}
			}
			while(!good);
			break;
			case 2: //This is for non-Pie Card holders
				System.out.println("Awesome! Here are our options:");
				System.out.println("A plain pie is $10");
				System.out.println("A pepporoni pie is $12");
				System.out.println("A cherry pie is $10 or $2 per slice");
				System.out.println("We have a special gold Pi charm for $50");
				System.out.println(" ");
				boolean goodb = false;
				do {
				System.out.println("Please choose an option:");
				System.out.println("1) Update Pizza Order");
				System.out.println("2) Update Cherry Pie Order");
				System.out.println("3) Update Pi Charm Order");
				System.out.println("4) Checkout");
				int choice = sc.nextInt();
				switch (choice) {
				case 1:
					do {
						System.out.println("How many plain pies would you like? >");
						numPlain = sc.nextInt();
							if (numPlain >= 0) {
								goodb = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");
							}
					}
					while (!goodb);

					do {
						System.out.println("How many pepperoni pies would you like? >");
						numPepperoni = sc.nextInt();
							if (numPepperoni >= 0) {
								goodb = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");
							}
					}
					while (!goodb);
					goodb = false;
				break;
				case 2:
					goodb = false;
					do {
						System.out.println("How many cherry slices would you like? (6 slices is $8) >");
						numCherry = sc.nextInt();
							if (numCherry >= 0) {
								goodb = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");	
							}
					}
					while (!goodb);
					goodb = false;
				break;
				case 3:
					goodb = false;
					do {
						System.out.println("How many Pi charms would you like? >");
						numCharm = sc.nextInt();
							if (numCharm >= 0) {
								goodb = true;
							}
							else{
							System.out.println("I didn't quite get that. Please try again");	
							}
					}	
					while (!goodb);
					goodb = false;
				break;
				case 4:
					int numCherryPie = numCherry/6;
					int numCherrySlices = numCherry % 6;
					double costPlain = 10, costPepperoni = 12, costcherryPie = 10, costcherrySlice = 2, costCharm = 50;
					double totPlain = (costPlain * numPlain);
					double totPepperoni = (costPepperoni * numPepperoni);
					double totCherryPie = (costcherryPie * (double) numCherryPie);
					double totCherrySlice = (costcherrySlice * (double) numCherrySlices);
					double totCharm = (costCharm * numCharm);
					double subtotal = totPlain + totCharm + totPepperoni + totCherrySlice + totCherryPie;
					double tax = subtotal * 0.07;
					total = tax + subtotal;
					System.out.println("Here is your total:");
					System.out.println(" ");
					System.out.printf("		" + (int) numPlain + " plain Pizzas at $10.00 each			$%.2f\n", totPlain);
					System.out.printf("		" + (int) numPepperoni + " pepperoni Pizzas at $12.00 each		$%.2f\n", totPepperoni);
					System.out.printf("		" + (int) numCherryPie + " cherry pies at $10.00 each			$%.2f\n", totCherryPie);
					System.out.printf("		" + (int) numCherrySlices + " cherry slices at $2.00 each			$%.2f\n", totCherrySlice);
					System.out.printf("		" + (int) numCharm + " pi charms at $50.00 each			$%.2f\n", totCharm);
					System.out.println("								--------");
					System.out.printf("		Subtotal:					$%.2f\n", subtotal);
					System.out.printf("		Tax:						$%.2f\n", tax);
					System.out.println("								--------");
					System.out.printf("		Total:						$%.2f\n", total);
					System.out.println(" ");
					do {
						System.out.println("Please enter your payment amount >");
						payment = sc.nextDouble();
							if (payment >= total) {
								goodb = true;
								change = payment - total;
								}
					}
					while (!goodb);
					System.out.printf("		Your change:					$%.2f\n", change);
					System.out.println("		Thanks for stopping by Pies, Pies and Pis!");
				break;
				default:
					System.out.println("I didn't quite get that. Please try again");
					System.exit(0);
				}
			}
			while(!goodb);
			break;
			default:
			System.out.println("I didn't quite get that. Please try again");
			System.exit(0);
		}
	break;
	case (2): System.out.println("Please come again!");
	break;
	default:
	System.out.println("I didn't quite get that. Please try again");
	System.exit(0);
		}


	}

}