/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.message;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class FeedbackCreator extends Creator<Feedback> {
    private String pathAccountSid;
    private final String pathMessageSid;
    private Feedback.Outcome outcome;

    /**
     * Construct a new FeedbackCreator.
     * 
     * @param pathMessageSid The message_sid
     */
    public FeedbackCreator(final String pathMessageSid) {
        this.pathMessageSid = pathMessageSid;
    }

    /**
     * Construct a new FeedbackCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param pathMessageSid The message_sid
     */
    public FeedbackCreator(final String pathAccountSid, 
                           final String pathMessageSid) {
        this.pathAccountSid = pathAccountSid;
        this.pathMessageSid = pathMessageSid;
    }

    /**
     * The outcome.
     * 
     * @param outcome The outcome
     * @return this
     */
    public FeedbackCreator setOutcome(final Feedback.Outcome outcome) {
        this.outcome = outcome;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Feedback
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Feedback create(final TwilioRestClient client) {
        this.pathAccountSid = this.pathAccountSid == null ? client.getAccountSid() : this.pathAccountSid;
        Request request = new Request(
            HttpMethod.POST,
            Domains.API.toString(),
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Messages/" + this.pathMessageSid + "/Feedback.json",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Feedback creation failed: Unable to connect to server");
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
        
        return Feedback.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (outcome != null) {
            request.addPostParam("Outcome", outcome.toString());
        }
    }
}