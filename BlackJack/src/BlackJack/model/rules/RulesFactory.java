package BlackJack.model.rules;

public class RulesFactory {

  public IHitStrategy GetHitRule() {
    //return new BasicHitStrategy();
	return new SoftSeventeenHitStrategy();
  }

  public INewGameStrategy GetNewGameRule() {
    return new AmericanNewGameStrategy();
  }
}