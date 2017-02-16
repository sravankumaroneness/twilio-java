/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010;

import com.twilio.base.Updater;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class AccountUpdater extends Updater<Account> {
    private String pathSid;
    private String friendlyName;
    private Account.Status status;

    /**
     * Construct a new AccountUpdater.
     */
    public AccountUpdater() {
    }

    /**
     * Construct a new AccountUpdater.
     * 
     * @param pathSid The sid
     */
    public AccountUpdater(final String pathSid) {
        this.pathSid = pathSid;
    }

    /**
     * Update the human-readable description of this Account.
     * 
     * @param friendlyName FriendlyName to update
     * @return this
     */
    public AccountUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * Alter the status of this account with a given Status.
     * 
     * @param status Status to update the Account with
     * @return this
     */
    public AccountUpdater setStatus(final Account.Status status) {
        this.status = status;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Account
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Account update(final TwilioRestClient client) {
        this.pathSid = this.pathSid == null ? client.getAccountSid() : this.pathSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathSid + ".json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Account update failed: Unable to connect to server");
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
        
        return Account.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (friendlyName != null) {
            request.addPostParam("FriendlyName", friendlyName);
        }
        
        if (status != null) {
            request.addPostParam("Status", status.toString());
        }
    }
}