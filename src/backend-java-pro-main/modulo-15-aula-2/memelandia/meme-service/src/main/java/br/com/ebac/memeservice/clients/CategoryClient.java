package br.com.ebac.memeservice.clients;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "category-service", url = "${category-service.url}")
public interface CategoryClient {
    @GetMapping("/categorias/{id}")
    Object getCategoryById(@PathVariable("id") Long id);
}
