//package com.gsd.techbloghub.web.global.config
//
//import com.fasterxml.classmate.TypeResolver
//import io.swagger.annotations.ApiModel
//import io.swagger.annotations.ApiModelProperty
//import io.swagger.v3.oas.models.OpenAPI
//import org.springframework.context.annotation.Bean
//import org.springframework.context.annotation.Configuration
//import org.springframework.data.domain.Pageable
//import springfox.documentation.builders.ApiInfoBuilder
//import springfox.documentation.builders.PathSelectors
//import springfox.documentation.builders.RequestHandlerSelectors
//import springfox.documentation.schema.AlternateTypeRules
//import springfox.documentation.service.ApiInfo
//import springfox.documentation.service.ApiKey
//import springfox.documentation.service.AuthorizationScope
//import springfox.documentation.service.SecurityReference
//import springfox.documentation.spi.DocumentationType
//import springfox.documentation.spi.service.contexts.SecurityContext
//import springfox.documentation.spring.web.plugins.Docket
//import java.time.YearMonth
//
///**
// * Created by Yohan lee
// * Created on 2023/02/13.
// **/
//
//@Configuration
//class SwaggerConfig {
//
//    @Bean
//    fun api(): Docket {
//        val typeResolver = TypeResolver()
//        return Docket(DocumentationType.OAS_30)
////            .ignoredParameterTypes(AuthenticationPrincipal::class.java)
//            //Pageable객체  처리
//            .alternateTypeRules(
//                AlternateTypeRules.newRule(
//                    typeResolver.resolve(Pageable::class.java),
//                    typeResolver.resolve(Page::class.java)
//                )
//            )
//            .directModelSubstitute(YearMonth::class.java, String::class.java)
//            .securityContexts(listOf(securityContext()))
//            .securitySchemes(listOf(apiKey()))
////            .apiInfo(apiInfo())
//            .select()
//            .apis(RequestHandlerSelectors.basePackage("com.gsd.techbloghub.web.domain"))
//            .paths(PathSelectors.any())
//            .build()
//
//    }
//
//    private fun apiInfo(): ApiInfo {
//        return ApiInfoBuilder()
//            .title("TechBlogHub API Document")
//            .description("TechBlogHub API 명세")
//            .version("1.0")
//            .build()
//    }
//
//    private fun securityContext(): SecurityContext {
//        return SecurityContext.builder()
//            .securityReferences(defaultAuth())
//            .build()
//    }
//
//    private fun defaultAuth(): List<SecurityReference> {
//        val authorizationScope = AuthorizationScope("global", "accessEverything")
//        val authorizationScopes = arrayOfNulls<AuthorizationScope>(1)
//        authorizationScopes[0] = authorizationScope
//        return listOf(SecurityReference("Authorization", authorizationScopes))
//    }
//
//    private fun apiKey(): ApiKey {
//        return ApiKey("Authorization", "Authorization", "header")
//    }
//
//
//    @ApiModel
//    class Page(
//
//        @ApiModelProperty(value = "페이지 번호(1..N)", example = "1")
//        val page: Int?,
//
//        @ApiModelProperty(value = "페이지 크기", allowableValues = "range[0, 100]", example = "1")
//        val size: Int?,
//
//        @ApiModelProperty(value = "현재 비활성화됨!! 정렬(사용법: 컬럼명,ASC|DESC)")
//        val sort: List<String>,
//    ) {
//    }
//}