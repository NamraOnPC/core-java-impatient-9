package jac444.wk1;

/**
 * @author Namra Rupesh Fanse
 *
 */

import java.util.List;

import jac444.wk1.LottoCentre;

public class Player {

	private final int max = 10;

	private final int min = 1;

	private final int range = max - min + 1;

	private int _money;

	private List<Integer> _noOfTickets;

	LottoCentre lottocentre;

	Ticket ticket;

	public Player(int money) {

		this._money = money;

	}

	public int getMoney() {

		return this._money;

	}

	/*
	 * public Ticket getTicket() {
	 * 
	 * Ticket ticket;
	 * 
	 * return ticket;
	 * 
	 * 
	 * }
	 */
	public void setMoney(int money) {

		this._money = money;

	}

	public void setNoOfTickets(List<Integer> noOfTickets) {

		this._noOfTickets = noOfTickets;

	}

	public void purchaseTickets() {

		this._money = this._money - LottoCentre.costOfTicket;

	}

	public void generatePlayerDrawAndCheck() {

		Ticket ticket = new Ticket();

		ticket._playerDraw[0] = (int) (Math.random() * range);

		ticket._playerDraw[1] = (int) (Math.random() * range);

		ticket._playerDraw[2] = (int) (Math.random() * range);

		if (ticket._playerDraw[0] == Ticket._draw[0] && ticket._playerDraw[1] == Ticket._draw[1]
				&& ticket._playerDraw[2] == Ticket._draw[2]) {

			this._money = this._money + LottoCentre.firstPrize;

		}

		int count = 0;

		for (int i = 0; i <= 2; i++) {
			for (int x = 0; x <= 2; x++) {
				if (Ticket._draw[i] == ticket._playerDraw[x]) {
					count++;
					ticket._playerDraw[x] = -1;
					break;
				}
			}
		}
		switch (count) {

		case 1:
			this._money = this._money + LottoCentre.thirdPrize;

		case 2:
			this._money = this._money + LottoCentre.secondPrize;

		}

	}

}
