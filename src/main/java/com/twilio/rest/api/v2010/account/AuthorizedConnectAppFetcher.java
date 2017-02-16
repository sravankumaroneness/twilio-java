/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AuthorizedConnectAppFetcher extends Fetcher<AuthorizedConnectApp> {
    private String pathAccountSid;
    private final String pathConnectAppSid;

    /**
     * Construct a new AuthorizedConnectAppFetcher.
     * 
     * @param pathConnectAppSid The connect_app_sid
     */
    public AuthorizedConnectAppFetcher(final String pathConnectAppSid) {
        this.pathConnectAppSid = pathConnectAppSid;
    }

    /**
     * Construct a new AuthorizedConnectAppFetcher.
     * 
     * @param pathAccountSid The account_sid
     * @param pathConnectAppSid The connect_app_sid
     */
    public AuthorizedConnectAppFetcher(final String pathAccountSid, 
                                       final String pathConnectAppSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathConnectAppSid = pathConnectAppSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched AuthorizedConnectApp
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AuthorizedConnectApp fetch(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/AuthorizedConnectApps/" + this.pathConnectAppSid + ".json",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("AuthorizedConnectApp fetch failed: Unable to connect to server");
        } else if (!TwilioRestClient.SUCCESS.apply(response.getStatusCode())) {
            RestException restException = RestException.fromJson(response.getStream(), client.getObjectMapper());
            if (restException == null) {
                throw new ApiException("Server Error, no content");
            }
        
            throw new ApiException(
                restException.getMessage(),
                restException.getCode(),
                restException.getMoreInfo(),
                restException.getStatus(),
                null
            );
        }
        
        return AuthorizedConnectApp.fromJson(response.getStream(), client.getObjectMapper());
    }
}