/**
 * @author :  Dinuth Dheeraka
 * Created : 8/4/2023 11:12 PM
 */
package com.ceyentra.sm.config.throttling_config;

import lombok.RequiredArgsConstructor;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.stereotype.Component;

import java.lang.reflect.Method;
import java.util.Arrays;

@Component
@Aspect
@RequiredArgsConstructor
public class ThrottlingAspect {

    private final ThrottlingManager throttlingManager;
    private final UserIdProvider userIdProvider;

    @Pointcut("within(@(@org.springframework.stereotype.Controller *) *)")
    public void controllerPointcut() {
        System.out.println("point cut----");
    }

    @Before("controllerPointcut()")
    public void log(JoinPoint pjp) {
        MethodSignature signature = (MethodSignature) pjp.getSignature();
        Method method = signature.getMethod();
        ThrottlingConfig throttlingConfig = getThrottlingConfig(method);
        EndpointMethod endpointMethod = new EndpointMethod(pjp.getTarget().getClass(), method.getName());
        userIdProvider.getCurrentUserId()
                .ifPresent(id -> throttlingManager.throttleRequest(endpointMethod, id, throttlingConfig));
    }

    private ThrottlingConfig getThrottlingConfig(Method method) {
        return Arrays.stream(method.getDeclaredAnnotations())
                .filter(d -> d.annotationType() == Throttling.class)
                .findFirst()
                .map(d -> {
                    Throttling t = (Throttling) d;
                    return new ThrottlingConfig(t.timeFrameInSeconds(), t.calls());
                })
                .orElse(ThrottlingConfig.DEFAULT);
    }

}
