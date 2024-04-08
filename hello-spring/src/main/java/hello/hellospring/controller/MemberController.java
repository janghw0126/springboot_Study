package hello.hellospring.controller;
import org.springframework.ui.Model;
import hello.hellospring.domain.Member;
import hello.hellospring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import java.util.List;


@Controller
public class MemberController {
    private final MemberService memberService;
    @Autowired
    public MemberController(MemberService memberService) {
        this.memberService = memberService;
    }

    @GetMapping("/members/new")
    public String createForm(){
        return "members/createMemberForm";
    }

    @PostMapping("members/new")
    public String create(MemberForm form){
        Member member = new Member();
        member.setName(form.getName()); //form에서 getName을 함 -> member가 만들어짐

        memberService.join(member);

        return "redirect:/"; //회원가입이 끝났으니까 홈화면으로 다시 돌아감
    }

    @GetMapping("/members")
    public String list(Model model){
        List<Member> members = memberService.findMembers(); //findMembers()하면 모든 멤버들을 다 가져올 수 있음
        model.addAttribute("members",members); //member List 자체를 모델에 담아서 화면에 넘길 거임
        return "members/memberList";
    }
}