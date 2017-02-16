/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.sip.credentiallist;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class CredentialCreator extends Creator<Credential> {
    private String pathAccountSid;
    private final String pathCredentialListSid;
    private final String username;
    private final String password;

    /**
     * Construct a new CredentialCreator.
     * 
     * @param pathCredentialListSid The credential_list_sid
     * @param username The username
     * @param password The password
     */
    public CredentialCreator(final String pathCredentialListSid, 
                             final String username, 
                             final String password) {
        this.pathCredentialListSid = pathCredentialListSid;
        this.username = username;
        this.password = password;
    }

    /**
     * Construct a new CredentialCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param pathCredentialListSid The credential_list_sid
     * @param username The username
     * @param password The password
     */
    public CredentialCreator(final String pathAccountSid, 
                             final String pathCredentialListSid, 
                             final String username, 
                             final String password) {
        this.pathAccountSid = pathAccountSid;
        this.pathCredentialListSid = pathCredentialListSid;
        this.username = username;
        this.password = password;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Credential
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Credential create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/SIP/CredentialLists/" + this.pathCredentialListSid + "/Credentials.json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Credential creation failed: Unable to connect to server");
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
        
        return Credential.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (username != null) {
            request.addPostParam("Username", username);
        }
        
        if (password != null) {
            request.addPostParam("Password", password);
        }
    }
}