/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.recording;

import com.twilio.base.Fetcher;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AddOnResultFetcher extends Fetcher<AddOnResult> {
    private String pathAccountSid;
    private final String pathReferenceSid;
    private final String pathSid;

    /**
     * Construct a new AddOnResultFetcher.
     * 
     * @param pathReferenceSid The reference_sid
     * @param pathSid Fetch by unique result Sid
     */
    public AddOnResultFetcher(final String pathReferenceSid, 
                              final String pathSid) {
        this.pathReferenceSid = pathReferenceSid;
        this.pathSid = pathSid;
    }

    /**
     * Construct a new AddOnResultFetcher.
     * 
     * @param pathAccountSid The account_sid
     * @param pathReferenceSid The reference_sid
     * @param pathSid Fetch by unique result Sid
     */
    public AddOnResultFetcher(final String pathAccountSid, 
                              final String pathReferenceSid, 
                              final String pathSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathReferenceSid = pathReferenceSid;
        this.pathSid = pathSid;
    }

    /**
     * Make the request to the Twilio API to perform the fetch.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Fetched AddOnResult
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public AddOnResult fetch(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.GET,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Recordings/" + this.pathReferenceSid + "/AddOnResults/" + this.pathSid + ".json",
            client.getRegion()
        );
        
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("AddOnResult fetch failed: Unable to connect to server");
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
        
        return AddOnResult.fromJson(response.getStream(), client.getObjectMapper());
    }
}