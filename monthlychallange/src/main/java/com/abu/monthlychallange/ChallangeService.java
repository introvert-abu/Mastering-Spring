package com.abu.monthlychallange;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public class ChallangeService {
    private List<Challange> challanges;
    private Long id = 1L;

    ChallangeService () {
        challanges = new ArrayList<>();
    }

    public List<Challange> getAllChallanges() {
        return this.challanges;
    }
    
    public Challange getAChallangeById(Long id) {
        return findChallangeById(id);
    }
    
    public Challange getAChallangeByMonth(String month) {
        return findChallangeByMonth(month);
    }

    public boolean addChallange(Challange challange) {
        if (challange.getMonth() != null && challange.getTask() != null) {
            challange.setId(this.id++);
            challanges.add(challange);
            return true;
        }

        return false;
    }
    
    public boolean updateAChallange(Long id, Challange updatedChallange) {
        Challange challange = findChallangeById(id);

        if (challange != null) {
            challange.setMonth(updatedChallange.getMonth());
            challange.setTask(updatedChallange.getTask());
            return true;
        }
        
        return false;
    }

    public boolean deteleAChallanage(Long id) {
        boolean isChallangeFound = challanges.removeIf(challange -> challange.getId().equals(id));

        return isChallangeFound;
    }

    private Challange findChallangeById(Long id) {
        for (Challange challange : challanges) {
            if (challange.getId().equals(id)) {
                return challange;
            }
        }

        return null;
    }

    private Challange findChallangeByMonth(String month) {
        for (Challange challange : challanges) {
            if (challange.getMonth().equalsIgnoreCase(month)) {
                return challange;
            }
        }

        return null;
    }

}
