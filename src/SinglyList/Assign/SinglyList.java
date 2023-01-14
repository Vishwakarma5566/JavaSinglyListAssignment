package SinglyList.Assign;

import java.util.Scanner;

public class SinglyList {
	Node head;
	Node tail;
	
	private static class Student{
		private String name;
		private String roll;
		private double pct;
		Student(String name, String roll, double pct){
			this.name=name;
			this.roll=roll;
			this.pct=pct;
		}
		
		//GETTERS AND SETTERS

		public String getName() {
			return name;
		}

		public String getRoll() {
			return roll;
		}

		public double getPct() {
			return pct;
		}

//		public void setName(String name) {
//			this.name = name;
//		}
//
//		public void setRoll(String roll) {
//			this.roll = roll;
//		}

		public void setPct(double pct) {
			this.pct = pct;
		}
		
	}
	public SinglyList() {
		this.head=null;
		this.tail=null;
	}
	 
	private static class Node{
		Student data;
		Node next;
		Node(Student data){
			this.data=data;
		}
	}
	public void addSorted(Student x) {
		Node node = new Node(x);
		Node p = head;
		int count=0;
		if(head==null) {
			head=tail=node;
		}
		else if(node.data.getPct()<p.data.getPct()) {
			node.next=head;
			head=node;
		}
		else {
			while (p!=null) {
				if(node.data.getPct()>=p.data.getPct()) {
					count++;
				}
				p=p.next;
			}
			if(count==length()) {
				tail.next=node;
				tail=node;
			}
			else {
				Node p2=head;
				while(--count>0) {
					p2=p2.next;
				}
				node.next=p2.next;
				p2.next=node;
			}
		}
 	}
	public int length() {
		Node pNode = head;
		int count=0;
		while(pNode!=null) {
			pNode=pNode.next;
			count++;
		}
		return count;
	}
	public void deletfirst() {
		Node head2=head;
		if(head2==null) {
			return;
		}
		else {
			if(head2==tail) {
				head2=null;
				tail=null;
			}
			else {
				head2=head2.next;
			}
		}
	}
	public void delete(String rroll) {
		Node pNode=head;
		int count=0;
		if(pNode.data.getRoll().equals(rroll)) {
			System.out.println("Rollno exist ");
			System.out.println("Data after deleting rollno "+rroll+" :");
			pNode=pNode.next;
			head=pNode;
		}
		else {
			while (pNode!=null) {
				if(pNode.data.getRoll().equals(rroll)) {
					break;
				}
				else {
					count++;
				}
				pNode=pNode.next;
			}
//			System.out.println(count);
			if(count>=length()) {
				System.out.println("Rollno not found ");
			}
			else {
				System.out.println("Rollno exist ");
			}
			if(count==(length()-1)) {
				Node p=head;
				while(--count>0) {
					p=p.next;
				}
				System.out.println("Data after deleting rollno "+rroll+":");
				p.next=null;
				tail=p;
			}
			else if(count<(length()-1)) {
				Node p=head;
				while(--count>0) {
					p=p.next;
				}
				System.out.println("Data after deleting rollno "+rroll+":");
				p.next=p.next.next;
			}
		}
	}
	public void set(String roll, double pct) {
		Node p = head;
		int count=0;
		while(p!=null) {
			if( p.data.getRoll().equals(roll)) {
				p.data.setPct(pct);
				count++;
			}
			p=p.next;
		}
		if (count==0) {
			System.out.println("Rollno not exist ");
		}
	}
	public String sortAgain(String roll) {
		Node pNode =head;
		String sname="h";
		while(pNode!=null) {
			if( pNode.data.getRoll().equals(roll)) {
				sname=pNode.data.getName();
			}
			pNode=pNode.next;
		}
		return sname;
	}
	public void display() {
		Node p=head;
		while(p!=null) {
			System.out.println(p.data.getName()+" " + p.data.getRoll() +" "+ p.data.getPct());
			p=p.next;
		}
	}

	public static void main(String[] args) {
		SinglyList sl = new SinglyList();
		Scanner input = new Scanner(System.in);
		Student stu1 = new Student("Amit","1",88D);
		Student stu2 = new Student("Rama","2",86D);
		Student stu3 = new Student("Naman","3",87D);
		Student stu4 = new Student("Shyam","4",89D);
		Student stu5 = new Student("Rahul","5",80D);
		Student stu6 = new Student("Deepak","6",78D);
		Student stu7 = new Student("Harsh","7",98D);
		Student stu8 = new Student("Aryan","8",92D);
		Student stu9 = new Student("Ayush","9",92D);
		Student stu10 = new Student("Keshav","10",94D);
		Student stu11 = new Student("Praveen","11",77D);
		
		sl.addSorted(stu1);
		sl.addSorted(stu2);
		sl.addSorted(stu3);
		sl.addSorted(stu4);
		sl.addSorted(stu5);
		sl.addSorted(stu6);
		sl.addSorted(stu7);
		sl.addSorted(stu8);
		sl.addSorted(stu9);
		sl.addSorted(stu10);
		sl.addSorted(stu11);
		
		
		sl.display();
//		System.out.println(sl.length());
		
		System.out.print("Enter rollno number to delete: ");
		String sroll = input.next();
		sl.delete(sroll);
		System.out.println();
		
		sl.display();
		
		System.out.print("Enter rollno and percent for reset: ");
		String sroll2 = input.next();
		Double pct1 = input.nextDouble();
		sl.set(sroll2,pct1);
		
		
		String name = sl.sortAgain(sroll2);
		
		sl.delete(sroll2);
		Student sortagain = new Student(name,sroll2,pct1);
		sl.addSorted(sortagain);
		
		System.out.println("\n");
		System.out.println("Data after updating percentage of rollno "+sroll2+":"+"\n");
		
		sl.display();

	}

}


