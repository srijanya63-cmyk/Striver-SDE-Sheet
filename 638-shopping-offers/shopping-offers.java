
import java.util.*;

class Solution {
    Map<List<Integer>, Integer> dp = new HashMap<>();

    public int shoppingOffers(List<Integer> price,
                              List<List<Integer>> special,
                              List<Integer> needs) {

        return solve(price, special, needs);
    }

    private int solve(List<Integer> price,
                      List<List<Integer>> special,
                      List<Integer> needs) {

        if (dp.containsKey(needs)) {
            return dp.get(needs);
        }

        // Buy all items individually
        int minCost = 0;

        for (int i = 0; i < needs.size(); i++) {
            minCost += needs.get(i) * price.get(i);
        }

        // Try every special offer
        for (List<Integer> offer : special) {
            List<Integer> remaining = new ArrayList<>(needs);
            boolean valid = true;

            for (int i = 0; i < needs.size(); i++) {
                if (offer.get(i) > needs.get(i)) {
                    valid = false;
                    break;
                }

                remaining.set(i,
                    needs.get(i) - offer.get(i));
            }

            if (valid) {
                minCost = Math.min(minCost,
                    offer.get(needs.size())
                    + solve(price, special, remaining));
            }
        }

        dp.put(new ArrayList<>(needs), minCost);
        return minCost;
    }
}
