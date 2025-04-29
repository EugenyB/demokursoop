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
import java.util.Collections;
import java.util.Optional;

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
//        Bandit bandit = new Bandit();
//        bandit.setName(name);
//        bandit.setNickName(nickName);
//        bandit.setGang(gang);
//        bandit.setCrimeType(crimeType);
//        bandit.setCrimeCount(crimeCount);
//        if (birthdayStr != null && !birthdayStr.isEmpty()) {
//            bandit.setBirthday(LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE));
//        }
//        banditService.save(bandit);

//        Bandit bandit;
//        if (birthdayStr != null && !birthdayStr.isEmpty()) {
//            bandit = new Bandit(name, nickName, LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE), gang, crimeType, crimeCount);
//        } else {
//            bandit = new Bandit(name, nickName, gang, crimeType, crimeCount);
//        }
        Bandit bandit = Bandit.builder().nickName(nickName).name(name).gang(gang).crimeCount(crimeCount).crimeType(crimeType).build();
        if (birthdayStr != null && !birthdayStr.isEmpty()) {
            bandit.setBirthday(LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE));
        }
        banditService.save(bandit);
        return "redirect:/";
    }

    @PostMapping("/edit")
    public String edit(
            @RequestParam("b_id") Integer id,
            @RequestParam("b_name") String name,
            @RequestParam("b_nickname") String nickName,
            @RequestParam("b_gang") String gang,
            @RequestParam("b_birthday") String birthdayStr,
            @RequestParam("b_crimetype") String crimeType,
            @RequestParam("b_crimecount") Integer crimeCount
    ) {
        LocalDate birthday = LocalDate.parse(birthdayStr, DateTimeFormatter.ISO_DATE);
        banditService.edit(new Bandit(id, name, nickName, birthday, gang, crimeType, crimeCount));
        return "redirect:/";
    }

    @RequestMapping("/delete")
    public String delete(@RequestParam Integer id) {
        banditService.deleteById(id);
        return "redirect:/";
    }

    @GetMapping("/crimes")
    public String crimes(Model model) {
        model.addAttribute("bandits", Collections.EMPTY_LIST);
        return "crimes";
    }

    @GetMapping("/showcrimes")
    public String showCrimes(Model model, @RequestParam("crime_type") String type) {
        var list = banditService.findAll().stream().filter(b->b.getCrimeType().equalsIgnoreCase(type)).toList();
        model.addAttribute("bandits", list);
        return "crimes";
    }

    @GetMapping("/show")
    public String show(Model model, @RequestParam("id") Integer id) {
        Optional<Bandit> bandit = banditService.findById(id);
        if (bandit.isEmpty()) {
            return "redirect:/";
        } else {
            model.addAttribute("b", bandit.get());
            return "bandit";
        }
    }
}
