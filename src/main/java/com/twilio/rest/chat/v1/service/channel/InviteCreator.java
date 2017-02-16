/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.chat.v1.service.channel;

import com.twilio.base.Creator;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

public class InviteCreator extends Creator<Invite> {
    private final String pathServiceSid;
    private final String pathChannelSid;
    private final String identity;
    private String roleSid;

    /**
     * Construct a new InviteCreator.
     * 
     * @param pathServiceSid The service_sid
     * @param pathChannelSid The channel_sid
     * @param identity The identity
     */
    public InviteCreator(final String pathServiceSid, 
                         final String pathChannelSid, 
                         final String identity) {
        this.pathServiceSid = pathServiceSid;
        this.pathChannelSid = pathChannelSid;
        this.identity = identity;
    }

    /**
     * The role_sid.
     * 
     * @param roleSid The role_sid
     * @return this
     */
    public InviteCreator setRoleSid(final String roleSid) {
        this.roleSid = roleSid;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Invite
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Invite create(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.CHAT.toString(),
            "/v1/Services/" + this.pathServiceSid + "/Channels/" + this.pathChannelSid + "/Invites",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Invite creation failed: Unable to connect to server");
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
        
        return Invite.fromJson(response.getStream(), client.getObjectMapper());
    }

    /**
     * Add the requested post parameters to the Request.
     * 
     * @param request Request to add post params to
     */
    private void addPostParams(final Request request) {
        if (identity != null) {
            request.addPostParam("Identity", identity);
        }
        
        if (roleSid != null) {
            request.addPostParam("RoleSid", roleSid);
        }
    }
}