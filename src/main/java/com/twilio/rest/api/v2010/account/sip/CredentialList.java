/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.sip;

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
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CredentialList extends Resource {
    private static final long serialVersionUID = 214188792953524L;

    /**
     * Create a CredentialListReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @return CredentialListReader capable of executing the read
     */
    public static CredentialListReader reader(final String pathAccountSid) {
        return new CredentialListReader(pathAccountSid);
    }

    /**
     * Create a CredentialListReader to execute read.
     * 
     * @return CredentialListReader capable of executing the read
     */
    public static CredentialListReader reader() {
        return new CredentialListReader();
    }

    /**
     * Create a CredentialListCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @param friendlyName The friendly_name
     * @return CredentialListCreator capable of executing the create
     */
    public static CredentialListCreator creator(final String pathAccountSid, 
                                                final String friendlyName) {
        return new CredentialListCreator(pathAccountSid, friendlyName);
    }

    /**
     * Create a CredentialListCreator to execute create.
     * 
     * @param friendlyName The friendly_name
     * @return CredentialListCreator capable of executing the create
     */
    public static CredentialListCreator creator(final String friendlyName) {
        return new CredentialListCreator(friendlyName);
    }

    /**
     * Create a CredentialListFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Fetch by unique credential Sid
     * @return CredentialListFetcher capable of executing the fetch
     */
    public static CredentialListFetcher fetcher(final String pathAccountSid, 
                                                final String pathSid) {
        return new CredentialListFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a CredentialListFetcher to execute fetch.
     * 
     * @param pathSid Fetch by unique credential Sid
     * @return CredentialListFetcher capable of executing the fetch
     */
    public static CredentialListFetcher fetcher(final String pathSid) {
        return new CredentialListFetcher(pathSid);
    }

    /**
     * Create a CredentialListUpdater to execute update.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid The sid
     * @param friendlyName The friendly_name
     * @return CredentialListUpdater capable of executing the update
     */
    public static CredentialListUpdater updater(final String pathAccountSid, 
                                                final String pathSid, 
                                                final String friendlyName) {
        return new CredentialListUpdater(pathAccountSid, pathSid, friendlyName);
    }

    /**
     * Create a CredentialListUpdater to execute update.
     * 
     * @param pathSid The sid
     * @param friendlyName The friendly_name
     * @return CredentialListUpdater capable of executing the update
     */
    public static CredentialListUpdater updater(final String pathSid, 
                                                final String friendlyName) {
        return new CredentialListUpdater(pathSid, friendlyName);
    }

    /**
     * Create a CredentialListDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Delete by unique credential Sid
     * @return CredentialListDeleter capable of executing the delete
     */
    public static CredentialListDeleter deleter(final String pathAccountSid, 
                                                final String pathSid) {
        return new CredentialListDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a CredentialListDeleter to execute delete.
     * 
     * @param pathSid Delete by unique credential Sid
     * @return CredentialListDeleter capable of executing the delete
     */
    public static CredentialListDeleter deleter(final String pathSid) {
        return new CredentialListDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a CredentialList object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return CredentialList object represented by the provided JSON
     */
    public static CredentialList fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CredentialList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a CredentialList object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return CredentialList object represented by the provided JSON
     */
    public static CredentialList fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, CredentialList.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String sid;
    private final Map<String, String> subresourceUris;
    private final String uri;

    @JsonCreator
    private CredentialList(@JsonProperty("account_sid")
                           final String accountSid, 
                           @JsonProperty("date_created")
                           final String dateCreated, 
                           @JsonProperty("date_updated")
                           final String dateUpdated, 
                           @JsonProperty("friendly_name")
                           final String friendlyName, 
                           @JsonProperty("sid")
                           final String sid, 
                           @JsonProperty("subresource_uris")
                           final Map<String, String> subresourceUris, 
                           @JsonProperty("uri")
                           final String uri) {
        this.accountSid = accountSid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.subresourceUris = subresourceUris;
        this.uri = uri;
    }

    /**
     * Returns The The unique sid that identifies this account.
     * 
     * @return The unique sid that identifies this account
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The date this resource was created.
     * 
     * @return The date this resource was created
     */
    public final DateTime getDateCreated() {
        return this.dateCreated;
    }

    /**
     * Returns The The date this resource was last updated.
     * 
     * @return The date this resource was last updated
     */
    public final DateTime getDateUpdated() {
        return this.dateUpdated;
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
     * Returns The A string that uniquely identifies this credential.
     * 
     * @return A string that uniquely identifies this credential
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The subresource_uris.
     * 
     * @return The subresource_uris
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        CredentialList other = (CredentialList) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(subresourceUris, other.subresourceUris) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            sid,
                            subresourceUris,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("sid", sid)
                          .add("subresourceUris", subresourceUris)
                          .add("uri", uri)
                          .toString();
    }
}