package dk.cit.fyp.repo;

import java.util.List;

import dk.cit.fyp.domain.Bet;
import dk.cit.fyp.domain.Race;

public interface BetDAO {
	
	Bet get(int id);
	
	void save(Bet bet);
	
	List<Bet> top();
	
	int getNumUntranslated();
	
	List<Bet> findAll();
	
	List<Bet> findAllOpen();
	
	List<Bet> findAllPaid();
	
	List<Bet> findAllUnpaid();	
	
	void onScreen(Bet bet);

	void offScreen(Bet bet);

	List<Bet> getWinBets(Race race);
	
	List<Bet> getEachWayBets(Race race);
	
}
