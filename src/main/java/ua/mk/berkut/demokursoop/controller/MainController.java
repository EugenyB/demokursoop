package ua.mk.berkut.demokursoop.controller;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import ua.mk.berkut.demokursoop.data.Bandit;
import ua.mk.berkut.demokursoop.service.BanditService;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

@Controller
@AllArgsConstructor
public class MainController {

    private final BanditService banditService;

    @GetMapping("/")
    public String mainPage(Model model) {
        model.addAttribute("bandits", banditService.findAll());
        return "home";
    }

    @PostMapping("/add")
    public String addBandit(
            @RequestParam("b_name") String name,
            @RequestParam("b_nickname") String nickName,
            @RequestParam("b_gang") String gang,
            @RequestParam("b_birthday") String birthdayStr,
            @RequestParam("b_crimetype") String crimeType,
            @RequestParam("b_crimecount") Integer crimeCount
    ) {
        Bandit bandit = new Bandit();
        bandit.setName(name);
        bandit.setNickName(nickName);
        bandit.setGang(gang);
        bandit.setCrimeType(crimeType);
        bandit.setCrimeCount(crimeCount);
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            bandit.setBirthday(LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE));
        }
        banditService.save(bandit);
        return "redirect:/";
    }
}
