package com.wrapping.intercetor;

import org.springframework.core.MethodParameter;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.method.support.HandlerMethodReturnValueHandler;
import org.springframework.web.method.support.ModelAndViewContainer;

public class HandlerMethodReturnValueHandlerWrapper implements HandlerMethodReturnValueHandler {
    /**
     * Whether the given {@linkplain MethodParameter method return type} is
     * supported by this handler.
     *
     * @param returnType the method return type to check
     * @return {@code true} if this handler supports the supplied return type;
     * {@code false} otherwise
     */
    public boolean supportsReturnType(MethodParameter returnType) {
        return false;
    }

    /**
     * Handle the given return value by adding attributes to the model and
     * setting a view or setting the
     * {@link ModelAndViewContainer#setRequestHandled} flag to {@code true}
     * to indicate the response has been handled directly.
     *
     * @param returnValue  the value returned from the handler method
     * @param returnType   the type of the return value. This type must have
     *                     previously been passed to {@link #supportsReturnType} which must
     *                     have returned {@code true}.
     * @param mavContainer the ModelAndViewContainer for the current request
     * @param webRequest   the current request
     * @throws Exception if the return value handling results in an error
     */
    public void handleReturnValue(Object returnValue, MethodParameter returnType, ModelAndViewContainer mavContainer, NativeWebRequest webRequest) throws Exception {

    }
}
