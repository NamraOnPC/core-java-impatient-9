/**
 * 
 */
package jac444.wk1;

/**
 * @author Namra Rupesh Fanse
 *
 */

import java.util.List;

import java.util.ArrayList;
import java.util.Collection;

import jac444.wk1.Player;

import jac444.wk1.Ticket;

public class LottoCentre {

	private static int _operatorMoney;

	public final static int firstPrize = 100;

	public final static int secondPrize = 50;

	public final static int thirdPrize = 25;

	private final static int minPlayers = 1;

	private final static int maxPlayers = 10;

	private final static int rangeOfPlayers = maxPlayers - minPlayers + 1;

	public static final int costOfTicket = 2;

	private static List<Player> player = new ArrayList<Player>();

	// private static List<List<Integer>> player = new ArrayList<List<Integer>>();

	static class Generator {

		// Ticket ticket;

		private final static int max = 10;

		private final static int min = 1;

		private final static int range = max - min + 1;

		public static void generateLottery() {

			Ticket._draw[0] = (int) (Math.random() * range);

			Ticket._draw[1] = (int) (Math.random() * range);

			Ticket._draw[2] = (int) (Math.random() * range);

		}

	}

	public static void main(String[] args) {

		System.out.println("This program instantiates 10 players, does 50 draws of lottery");

		System.out.println("Each player is instanitated with 100 dollars in their account\n");

		for (int i = 0; i < rangeOfPlayers; i++) {

			player.add(new Player(100));

		}

		for (int j = 0; j < rangeOfPlayers; j++) {

			System.out.println("Money player has before purchasing tickets :- " + player.get(j).getMoney());

		}

		System.out.println("\nMoney operator has before purchasing tickets :- " + _operatorMoney + "\n");
		// Here 5 is hard coded for each player buying 5 tickets.

		for (int s = 0; s < 5; s++) {

			for (int k = 0; k < rangeOfPlayers; k++) {

				player.get(k).purchaseTickets();

			}

		}

		System.out.println("Each player purchases 5 tickets so each player can do 5 draws; 5 * 10 = 50 draws\n");

		for (int l = 0; l < rangeOfPlayers; l++) {

			System.out.println("Money player has after purchasing tickets :- " + player.get(l).getMoney());

		}

		// Hard coded 5 tickets for each player.10->5
		for (int a = 0; a < 5; a++) {

			for (int b = 0; b < 10; b++) {

				_operatorMoney = _operatorMoney + costOfTicket;

			}

		}

		System.out.println("\nMoney operator has after players bought their tickets :- " + _operatorMoney + "\n");

		System.out.println("**Get ready Generating Lottery**\n");

		Generator.generateLottery();

		// Here 5 is hard coded for each player buying 5 tickets.

		for (int n = 0; n < 5; n++) {

			for (int m = 0; m < rangeOfPlayers; m++) {

				// player.get(m).add(new Ticket());

				player.get(m).generatePlayerDrawAndCheck();

			}

		}

		// As each player has bought 5 tickets they did 5 draws and hence they have
		// multiple winnings

		for (int q = 0; q < rangeOfPlayers; q++) {

			System.out.println("Money player has after lottery :- " + player.get(q).getMoney());

		}

	}

}
