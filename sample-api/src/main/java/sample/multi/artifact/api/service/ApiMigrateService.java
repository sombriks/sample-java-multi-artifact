package sample.multi.artifact.api.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import java.nio.file.Files;
import java.nio.file.Paths;

public class ApiMigrateService implements MigrateService {

	private static final Logger LOG = LoggerFactory.getLogger(ApiMigrateService.class);

	private final EntityManagerFactory factory;

	private static final String[] MIGRATIONS = {
			"migrations/0001-create-table-game.sql",
			"migrations/0002-create-table-line.sql",
	};

	@Inject
	public ApiMigrateService(EntityManagerFactory factory) {
		this.factory = factory;
	}

	@Override
	public void latest() throws Exception {
		EntityManager em = factory.createEntityManager();
		for (String sql : MIGRATIONS) {
			LOG.info("running " + sql);
			String query = new String(Files.readAllBytes(Paths
					.get(this.getClass().getClassLoader()
					.getResource(sql).toURI())));
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			em.createNativeQuery(query).executeUpdate();
			tx.commit();
		}
		em.close();

	}
}
