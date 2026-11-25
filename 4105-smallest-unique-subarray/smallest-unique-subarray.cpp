class Solution {
public:
    static const long long MOD1 = 1000000007;
    static const long long MOD2 = 998244353;
    static const long long BASE = 233;

    vector<long long> h1, h2, p1, p2;

    long long getHash(int l, int r) {
        long long x = (h1[r] - h1[l] * p1[r-l] % MOD1 + MOD1) % MOD1;
        long long y = (h2[r] - h2[l] * p2[r-l] % MOD2 + MOD2) % MOD2;
        return x * MOD2 + y;
    }

    bool check(int len) {
        unordered_map<long long, int> mp;

        for (int i = 0; i + len <= h1.size() - 1; i++) {
            long long hash = getHash(i, i + len);
            mp[hash]++;
        }

        for (auto &it : mp) {
            if (it.second == 1)
                return true;
        }

        return false;
    }

    int smallestUniqueSubarray(vector<int>& nums) {
        int n = nums.size();

        h1.assign(n + 1, 0);
        h2.assign(n + 1, 0);
        p1.assign(n + 1, 1);
        p2.assign(n + 1, 1);

        for (int i = 0; i < n; i++) {
            h1[i+1] = (h1[i] * BASE + nums[i]) % MOD1;
            h2[i+1] = (h2[i] * BASE + nums[i]) % MOD2;

            p1[i+1] = p1[i] * BASE % MOD1;
            p2[i+1] = p2[i] * BASE % MOD2;
        }

        int low = 1, high = n, ans = n;

        while (low <= high) {
            int mid = low + (high - low) / 2;

            if (check(mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }

        return ans;
    }
};
