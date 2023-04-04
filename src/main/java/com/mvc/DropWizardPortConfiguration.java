package com.mvc;

import io.dropwizard.Configuration;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.hibernate.validator.constraints.*;
import javax.validation.constraints.*;
import javax.validation.constraints.NotEmpty;

public class DropWizardPortConfiguration extends Configuration {
    @NotEmpty
    private String dateFormat;

    public String getDateFormat() {
        return dateFormat;
    }
}
