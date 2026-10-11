package Graph;

/*
Given a list of accounts where each element accounts[i] is a list of strings, where the first element accounts[i][0] is a name, and the rest of the elements are emails representing emails of the account.

Now, we would like to merge these accounts. Two accounts definitely belong to the same person if there is some common email to both accounts. Note that even if two accounts have the same name, they may belong to different people as people could have the same name. A person can have any number of accounts initially, but all of their accounts definitely have the same name.

After merging the accounts, return the accounts in the following format: the first element of each account is the name, and the rest of the elements are emails in sorted order. The accounts themselves can be returned in any order.



Example 1:

Input: accounts = [["John","johnsmith@mail.com","john_newyork@mail.com"],["John","johnsmith@mail.com","john00@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Output: [["John","john00@mail.com","john_newyork@mail.com","johnsmith@mail.com"],["Mary","mary@mail.com"],["John","johnnybravo@mail.com"]]
Explanation:
The first and second John's are the same person as they have the common email "johnsmith@mail.com".
The third John and Mary are different people as none of their email addresses are used by other accounts.
We could return these lists in any order, for example the answer [['Mary', 'mary@mail.com'], ['John', 'johnnybravo@mail.com'],
['John', 'john00@mail.com', 'john_newyork@mail.com', 'johnsmith@mail.com']] would still be accepted.
 */

import java.util.*;

/*
Time Complexity: O(A+ElogE)
A->Number of accounts
E->Number of emails across accounts

Space Complexity: O(U+A)
U->Number of unique emails
 */
public class AccountMerge {
    static class DisJointSet {
        int[] parent;
        int[] rank;

        public DisJointSet(int n) {
            parent = new int[n];
            rank = new int[n];
            for (int i = 0; i < n; i++) {
                parent[i] = i;
            }
        }

        public int findUltimateParent(int node) {
            if (parent[node] == node) {
                return node;
            }
            parent[node] = findUltimateParent(parent[node]);
            return parent[node];
        }

        public void unionByRank(int u, int v) {
            int rootU = findUltimateParent(u);
            int rootV = findUltimateParent(v);
            if (rootU == rootV) {
                return;
            }
            if (rank[rootU] < rank[rootV]) {
                parent[rootU] = rootV;
            } else if (rank[rootV] < rank[rootU]) {
                parent[rootV] = rootU;
            } else {
                parent[rootV] = rootU;
                rank[rootU]++;
            }
        }
    }

    private static List<List<String>> accountsMerge(List<List<String>> accounts) {
        int n = accounts.size();
        DisJointSet ds = new DisJointSet(n);
        Map<String, Integer> emailToAccount = new HashMap<>();
        //Union account that share an email
        for (int i = 0; i < n; i++) {
            List<String> account = accounts.get(i);
            //iterating email hence starting from 1
            for (int j = 1; j < account.size(); j++) {
                String email = account.get(j);
                if (emailToAccount.containsKey(email)) {
                    ds.unionByRank(i, emailToAccount.get(email));
                } else {
                    emailToAccount.put(email, i);
                }
            }
        }

        //Group emails by DSU root
        Map<Integer, List<String>> mergedEmails = new HashMap<>();
        for (Map.Entry<String, Integer> entry : emailToAccount.entrySet()) {
            String email = entry.getKey();
            int accountIndex = entry.getValue();
            int root = ds.findUltimateParent(accountIndex);
            if (!mergedEmails.containsKey(root)) {
                // If this is the first email encountered for this component,
                // create a new empty list and associate it with the root.
                mergedEmails.put(root, new ArrayList<>());
            }
            mergedEmails.get(root).add(email);
        }

        //Sort emails and build the result
        List<List<String>> result = new ArrayList<>();
        for (Map.Entry<Integer, List<String>> entry : mergedEmails.entrySet()) {
            int root = entry.getKey();
            List<String> emails = entry.getValue();
            Collections.sort(emails);
            List<String> mergedAccount = new ArrayList<>();
            mergedAccount.add(accounts.get(root).get(0));
            mergedAccount.addAll(emails);
            result.add(mergedAccount);
        }
        return result;

    }

    public static void main(String[] args) {
        List<List<String>> accounts = new ArrayList<>();
        accounts.add(
                Arrays.asList(
                        "John",
                        "johnsmith@mail.com",
                        "john_newyork@mail.com"
                )
        );
        accounts.add(
                Arrays.asList(
                        "John",
                        "johnsmith@mail.com",
                        "john00@mail.com"
                )
        );
        accounts.add(
                Arrays.asList(
                        "Mary",
                        "mary@mail.com"
                )
        );
        accounts.add(
                Arrays.asList(
                        "John",
                        "johnybravo@mail.com"
                )
        );
        List<List<String>> result = accountsMerge(accounts);
        for (List<String> account : result) {
            System.out.println(account);
        }

    }
}
