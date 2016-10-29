package BlackJack.model.rules;

import BlackJack.model.Deck;
import BlackJack.model.Dealer;
import BlackJack.model.Player;  

class InternationalNewGameStrategy implements INewGameStrategy {

  public boolean NewGame(Deck a_deck, Dealer a_dealer, Player a_player) {
    a_player.DealCard(a_deck, true);
    a_dealer.DealCard(a_deck, true);
    a_player.DealCard(a_deck, true);
  
    return true;
  }
}