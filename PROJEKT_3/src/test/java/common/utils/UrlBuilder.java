package common.utils;

import org.apache.commons.lang3.StringUtils;

public final class UrlBuilder {

    private final StringBuffer urlBuffer;

    public UrlBuilder(String baseUrl) {
        this.urlBuffer = new StringBuffer(baseUrl);
    }

    public UrlBuilder add(Object url) {
        if(urlBuffer.toString().endsWith("/") || StringUtils.defaultString(String.valueOf(url), "INVALID-URL-PARAM").startsWith("/")) {
            urlBuffer.append(url);
        } else {
            urlBuffer.append("/").append(url);
        }
        return this;
    }
    public String build(){
        return urlBuffer.toString();
    }

}
