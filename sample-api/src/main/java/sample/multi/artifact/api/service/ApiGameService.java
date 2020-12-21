package sample.multi.artifact.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sample.multi.artifact.model.Game;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.util.List;

public class ApiGameService implements GameService {

	private static final Logger LOG = LoggerFactory.getLogger(ApiGameService.class);

	private final EntityManagerFactory factory;

	@Inject
	public ApiGameService(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void save(Game game) {
		EntityManager em = factory.createEntityManager();
		EntityTransaction tx = em.getTransaction();
		tx.begin();
		em.persist(game);
		tx.commit();
		em.close();
		LOG.info("game saved!");
	}

	@Override
	public List<Game> list() {
		EntityManager em = factory.createEntityManager();
		List<Game> games = em.createQuery("select g from Game g", Game.class).getResultList();
		em.close();
		return games;
	}
}
