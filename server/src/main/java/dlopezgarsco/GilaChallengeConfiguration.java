package dlopezgarsco;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.core.Configuration;
import io.dropwizard.db.DataSourceFactory;
import io.dropwizard.web.conf.WebConfiguration;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotNull;

public class GilaChallengeConfiguration extends Configuration {

    @Valid
    @NotNull
    @JsonProperty("database")
    private DataSourceFactory database = new DataSourceFactory();

    @Valid
    @NotNull
    @JsonProperty("web")
    private WebConfiguration webConfiguration = new WebConfiguration();

    public WebConfiguration getWebConfiguration() {
        return webConfiguration;
    }

    public void setWebConfiguration(final WebConfiguration webConfiguration) {
        this.webConfiguration = webConfiguration;
    }

    public void setDataSourceFactory(final DataSourceFactory factory) {
        this.database = factory;
    }

    public DataSourceFactory getDataSourceFactory() {
        return database;
    }
}
