import java.util.Scanner;
import java.util.*;

class oper
{
	double add(double n1,double n2)
	{
		return n1+n2;
	}
	double mns(double n1,double n2)
	{
		return n1-n2;
	}
	double time(double n1,double n2)
	{
		return n1*n2;
	}
	double devide(double n1,double n2)
	{
		return n1/n2;
	}
	void push(Vector a)
	{
		;
	}
	float numpop(Vector<Float> a)//���Ϳ��� ���ڸ� pop�ؼ� ��ȯ�ϴ� �Լ�
	{
		float num;
		num=0;
		if(a.size()>0)
		{
			//System.out.println("Q");
			num=a.get(a.size()-1);
			a.remove(a.size()-1);
		}
		return num; 
	}
	boolean isnum(String str)
	{
		for(int i=0;i<str.length();i++)
		{
			if(Character.isDigit(str.charAt(i))==true)
			{
				
			}
			else return false;
		}
		return true;
	}
	float doop(float a,float b,String op)
	{
		if(op.equals("+"))
			return a+b;
		else if(op.equals("-"))
			return b-a;
		else if(op.equals("*"))
			return a*b;
		else if(op.equals("/"))
			return b/a;
		return 0;
	}
}

public class Sclass extends oper
{
	
	public static void main(String[] args) 
	{
		Sclass s=new Sclass();
		
		Vector<String> stk_str=new Vector<String>();//���������� �޴� ����
		Vector<Integer> stk_int=new Vector<Integer>();
		Vector<String> stk_op=new Vector<String>();//������������ �ٲٸ鼭, �����ڵ��� ��Ƴ��� ����
		Vector<Float> stk_last=new Vector<Float>();//���������� �̿��� ������ ��갪�� �����Ͽ� ��Ƴ��� ����
		HashMap<String,Integer> oprank=new HashMap<String,Integer>();//�����ڵ��� �켱������ ��� �ؽ� ��(��ųʸ�)
		// TODO Auto-generated method stub
		String str="";//��ĳ�ʿ��� �Է¹��� �����ڸ� �ӽ÷� �����ϴ� ����
		oprank.put("+",1);
		oprank.put("-",1);
		oprank.put("*",2);
		oprank.put("/",2);
		oprank.put("(",0);
		Scanner scanner=new Scanner(System.in);
		System.out.println("����(���ڴ� ������ ����)�� �������� �����Ͽ� �Է��ϼ���");
		System.out.println("ex)3 + 2 * 5 =");
		
		
		
		
		//����ϴ� ��Ʈ
		//����������� ������������� ����
		while(str.equals("=")==false)
		{
			str=scanner.next();
			if(str.equals("="))
				break;
			if((s.isnum(str)==true))
			{
				stk_str.add(str);//�ǿ����ڴ� �״�� ���
			}
			else//�������� �� ���ÿ� ��Ƴ��� ����ϴ� ����
			{
				if(str.equals("("))
				{
					stk_op.add(str);
				}
				else if(str.equals(")"))//�ݴ°�ȣ�� ������ ���°�ȣ�� ���������� �����ڸ� ��� pop
				{
					//int i=stk_op.size()-1;
					while((stk_op.get(stk_op.size()-1)).equals("("));
					{
						
						stk_str.add(stk_op.get(stk_op.size()-1));
						stk_op.remove(stk_op.size()-1);
						
					}
					//System.out.println(stk_op.get(stk_op.size()-1));
					stk_op.remove(stk_op.size()-1);//��� �����ϰ��� '('�� ���������Ƿ� �� �� �� pop�ؼ� �������ش�.
				}
				else if(stk_op.isEmpty()==true||oprank.get(str)>oprank.get(stk_op.get(stk_op.size()-1)))//�����ڸ� ������ �켭������ ���� ��� pop�Ͽ� ��º��Ϳ� ����
				{
					stk_op.add(str);
				}
				else
				{
					//������ ���ÿ� �켱������ �� ũ�ų� ���� ���� ���� ��� ���ÿ��� pop�ؼ� ����ϰ� �����ڸ� push
					stk_str.add(stk_op.get(stk_op.size()-1));//�����ڽ��ÿ��� pop�ϴ� ����
					stk_op.remove(stk_op.size()-1);//�����ڽ��ÿ��� pop�ϴ� ����
					stk_op.add(str);//�������Ŀ� ���
				}
			}
		}
		while(stk_op.isEmpty()==false)
		{
			stk_str.add(stk_op.get(stk_op.size()-1));
			stk_op.remove(stk_op.size()-1);
		}
		Iterator<String>it=stk_str.iterator();//string iterator
		/*while(it.hasNext()==true)
		{
			//System.out.println(it.next());
		}*/
		it=stk_str.iterator();
		
		//����������� �������� ���� ������
		while(it.hasNext()==true)
		{
			str=it.next();
			if(s.isnum(str)==true)
				stk_last.add(Float.parseFloat(str));
			else
			{
				stk_last.add(s.doop(s.numpop(stk_last),s.numpop(stk_last),str));
			}
			//System.out.println(stk_last.get(stk_last.size()-1));
		}
		System.out.println(stk_last.get(0));
		
	}

}
