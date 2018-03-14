import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.regex.*;
class WordFrequency{
	public static void main(String args[])throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		System.out.println("Enter the Paragraph of text");
		String p=br.readLine();
		//System.out.println(p)
		Pattern pa = Pattern.compile("[a-zA-Z]+");
		Matcher m1 = pa.matcher(p);
		m1.find();
		Node root=new Node(m1.group());
		while(m1.find()){
			Node temp=root,prev=null;
			String s=m1.group();
			int r=0;
			while(temp!=null){
				r=s.compareToIgnoreCase(temp.s);
				if(r==0){
					temp.freq++;
					break;
				}
				else if(r<0){
					prev=temp;
					temp=temp.left;
				}
				else if(r>0){
					prev=temp;
					temp=temp.right;
				}
			}
			if(r<0)
				prev.left=new Node(s);
			else if(r>0)
				prev.right=new Node(s);
		}
		Node temp=root,prev=null;
		System.out.println("Word\t\tFrequency");
		print(temp);
	}
	static void print(Node temp){
		if(temp==null)
			return;
		System.out.println(temp.s+"\t\t"+temp.freq);
		print(temp.left);
		print(temp.right);
	}
}
class Node{
	String s;
	Node left,right;
	int freq;
	Node(String s){
		this.s=s;
		left=null;
		right=null;
		freq=1;
	}
}
