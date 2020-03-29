package niucaocao.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import niucaocao.dao.HeroMapper;
import niucaocao.domain.Hero;
import niucaocao.service.HeroService;
@Service
@Transactional
public class HeroServiceImpl implements HeroService {

	  @Resource
		private HeroMapper heromapper;
		@Override
		public int save(Hero hero) {
			return heromapper.save(hero);
		}
		@Override
		public List<Hero> findAll() {
			List<Hero> result=heromapper.findAll();		
			return result;
		}
		@Override
		public Hero findById(Integer id) {
			return heromapper.findById(id);
		}
		@Override
		public void update(Hero hero) {
			heromapper.update(hero);
		}
		@Override
		public void delete(Integer id) {
			// TODO Auto-generated method stub
			heromapper.delete(id);
		}
		@Override
		public List<Hero> findbyInput(String name) {
			// TODO Auto-generated method stub
			return heromapper.findbyInput(name);
		}

}
