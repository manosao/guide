package gr.manos.guide.restapi.utils;

import org.springframework.data.domain.AuditorAware;

public class CustomAuditorAware implements AuditorAware<String> {

    @Override
    public String getCurrentAuditor() {
        return null;
    }

}