package com.ceyentra.sm.controller;

import com.ceyentra.sm.dto.common.CommonResponseDTO;
import com.ceyentra.sm.dto.common.ResponseDTO;
import com.ceyentra.sm.dto.web.request.MealOrderReqDTO;
import com.ceyentra.sm.dto.web.request.SaveQueryReqDTO;
import com.ceyentra.sm.dto.web.request.TableReservationReqDTO;
import com.ceyentra.sm.enums.QueryType;
import com.ceyentra.sm.service.QueryService;
import com.ceyentra.sm.service.ReservationService;
import com.stripe.Stripe;
import com.stripe.exception.StripeException;
import com.stripe.model.checkout.Session;
import com.stripe.param.checkout.SessionCreateParams;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.PostConstruct;


@RestController
@CrossOrigin
@RequestMapping(value = "/v1/reservation")
@RequiredArgsConstructor
public class ReservationController {

    private static final Logger log = LoggerFactory.getLogger(ReservationController.class);
    private final ReservationService reservationService;
    private final QueryService queryService;

    @PostConstruct
    public void init() {
        // Set your secret API key
        Stripe.apiKey = "sk_test_51PtXuxL18030aj4hVq7Y6fEarn0xyqtwWouHUge2IJZE0yN7IsBAYqPxxKguejK4P1VApkirGOw0uyZpJOTtkm1m00UxmzCXF5";
    }

    @PostMapping("/table")
    public ResponseEntity<Object> saveTableReservation(@RequestBody TableReservationReqDTO reqDTO) {
        return ResponseEntity.status(HttpStatus.OK).body(reservationService.saveTableReservation(reqDTO));
    }

    @PostMapping("/meal")
    public ResponseEntity<Object> saveMealOrder(@RequestBody MealOrderReqDTO reqDTO) {
        reservationService.saveMealOrder(reqDTO);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponseDTO.builder()
                .success(true)
                .message("Saved meal order")
                .build());
    }

    @GetMapping("/{type}/{orderId}")
    public ResponseEntity<Object> getReservations(@PathVariable QueryType type, @PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(queryService.getQueries(type, orderId))
                .build());
    }

    @PostMapping("/query")
    public ResponseEntity<Object> saveQuery(@RequestBody SaveQueryReqDTO reqDTO) {
        queryService.save(reqDTO);
        return ResponseEntity.status(HttpStatus.OK).body(CommonResponseDTO.builder()
                .success(true)
                .message("Saved query")
                .build());
    }

    @GetMapping("/query/{type}/{userId}")
    public ResponseEntity<Object> getQueries(@PathVariable QueryType type, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(queryService.getQueries(type, userId))
                .build());
    }

    @GetMapping("/order/{type}/{userId}")
    public ResponseEntity<Object> getReservationsByType(@PathVariable QueryType type, @PathVariable Long userId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(reservationService.getReservationsByType(type, userId))
                .build());
    }

    @GetMapping("/by-order/{type}/{orderId}")
    public ResponseEntity<Object> getReservationsByTypeAndId(@PathVariable QueryType type, @PathVariable Long orderId) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(reservationService.getReservationsByTypeAndId(type, orderId))
                .build());
    }

    @GetMapping("/{type}")
    public ResponseEntity<Object> getReservationsByTypeAndId(@PathVariable QueryType type) {
        return ResponseEntity.status(HttpStatus.OK).body(ResponseDTO.builder()
                .success(true)
                .data(reservationService.getAllReservations(type))
                .build());
    }

    @GetMapping("/payment/session")
    public String makeCheckoutSession() throws StripeException {
        try {
            String YOUR_DOMAIN = "http://localhost:8080"; // Adjust your domain and port as necessary

            SessionCreateParams params = SessionCreateParams.builder()
                    .setMode(SessionCreateParams.Mode.PAYMENT)
                    .setSuccessUrl(YOUR_DOMAIN + "/success.html")
                    .setCancelUrl(YOUR_DOMAIN + "/canceled.html")
                    .addLineItem(
                            SessionCreateParams.LineItem.builder()
                                    .setQuantity(1L)
                                    .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                            .setCurrency("LKR")
                                            .setUnitAmount(540000L)
                                            .setProductData(
                                                    SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                            .setName("Chicken BBQ")
                                                            .addImage("https://imagesofspicymeals.s3.ap-south-1.amazonaws.com/meals/chicken.png")
                                                            .setDescription("Free to use. Easy to try. Just ask and ChatGPT can help with writing, learning, brainstorming, and more.")
                                                            .build())
                                            .build())
                                    .build())
                    .addLineItem(SessionCreateParams.LineItem.builder()
                            .setQuantity(1L)
                            .setPriceData(SessionCreateParams.LineItem.PriceData.builder()
                                    .setCurrency("LKR")
                                    .setUnitAmount(600000L)
                                    .setProductData(
                                            SessionCreateParams.LineItem.PriceData.ProductData.builder()
                                                    .setName("Biriyani")
                                                    .addImage("https://imagesofspicymeals.s3.ap-south-1.amazonaws.com/meals/biriyani.png")
                                                    .setDescription("Free to use. Easy to try. Just ask and ChatGPT can help with writing, learning, brainstorming, and more.")
                                                    .build())
                                    .build())
                            .build())
                    .build();

            return Session.create(params).getUrl();

        } catch (Exception e) {
            log.error(e.getMessage());
            throw e;
        }
    }

}
