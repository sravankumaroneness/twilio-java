/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account;

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
public class OutgoingCallerId extends Resource {
    private static final long serialVersionUID = 160246512577628L;

    /**
     * Create a OutgoingCallerIdFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Fetch by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdFetcher capable of executing the fetch
     */
    public static OutgoingCallerIdFetcher fetcher(final String pathAccountSid, 
                                                  final String pathSid) {
        return new OutgoingCallerIdFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a OutgoingCallerIdFetcher to execute fetch.
     * 
     * @param pathSid Fetch by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdFetcher capable of executing the fetch
     */
    public static OutgoingCallerIdFetcher fetcher(final String pathSid) {
        return new OutgoingCallerIdFetcher(pathSid);
    }

    /**
     * Create a OutgoingCallerIdUpdater to execute update.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Update by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdUpdater capable of executing the update
     */
    public static OutgoingCallerIdUpdater updater(final String pathAccountSid, 
                                                  final String pathSid) {
        return new OutgoingCallerIdUpdater(pathAccountSid, pathSid);
    }

    /**
     * Create a OutgoingCallerIdUpdater to execute update.
     * 
     * @param pathSid Update by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdUpdater capable of executing the update
     */
    public static OutgoingCallerIdUpdater updater(final String pathSid) {
        return new OutgoingCallerIdUpdater(pathSid);
    }

    /**
     * Create a OutgoingCallerIdDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Delete by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdDeleter capable of executing the delete
     */
    public static OutgoingCallerIdDeleter deleter(final String pathAccountSid, 
                                                  final String pathSid) {
        return new OutgoingCallerIdDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a OutgoingCallerIdDeleter to execute delete.
     * 
     * @param pathSid Delete by unique outgoing-caller-id Sid
     * @return OutgoingCallerIdDeleter capable of executing the delete
     */
    public static OutgoingCallerIdDeleter deleter(final String pathSid) {
        return new OutgoingCallerIdDeleter(pathSid);
    }

    /**
     * Create a OutgoingCallerIdReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @return OutgoingCallerIdReader capable of executing the read
     */
    public static OutgoingCallerIdReader reader(final String pathAccountSid) {
        return new OutgoingCallerIdReader(pathAccountSid);
    }

    /**
     * Create a OutgoingCallerIdReader to execute read.
     * 
     * @return OutgoingCallerIdReader capable of executing the read
     */
    public static OutgoingCallerIdReader reader() {
        return new OutgoingCallerIdReader();
    }

    /**
     * Converts a JSON String into a OutgoingCallerId object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return OutgoingCallerId object represented by the provided JSON
     */
    public static OutgoingCallerId fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OutgoingCallerId.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a OutgoingCallerId object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return OutgoingCallerId object represented by the provided JSON
     */
    public static OutgoingCallerId fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, OutgoingCallerId.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String sid;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final String accountSid;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String uri;

    @JsonCreator
    private OutgoingCallerId(@JsonProperty("sid")
                             final String sid, 
                             @JsonProperty("date_created")
                             final String dateCreated, 
                             @JsonProperty("date_updated")
                             final String dateUpdated, 
                             @JsonProperty("friendly_name")
                             final String friendlyName, 
                             @JsonProperty("account_sid")
                             final String accountSid, 
                             @JsonProperty("phone_number")
                             final com.twilio.type.PhoneNumber phoneNumber, 
                             @JsonProperty("uri")
                             final String uri) {
        this.sid = sid;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.accountSid = accountSid;
        this.phoneNumber = phoneNumber;
        this.uri = uri;
    }

    /**
     * Returns The A string that uniquely identifies this outgoing-caller-ids.
     * 
     * @return A string that uniquely identifies this outgoing-caller-ids
     */
    public final String getSid() {
        return this.sid;
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
     * Returns The A human readable description for this resource.
     * 
     * @return A human readable description for this resource
     */
    public final String getFriendlyName() {
        return this.friendlyName;
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
     * Returns The The incoming phone number.
     * 
     * @return The incoming phone number
     */
    public final com.twilio.type.PhoneNumber getPhoneNumber() {
        return this.phoneNumber;
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
        
        OutgoingCallerId other = (OutgoingCallerId) o;
        
        return Objects.equals(sid, other.sid) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sid,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            accountSid,
                            phoneNumber,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("sid", sid)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("accountSid", accountSid)
                          .add("phoneNumber", phoneNumber)
                          .add("uri", uri)
                          .toString();
    }
}