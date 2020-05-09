package niucaocao.service;

import java.util.List;

import niucaocao.domain.Hero;

public interface HeroService {
	public int save(Hero hero);
	public List<Hero> findAll();
	
	public Hero findById(Integer id);

	public void update(Hero hero);
	
	public void delete(Integer id);
	
	public List<Hero> findbyInput(String name);
}
