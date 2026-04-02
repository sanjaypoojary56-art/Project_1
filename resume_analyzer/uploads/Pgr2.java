import java.io.*;
import java.lang.*;
class Pgr2
{
	public static void main(String[] args)throws IOException
	{
		int i,j,k,len;
		String str;
		String s[]=new String[20];
		DataInputStream in=new DataInputStream(System.in);
		System.out.println("Enter the string:");
		str=in.readLine();
		s=str.split(" ");
		for(i=0;i<s.length;i++)
		{
			len=s[i].length();
			char[] m=new char[len];
			if(len%2==0)
			{
				m=s[i].toCharArray();
				for(j=0;j<len;j+=2)
				{
					char c=m[j];
					m[j]=m[j+1];
					m[j+1]=c;
				}
				s[i]="";
				for(k=0;k<len;k++)
				{
					s[i]+=m[k];	
				}	
			}
			System.out.println(s[i]);
		}
		len=str.length();
		char[] d=new char[len];
		d=str.toCharArray();
		for(i=0;i<n;i++)
		{
			if(Character.isUpperCase(d[i]))
				d[i]=Character.toLowerCase(d[i]);
			else
				d[i]=Character.toUpperCase(d[i]);
		}
		str="";
		for(k=0;k<len;k++)
		{
			str+=d[i];
		}
		System.out.println(str);
	}
}