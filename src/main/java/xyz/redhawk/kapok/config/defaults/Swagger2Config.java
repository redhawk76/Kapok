package xyz.redhawk.kapok.config.defaults;/**
 * @author RedHawk
 * @create 2019-11-27 10:18
 */

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Parameter;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;
import java.util.List;

/**
 * <Description> <br>
 *
 * @author redhawk<br>
 * @taskId:   <br>
 * @version 1.0<br>
 * @createDate 2019/11/27 10:18 <br>
 * @see xyz.redhawk.kapok.config.defaults <br>
 */
// 访问地址 http://127.0.0.1:8076/swagger-ui.html#
@Configuration
@EnableSwagger2
public class Swagger2Config {

    private ApiInfo apiInfo() {
        return new ApiInfoBuilder()
                .title("Kapok - APi接口文档")
                .description("")
                .termsOfServiceUrl("https://swagger.io/docs/specification/what-is-swagger/")
                .version("1.0")
                .build();
    }

    @Bean
    public Docket createRestApi() {
        ParameterBuilder ticketPar = new ParameterBuilder();
        List<Parameter> pars = new ArrayList<Parameter>();
        ticketPar.name("Kapok_data").description("login token")
                .modelRef(new ModelRef("string")).parameterType("header")
                .required(false).build(); //header中的ticket参数非必填，传空也可以
        pars.add(ticketPar.build());    //根据每个方法名也知道当前方法在设置什么参数
        return new Docket(DocumentationType.SWAGGER_2)
                .select()
                .apis(RequestHandlerSelectors.basePackage("xyz.redhawk.kapok"))
                .build()
                .globalOperationParameters(pars)
                .apiInfo(apiInfo());
    }
}
