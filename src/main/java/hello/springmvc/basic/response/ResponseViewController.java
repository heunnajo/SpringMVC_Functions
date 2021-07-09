package hello.springmvc.basic.response;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class ResponseViewController {

    @RequestMapping("/response-view-v1")
    public ModelAndView responseViewV1(){
        ModelAndView mav = new ModelAndView("response/hello")
                .addObject("data","hello!");//모델에 데이터 넣어준다!
        return mav;
    }
    //@ResponseBody => 뷰로 가야하는데 HTTP 바디로 들어가버린다!
    @RequestMapping("/response-view-v2")
    public String responseViewV2(Model model){
        model.addAttribute("data","hello!");//모델에 데이터 넣어준다!
        return "response/hello";//@Controller이면서 String 반환 = 뷰의 논리적 이름
    }

    //컨트롤러 이름과 뷰의 논리적 이름과 똑같으면 리턴하는 게 없어도 된다!
    //그러니까 요청 url과 이동하려는 뷰 이름과 같으면 그 url과 같은 이름의 뷰로 이동한다.
    @RequestMapping("/response/hello")
    public void responseViewV3(Model model){
        model.addAttribute("data","hello!");//모델에 데이터 넣어준다!
    }
}
