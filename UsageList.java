/*
it contains
	put(String) (void) - stores string in the list
	get(index)  (String) - gets string from list with index number
	get(String)	(int) - gets index number of string
	getLeastUsed()	(String) - gets least used item in the list
	update()			(void) - orders list according to ussage in the order of most used to least used at the last
*/

package usagelist;
class UsageList
{
	Node head;
	Node tail;
	static class Node
	{
		String data;
		long lastUsed;
		Node next;
		Node previous;
		Node(String d,long time)
		{
			data=d;
			lastUsed=time;
			next=null;
		}
	}
	
	public  void put(String s)
	{
		Node node=new Node(s,System.nanoTime());
		Node next=head;
		if(head==null)
		{
			head=node;
			tail=node;
			node.previous=null;
			node.next=null;
		}
		else
		{
			head.previous=node;
			node.previous=null;
			node.next=head;	
			head=node;
		}
	}
	
	public  void update(Node current)
	{
		if(current.next==null)
		{
			current.previous.next=null;
			tail=current.previous;
		}
		else
		{
			current.previous.next=current.next;
			current.next.previous=current.previous;
		}
		
		Node next=head;
		head=current;
		current.next=next;
		next.previous=current;
	}
	
	public  String getLeastUsed()
	{
		return tail.data;
	}
	
	public  void print()
	{
		Node node=head;
		while(node!=null)
		{
			System.out.println(node.data+" --- "+(System.nanoTime()-node.lastUsed)/(1000*1000*1000)+"  Seconds ago");
			node=node.next;
		}
	}
	
	public  String get(int index)
	{
		Node node=head;
		if(index==0)
		{
			node.lastUsed=System.nanoTime();
			return node.data;
		}
		int i=1;
		node=node.next;
		while(node!=null)
		{
			if(index==i)
			{
				node.lastUsed=System.nanoTime();
				update(node);
				return node.data;
			}
			i++;
			node=node.next;	
		}
		return null;
	}
	
	public  int get(String s)
	{
		int index=0;
		Node node=head;
		if(node.data.equals(s))
		{
			node.lastUsed=System.nanoTime();
			return index;
		}
		index++;
		node=node.next;
		while(node!=null)
		{
			if(node.data.equals(s))
			{
				node.lastUsed=System.nanoTime();
				update(node);
				return index;
			}
			index++;
			node=node.next;	
		}
		return -1;
	}
	

}
