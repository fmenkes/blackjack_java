package BlackJack.model.rules;

public interface IGameWinnerStrategy {
	boolean IsDealerWinner(int dealer_score, int player_score);
}
