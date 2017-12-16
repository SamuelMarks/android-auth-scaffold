package io.complicated.android_auth_scaffold.utils;

import java.util.Locale;


public final class HttpCodeException extends Exception {
    public HttpCodeException() {
    }

    // Constructor that accepts a message
    public HttpCodeException(int http_code) {
        super(String.format(Locale.getDefault(), "%d", http_code));
    }
}
