package BlackJack.controller;

import BlackJack.model.EventObserver;
import BlackJack.model.Game;
import BlackJack.view.IView;
import BlackJack.view.ViewInput;

public class PlayGame implements EventObserver {

	private Game m_game;
	private IView m_view;
	
  public PlayGame(Game a_game, IView a_view) {
	  this.m_game = a_game;
	  this.m_view = a_view;
  }

  public boolean Play() {
    Redraw();

    if (m_game.IsGameOver())
    {
        m_view.DisplayGameOver(m_game.IsDealerWinner());
    }

    ViewInput input = m_view.GetInput();
    
    if (input == ViewInput.PLAY)
    {
        m_game.NewGame();
    }
    else if (input == ViewInput.HIT)
    {
        m_game.Hit();
    }
    else if (input == ViewInput.STAND)
    {
        m_game.Stand();
    }

    return input != ViewInput.QUIT;
  }

  @Override
  public void onEvent() {
	try {
		Thread.sleep(500);
		Redraw();
	} catch (InterruptedException e) {
		e.printStackTrace();
	}
  }
  
  private void Redraw() {
	  m_view.DisplayWelcomeMessage();
	    
	  m_view.DisplayDealerHand(m_game.GetDealerHand(), m_game.GetDealerScore());
	  m_view.DisplayPlayerHand(m_game.GetPlayerHand(), m_game.GetPlayerScore());
  }
}