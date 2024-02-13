class Node:
    def __init__(self, value):
        self.value = value
        self.next = None
        

class LinkedList:
    def __init__(self, value):
        new_node = Node(value)
        self.head = new_node
        self.tail = new_node

        
    def append(self, value):
        new_node = Node(value)
        if self.head == None:
            self.head = new_node
            self.tail = new_node
        else:
            self.tail.next = new_node
            self.tail = new_node
        return True
  
  
def find_kth_from_end(list,k):
    temp1=list.head
    temp2=list.head
    count=k
    if not list:
        print("linked list is empty")
    while count!=0 and temp1 is not None:
        temp1=temp1.next
        count-=1
    if(temp1 is None):
        return None
    while temp1 is not None:
        temp1=temp1.next
        temp2=temp2.next
    return temp2




my_linked_list = LinkedList(1)
my_linked_list.append(2)
my_linked_list.append(3)
my_linked_list.append(4)
my_linked_list.append(5)


k = 2
result = find_kth_from_end(my_linked_list, k)

print(result.value)  # Output: 4



"""
    EXPECTED OUTPUT:
    ----------------
    4
    
"""

