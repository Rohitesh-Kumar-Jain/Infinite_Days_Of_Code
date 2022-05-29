import java.math.*;   

class Solution {
    public String discountPrices(String sentence, int discount) {
        String[] words = sentence.split(" ");
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (isPrice(word) == true) {
                BigDecimal price = new BigDecimal(word.substring(1, word.length()));
                double dis = (double)(100 - discount);
                price = price.multiply(new BigDecimal(dis));
                price = price.setScale(2, RoundingMode.CEILING);
                price = price.divide(new BigDecimal(100));
                String newPrice = price.toString();
                newPrice = "$" + newPrice;
                words[i] = newPrice;
            }
        }
        
        String ans = "";
        for (String word : words) {
            ans = ans + word + " ";
        }
        
        return ans.substring(0, ans.length() - 1);
    }
    
    private boolean isPrice (String word) {
        if (word.charAt(0) != '$' || word.length() == 1) return false;
        
        for (int i = 1; i < word.length(); i++) {
            if (!Character.isDigit(word.charAt(i))) return false;
        }
        
        return true;
    }
}