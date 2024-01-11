package org.example;
import java.util.HashMap;
import java.util.Map;

public class Zoo {
    private Map<String, Integer> discounts = new HashMap<>();
//    private Map<String, String> visitorFeedbackMap = new HashMap<>();
//    public Map<String, String> getVisitorFeedbackMap() {
//        return visitorFeedbackMap;
//    }


    public Map<String, Integer> getDiscounts() {
        return discounts;
    }

    public void addDiscount(String discountName, int discountPercent) {
        discounts.put(discountName, discountPercent);
    }

    public void removeDiscount(String discountName) {
        discounts.remove(discountName);
    }
}




//    public void collectVisitorFeedback(String scanner) {
//
//            visitorFeedbackMap.put("VisitorFeedback", scanner);
//
//    }





//    private int minorDiscount = 0.10; // 10% discount for minors
//    private int seniorDiscount = 0.20; // 20% discount for senior citizens
//
//    public int getMinorDiscount() {
//        return minorDiscount;
//    }
//
//    public void setMinorDiscount(int minorDiscount) {
//        this.minorDiscount = minorDiscount;
//    }
//
//    public int getSeniorDiscount() {
//        return seniorDiscount;
//    }
//
//    public void setSeniorDiscount(int seniorDiscount) {
//        this.seniorDiscount = seniorDiscount;
//    }

