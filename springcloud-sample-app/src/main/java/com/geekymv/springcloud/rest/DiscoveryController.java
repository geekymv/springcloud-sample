package com.geekymv.springcloud.rest;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Slf4j
@RestController
public class DiscoveryController {

    @Autowired
    private DiscoveryClient discoveryClient;

    @GetMapping("/getDiscoveryInfo")
    public DiscoveryClient getDiscoveryInfo() {

        List<String> services = discoveryClient.getServices();

        for(String service : services) {
            List<ServiceInstance> instances = discoveryClient.getInstances(service);
            for(ServiceInstance instance : instances) {
                log.info(instance.getInstanceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
            }
        }

        return discoveryClient;
    }
}
