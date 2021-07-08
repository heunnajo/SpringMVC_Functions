package hello.springmvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Controller 이면 리턴되는 스트링은 뷰 이름이다!
//RestAPI의 그 Rest이다. 스트링을 반환하면 스트링 그 자체가 반환된다!
//RestAPI 만들 때 핵심적인 컨트롤러다!
@RestController
@Slf4j//롬복이 제공하는 애노테이션
public class LogTestController {
    //클래스 지정 : 아래 두 가지 모두 동일하다.
    //private final Logger log = LoggerFactory.getLogger(getClass());
//    private final Logger log = LoggerFactory.getLogger(LogTestController.class);

    @RequestMapping("/log-test")
    public String logTest(){
        String name = "Spring";
        //로그를 찍을 때 레벨을 선택할 수 있다?!
        log.trace("trace log={}",name);
        log.debug("debug log={}",name);
        log.info(" info log={}",name);
        log.warn(" warn log={}",name);
        log.error("error log={}",name);

        //[시간] INFO [프로세스ID] [현재 스레드 from 스레드 풀] [현재 나의 컨트롤러 이름까지] + "info log=Spring"
        return  "ok";//HTTP 바디에 이 스트링을 콱 넣어버린다!
    }
}
