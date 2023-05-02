import java.util.Scanner;

public class BevShopDriverApp {
	
	public static void main(String[] args) {
		String name = null;
		int age = 0;
		
		try (Scanner keyboard = new Scanner(System.in))
		{
		BevShop shop = new BevShop();
		System.out.println("The current order in process can have at most 3 alcoholic beverages.\r\n"
				+ "The minimum age to order alcohol drink is 21\r\n"
				+ "");
		
			System.out.println("What's your name");
			name = keyboard.nextLine();
			System.out.println("how old are you");
			age = keyboard.nextInt();
			if (shop.validAge(age) == true)
				System.out.println("congrats you can order alcohol");
			else
				System.out.println("you are not old enough to order alcohol");
		shop.startNewOrder(22, Day.MONDAY, name,age);
	
		if (age>=21) 
		{
		System.out.println("Your order will have Wine, Gin and Beer");
		shop.processAlcoholOrder("Wine", Size.MEDIUM);
		System.out.println("You ordered a medium wine");
		shop.getNumOfAlcoholDrink();
		shop.processAlcoholOrder("Gin", Size.SMALL);
		System.out.println("You ordered a small Gin&tonic");
		shop.getNumOfAlcoholDrink();
		shop.processAlcoholOrder("Beer", Size.LARGE);
		System.out.println("You ordered a Large Beer");
		System.out.println("you have ordered " + shop.getNumOfAlcoholDrink() + " drinks you are no longer eligble to order more alcohol drinks");
		}
		else
		{
			System.out.println("Since you're so young lets just get you a coffee");
			shop.processCoffeeOrder("HotCarmel", Size.LARGE, true, true);
			System.out.println("You ordered a Large Hot CArmel Coffee");
		}
		System.out.println("Getting total order price");
		System.out.println(shop.totalOrderPrice(shop.getCurrentOrder().Generatenumber()));
		System.out.println("heres a recipt for your order :D");
		System.out.println(shop);
		System.out.println("Thanks for comming :D ");
		System.out.println("Have an AMAZING DAY!!!");
	
		
		
	}

	
	}

}