package com.corner.util.tools;

public class Test
{
	public static void main(String[] args)
	{
		int a=536;
		System.out.println(a/100);
		System.out.println((a-a/100*100)/10);
		System.out.println(a-a/100*100-(a-a/100*100)/10*10);
	}
}
