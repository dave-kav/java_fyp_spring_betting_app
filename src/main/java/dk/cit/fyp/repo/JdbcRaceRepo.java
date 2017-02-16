package dk.cit.fyp.repo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import dk.cit.fyp.domain.Race;
import dk.cit.fyp.mapper.RaceRowMapper;

@Repository
public class JdbcRaceRepo implements RaceDAO {

	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	public JdbcRaceRepo(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}
	
	@Override
	public Race get(int raceID) {
		String sql = "SELECT * FROM Races WHERE Race_id = ?";
		return jdbcTemplate.queryForObject(sql, new Object[] {raceID}, new RaceRowMapper());
	}

	@Override
	public void save(Race race) {
		if (race.getRaceID() != 0)
			update(race);
		else
			add(race);
	}
	
	private void add(Race race) {
		String sql = "INSERT INTO Races (Time, Racetrack) VALUES (?, ?)";
		
		jdbcTemplate.update(sql, new Object[] {race.getTime(), race.getRacetrack()});
	}
	
	private void update(Race race) {
		String sql = "UPDATE Races SET Time = ?, Racetrack = ?"
				+ "WHERE Race_id = ?";
		
		jdbcTemplate.update(sql, new Object[] {race.getTime(), race.getRacetrack(), race.getRaceID()});
	}

	@Override
	public List<Race> findAll() {
		String sql = "SELECT * FROM Races";
		return jdbcTemplate.query(sql, new RaceRowMapper());
	}

}
