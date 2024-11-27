package edu.csula.cysun.jpa.controller;

import edu.csula.cysun.jpa.model.GuestBookEntry;
import edu.csula.cysun.jpa.repository.GuestBookEntryRepo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/guestbook")
public class GuestBookController {
    private final GuestBookEntryRepo repo;

    public GuestBookController(GuestBookEntryRepo repo) {
        this.repo = repo;
    }

    @RequestMapping("")
    public String index(Model model) {
        model.addAttribute("entries", repo.findAll());
        return "guestbook/index";
    }

    @GetMapping("/add")
    public String add() {
        return "guestbook/add";
    }

    @PostMapping("/add")
    public String add(GuestBookEntry entry) {
        repo.save(entry);
        return "redirect:/guestbook";
    }

    @GetMapping("/edit/{id}")
    public String edit(@PathVariable int id, Model model) {
        model.addAttribute("entry", repo.findById(id).orElse(null));
        return "guestbook/edit";
    }

    @PostMapping("/edit/{id}")
    public String edit(@PathVariable int id, GuestBookEntry newEntry) {
        GuestBookEntry entry = repo.findById(id).orElse(null);
        entry.setName(newEntry.getName());
        entry.setMessage(newEntry.getMessage());
        repo.save(entry);
        return "redirect:/guestbook";
    }

    @DeleteMapping("/delete/{id}")
    @ResponseBody
    public boolean delete(@PathVariable int id) {
        repo.deleteById(id);
        return true;
    }
}
