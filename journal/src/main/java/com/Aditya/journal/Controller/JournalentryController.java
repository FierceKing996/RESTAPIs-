package com.Aditya.journal.Controller;

import com.Aditya.journal.entity.JournalEntry;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/journal")
public class JournalentryController {
    private Map<Long, JournalEntry>  journalentries= new HashMap<>();

    @GetMapping
    public List<JournalEntry> getall(){
        return new ArrayList<>(journalentries.values());
    }

    @PostMapping
    public boolean createentry(@RequestBody JournalEntry myentry){
        journalentries.put(myentry.getId(), myentry);
        return true;
    }

    @GetMapping("/id/{myid}")
    public JournalEntry getbyid(@PathVariable Long myid){
        return journalentries.get(myid);
    }

    @DeleteMapping("/id/{myid}")
    public JournalEntry deletebyid(@PathVariable Long myid){
        return journalentries.remove(myid);
    }

    @PutMapping("/id/{myid}")
    public boolean updatebyid(@PathVariable Long myid,@RequestBody JournalEntry myentry){
        journalentries.put(myid,myentry);
        return true;
    }

}
