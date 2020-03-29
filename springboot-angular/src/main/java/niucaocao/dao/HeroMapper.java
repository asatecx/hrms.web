package niucaocao.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import niucaocao.domain.Hero;

public interface HeroMapper {
	public List<Hero> findAll();
	public Hero findById(Integer id);
	public void delete(Integer id);
	public int save(Hero hero);
	public void update(Hero hero);
	public List<Hero> findbyInput(@Param("heroName") String heroName);
}
