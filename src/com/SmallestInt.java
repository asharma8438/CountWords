package com;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SmallestInt {

	public static void main(String args[]){

		int A[] = {-1,-3,0,1};

		System.out.println("Min="+solution(A));
	}

	public static int solution(int[] A){
		List<Integer> al = Arrays.stream(A).sorted().boxed().collect(Collectors.toList());
		List<Integer> negativeL = new ArrayList<Integer>();
		List<Integer> positiveL = new ArrayList<Integer>();

		al.forEach(a -> {
			//System.out.println(a);
			if(a <0 && !negativeL.contains(a)){
				negativeL.add(a);
			}
			else if(!positiveL.contains(a)){
				positiveL.add(a);
			}
		});

		positiveL.forEach(System.out::println);
		negativeL.forEach(System.out::println);

		int min = 1;

		for(Integer i : positiveL){
			/*if(i==0){
				System.out.println("0=i=="+i);
				min=1;
			}*/
			if(i==min ){
				System.out.println("min=i=="+i);
				min=min+1;
			}
			else
			{
				System.out.println("return=="+min);
				return min;	
			}
		}

		return min;		
	}
}

