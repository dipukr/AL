import java.util.Scanner;

public class Coin {
	private static void play(String player1, String player2) {
		if (Math.random() < 0.5) {
			String tmp = player1;
			player1 = player2;
			player2 = tmp;
		}
		String result = (Math.random() < 0.5) ? "head" : "tail";
		System.out.println("\t"+player1+" won with a flip of "+result);
	}

	public static void main(String[] args) {
		String response;
		Scanner sc = new Scanner(System.in);
		do {
			play("Aryan", "Giya");
			System.out.print("\t\tPaly again? ");
			response = sc.nextLine();
		} while (response.startsWith("y") || response.startsWith("Y"));
	}
}