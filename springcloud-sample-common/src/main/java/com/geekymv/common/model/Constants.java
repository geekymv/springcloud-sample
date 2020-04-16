package com.geekymv.common.model;

public interface Constants {


    String CACHE_NAMESPACE = "SC";

    String COLON = ":";

    interface Cache {

        String TOKEN = CACHE_NAMESPACE + COLON + "TOKEN";

        String CAPTCHA_TOKEN = CACHE_NAMESPACE + COLON + "CAPTCHA_TOKEN";

        String COMPETENCE = CACHE_NAMESPACE + COLON + "COMPETENCE";

        String USERID_TOKEN = CACHE_NAMESPACE + COLON + "USERID_TOKEN";

        String PROCUCT_INVENTORY = CACHE_NAMESPACE + COLON + "PROCUCT_INVENTORY";

    }

}
