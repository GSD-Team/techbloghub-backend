package com.gsd.techbloghub.core.client.woowahan

import feign.codec.Encoder
import feign.form.FormEncoder
import org.springframework.context.annotation.Bean

/**
 * Created by Yohan lee
 * Created on 2023/02/06.
 **/
class WoowahanTbClientConfig {


    @Bean
    fun woowahanTbClientEncoder(): Encoder {
        return FormEncoder()
    }


}