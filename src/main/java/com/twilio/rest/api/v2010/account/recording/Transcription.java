/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.api.v2010.account.recording;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
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
import java.math.BigDecimal;
import java.util.Currency;
import java.util.Map;
import java.util.Objects;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Transcription extends Resource {
    private static final long serialVersionUID = 226252531194892L;

    public enum Status {
        IN_PROGRESS("in-progress"),
        COMPLETED("completed"),
        FAILED("failed");
    
        private final String value;
        
        private Status(final String value) {
            this.value = value;
        }
        
        public String toString() {
            return value;
        }
        
        /**
         * Generate a Status from a string.
         * @param value string value
         * @return generated Status
         */
        @JsonCreator
        public static Status forValue(final String value) {
            String normalized = value.replace("-", "_").toUpperCase();
            try {
                return Status.valueOf(normalized);
            } catch (RuntimeException e) {
        
                // Don't blow up of value does not exist
                return null;
            }
        }
    }

    /**
     * Create a TranscriptionFetcher to execute fetch.
     * 
     * @param pathAccountSid The account_sid
     * @param pathRecordingSid The recording_sid
     * @param pathSid The sid
     * @return TranscriptionFetcher capable of executing the fetch
     */
    public static TranscriptionFetcher fetcher(final String pathAccountSid, 
                                               final String pathRecordingSid, 
                                               final String pathSid) {
        return new TranscriptionFetcher(pathAccountSid, pathRecordingSid, pathSid);
    }

    /**
     * Create a TranscriptionFetcher to execute fetch.
     * 
     * @param pathRecordingSid The recording_sid
     * @param pathSid The sid
     * @return TranscriptionFetcher capable of executing the fetch
     */
    public static TranscriptionFetcher fetcher(final String pathRecordingSid, 
                                               final String pathSid) {
        return new TranscriptionFetcher(pathRecordingSid, pathSid);
    }

    /**
     * Create a TranscriptionDeleter to execute delete.
     * 
     * @param pathAccountSid The account_sid
     * @param pathRecordingSid The recording_sid
     * @param pathSid The sid
     * @return TranscriptionDeleter capable of executing the delete
     */
    public static TranscriptionDeleter deleter(final String pathAccountSid, 
                                               final String pathRecordingSid, 
                                               final String pathSid) {
        return new TranscriptionDeleter(pathAccountSid, pathRecordingSid, pathSid);
    }

    /**
     * Create a TranscriptionDeleter to execute delete.
     * 
     * @param pathRecordingSid The recording_sid
     * @param pathSid The sid
     * @return TranscriptionDeleter capable of executing the delete
     */
    public static TranscriptionDeleter deleter(final String pathRecordingSid, 
                                               final String pathSid) {
        return new TranscriptionDeleter(pathRecordingSid, pathSid);
    }

    /**
     * Create a TranscriptionReader to execute read.
     * 
     * @param pathAccountSid The account_sid
     * @param pathRecordingSid The recording_sid
     * @return TranscriptionReader capable of executing the read
     */
    public static TranscriptionReader reader(final String pathAccountSid, 
                                             final String pathRecordingSid) {
        return new TranscriptionReader(pathAccountSid, pathRecordingSid);
    }

    /**
     * Create a TranscriptionReader to execute read.
     * 
     * @param pathRecordingSid The recording_sid
     * @return TranscriptionReader capable of executing the read
     */
    public static TranscriptionReader reader(final String pathRecordingSid) {
        return new TranscriptionReader(pathRecordingSid);
    }

    /**
     * Converts a JSON String into a Transcription object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON String
     * @param objectMapper Jackson ObjectMapper
     * @return Transcription object represented by the provided JSON
     */
    public static Transcription fromJson(final String json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    /**
     * Converts a JSON InputStream into a Transcription object using the provided
     * ObjectMapper.
     * 
     * @param json Raw JSON InputStream
     * @param objectMapper Jackson ObjectMapper
     * @return Transcription object represented by the provided JSON
     */
    public static Transcription fromJson(final InputStream json, final ObjectMapper objectMapper) {
        // Convert all checked exceptions to Runtime
        try {
            return objectMapper.readValue(json, Transcription.class);
        } catch (final JsonMappingException | JsonParseException e) {
            throw new ApiException(e.getMessage(), e);
        } catch (final IOException e) {
            throw new ApiConnectionException(e.getMessage(), e);
        }
    }

    private final String accountSid;
    private final String apiVersion;
    private final DateTime dateCreated;
    private final DateTime dateUpdated;
    private final String duration;
    private final BigDecimal price;
    private final Currency priceUnit;
    private final String recordingSid;
    private final String sid;
    private final Transcription.Status status;
    private final String transcriptionText;
    private final String type;
    private final String uri;

    @JsonCreator
    private Transcription(@JsonProperty("account_sid")
                          final String accountSid, 
                          @JsonProperty("api_version")
                          final String apiVersion, 
                          @JsonProperty("date_created")
                          final String dateCreated, 
                          @JsonProperty("date_updated")
                          final String dateUpdated, 
                          @JsonProperty("duration")
                          final String duration, 
                          @JsonProperty("price")
                          final BigDecimal price, 
                          @JsonProperty("price_unit")
                          @JsonDeserialize(using = com.twilio.converter.CurrencyDeserializer.class)
                          final Currency priceUnit, 
                          @JsonProperty("recording_sid")
                          final String recordingSid, 
                          @JsonProperty("sid")
                          final String sid, 
                          @JsonProperty("status")
                          final Transcription.Status status, 
                          @JsonProperty("transcription_text")
                          final String transcriptionText, 
                          @JsonProperty("type")
                          final String type, 
                          @JsonProperty("uri")
                          final String uri) {
        this.accountSid = accountSid;
        this.apiVersion = apiVersion;
        this.dateCreated = DateConverter.rfc2822DateTimeFromString(dateCreated);
        this.dateUpdated = DateConverter.rfc2822DateTimeFromString(dateUpdated);
        this.duration = duration;
        this.price = price;
        this.priceUnit = priceUnit;
        this.recordingSid = recordingSid;
        this.sid = sid;
        this.status = status;
        this.transcriptionText = transcriptionText;
        this.type = type;
        this.uri = uri;
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
     * Returns The The api_version.
     * 
     * @return The api_version
     */
    public final String getApiVersion() {
        return this.apiVersion;
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
     * Returns The The duration.
     * 
     * @return The duration
     */
    public final String getDuration() {
        return this.duration;
    }

    /**
     * Returns The The price.
     * 
     * @return The price
     */
    public final BigDecimal getPrice() {
        return this.price;
    }

    /**
     * Returns The The price_unit.
     * 
     * @return The price_unit
     */
    public final Currency getPriceUnit() {
        return this.priceUnit;
    }

    /**
     * Returns The The recording_sid.
     * 
     * @return The recording_sid
     */
    public final String getRecordingSid() {
        return this.recordingSid;
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
     * Returns The The status.
     * 
     * @return The status
     */
    public final Transcription.Status getStatus() {
        return this.status;
    }

    /**
     * Returns The The transcription_text.
     * 
     * @return The transcription_text
     */
    public final String getTranscriptionText() {
        return this.transcriptionText;
    }

    /**
     * Returns The The type.
     * 
     * @return The type
     */
    public final String getType() {
        return this.type;
    }

    /**
     * Returns The The uri.
     * 
     * @return The uri
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
        
        Transcription other = (Transcription) o;
        
        return Objects.equals(accountSid, other.accountSid) && 
               Objects.equals(apiVersion, other.apiVersion) && 
               Objects.equals(dateCreated, other.dateCreated) && 
               Objects.equals(dateUpdated, other.dateUpdated) && 
               Objects.equals(duration, other.duration) && 
               Objects.equals(price, other.price) && 
               Objects.equals(priceUnit, other.priceUnit) && 
               Objects.equals(recordingSid, other.recordingSid) && 
               Objects.equals(sid, other.sid) && 
               Objects.equals(status, other.status) && 
               Objects.equals(transcriptionText, other.transcriptionText) && 
               Objects.equals(type, other.type) && 
               Objects.equals(uri, other.uri);
    }

    @Override
    public int hashCode() {
        return Objects.hash(accountSid,
                            apiVersion,
                            dateCreated,
                            dateUpdated,
                            duration,
                            price,
                            priceUnit,
                            recordingSid,
                            sid,
                            status,
                            transcriptionText,
                            type,
                            uri);
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                          .add("accountSid", accountSid)
                          .add("apiVersion", apiVersion)
                          .add("dateCreated", dateCreated)
                          .add("dateUpdated", dateUpdated)
                          .add("duration", duration)
                          .add("price", price)
                          .add("priceUnit", priceUnit)
                          .add("recordingSid", recordingSid)
                          .add("sid", sid)
                          .add("status", status)
                          .add("transcriptionText", transcriptionText)
                          .add("type", type)
                          .add("uri", uri)
                          .toString();
    }
}