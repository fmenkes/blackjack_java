package BlackJack.model.rules;

import BlackJack.model.Card;
import BlackJack.model.Player;

public class SoftSeventeenHitStrategy implements IHitStrategy {
	private final int g_hitlimit = 17;
	
	@Override
	public boolean DoHit(Player a_dealer) {
		int score = a_dealer.CalcScore();
		
		if(score < g_hitlimit) {
			return true;
		} else if(score == g_hitlimit) {
			boolean has_ace = false;
			int other_cards_total = 0;
			
			for(Card c : a_dealer.GetHand()) {
				if(c.GetValue() == Card.Value.Ace) {
					has_ace = true;
				} else {
					other_cards_total += c.GetValue().ordinal();
				}
			}
			
			return has_ace && other_cards_total == 6;
		} else {
			return false;
		}
	}

}
