/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.taskrouter.v1.workspace.taskqueue;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.Converter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class TaskQueueStatistics extends Resource {
    private static final long serialVersionUID = 25740453860502L;

    /**
     * Create a TaskQueueStatisticsFetcher to execute fetch.
     * 
     * @param pathWorkspaceSid The workspace_sid
     * @param pathTaskQueueSid The task_queue_sid
     * @return TaskQueueStatisticsFetcher capable of executing the fetch
     */
    public static TaskQueueStatisticsFetcher fetcher(final String pathWorkspaceSid, 
                                                     final String pathTaskQueueSid) {
        return new TaskQueueStatisticsFetcher(pathWorkspaceSid, pathTaskQueueSid);
    }

    /**
     * Converts a JSON String into a TaskQueueStatistics object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueStatistics object represented by the provided JSON
     */
    public static TaskQueueStatistics fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a TaskQueueStatistics object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return TaskQueueStatistics object represented by the provided JSON
     */
    public static TaskQueueStatistics fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, TaskQueueStatistics.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final Map<String, Object> cumulative;
    private final Map<String, Object> realtime;
    private final String taskQueueSid;
    private final String workspaceSid;
    private final URI url;

    @JsonCreator
    private TaskQueueStatistics(@JsonProperty("account_sid")
                                final String accountSid, 
                                @JsonProperty("cumulative")
                                final Map<String, Object> cumulative, 
                                @JsonProperty("realtime")
                                final Map<String, Object> realtime, 
                                @JsonProperty("task_queue_sid")
                                final String taskQueueSid, 
                                @JsonProperty("workspace_sid")
                                final String workspaceSid, 
                                @JsonProperty("url")
                                final URI url) {
        this.accountSid = accountSid;
        this.cumulative = cumulative;
        this.realtime = realtime;
        this.taskQueueSid = taskQueueSid;
        this.workspaceSid = workspaceSid;
        this.url = url;
    }

    /**
     * Returns The The account_sid.
     * 
     * @return The account_sid
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The cumulative.
     * 
     * @return The cumulative
     */
    public final Map<String, Object> getCumulative() {
        return this.cumulative;
    }

    /**
     * Returns The The realtime.
     * 
     * @return The realtime
     */
    public final Map<String, Object> getRealtime() {
        return this.realtime;
    }

    /**
     * Returns The The task_queue_sid.
     * 
     * @return The task_queue_sid
     */
    public final String getTaskQueueSid() {
        return this.taskQueueSid;
    }

    /**
     * Returns The The workspace_sid.
     * 
     * @return The workspace_sid
     */
    public final String getWorkspaceSid() {
        return this.workspaceSid;
    }

    /**
     * Returns The The url.
     * 
     * @return The url
     */
    public final URI getUrl() {
        return this.url;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        TaskQueueStatistics other = (TaskQueueStatistics) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(cumulative, other.cumulative) && 
               Objects.equals(realtime, other.realtime) && 
               Objects.equals(taskQueueSid, other.taskQueueSid) && 
               Objects.equals(workspaceSid, other.workspaceSid) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            cumulative,
                            realtime,
                            taskQueueSid,
                            workspaceSid,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("cumulative", cumulative)
                          .add("realtime", realtime)
                          .add("taskQueueSid", taskQueueSid)
                          .add("workspaceSid", workspaceSid)
                          .add("url", url)
                          .toString();
    }
}