package BlackJack.model.rules;

public class PlayerWinsTiesGameWinnerStrategy implements IGameWinnerStrategy {

	@Override
	public boolean IsDealerWinner(int dealer_score, int player_score) {
		return dealer_score > player_score;
	}
}
