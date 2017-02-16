/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace;

import com.twilio.base.Updater;
import com.twilio.converter.Promoter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.net.URI;

public class WorkflowUpdater extends Updater<Workflow> {
    private final String pathWorkspaceSid;
    private final String pathSid;
    private String friendlyName;
    private URI assignmentCallbackUrl;
    private URI fallbackAssignmentCallbackUrl;
    private String configuration;
    private Integer taskReservationTimeout;

    /**
     * Construct a new WorkflowUpdater.
     * 
     * @param pathWorkspaceSid The workspace_sid
     * @param pathSid The sid
     */
    public WorkflowUpdater(final String pathWorkspaceSid, 
                           final String pathSid) {
        this.pathWorkspaceSid = pathWorkspaceSid;
        this.pathSid = pathSid;
    }

    /**
     * The friendly_name.
     * 
     * @param friendlyName The friendly_name
     * @return this
     */
    public WorkflowUpdater setFriendlyName(final String friendlyName) {
        this.friendlyName = friendlyName;
        return this;
    }

    /**
     * The assignment_callback_url.
     * 
     * @param assignmentCallbackUrl The assignment_callback_url
     * @return this
     */
    public WorkflowUpdater setAssignmentCallbackUrl(final URI assignmentCallbackUrl) {
        this.assignmentCallbackUrl = assignmentCallbackUrl;
        return this;
    }

    /**
     * The assignment_callback_url.
     * 
     * @param assignmentCallbackUrl The assignment_callback_url
     * @return this
     */
    public WorkflowUpdater setAssignmentCallbackUrl(final String assignmentCallbackUrl) {
        return setAssignmentCallbackUrl(Promoter.uriFromString(assignmentCallbackUrl));
    }

    /**
     * The fallback_assignment_callback_url.
     * 
     * @param fallbackAssignmentCallbackUrl The fallback_assignment_callback_url
     * @return this
     */
    public WorkflowUpdater setFallbackAssignmentCallbackUrl(final URI fallbackAssignmentCallbackUrl) {
        this.fallbackAssignmentCallbackUrl = fallbackAssignmentCallbackUrl;
        return this;
    }

    /**
     * The fallback_assignment_callback_url.
     * 
     * @param fallbackAssignmentCallbackUrl The fallback_assignment_callback_url
     * @return this
     */
    public WorkflowUpdater setFallbackAssignmentCallbackUrl(final String fallbackAssignmentCallbackUrl) {
        return setFallbackAssignmentCallbackUrl(Promoter.uriFromString(fallbackAssignmentCallbackUrl));
    }

    /**
     * The configuration.
     * 
     * @param configuration The configuration
     * @return this
     */
    public WorkflowUpdater setConfiguration(final String configuration) {
        this.configuration = configuration;
        return this;
    }

    /**
     * The task_reservation_timeout.
     * 
     * @param taskReservationTimeout The task_reservation_timeout
     * @return this
     */
    public WorkflowUpdater setTaskReservationTimeout(final Integer taskReservationTimeout) {
        this.taskReservationTimeout = taskReservationTimeout;
        return this;
    }

    /**
     * Make the request to the Twilio API to perform the update.
     * 
     * @param client TwilioRestClient with which to make the request
     * @return Updated Workflow
     */
    @Override
    @SuppressWarnings("checkstyle:linelength")
    public Workflow update(final TwilioRestClient client) {
        Request request = new Request(
            HttpMethod.POST,
            Domains.TASKROUTER.toString(),
            "/v1/Workspaces/" + this.pathWorkspaceSid + "/Workflows/" + this.pathSid + "",
            client.getRegion()
        );
        
        addPostParams(request);
        Response response = client.request(request);
        
        if (response == null) {
            throw new ApiConnectionException("Workflow update failed: Unable to connect to server");
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
        
        return Workflow.fromJson(response.getStream(), client.getObjectMapper());
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
        
        if (assignmentCallbackUrl != null) {
            request.addPostParam("AssignmentCallbackUrl", assignmentCallbackUrl.toString());
        }
        
        if (fallbackAssignmentCallbackUrl != null) {
            request.addPostParam("FallbackAssignmentCallbackUrl", fallbackAssignmentCallbackUrl.toString());
        }
        
        if (configuration != null) {
            request.addPostParam("Configuration", configuration);
        }
        
        if (taskReservationTimeout != null) {
            request.addPostParam("TaskReservationTimeout", taskReservationTimeout.toString());
        }
    }
}