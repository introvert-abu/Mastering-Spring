package com.abu.monthlychallange;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;



@RestController
@RequestMapping("/challanges")
public class ChallangeController {
    private ChallangeService challangeService;
    
    public ChallangeController(ChallangeService challangeService) {
        this.challangeService = challangeService;
    }
    
    @GetMapping
    public List<Challange> getAllChallanges() {
        return challangeService.getAllChallanges();
    }

    @PostMapping
    public String addChallange(@RequestBody Challange challange) {
        boolean isChallangeAdded = challangeService.addChallange(challange);

        if (isChallangeAdded)
            return "Challange Added Successfully";
        else 
            return "Adding Challange Failed";
    }

    @GetMapping("/month/{month}")
    public ResponseEntity<Challange> getAChallangeByMonth(@PathVariable String month) {
        Challange challange = challangeService.getAChallangeByMonth(month);

        if (challange != null) 
            return new ResponseEntity<>(challange, HttpStatus.OK);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @GetMapping("/id/{id}")
    public ResponseEntity<Challange> getAChallangeById(@PathVariable Long id) {
        Challange challange = challangeService.getAChallangeById(id);

        if (challange != null) 
            return new ResponseEntity<>(challange, HttpStatus.OK);
        else 
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updateAChallange(@PathVariable Long id, @RequestBody Challange updatedChallange) {
        boolean isChallangeUpdated = challangeService.updateAChallange(id, updatedChallange);

        if (isChallangeUpdated) 
            return new ResponseEntity<>("Challange Updated Successfully", HttpStatus.OK);
        else 
            return new ResponseEntity<>("Something went wrong", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteAChallange(@PathVariable Long id) {
        boolean isChallangeDeleted = challangeService.deteleAChallanage(id);

        if (isChallangeDeleted) 
            return new ResponseEntity<>("Challange Deleted Successfully", HttpStatus.OK);
        else 
            return new ResponseEntity<>("Challange Not Found", HttpStatus.NOT_FOUND);
    }
}
