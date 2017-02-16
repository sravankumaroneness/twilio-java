/**
 * This code was generated by
 * \ / _    _  _|   _  _
 *  | (_)\/(_)(_|\/| |(/_  v1.0.0
 *       /       /       
 */

package com.twilio.rest.video.v1;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.twilio.Twilio;
import com.twilio.converter.DateConverter;
import com.twilio.converter.Promoter;
import com.twilio.exception.TwilioException;
import com.twilio.http.HttpMethod;
import com.twilio.http.Request;
import com.twilio.http.Response;
import com.twilio.http.TwilioRestClient;
import com.twilio.rest.Domains;
import mockit.Mocked;
import mockit.NonStrictExpectations;
import org.junit.Before;
import org.junit.Test;

import java.net.URI;

import static com.twilio.TwilioTest.serialize;
import static org.junit.Assert.*;

public class RoomTest {
    @Mocked
    private TwilioRestClient twilioRestClient;

    @Before
    public void setUp() throws Exception {
        Twilio.init("AC123", "AUTH TOKEN");
    }

    @Test
    public void testFetchRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VIDEO.toString(),
                                          "/v1/Rooms/RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Room.fetcher("RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").fetch();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testFetchResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"status\": \"in-progress\",\"type\": \"peer-to-peer\",\"sid\": \"RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"enable_turn\": true,\"unique_name\": \"unique_name\",\"max_participants\": 10,\"duration\": 0,\"status_callback_method\": \"POST\",\"status_callback\": \"\",\"start_time\": \"2015-07-30T20:00:00Z\",\"end_time\": \"2015-07-30T20:00:00Z\",\"url\": \"https://video.twilio.com/v1/Rooms/RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Room.fetcher("RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa").fetch());
    }

    @Test
    public void testCreateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VIDEO.toString(),
                                          "/v1/Rooms");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Room.creator().create();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testCreateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"status\": \"in-progress\",\"type\": \"peer-to-peer\",\"sid\": \"RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"enable_turn\": true,\"unique_name\": \"RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"max_participants\": 10,\"duration\": 0,\"status_callback_method\": \"POST\",\"status_callback\": \"\",\"start_time\": \"2015-07-30T20:00:00Z\",\"end_time\": \"2015-07-30T20:00:00Z\",\"url\": \"https://video.twilio.com/v1/Rooms/RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_CREATED);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Room.creator().create();
    }

    @Test
    public void testReadRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.GET,
                                          Domains.VIDEO.toString(),
                                          "/v1/Rooms");
            
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Room.reader().read();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testReadEmptyResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"rooms\": [],\"meta\": {\"page\": 0,\"page_size\": 50,\"first_page_url\": \"https://video.twilio.com/v1/Rooms?PageSize=50&Page=0\",\"previous_page_url\": null,\"url\": \"https://video.twilio.com/v1/Rooms?PageSize=50&Page=0\",\"next_page_url\": null,\"key\": \"rooms\"}}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        assertNotNull(Room.reader().read());
    }

    @Test
    public void testUpdateRequest() {
        new NonStrictExpectations() {{
            Request request = new Request(HttpMethod.POST,
                                          Domains.VIDEO.toString(),
                                          "/v1/Rooms/RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa");
            request.addPostParam("Status", serialize(Room.RoomStatus.IN_PROGRESS));
            twilioRestClient.request(request);
            times = 1;
            result = new Response("", 500);
            twilioRestClient.getAccountSid();
            result = "AC123";
        }};
        
        try {
            Room.updater("RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Room.RoomStatus.IN_PROGRESS).update();
            fail("Expected TwilioException to be thrown for 500");
        } catch (TwilioException e) {}
    }

    @Test
    public void testUpdateResponse() {
        new NonStrictExpectations() {{
            twilioRestClient.request((Request) any);
            result = new Response("{\"account_sid\": \"ACaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"date_created\": \"2015-07-30T20:00:00Z\",\"date_updated\": \"2015-07-30T20:00:00Z\",\"status\": \"completed\",\"type\": \"peer-to-peer\",\"sid\": \"RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\",\"enable_turn\": true,\"unique_name\": \"unique_name\",\"max_participants\": 10,\"status_callback_method\": \"POST\",\"status_callback\": \"\",\"start_time\": \"2015-07-30T20:00:00Z\",\"end_time\": \"2015-07-30T20:00:00Z\",\"duration\": 10,\"url\": \"https://video.twilio.com/v1/Rooms/RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa\"}", TwilioRestClient.HTTP_STATUS_CODE_OK);
            twilioRestClient.getObjectMapper();
            result = new ObjectMapper();
        }};
        
        Room.updater("RMaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa", Room.RoomStatus.IN_PROGRESS).update();
    }
}