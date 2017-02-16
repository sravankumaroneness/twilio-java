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
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Domain extends Resource {
    private static final long serialVersionUID = 72982381631904L;

    /**
     * Create a DomainReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @return DomainReader capable of executing the read
     */
    public static DomainReader reader(final String pathAccountSid) {
        return new DomainReader(pathAccountSid);
    }

    /**
     * Create a DomainReader to execute read.
     * 
     * @return DomainReader capable of executing the read
     */
    public static DomainReader reader() {
        return new DomainReader();
    }

    /**
     * Create a DomainCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @param domainName The unique address on Twilio to route SIP traffic
     * @return DomainCreator capable of executing the create
     */
    public static DomainCreator creator(final String pathAccountSid, 
                                        final String domainName) {
        return new DomainCreator(pathAccountSid, domainName);
    }

    /**
     * Create a DomainCreator to execute create.
     * 
     * @param domainName The unique address on Twilio to route SIP traffic
     * @return DomainCreator capable of executing the create
     */
    public static DomainCreator creator(final String domainName) {
        return new DomainCreator(domainName);
    }

    /**
     * Create a DomainFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Fetch by unique Domain Sid
     * @return DomainFetcher capable of executing the fetch
     */
    public static DomainFetcher fetcher(final String pathAccountSid, 
                                        final String pathSid) {
        return new DomainFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a DomainFetcher to execute fetch.
     * 
     * @param pathSid Fetch by unique Domain Sid
     * @return DomainFetcher capable of executing the fetch
     */
    public static DomainFetcher fetcher(final String pathSid) {
        return new DomainFetcher(pathSid);
    }

    /**
     * Create a DomainUpdater to execute update.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid The sid
     * @return DomainUpdater capable of executing the update
     */
    public static DomainUpdater updater(final String pathAccountSid, 
                                        final String pathSid) {
        return new DomainUpdater(pathAccountSid, pathSid);
    }

    /**
     * Create a DomainUpdater to execute update.
     * 
     * @param pathSid The sid
     * @return DomainUpdater capable of executing the update
     */
    public static DomainUpdater updater(final String pathSid) {
        return new DomainUpdater(pathSid);
    }

    /**
     * Create a DomainDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid The sid
     * @return DomainDeleter capable of executing the delete
     */
    public static DomainDeleter deleter(final String pathAccountSid, 
                                        final String pathSid) {
        return new DomainDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a DomainDeleter to execute delete.
     * 
     * @param pathSid The sid
     * @return DomainDeleter capable of executing the delete
     */
    public static DomainDeleter deleter(final String pathSid) {
        return new DomainDeleter(pathSid);
    }

    /**
     * Converts a JSON String into a Domain object using the provided ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Domain object represented by the provided JSON
     */
    public static Domain fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Domain.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Domain object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Domain object represented by the provided JSON
     */
    public static Domain fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Domain.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final String authType;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String domainName;
    private final String friendlyName;
    private final String sid;
    private final String uri;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final HttpMethod voiceStatusCallbackMethod;
    private final URI voiceStatusCallbackUrl;
    private final URI voiceUrl;
    private final Map<String, String> subresourceUris;

    @JsonCreator
    private Domain(@JsonProperty("account_sid")
                   final String accountSid, 
                   @JsonProperty("api_version")
                   final String apiVersion, 
                   @JsonProperty("auth_type")
                   final String authType, 
                   @JsonProperty("date_created")
                   final String dateCreated, 
                   @JsonProperty("date_updated")
                   final String dateUpdated, 
                   @JsonProperty("domain_name")
                   final String domainName, 
                   @JsonProperty("friendly_name")
                   final String friendlyName, 
                   @JsonProperty("sid")
                   final String sid, 
                   @JsonProperty("uri")
                   final String uri, 
                   @JsonProperty("voice_fallback_method")
                   final HttpMethod voiceFallbackMethod, 
                   @JsonProperty("voice_fallback_url")
                   final URI voiceFallbackUrl, 
                   @JsonProperty("voice_method")
                   final HttpMethod voiceMethod, 
                   @JsonProperty("voice_status_callback_method")
                   final HttpMethod voiceStatusCallbackMethod, 
                   @JsonProperty("voice_status_callback_url")
                   final URI voiceStatusCallbackUrl, 
                   @JsonProperty("voice_url")
                   final URI voiceUrl, 
                   @JsonProperty("subresource_uris")
                   final Map<String, String> subresourceUris) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.authType = authType;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.domainName = domainName;
        this.friendlyName = friendlyName;
        this.sid = sid;
        this.uri = uri;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceStatusCallbackMethod = voiceStatusCallbackMethod;
        this.voiceStatusCallbackUrl = voiceStatusCallbackUrl;
        this.voiceUrl = voiceUrl;
        this.subresourceUris = subresourceUris;
    }

    /**
     * Returns The The unique id of the account that sent the message.
     * 
     * @return The unique id of the account that sent the message
     */
    public final String getAccountSid() {
        return this.accountSid;
    }

    /**
     * Returns The The Twilio API version used to process the message.
     * 
     * @return The Twilio API version used to process the message
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The The types of authentication mapped to the domain.
     * 
     * @return The types of authentication mapped to the domain
     */
    public final String getAuthType() {
        return this.authType;
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
     * Returns The The unique address on Twilio to route SIP traffic.
     * 
     * @return The unique address on Twilio to route SIP traffic
     */
    public final String getDomainName() {
        return this.domainName;
    }

    /**
     * Returns The A user-specified, human-readable name for the trigger..
     * 
     * @return A user-specified, human-readable name for the trigger.
     */
    public final String getFriendlyName() {
        return this.friendlyName;
    }

    /**
     * Returns The A string that uniquely identifies the SIP Domain.
     * 
     * @return A string that uniquely identifies the SIP Domain
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The The URI for this resource.
     * 
     * @return The URI for this resource
     */
    public final String getUri() {
        return this.uri;
    }

    /**
     * Returns The HTTP method used with voice_fallback_url.
     * 
     * @return HTTP method used with voice_fallback_url
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * Returns The URL Twilio will request if an error occurs in executing TwiML.
     * 
     * @return URL Twilio will request if an error occurs in executing TwiML
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * Returns The HTTP method to use with voice_url.
     * 
     * @return HTTP method to use with voice_url
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
    }

    /**
     * Returns The The voice_status_callback_method.
     * 
     * @return The voice_status_callback_method
     */
    public final HttpMethod getVoiceStatusCallbackMethod() {
        return this.voiceStatusCallbackMethod;
    }

    /**
     * Returns The URL that Twilio will request with status updates.
     * 
     * @return URL that Twilio will request with status updates
     */
    public final URI getVoiceStatusCallbackUrl() {
        return this.voiceStatusCallbackUrl;
    }

    /**
     * Returns The URL Twilio will request when receiving a call.
     * 
     * @return URL Twilio will request when receiving a call
     */
    public final URI getVoiceUrl() {
        return this.voiceUrl;
    }

    /**
     * Returns The The subresource_uris.
     * 
     * @return The subresource_uris
     */
    public final Map<String, String> getSubresourceUris() {
        return this.subresourceUris;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        Domain other = (Domain) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(authType, other.authType) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(domainName, other.domainName) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) && 
               Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) && 
               Objects.equals(voiceMethod, other.voiceMethod) && 
               Objects.equals(voiceStatusCallbackMethod, other.voiceStatusCallbackMethod) && 
               Objects.equals(voiceStatusCallbackUrl, other.voiceStatusCallbackUrl) && 
               Objects.equals(voiceUrl, other.voiceUrl) && 
               Objects.equals(subresourceUris, other.subresourceUris);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            authType,
                            dateCreated,
                            dateUpdated,
                            domainName,
                            friendlyName,
                            sid,
                            uri,
                            voiceFallbackMethod,
                            voiceFallbackUrl,
                            voiceMethod,
                            voiceStatusCallbackMethod,
                            voiceStatusCallbackUrl,
                            voiceUrl,
                            subresourceUris);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("authType", authType)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("domainName", domainName)
                          .add("friendlyName", friendlyName)
                          .add("sid", sid)
                          .add("uri", uri)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceStatusCallbackMethod", voiceStatusCallbackMethod)
                          .add("voiceStatusCallbackUrl", voiceStatusCallbackUrl)
                          .add("voiceUrl", voiceUrl)
                          .add("subresourceUris", subresourceUris)
                          .toString();
    }
}