class Node:
    def __init__(self, value):
        self.value=value
        self.next=None
class LinkedList:
    def __init__(self,value):
        new_node=Node(value)
        self.head=new_node
        self.tail=new_node
        self.length=1
    def print(self):
        if(self.head==None):

            print("Linked list is empty")
        else:
            temp=self.head
            while(temp!=None):
                print(temp.value)
                temp=temp.next
    def appendFirst(self,value):
        new_node=Node(value)
        new_node.next=self.head
        self.head=new_node
        self.length+=1
    def removeFirst(self):
        if(self.head==None):
            print("the list is already empty .. There is nothing to remove ")
        else:
            temp=self.head
            self.head=temp.next
            self.length-=1 
    def appendEnd(self,value):
        new_node=Node(value)
        if(self.head==None):
            self.head=new_node
        else:
            temp=self.head
            while(temp.next!=None):
                temp=temp.next
            temp.next=new_node
        self.length+=1    
    def removeEnd(self):
        if(self.head==None):
            print("List is already empty and there is nothing to remove")
        elif(self.head.next==None):
            self.head=None
            self.length-=1
        else:
            temp=self.head
            while(temp.next.next!=None):
                temp=temp.next
            temp.next=None
            self.length-=1
        pass
    def addIndexElement(self,value,index):
        new_node = Node(value)
        count=index
        if(index==0):
            print("The position starts from 1, seems like you entered 0, so the process is interrupted")
            
        elif index == 1 :
            new_node.next=self.head
            self.head=new_node
            self.length+=1
        else:
            temp=self.head
            prev=self.head
            while(temp!=None and count!=0):
                prev=temp
                count=count-1
                temp=temp.next
            if(count>0):
                print("Index is out of range")
            else:
                prev.next=new_node
                new_node.next=temp
                self.length+=1
            
    def removeIndexElement(self,index):
        count=index
        if(index==0):
                print("The position starts from 1, seems like you entered 0, so the process is interrupted")
        elif(index==1):
            self.head=None
        else:
            temp=self.head
            prev=self.head
            while(temp.next!=None and count>0):
                prev=temp
                count=count-1
                temp=temp.next
            
            if(count>1):
                print("Index is out of range")
            elif(temp==None and count==1):
                prev=None
                self.length-=1
            else:
                prev.next=temp.next
                temp=None
                self.length-=1
    def Search(self,value):
        temp=self.head
        count=1
        while(temp!=None):
            if(temp.value==value):
                print("The Number is found")
                count-=1
            temp=temp.next
        if(count==1):
            print("Number not Found in List")
    def getElement(self,index):
        temp=self.head
        count=index
        while(temp!=None and count>0):
            temp=temp.next
            count=count-1
        if(count>0):
            print("Index is out of range")
        else:
            return temp.value    
    def reverseList(self):
        current = self.head
        prev = None
        while current is not None:
            next_node = current.next
            current.next = prev
            prev = current
            current = next_node
        self.tail = self.head  # Update the tail to the original head
        self.head = prev  # Update the head to the last element
        
print("After adding first element to the list ie., 2")       
list=LinkedList(2)
list.print()
print(" The length of the list :",list.length)
print("After apending first element to the list ie., 5 before 2")  
list.appendFirst(5)
list.print()
print(" The length of the list :",list.length)
print("After removing first element to the list ie., 5")  
list.removeFirst()
list.print()
print(" The length of the list :",list.length)
print("After appending element at the end ie., 8")
list.appendEnd(8)
list.print()
print(" The length of the list :",list.length)
print("After appending element at the end ie., 7")
list.appendEnd(7)
list.print()
print(" The length of the list :",list.length)
print("After removing element at the end ie., 7")
list.removeEnd()
list.print()
print(" The length of the list :",list.length)
print("Second round")
list.removeEnd()
list.print()
print(" The length of the list :",list.length)
print("Third round")
list.removeEnd()
list.print()
print(" The length of the list :",list.length)
print("Adding some more elements 1,2,3,4,5")
list.appendEnd(1)
list.appendEnd(2)
list.appendEnd(3)
list.appendEnd(4)
list.appendEnd(5)
list.print()
print(" The length of the list :",list.length)
print("Adding element at particular index")
list.addIndexElement(8,3)
list.print()
print(" The length of the list :",list.length)
print(" Deleting a element in particular position")
list.removeIndexElement(6)
list.print()

print(" The length of the list :",list.length)
list.Search(10)
n=3
print(" The element at index ",n, " is ",list.getElement(n))
print("Reversing the linked List")
list.reverseList()
list.print()