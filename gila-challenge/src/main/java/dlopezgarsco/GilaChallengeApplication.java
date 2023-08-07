package dlopezgarsco;

import io.dropwizard.core.Application;
import io.dropwizard.core.setup.Bootstrap;
import io.dropwizard.core.setup.Environment;

public class GilaChallengeApplication extends Application<GilaChallengeConfiguration> {

    public static void main(final String[] args) throws Exception {
        new GilaChallengeApplication().run(args);
    }

    @Override
    public String getName() {
        return "GilaChallenge";
    }

    @Override
    public void initialize(final Bootstrap<GilaChallengeConfiguration> bootstrap) {
        // TODO: application initialization
    }

    @Override
    public void run(final GilaChallengeConfiguration configuration,
                    final Environment environment) {
        // TODO: implement application
    }

}
