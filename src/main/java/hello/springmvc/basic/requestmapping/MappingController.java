package hello.springmvc.basic.requestmapping;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
public class MappingController {
    private Logger log = LoggerFactory.getLogger(getClass());

    @RequestMapping("/hello-basic")
    public String helloBasic(){
        log.info("helloBasic");
        return "ok";
    }
    @RequestMapping(value = "/mapping-get-v1",method = RequestMethod.GET)
    public String mappingGetV1(){
        log.info("mappingGetV1");
        return "ok";
    }
    @GetMapping ("/mapping-get-v2")
    public String mappingGetV2(){
        log.info("mappingGetV1");
        return "ok";
    }
    @GetMapping("/mapping/{userId}")
    public String mappingPath(@PathVariable("userId") String data){//변수명이 {userId}라면 @PathVariable String data 가능
        log.info("mappingPath userId={}",data);
        return "ok";
    }
    /**
     * PathVariable 사용 다중
     */
    @GetMapping("/mapping/users/{userId}/orders/{orderId}")
    public String mappingPath(@PathVariable String userId, @PathVariable Long
            orderId) {
        log.info("mappingPath userId={}, orderId={}", userId, orderId);
        return "ok";
    }
    /**
     * 파라미터로 추가 매핑
     * params="mode",
     * params="!mode"
     * params="mode=debug"
     * params="mode!=debug" (! = )
     * params = {"mode=debug","data=good"}
     */
    //단순히 요청 정보를 꺼내는 게 아니라 조건으로도 활용가능하다!
    //특정 파라미터값으로 "mode=debug"가 와야 함수가 호출된다!(AND 조건으로 추가 매핑)
    @GetMapping(value = "/mapping-param", params = "mode=debug")
    public String mappingParam() {
        log.info("mappingParam");
        return "ok";
    }
    /**
     *특정 헤더로 추가 매핑
     * headers="mode",
     * headers="!mode" : 헤더에 mode라는 것이 있으면 안 됨.
     * headers="mode=debug" : 헤더에 key,value가 다 있어야함.
     * headers="mode!=debug" (! = ) : 헤더에 key,value가 같으면 안 됨
     */
    @GetMapping(value = "/mapping-header", headers = "mode=debug")
    public String mappingHeader() {
        log.info("mappingHeader");
        return "ok";
    }
    /**
     * Content-Type 헤더 기반 추가 매핑 Media Type * consumes="application/json"
     * consumes="!application/json"
     * consumes="application/*"
     * consumes="*\/*"
     * MediaType.APPLICATION_JSON_VALUE
     */
    //content-type이 application/json일 때만 호출된다!
    //서버 입장에서는 소비하기 때문에 consume. 요청의 content-type 정보를 소비하기 때문.
    @PostMapping(value = "/mapping-consume", consumes = "application/json")
    public String mappingConsumes() {
        log.info("mappingConsumes");
        return "ok";
    }
    /**
    * Accept 헤더 기반 Media Type
    * produces = "text/html"
    * produces = "!text/html" * produces = "text/*"
    * produces = "*\/*"
    */
    //Accept 헤더가 필요하다!
    @PostMapping(value = "/mapping-produce", produces = "text/html")
    public String mappingProduces() {
        log.info("mappingProduces");
        return "ok";
    }
}
