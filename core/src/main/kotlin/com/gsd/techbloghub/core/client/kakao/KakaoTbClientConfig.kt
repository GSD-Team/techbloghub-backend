package com.gsd.techbloghub.core.client.kakao

import com.gsd.techbloghub.core.client.kakao.http.KakaoTbPost
import com.gsd.techbloghub.core.util.FeignUtil
import com.gsd.techbloghub.core.util.HttpUtil
import com.gsd.techbloghub.core.vo.DatePattern
import feign.codec.Decoder
import org.jsoup.Jsoup
import org.springframework.context.annotation.Bean
import java.time.LocalDate

/**
 * Created by Yohan lee
 * Created on 2023/03/12.
 **/
class KakaoTbClientConfig {


    @Bean
    fun kakaoTbClientDecoder(): Decoder {
        return Decoder { response, _ ->
            val html = FeignUtil.responseToString(response)
            val elements = Jsoup.parse(html)
                .select("[data-id=e059563]")
                .select(".elementor-widget-container")
                .select(".elementor-posts-container")
                .select(".elementor-post__text")


            elements.map {
                val titleElement = it.select(".elementor-post__title")
                val title = titleElement.text()
                val link = titleElement.select("a").attr("href")
                val postDate = it.select(".elementor-post-date").text()
                val excerpt = it.select(".elementor-post__excerpt").text()

                KakaoTbPost(
                    id = HttpUtil.extractPath(link),
                    title = title,
                    link = link,
                    postDate = LocalDate.parse(postDate, DatePattern.DOT_YYYY_MM_DD),
                    excerpt = excerpt
                )
            }

        }
    }
}