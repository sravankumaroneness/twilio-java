/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.chat.v1.service;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.common.base.MoreObjects;
import com.twilio.base.Resource;
import com.twilio.converter.DateConverter;
import com.twilio.exception.ApiConnectionException;
import com.twilio.exception.ApiException;
import com.twilio.exception.RestException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class User extends Resource {
    private static final long serialVersionUID = 15696146917822L;

    /**
     * Create a UserFetcher to execute fetch.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     * @return UserFetcher capable of executing the fetch
     */
    public static UserFetcher fetcher(final String pathServiceSid, 
                                      final String pathSid) {
        return new UserFetcher(pathServiceSid, pathSid);
    }

    /**
     * Create a UserDeleter to execute delete.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     * @return UserDeleter capable of executing the delete
     */
    public static UserDeleter deleter(final String pathServiceSid, 
                                      final String pathSid) {
        return new UserDeleter(pathServiceSid, pathSid);
    }

    /**
     * Create a UserCreator to execute create.
     * 
     * @param pathServiceSid The service_sid
     * @param identity The identity
     * @return UserCreator capable of executing the create
     */
    public static UserCreator creator(final String pathServiceSid, 
                                      final String identity) {
        return new UserCreator(pathServiceSid, identity);
    }

    /**
     * Create a UserReader to execute read.
     * 
     * @param pathServiceSid The service_sid
     * @return UserReader capable of executing the read
     */
    public static UserReader reader(final String pathServiceSid) {
        return new UserReader(pathServiceSid);
    }

    /**
     * Create a UserUpdater to execute update.
     * 
     * @param pathServiceSid The service_sid
     * @param pathSid The sid
     * @return UserUpdater capable of executing the update
     */
    public static UserUpdater updater(final String pathServiceSid, 
                                      final String pathSid) {
        return new UserUpdater(pathServiceSid, pathSid);
    }

    /**
     * Converts a JSON String into a User object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a User object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return User object represented by the provided JSON
     */
    public static User fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, User.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final String accountSid;
    private final String serviceSid;
    private final String attributes;
    private final String friendlyName;
    private final String roleSid;
    private final String identity;
    private final Boolean isOnline;
    private final Boolean isNotifiable;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final Map<String, String> links;
    private final URI url;

    @JsonCreator
    private User(@JsonProperty("sid")
                 final String sid, 
                 @JsonProperty("account_sid")
                 final String accountSid, 
                 @JsonProperty("service_sid")
                 final String serviceSid, 
                 @JsonProperty("attributes")
                 final String attributes, 
                 @JsonProperty("friendly_name")
                 final String friendlyName, 
                 @JsonProperty("role_sid")
                 final String roleSid, 
                 @JsonProperty("identity")
                 final String identity, 
                 @JsonProperty("is_online")
                 final Boolean isOnline, 
                 @JsonProperty("is_notifiable")
                 final Boolean isNotifiable, 
                 @JsonProperty("date_created")
                 final String dateCreated, 
                 @JsonProperty("date_updated")
                 final String dateUpdated, 
                 @JsonProperty("links")
                 final Map<String, String> links, 
                 @JsonProperty("url")
                 final URI url) {
        this.sid = sid;
        this.accountSid = accountSid;
        this.serviceSid = serviceSid;
        this.attributes = attributes;
        this.friendlyName = friendlyName;
        this.roleSid = roleSid;
        this.identity = identity;
        this.isOnline = isOnline;
        this.isNotifiable = isNotifiable;
        this.dateCreated = DateConverter.iso8601DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.iso8601DateTimeFromString(dateUpdated);
        this.links = links;
        this.url = url;
    }

    /**
     * Returns The The sid.
     * 
     * @return The sid
     */
    public final String getSid() {
        return this.sid;
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
     * Returns The The service_sid.
     * 
     * @return The service_sid
     */
    public final String getServiceSid() {
        return this.serviceSid;
    }

    /**
     * Returns The The attributes.
     * 
     * @return The attributes
     */
    public final String getAttributes() {
        return this.attributes;
    }

    /**
     * Returns The The friendly_name.
     * 
     * @return The friendly_name
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The The role_sid.
     * 
     * @return The role_sid
     */
    public final String getRoleSid() {
        return this.roleSid;
    }

    /**
     * Returns The The identity.
     * 
     * @return The identity
     */
    public final String getIdentity() {
        return this.identity;
    }

    /**
     * Returns The The is_online.
     * 
     * @return The is_online
     */
    public final Boolean getIsOnline() {
        return this.isOnline;
    }

    /**
     * Returns The The is_notifiable.
     * 
     * @return The is_notifiable
     */
    public final Boolean getIsNotifiable() {
        return this.isNotifiable;
    }

    /**
     * Returns The The date_created.
     * 
     * @return The date_created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date_updated.
     * 
     * @return The date_updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
    }

    /**
     * Returns The The links.
     * 
     * @return The links
     */
    public final Map<String, String> getLinks() {
        return this.links;
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
        
        User other = (User) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(serviceSid, other.serviceSid) && 
               Objects.equals(attributes, other.attributes) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(roleSid, other.roleSid) && 
               Objects.equals(identity, other.identity) && 
               Objects.equals(isOnline, other.isOnline) && 
               Objects.equals(isNotifiable, other.isNotifiable) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(links, other.links) && 
               Objects.equals(url, other.url);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            accountSid,
                            serviceSid,
                            attributes,
                            friendlyName,
                            roleSid,
                            identity,
                            isOnline,
                            isNotifiable,
                            dateCreated,
                            dateUpdated,
                            links,
                            url);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("accountSid", accountSid)
                          .add("serviceSid", serviceSid)
                          .add("attributes", attributes)
                          .add("friendlyName", friendlyName)
                          .add("roleSid", roleSid)
                          .add("identity", identity)
                          .add("isOnline", isOnline)
                          .add("isNotifiable", isNotifiable)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("links", links)
                          .add("url", url)
                          .toString();
    }
}