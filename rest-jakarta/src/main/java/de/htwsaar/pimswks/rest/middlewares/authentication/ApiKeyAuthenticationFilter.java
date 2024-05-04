/*
 * Copyright (c) 2024. 
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the “Software”), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED “AS IS”, WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package de.htwsaar.pimswks.rest.middlewares.authentication;

import de.htwsaar.pimswks.rest.security.Secured;
import jakarta.annotation.Priority;
import jakarta.ws.rs.Priorities;
import jakarta.ws.rs.container.ContainerRequestContext;
import jakarta.ws.rs.container.ContainerRequestFilter;
import jakarta.ws.rs.core.HttpHeaders;
import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.Provider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 *
 */
@Secured
@Provider
@Priority(Priorities.AUTHENTICATION)
public class ApiKeyAuthenticationFilter implements ContainerRequestFilter {
    public static final String APIKEY_HEADER = "X-API-KEY";

    private static final Logger LOGGER = LoggerFactory.getLogger(ApiKeyAuthenticationFilter.class.getName());

    private final String apiKey;

    public ApiKeyAuthenticationFilter() {
        // Try loading the API key from the environment
        String providedApiKey = System.getenv().get("API_KEY");

        if (providedApiKey == null) {
            providedApiKey = UUID.randomUUID().toString();
            LOGGER.warn("No API key found in environment, using random key: {}", providedApiKey);
        }

        this.apiKey = providedApiKey;
    }

    @Override
    public void filter(ContainerRequestContext containerRequestContext) {
        String apiKeyHeader = containerRequestContext.getHeaderString(APIKEY_HEADER);
        
        if (apiKeyHeader != null) {
            rejectRequestWithUnauthorized(containerRequestContext);
        }
        
        if (!this.apiKey.equals(apiKeyHeader)) {
            rejectRequestWithUnauthorized(containerRequestContext);
        }
    }

    private void rejectRequestWithUnauthorized(ContainerRequestContext containerRequestContext) {
        containerRequestContext.abortWith(
            Response.status(Response.Status.UNAUTHORIZED)
                .header(HttpHeaders.WWW_AUTHENTICATE, APIKEY_HEADER)
                .build()
        );
    }
}
