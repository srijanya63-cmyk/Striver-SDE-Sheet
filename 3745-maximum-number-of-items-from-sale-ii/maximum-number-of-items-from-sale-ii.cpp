
class Solution {
public:
    int maximumSaleItems(vector<vector<int>>& items, int budget) {
        int n = items.size();

        // Step 1: Count frequency of each factor
        vector<int> freq(n + 1, 0);

        int minPrice = INT_MAX;

        for (auto &item : items) {
            freq[item[0]]++;
            minPrice = min(minPrice, item[1]);
        }

        // Step 2: Count how many items each factor can unlock
        vector<int> gain(n + 1, 0);

        for (int i = 1; i <= n; i++) {
            for (int j = i; j <= n; j += i) {
                gain[i] += freq[j];
            }

            gain[i]--; // Exclude the item itself
        }

        // Step 3: Group bonus purchases by price
        map<int, long long> bonus;

        for (auto &item : items) {
            int factor = item[0];
            int price = item[1];

            if (gain[factor] > 0 && price < 2LL * minPrice) {
                bonus[price] += gain[factor];
            }
        }

        // Step 4: Greedily purchase cheapest bonus items
        long long ans = 0;

        for (auto &[price, count] : bonus) {
            long long take = min(count, (long long)budget / price);

            ans += 2 * take;
            budget -= take * price;
        }

        // Step 5: Spend remaining budget on cheapest item
        ans += budget / minPrice;

        return (int)ans;
    }
};
