/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.creator.trunking.v1;

import com.twilio.rest.converter.Promoter;
import com.twilio.rest.creator.Creator;
import com.twilio.rest.exception.ApiConnectionException;
import com.twilio.rest.exception.ApiException;
import com.twilio.rest.http.HttpMethod;
import com.twilio.rest.http.Request;
import com.twilio.rest.http.Response;
import com.twilio.rest.http.TwilioRestClient;
import com.twilio.rest.resource.RestException;
import com.twilio.rest.resource.trunking.v1.Trunk;

import java.net.URI;

public class TrunkCreator extends Creator<Trunk> {
    private String friendlyName;
    private String domainName;
    private URI disasterRecoveryUrl;
    private HttpMethod disasterRecoveryMethod;
    private String recording;
    private Boolean secure;

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public TrunkCreator setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The domain_name.
     * 
     * @param domainName The domain_name
     * @return this
     */
    public TrunkCreator setDomainName(final String domainName) {
        this.domainName = domainName;
        return this;
    }

    /**
     * The disaster_recovery_url.
     * 
     * @param disasterRecoveryUrl The disaster_recovery_url
     * @return this
     */
    public TrunkCreator setDisasterRecoveryUrl(final URI disasterRecoveryUrl) {
        this.disasterRecoveryUrl = disasterRecoveryUrl;
        return this;
    }

    /**
     * The disaster_recovery_url.
     * 
     * @param disasterRecoveryUrl The disaster_recovery_url
     * @return this
     */
    public TrunkCreator setDisasterRecoveryUrl(final String disasterRecoveryUrl) {
        return setDisasterRecoveryUrl(Promoter.uriFromString(disasterRecoveryUrl));
    }

    /**
     * The disaster_recovery_method.
     * 
     * @param disasterRecoveryMethod The disaster_recovery_method
     * @return this
     */
    public TrunkCreator setDisasterRecoveryMethod(final HttpMethod disasterRecoveryMethod) {
        this.disasterRecoveryMethod = disasterRecoveryMethod;
        return this;
    }

    /**
     * The recording.
     * 
     * @param recording The recording
     * @return this
     */
    public TrunkCreator setRecording(final String recording) {
        this.recording = recording;
        return this;
    }

    /**
     * The secure.
     * 
     * @param secure The secure
     * @return this
     */
    public TrunkCreator setSecure(final Boolean secure) {
        this.secure = secure;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the create.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Created Trunk
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Trunk execute(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            TwilioRestClient.Domains.TRUNKING,
            "/v1/Trunks",
            client.getAccountSid()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Trunk creation failed: Unable to connect to server");
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
        
        return Trunk.fromJson(response.getStream(), client.getObjectMapper());
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
        
        if (domainName != null) {
            request.addPostParam("DomainName", domainName);
        }
        
        if (disasterRecoveryUrl != null) {
            request.addPostParam("DisasterRecoveryUrl", disasterRecoveryUrl.toString());
        }
        
        if (disasterRecoveryMethod != null) {
            request.addPostParam("DisasterRecoveryMethod", disasterRecoveryMethod.toString());
        }
        
        if (recording != null) {
            request.addPostParam("Recording", recording);
        }
        
        if (secure != null) {
            request.addPostParam("Secure", secure.toString());
        }
    }
}