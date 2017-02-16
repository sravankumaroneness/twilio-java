/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.call;

import com.twilio.base.Creator;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.util.List;

public class FeedbackCreator extends Creator<Feedback> {
    private String pathAccountSid;
    private final String pathCallSid;
    private final Integer qualityScore;
    private List<Feedback.Issues> issue;

    /**
     * Construct a new FeedbackCreator.
     * 
     * @param pathCallSid The call_sid
     * @param qualityScore The quality_score
     */
    public FeedbackCreator(final String pathCallSid, 
                           final Integer qualityScore) {
        this.pathCallSid = pathCallSid;
        this.qualityScore = qualityScore;
    }

    /**
     * Construct a new FeedbackCreator.
     * 
     * @param pathAccountSid The account_sid
     * @param pathCallSid The call_sid
     * @param qualityScore The quality_score
     */
    public FeedbackCreator(final String pathAccountSid, 
                           final String pathCallSid, 
                           final Integer qualityScore) {
        this.pathAccountSid = pathAccountSid;
        this.pathCallSid = pathCallSid;
        this.qualityScore = qualityScore;
    }

    /**
     * The issue.
     * 
     * @param issue The issue
     * @return this
     */
    public FeedbackCreator setIssue(final List<Feedback.Issues> issue) {
        this.issue = issue;
        return this;
    }

    /**
     * The issue.
     * 
     * @param issue The issue
     * @return this
     */
    public FeedbackCreator setIssue(final Feedback.Issues issue) {
        return setIssue(Promoter.listOfOne(issue));
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
            "/2010-04-01/Accounts/" + this.pathAccountSid + "/Calls/" + this.pathCallSid + "/Feedback.json",
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
        if (qualityScore != null) {
            request.addPostParam("QualityScore", qualityScore.toString());
        }
        
        if (issue != null) {
            for (Feedback.Issues prop : issue) {
                request.addPostParam("Issue", prop.toString());
            }
        }
    }
}