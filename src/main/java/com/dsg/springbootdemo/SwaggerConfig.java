package com.dsg.springbootdemo;

import java.lang.reflect.WildcardType;
import java.time.LocalDate;
import java.util.Collections;
import java.util.List;

import com.fasterxml.classmate.TypeResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.context.request.async.DeferredResult;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.Tag;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spi.service.contexts.SecurityContext;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import static springfox.documentation.schema.AlternateTypeRules.newRule;

@Configuration
@EnableSwagger2
@Import({springfox.documentation.spring.data.rest.configuration.SpringDataRestConfiguration.class})
public class SwaggerConfig {
    @Autowired
    private TypeResolver typeResolver;

    @Bean
    public Docket greetingApi(){
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                //A.apis(RequestHandlerSelectors.basePackage(Application.class.getPackage().getName()))
                //.paths(PathSelectors.ant("/students*")
                //        .or(PathSelectors.ant("/standards*"))
                //                .or(PathSelectors.regex("/greeting")))
                //                       .or(PathSelectors.regex("")))))
                .build();
                /*.pathMapping("/")
                .directModelSubstitute(LocalDate.class, String.class)
                .genericModelSubstitutes(ResponseEntity.class)
                .alternateTypeRules(
                        newRule(typeResolver.resolve(DeferredResult.class,
                                typeResolver.resolve(ResponseEntity.class, WildcardType.class)),
                                typeResolver.resolve(WildcardType.class)))*/
                /*.useDefaultResponseMessages(false)
                .globalResponses(HttpMethod.GET,
                        Collections.singletonList(new ResponseBuilder()
                                .code("500")
                                .description("500 messages")
                                .representation(MediaType.TEXT_XML)
                                .apply(r ->
                                        r.model(m ->
                                                m.referenceModel(ref ->
                                                        ref.key(k ->
                                                                k.qualifiedModelName(q ->
                                                                        q.namespace("some:namespace")
                                                                            .name("ERROR"))))))
                                .build()))*/
                /*.securitySchemes(Collections.singletonList(apiKey()))
                .securityContexts(Collections.singletonList(securityContext()))
                .enableUrlTemplating(true)
                .globalRequestParameters(
                        Collections.singletonList(new RequestParameterBuilder()
                                .name("someGlobalParameter")
                                .description("Description of someGlobalParameter")
                                .in(ParameterType.QUERY)
                                .required(true)
                                .query(q -> q.model(m -> m.scalarModel(ScalarType.STRING)))
                                .build()))
                .tags(new Tag("Student service", "All apis relating to students"));*/
                //.additionalModels(typeResolver.resolve(AdditionalModel.class));

    }
    /*
    private ApiKey apiKey(){
        return new ApiKey("mykey", "api_key", "header");
    }

    private SecurityContext securityContext(){
        return SecurityContext.builder()
                .securityReferences(defaultAuth())
                .forPaths(PathSelectors.regex("/*"))
                .build();
    }

    private List<SecurityReference> defaultAuth() {
        AuthorizationScope authorizationScope = new AuthorizationScope("global", "accessEverything");
        AuthorizationScope[] authScopes = new AuthorizationScope[1];
        authScopes[0] = authorizationScope;
        return Collections.singletonList(new SecurityReference("mykey", authScopes));
    }

    @Bean SecurityConfiguration security(){
        return SecurityConfigurationBuilder.builder()
                .clientId("test-app-client-id")
                .clientSecret("test-app-client-secret")
                .realm("test-app-realm")
                .appName("test-app")
                .scopeSeparator(",")
                .additionalQueryStringParams(null)
                .useBasicAuthenticationWithAccessCodeGrant(false)
                .enableCsrfSupport(false)
                .build();
    }

    @Bean UiConfiguration uiConfig(){
        return UiConfigurationBuilder.builder()
                .deepLinking(true)
                .displayOperationId(false)
                //.defaultModelExpandDepth(1)
                //.defaultModelsExpandDepth(1)
                .defaultModelRendering(ModelRendering.EXAMPLE)
                .displayRequestDuration(false)
                .docExpansion(DocExpansion.NONE)
                .filter(false)
                .maxDisplayedTags(null)
                .operationsSorter(OperationsSorter.ALPHA)
                .showExtensions(false)
                .showCommonExtensions(false)
                .tagsSorter(TagsSorter.ALPHA)
                .supportedSubmitMethods(Constants.DEFAULT_SUBMIT_METHODS)
                .validatorUrl(null)
                .build();
    }*/
}
