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
import com.twilio.type.PhoneNumberCapabilities;
import org.joda.time.DateTime;

import java.io.IOException;
import java.io.InputStream;
import java.net.URI;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IncomingPhoneNumber extends Resource {
    private static final long serialVersionUID = 172848453454291L;

    public enum AddressRequirement {
        NONE("none"),
        ANY("any"),
        LOCAL("local"),
        FOREIGN("foreign");
    
        private final String value;
        
        private AddressRequirement(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a AddressRequirement from a string.
         * @param value string value
         * @return generated AddressRequirement
         */
        @JsonCreator
        public static AddressRequirement forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return AddressRequirement.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    public enum EmergencyStatus {
        ACTIVE("Active"),
        INACTIVE("Inactive");
    
        private final String value;
        
        private EmergencyStatus(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a EmergencyStatus from a string.
         * @param value string value
         * @return generated EmergencyStatus
         */
        @JsonCreator
        public static EmergencyStatus forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return EmergencyStatus.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a IncomingPhoneNumberUpdater to execute update.
     * 
     * @param pathAccountSid The new owner of the phone number
     * @param pathSid The sid
     * @return IncomingPhoneNumberUpdater capable of executing the update
     */
    public static IncomingPhoneNumberUpdater updater(final String pathAccountSid, 
                                                     final String pathSid) {
        return new IncomingPhoneNumberUpdater(pathAccountSid, pathSid);
    }

    /**
     * Create a IncomingPhoneNumberUpdater to execute update.
     * 
     * @param pathSid The sid
     * @return IncomingPhoneNumberUpdater capable of executing the update
     */
    public static IncomingPhoneNumberUpdater updater(final String pathSid) {
        return new IncomingPhoneNumberUpdater(pathSid);
    }

    /**
     * Create a IncomingPhoneNumberFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Fetch by unique incoming-phone-number Sid
     * @return IncomingPhoneNumberFetcher capable of executing the fetch
     */
    public static IncomingPhoneNumberFetcher fetcher(final String pathAccountSid, 
                                                     final String pathSid) {
        return new IncomingPhoneNumberFetcher(pathAccountSid, pathSid);
    }

    /**
     * Create a IncomingPhoneNumberFetcher to execute fetch.
     * 
     * @param pathSid Fetch by unique incoming-phone-number Sid
     * @return IncomingPhoneNumberFetcher capable of executing the fetch
     */
    public static IncomingPhoneNumberFetcher fetcher(final String pathSid) {
        return new IncomingPhoneNumberFetcher(pathSid);
    }

    /**
     * Create a IncomingPhoneNumberDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathSid Delete by unique phone-number Sid
     * @return IncomingPhoneNumberDeleter capable of executing the delete
     */
    public static IncomingPhoneNumberDeleter deleter(final String pathAccountSid, 
                                                     final String pathSid) {
        return new IncomingPhoneNumberDeleter(pathAccountSid, pathSid);
    }

    /**
     * Create a IncomingPhoneNumberDeleter to execute delete.
     * 
     * @param pathSid Delete by unique phone-number Sid
     * @return IncomingPhoneNumberDeleter capable of executing the delete
     */
    public static IncomingPhoneNumberDeleter deleter(final String pathSid) {
        return new IncomingPhoneNumberDeleter(pathSid);
    }

    /**
     * Create a IncomingPhoneNumberReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @return IncomingPhoneNumberReader capable of executing the read
     */
    public static IncomingPhoneNumberReader reader(final String pathAccountSid) {
        return new IncomingPhoneNumberReader(pathAccountSid);
    }

    /**
     * Create a IncomingPhoneNumberReader to execute read.
     * 
     * @return IncomingPhoneNumberReader capable of executing the read
     */
    public static IncomingPhoneNumberReader reader() {
        return new IncomingPhoneNumberReader();
    }

    /**
     * Create a IncomingPhoneNumberCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @param phoneNumber The phone number
     * @return IncomingPhoneNumberCreator capable of executing the create
     */
    public static IncomingPhoneNumberCreator creator(final String pathAccountSid, 
                                                     final com.twilio.type.PhoneNumber phoneNumber) {
        return new IncomingPhoneNumberCreator(pathAccountSid, phoneNumber);
    }

    /**
     * Create a IncomingPhoneNumberCreator to execute create.
     * 
     * @param phoneNumber The phone number
     * @return IncomingPhoneNumberCreator capable of executing the create
     */
    public static IncomingPhoneNumberCreator creator(final com.twilio.type.PhoneNumber phoneNumber) {
        return new IncomingPhoneNumberCreator(phoneNumber);
    }

    /**
     * Create a IncomingPhoneNumberCreator to execute create.
     * 
     * @param pathAccountSid The account_sid
     * @param areaCode The desired area code for the new number
     * @return IncomingPhoneNumberCreator capable of executing the create
     */
    public static IncomingPhoneNumberCreator creator(final String pathAccountSid, 
                                                     final String areaCode) {
        return new IncomingPhoneNumberCreator(pathAccountSid, areaCode);
    }

    /**
     * Create a IncomingPhoneNumberCreator to execute create.
     * 
     * @param areaCode The desired area code for the new number
     * @return IncomingPhoneNumberCreator capable of executing the create
     */
    public static IncomingPhoneNumberCreator creator(final String areaCode) {
        return new IncomingPhoneNumberCreator(areaCode);
    }

    /**
     * Converts a JSON String into a IncomingPhoneNumber object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return IncomingPhoneNumber object represented by the provided JSON
     */
    public static IncomingPhoneNumber fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IncomingPhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a IncomingPhoneNumber object using the
     * provided ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return IncomingPhoneNumber object represented by the provided JSON
     */
    public static IncomingPhoneNumber fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, IncomingPhoneNumber.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final IncomingPhoneNumber.AddressRequirement addressRequirements;
    private final String apiVersion;
    private final Boolean beta;
    private final PhoneNumberCapabilities capabilities;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String friendlyName;
    private final com.twilio.type.PhoneNumber phoneNumber;
    private final String sid;
    private final String smsApplicationSid;
    private final HttpMethod smsFallbackMethod;
    private final URI smsFallbackUrl;
    private final HttpMethod smsMethod;
    private final URI smsUrl;
    private final URI statusCallback;
    private final HttpMethod statusCallbackMethod;
    private final String trunkSid;
    private final String uri;
    private final String voiceApplicationSid;
    private final Boolean voiceCallerIdLookup;
    private final HttpMethod voiceFallbackMethod;
    private final URI voiceFallbackUrl;
    private final HttpMethod voiceMethod;
    private final URI voiceUrl;
    private final IncomingPhoneNumber.EmergencyStatus emergencyStatus;
    private final String emergencyAddressSid;

    @JsonCreator
    private IncomingPhoneNumber(@JsonProperty("account_sid")
                                final String accountSid, 
                                @JsonProperty("address_requirements")
                                final IncomingPhoneNumber.AddressRequirement addressRequirements, 
                                @JsonProperty("api_version")
                                final String apiVersion, 
                                @JsonProperty("beta")
                                final Boolean beta, 
                                @JsonProperty("capabilities")
                                final PhoneNumberCapabilities capabilities, 
                                @JsonProperty("date_created")
                                final String dateCreated, 
                                @JsonProperty("date_updated")
                                final String dateUpdated, 
                                @JsonProperty("friendly_name")
                                final String friendlyName, 
                                @JsonProperty("phone_number")
                                final com.twilio.type.PhoneNumber phoneNumber, 
                                @JsonProperty("sid")
                                final String sid, 
                                @JsonProperty("sms_application_sid")
                                final String smsApplicationSid, 
                                @JsonProperty("sms_fallback_method")
                                final HttpMethod smsFallbackMethod, 
                                @JsonProperty("sms_fallback_url")
                                final URI smsFallbackUrl, 
                                @JsonProperty("sms_method")
                                final HttpMethod smsMethod, 
                                @JsonProperty("sms_url")
                                final URI smsUrl, 
                                @JsonProperty("status_callback")
                                final URI statusCallback, 
                                @JsonProperty("status_callback_method")
                                final HttpMethod statusCallbackMethod, 
                                @JsonProperty("trunk_sid")
                                final String trunkSid, 
                                @JsonProperty("uri")
                                final String uri, 
                                @JsonProperty("voice_application_sid")
                                final String voiceApplicationSid, 
                                @JsonProperty("voice_caller_id_lookup")
                                final Boolean voiceCallerIdLookup, 
                                @JsonProperty("voice_fallback_method")
                                final HttpMethod voiceFallbackMethod, 
                                @JsonProperty("voice_fallback_url")
                                final URI voiceFallbackUrl, 
                                @JsonProperty("voice_method")
                                final HttpMethod voiceMethod, 
                                @JsonProperty("voice_url")
                                final URI voiceUrl, 
                                @JsonProperty("emergency_status")
                                final IncomingPhoneNumber.EmergencyStatus emergencyStatus, 
                                @JsonProperty("emergency_address_sid")
                                final String emergencyAddressSid) {
        this.accountSid = accountSid;
        this.addressRequirements = addressRequirements;
        this.apiVersion = apiVersion;
        this.beta = beta;
        this.capabilities = capabilities;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.friendlyName = friendlyName;
        this.phoneNumber = phoneNumber;
        this.sid = sid;
        this.smsApplicationSid = smsApplicationSid;
        this.smsFallbackMethod = smsFallbackMethod;
        this.smsFallbackUrl = smsFallbackUrl;
        this.smsMethod = smsMethod;
        this.smsUrl = smsUrl;
        this.statusCallback = statusCallback;
        this.statusCallbackMethod = statusCallbackMethod;
        this.trunkSid = trunkSid;
        this.uri = uri;
        this.voiceApplicationSid = voiceApplicationSid;
        this.voiceCallerIdLookup = voiceCallerIdLookup;
        this.voiceFallbackMethod = voiceFallbackMethod;
        this.voiceFallbackUrl = voiceFallbackUrl;
        this.voiceMethod = voiceMethod;
        this.voiceUrl = voiceUrl;
        this.emergencyStatus = emergencyStatus;
        this.emergencyAddressSid = emergencyAddressSid;
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
     * Returns The Indicates if the customer requires an address.
     * 
     * @return Indicates if the customer requires an address
     */
    public final IncomingPhoneNumber.AddressRequirement getAddressRequirements() {
        return this.addressRequirements;
    }

    /**
     * Returns The The Twilio REST API version to use.
     * 
     * @return The Twilio REST API version to use
     */
    public final String getApiVersion() {
        return this.apiVersion;
    }

    /**
     * Returns The Indicates if the phone number is a beta number.
     * 
     * @return Indicates if the phone number is a beta number
     */
    public final Boolean getBeta() {
        return this.beta;
    }

    /**
     * Returns The Indicate if a phone can receive calls or messages.
     * 
     * @return Indicate if a phone can receive calls or messages
     */
    public final PhoneNumberCapabilities getCapabilities() {
        return this.capabilities;
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
     * Returns The A human readable description of this resouce.
     * 
     * @return A human readable description of this resouce
     */
    public final String getFriendlyName() {
        return this.friendlyName;
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
     * Returns The A string that uniquely identifies this resource.
     * 
     * @return A string that uniquely identifies this resource
     */
    public final String getSid() {
        return this.sid;
    }

    /**
     * Returns The Unique string that identifies the application.
     * 
     * @return Unique string that identifies the application
     */
    public final String getSmsApplicationSid() {
        return this.smsApplicationSid;
    }

    /**
     * Returns The HTTP method used with sms fallback url.
     * 
     * @return HTTP method used with sms fallback url
     */
    public final HttpMethod getSmsFallbackMethod() {
        return this.smsFallbackMethod;
    }

    /**
     * Returns The URL Twilio will request if an error occurs in executing TwiML.
     * 
     * @return URL Twilio will request if an error occurs in executing TwiML
     */
    public final URI getSmsFallbackUrl() {
        return this.smsFallbackUrl;
    }

    /**
     * Returns The HTTP method to use with sms url.
     * 
     * @return HTTP method to use with sms url
     */
    public final HttpMethod getSmsMethod() {
        return this.smsMethod;
    }

    /**
     * Returns The URL Twilio will request when receiving an SMS.
     * 
     * @return URL Twilio will request when receiving an SMS
     */
    public final URI getSmsUrl() {
        return this.smsUrl;
    }

    /**
     * Returns The URL Twilio will use to pass status parameters.
     * 
     * @return URL Twilio will use to pass status parameters
     */
    public final URI getStatusCallback() {
        return this.statusCallback;
    }

    /**
     * Returns The HTTP method twilio will use with status callback.
     * 
     * @return HTTP method twilio will use with status callback
     */
    public final HttpMethod getStatusCallbackMethod() {
        return this.statusCallbackMethod;
    }

    /**
     * Returns The Unique string to identify the trunk.
     * 
     * @return Unique string to identify the trunk
     */
    public final String getTrunkSid() {
        return this.trunkSid;
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
     * Returns The The unique sid of the application to handle this number.
     * 
     * @return The unique sid of the application to handle this number
     */
    public final String getVoiceApplicationSid() {
        return this.voiceApplicationSid;
    }

    /**
     * Returns The Look up the caller's caller-ID.
     * 
     * @return Look up the caller's caller-ID
     */
    public final Boolean getVoiceCallerIdLookup() {
        return this.voiceCallerIdLookup;
    }

    /**
     * Returns The HTTP method used with fallback_url.
     * 
     * @return HTTP method used with fallback_url
     */
    public final HttpMethod getVoiceFallbackMethod() {
        return this.voiceFallbackMethod;
    }

    /**
     * Returns The URL Twilio will request when an error occurs in TwiML.
     * 
     * @return URL Twilio will request when an error occurs in TwiML
     */
    public final URI getVoiceFallbackUrl() {
        return this.voiceFallbackUrl;
    }

    /**
     * Returns The HTTP method used with the voice url.
     * 
     * @return HTTP method used with the voice url
     */
    public final HttpMethod getVoiceMethod() {
        return this.voiceMethod;
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
     * Returns The The emergency_status.
     * 
     * @return The emergency_status
     */
    public final IncomingPhoneNumber.EmergencyStatus getEmergencyStatus() {
        return this.emergencyStatus;
    }

    /**
     * Returns The The emergency_address_sid.
     * 
     * @return The emergency_address_sid
     */
    public final String getEmergencyAddressSid() {
        return this.emergencyAddressSid;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        
        IncomingPhoneNumber other = (IncomingPhoneNumber) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(addressRequirements, other.addressRequirements) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(beta, other.beta) && 
               Objects.equals(capabilities, other.capabilities) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(friendlyName, other.friendlyName) && 
               Objects.equals(phoneNumber, other.phoneNumber) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(smsApplicationSid, other.smsApplicationSid) && 
               Objects.equals(smsFallbackMethod, other.smsFallbackMethod) && 
               Objects.equals(smsFallbackUrl, other.smsFallbackUrl) && 
               Objects.equals(smsMethod, other.smsMethod) && 
               Objects.equals(smsUrl, other.smsUrl) && 
               Objects.equals(statusCallback, other.statusCallback) && 
               Objects.equals(statusCallbackMethod, other.statusCallbackMethod) && 
               Objects.equals(trunkSid, other.trunkSid) && 
               Objects.equals(uri, other.uri) && 
               Objects.equals(voiceApplicationSid, other.voiceApplicationSid) && 
               Objects.equals(voiceCallerIdLookup, other.voiceCallerIdLookup) && 
               Objects.equals(voiceFallbackMethod, other.voiceFallbackMethod) && 
               Objects.equals(voiceFallbackUrl, other.voiceFallbackUrl) && 
               Objects.equals(voiceMethod, other.voiceMethod) && 
               Objects.equals(voiceUrl, other.voiceUrl) && 
               Objects.equals(emergencyStatus, other.emergencyStatus) && 
               Objects.equals(emergencyAddressSid, other.emergencyAddressSid);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            addressRequirements,
                            apiVersion,
                            beta,
                            capabilities,
                            dateCreated,
                            dateUpdated,
                            friendlyName,
                            phoneNumber,
                            sid,
                            smsApplicationSid,
                            smsFallbackMethod,
                            smsFallbackUrl,
                            smsMethod,
                            smsUrl,
                            statusCallback,
                            statusCallbackMethod,
                            trunkSid,
                            uri,
                            voiceApplicationSid,
                            voiceCallerIdLookup,
                            voiceFallbackMethod,
                            voiceFallbackUrl,
                            voiceMethod,
                            voiceUrl,
                            emergencyStatus,
                            emergencyAddressSid);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("addressRequirements", addressRequirements)
                          .add("apiVersion", apiVersion)
                          .add("beta", beta)
                          .add("capabilities", capabilities)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("friendlyName", friendlyName)
                          .add("phoneNumber", phoneNumber)
                          .add("sid", sid)
                          .add("smsApplicationSid", smsApplicationSid)
                          .add("smsFallbackMethod", smsFallbackMethod)
                          .add("smsFallbackUrl", smsFallbackUrl)
                          .add("smsMethod", smsMethod)
                          .add("smsUrl", smsUrl)
                          .add("statusCallback", statusCallback)
                          .add("statusCallbackMethod", statusCallbackMethod)
                          .add("trunkSid", trunkSid)
                          .add("uri", uri)
                          .add("voiceApplicationSid", voiceApplicationSid)
                          .add("voiceCallerIdLookup", voiceCallerIdLookup)
                          .add("voiceFallbackMethod", voiceFallbackMethod)
                          .add("voiceFallbackUrl", voiceFallbackUrl)
                          .add("voiceMethod", voiceMethod)
                          .add("voiceUrl", voiceUrl)
                          .add("emergencyStatus", emergencyStatus)
                          .add("emergencyAddressSid", emergencyAddressSid)
                          .toString();
    }
}