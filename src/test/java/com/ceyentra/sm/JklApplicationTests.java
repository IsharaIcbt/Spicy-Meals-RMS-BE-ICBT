package com.ceyentra.sm;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
class JklApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testLoginWithBasicAuth() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.post("/v1/oauth/token")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .header(HttpHeaders.AUTHORIZATION, "Basic VVNFUjo=")
                        .param("username", "dinuth@gmail.com")
                        .param("password", "1234")
                        .param("grant_type", "password"))
                .andExpect(status().isOk())  // Expecting 200 OK
                .andExpect(content().contentType(MediaType.valueOf("application/json;charset=UTF-8")));  // Adjust the expected response
    }

    @Test
    void testUserRegistration() throws Exception {

        MockMultipartFile imgFile = new MockMultipartFile(
                "imgFile",
                "image.jpg",
                "image/jpeg",
                "image content".getBytes()
        );

        mockMvc.perform(MockMvcRequestBuilders.multipart("/v1/user/register")
                        .file(imgFile)
                        .param("name", "kasun")
                        .param("email", "kasun@gmail.com")
                        .param("password", "123456")
                        .param("nic", "982241562v")
                        .param("phoneNumber", "0701234567")
                        .param("homeAddress", "ruwanwella")
                        .contentType(MediaType.MULTIPART_FORM_DATA))
                .andExpect(status().isOk())
                .andExpect(content().json("{\"message\":\"User successfully registered.\",\"success\":true}"));
    }

    @Test
    void testGetQueriesFromNonExistingReservation() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/reservation/TABLE/10000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Table reservation does not exist\",\"success\":false,\"status\":200}"));
    }

    @Test
    void testGetQueriesFromNonExistingMealOrder() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/reservation/MEAL/10000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"message\":\"Meal order does not exist\",\"success\":false,\"status\":200}"));
    }

    @Test
    void testGetMealOrdersFromNonExistingCustomer() throws Exception {
        mockMvc.perform(MockMvcRequestBuilders.get("/v1/reservation/order/MEAL/1000000")
                        .accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"data\":[],\"success\":true}"));
    }

    @Test
    void testPostCustomQueryFormCustomerSide() throws Exception {

        String jsonPayload = "{"
                + "\"userRole\": \"CUSTOMER\","
                + "\"queryType\": \"CUSTOM\","
                + "\"message\": \"I need help with my recent order.\","
                + "\"userId\": 1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":true,\"message\":\"Saved query\"}"));
    }

    @Test
    void testPostCustomQueryFormCustomerSideWithNonExistingCustomer() throws Exception {

        String jsonPayload = "{"
                + "\"userRole\": \"CUSTOMER\","
                + "\"queryType\": \"CUSTOM\","
                + "\"message\": \"I need help with my recent order.\","
                + "\"userId\": 100000000"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":false,\"message\":\"Customer does not exist\",\"status\":200}"));
    }

    @Test
    void testPostMealOrderQueryFormAdminSideWithNonExistingMealOrder() throws Exception {

        String jsonPayload = "{"
                + "\"mealOrderId\": 10000,"
                + "\"userRole\": \"ADMIN\","
                + "\"queryType\": \"MEAL\","
                + "\"message\": \"I need help with my recent order.\","
                + "\"userId\": 2"
                + "}";


        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":false,\"message\":\"Meal order does not exist\",\"status\":200}"));
    }

    @Test
    void testPostMealOrderQueryFormAdminSideWithNonExistingAdminAccount() throws Exception {

        String jsonPayload = "{"
                + "\"mealOrderId\": 1,"
                + "\"userRole\": \"ADMIN\","
                + "\"queryType\": \"MEAL\","
                + "\"message\": \"I need help with my recent order.\","
                + "\"userId\": 20000"
                + "}";


        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":false,\"message\":\"Admin does not exist\",\"status\":200}"));
    }

    @Test
    void testPostMealOrderQueryFormAdminSideWithExistingAdminAccount() throws Exception {

        String jsonPayload = "{"
                + "\"mealOrderId\": 1,"
                + "\"userRole\": \"ADMIN\","
                + "\"queryType\": \"MEAL\","
                + "\"message\": \"I need help with my recent order.\","
                + "\"userId\": 2"
                + "}";


        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":true,\"message\":\"Saved query\"}"));
    }

    @Test
    void testPostCustomQueryReplyFormStaffSideWithExistingStaffAccount() throws Exception {

        String jsonPayload = "{"
                + "\"userRole\": \"STAFF\","
                + "\"queryType\": \"CUSTOM\","
                + "\"message\": \"I will get back to you soon.\","
                + "\"userId\": 2,"
                + "\"repliedTo\": 1"
                + "}";

        mockMvc.perform(MockMvcRequestBuilders.post("/v1/reservation/query")
                        .contentType(MediaType.APPLICATION_JSON)
                        .content(jsonPayload))
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().json("{\"success\":true,\"message\":\"Saved query\"}"));
    }

}
