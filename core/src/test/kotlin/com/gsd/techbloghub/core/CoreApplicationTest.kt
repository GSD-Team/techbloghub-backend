package com.gsd.techbloghub.core

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.cloud.openfeign.EnableFeignClients

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/

@EnableFeignClients(basePackages = ["com.gsd.techbloghub.core.client"])
@SpringBootApplication
class CoreApplicationTest {
}