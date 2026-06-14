class Solution {
    public boolean isPalindrome(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;
        while(fast!=null&& fast.next!=null)
        {
            slow = slow.next;
            fast = fast.next.next;
        }
        // Reverse the second half 
        ListNode prev = null;
        ListNode curr = slow;
        
        while(curr!=null)
        {
     ListNode front = curr.next;
        curr.next = prev;
        prev = curr;
        curr = front;
        }
// comparison
ListNode first = head;
ListNode second = prev;
  while(second != null)
  {
    if(first.val!=second.val)
    {
    return false;
  }
  first = first.next;
  second = second.next;
    }
    return true;
    }
}
    

