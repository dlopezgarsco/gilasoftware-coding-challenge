package dlopezgarsco;

import dlopezgarsco.db.CategoryDAO;
import dlopezgarsco.api.category.CategoryResource;
import dlopezgarsco.api.category.CategoryServiceImpl;
import dlopezgarsco.db.NotificationDAO;
import dlopezgarsco.api.notification.NotificationResource;
import dlopezgarsco.api.notification.NotificationServiceImpl;
import dlopezgarsco.db.UserDAO;
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

        final CategoryDAO categoryDAO = jdbi.onDemand(CategoryDAO.class);
        final UserDAO userDAO = jdbi.onDemand(UserDAO.class);
        final NotificationDAO notificationDAO = jdbi.onDemand(NotificationDAO.class);

        environment.jersey().register(new CategoryResource(new CategoryServiceImpl(categoryDAO)));
        environment.jersey().register(new NotificationResource(new NotificationServiceImpl(notificationDAO, userDAO)));
    }

}
