package com.banking.core.util;

import lombok.RequiredArgsConstructor;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpHeaders;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.web.reactive.function.client.WebClient;


import java.net.URI;
import java.util.HashMap;
import java.util.List;
import java.util.function.Consumer;
@RequiredArgsConstructor
public class WebClientConnector {
    protected WebClient webClient;

    protected LinkedMultiValueMap multiValueMap = new LinkedMultiValueMap(new HashMap());
    private Consumer<HttpHeaders> consumer = (it) -> {
        it.addAll(multiValueMap);
    };

    protected <T> T getSingleObjectResponse(URI uri) {
        return this.webClient.get().uri(uri).headers(this.consumer).retrieve().bodyToMono(new ParameterizedTypeReference<T>() {}).block();
    }

    protected <T> List<T> getListResponse(URI uri) {
        return this.webClient.get().uri(uri).headers(this.consumer).retrieve().bodyToFlux(new ParameterizedTypeReference<List<T>>() {
        }).blockLast();
    }

    protected <T> List<T>  postExpectingList(URI uri,Object request) {
        return this.webClient.post().uri(uri).headers(this.consumer).bodyValue(request).retrieve().bodyToFlux(new ParameterizedTypeReference<List<T>>() {
        }).blockLast();
    }
    protected <T>  T postExpectingSingleObject(URI uri,Object request) {
        return this.webClient.post().uri(uri).headers(this.consumer).bodyValue(request).retrieve().bodyToMono(new ParameterizedTypeReference<T>() {
        }).block();
    }


}
