package dlopezgarsco;

import dlopezgarsco.db.UserDAO;
import dlopezgarsco.resources.UserResource;
import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Environment;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.jdbi3.JdbiFactory;
import org.flywaydb.core.Flyway;
import org.jdbi.v3.core.Jdbi;

public class GilaChallengeApplication extends Application<GilaChallengeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GilaChallengeApplication().run(args);
    }

    @Override
    public String getName() {
        return "GilaChallenge";
    }

    @Override
    public void run(final GilaChallengeConfiguration config,
                    final Environment environment) {
        DataSourceFactory dataSourceFactory = config.getDataSourceFactory();
        Flyway.configure().dataSource(
                        dataSourceFactory.getUrl(),
                        dataSourceFactory.getUser(),
                        dataSourceFactory.getPassword())
                .load()
                .migrate();
        final Jdbi jdbi = new JdbiFactory().build(environment, config.getDataSourceFactory(), "h2");
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        environment.jersey().register(new UserResource(userDAO));
    }

}
