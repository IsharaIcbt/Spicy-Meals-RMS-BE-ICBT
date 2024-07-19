/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 11:18 PM
 */
package com.ceyentra.sm.config.throttling_config;

import com.google.common.cache.Cache;
import com.google.common.cache.CacheBuilder;
import org.springframework.stereotype.Service;

import java.security.SecureRandom;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;

@Service
public class ThrottlingManager {

    private final Map<EndpointMethod, Map<String, Cache<Long, Long>>> ENDPOINT_THROTTLE_MAPPING = new ConcurrentHashMap<>();

    void throttleRequest(EndpointMethod endpointMethod, String userId, ThrottlingConfig throttlingConfig) {
        Map<String, Cache<Long, Long>> endpointThrottle = ENDPOINT_THROTTLE_MAPPING.computeIfAbsent(endpointMethod, k -> new HashMap<>());
        Cache<Long, Long> autoExpiringUserCallsCounter = endpointThrottle.computeIfAbsent(userId, k -> buildCacheWhichRemovesEntriesAfterTimeFrame(throttlingConfig));
        Long callsCount = autoExpiringUserCallsCounter.size();
        if (requestLimitReached(throttlingConfig, callsCount)) {
            autoExpiringUserCallsCounter.cleanUp();
            if (requestLimitReached(throttlingConfig, autoExpiringUserCallsCounter.size())) {
                throw new RuntimeException( "too many request.");
            }
        } else {
            long randomKeyToIncreaseCounter = new SecureRandom().nextLong();
            autoExpiringUserCallsCounter.put(randomKeyToIncreaseCounter, randomKeyToIncreaseCounter);
        }
    }

    private boolean requestLimitReached(ThrottlingConfig throttlingConfig, Long callsCount) {
        return callsCount != null && callsCount + 1 > throttlingConfig.getCallsCount();
    }

    private Cache<Long, Long> buildCacheWhichRemovesEntriesAfterTimeFrame(ThrottlingConfig throttlingConfig) {
        return CacheBuilder.newBuilder()
                .expireAfterWrite(throttlingConfig.getTimeFrameInSeconds(), TimeUnit.SECONDS)
                .build();
    }


}
