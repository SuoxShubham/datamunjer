package com.stackroute.datamunger;
/*There are total 5 DataMungertest files:
 * 
 * 1)DataMungerTestTask1.java file is for testing following 3 methods
 * a)getSplitStrings()  b) getFileName()  c) getBaseQuery()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask1.java
 * 
 * 2)DataMungerTestTask2.java file is for testing following 3 methods
 * a)getFields() b) getConditionsPartQuery() c) getConditions()
 * 
 * Once you implement the above 3 methods,run DataMungerTestTask2.java
 * 
 * 3)DataMungerTestTask3.java file is for testing following 2 methods
 * a)getLogicalOperators() b) getOrderByFields()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask3.java
 * 
 * 4)DataMungerTestTask4.java file is for testing following 2 methods
 * a)getGroupByFields()  b) getAggregateFunctions()
 * 
 * Once you implement the above 2 methods,run DataMungerTestTask4.java
 * 
 * Once you implement all the methods run DataMungerTest.java.This test case consist of all
 * the test cases together.
 */
import java.util.*;

public class DataMunger {
	/*
	 * This method will split the query string based on space into an array of words
	 * and display it on console
	 */

	public String[] getSplitStrings(String queryString) {
		String arr[] = queryString.toLowerCase().split(" ");

		return arr;
	}

	/*
	 * Extract the name of the file from the query. File name can be found after a
	 * space after "from" clause. Note: ----- CSV file can contain a field that
	 * contains from as a part of the column name. For eg: from_date,from_hrs etc.
	 * 
	 * Please consider this while extracting the file name in this method.
	 */

	public String getFileName(String queryString) {
		String temp = "";
		int i;
		for(i=0;i<queryString.length();i++) {
			temp = temp+ queryString.charAt(i);
			if(queryString.charAt(i)==' '|| i==queryString.length()-1) {
				if(temp.indexOf('.')!=-1) {
					break;
				}
				else {
					temp ="";
				}
			}
		}
		return temp.trim();
	}

	/*
	 * This method is used to extract the baseQuery from the query string. BaseQuery
	 * contains from the beginning of the query till the where clause
	 * 
	 * Note: ------- 1. The query might not contain where clause but contain order
	 * by or group by clause 2. The query might not contain where, order by or group
	 * by clause 3. The query might not contain where, but can contain both group by
	 * and order by clause
	 */
	
	public String getBaseQuery(String queryString) {
		String temp[] = queryString.split("where");
		String t1="";
			t1=t1+temp[0].trim();
		return t1;
	}

	/*
	 * This method will extract the fields to be selected from the query string. The
	 * query string can have multiple fields separated by comma. The extracted
	 * fields will be stored in a String array which is to be printed in console as
	 * well as to be returned by the method
	 * 
	 * Note: 1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The field
	 * name can contain '*'
	 * 
	 */
	
	public String[] getFields(String queryString) {
		String temp[]= queryString.split("from");
		int i;
		String str[]= temp[0].split("select");
		String str1[]= str[1].split(",");
		String t[]= new String[str1.length];

		for(i=0;i<str1.length;i++) {

			t[i]= str1[i].trim();
		}
		return t;
	}

	/*
	 * This method is used to extract the conditions part from the query string. The
	 * conditions part contains starting from where keyword till the next keyword,
	 * which is either group by or order by clause. In case of absence of both group
	 * by and order by clause, it will contain till the end of the query string.
	 * Note:  1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
	 * might not contain where clause at all.
	 */
	
	public String getConditionsPartQuery(String queryString) {
		String temp[] = queryString.split("where");
		String t1="";
		t1=t1+temp[1].trim().toLowerCase();
		return t1;
	}

	/*
	 * This method will extract condition(s) from the query string. The query can
	 * contain one or multiple conditions. In case of multiple conditions, the
	 * conditions will be separated by AND/OR keywords. for eg: Input: select
	 * city,winner,player_match from ipl.csv where season > 2014 and city
	 * ='Bangalore'
	 * 
	 * This method will return a string array ["season > 2014","city ='bangalore'"]
	 * and print the array
	 * 
	 * Note: ----- 1. The field name or value in the condition can contain keywords
	 * as a substring. For eg: from_city,job_order_no,group_no etc. 2. The query
	 * might not contain where clause at all.
	 */

	public String[] getConditions(String queryString) {
//		String temp[] = queryString.split("where");
//		String str = temp[1];
//		int i,j=0;
//		String s="",val=" ";
//		for(i=0;i<str.length();i++) {String temp[]= queryString.split("from");
//
//		String str[]= temp[0].split("select");
//		String str1[]= str[1].split(",");
//		String t[]= new String[str1.length];
//		for(i=0;i<str1.length;i++) {
//			if(str1[i].indexOf("count")!=-1||str1[i].indexOf("sum")!=-1||str1[i].indexOf("min")!=-1||str1[i].indexOf("max")!=-1||str1[i].indexOf("avg")!=-1)
//			t[i]= str1[i].trim();
//		}
//			s = s + str.charAt(i);
//			if (str.charAt(i) == ' ' || i == str.length() - 1) {
//				if (s.trim().equals("and") || s.trim().equals("or") || s.trim().equals("not") || s.trim().equals("AND") || s.trim().equals("OR") || s.trim().equals("NOT")) {
//					s = "";
//				} else {
//					j++;
//					val = s + val;
//				}
//			}
//		}
//		String temp1[] = val.trim().split(" ");
//		return temp1;
		return null;
	}

	/*
	 * This method will extract logical operators(AND/OR) from the query string. The
	 * extracted logical operators will be stored in a String array which will be
	 * returned by the method and the same will be printed Note:  1. AND/OR
	 * keyword will exist in the query only if where conditions exists and it
	 * contains multiple conditions. 2. AND/OR can exist as a substring in the
	 * conditions as well. For eg: name='Alexander',color='Red' etc. Please consider
	 * these as well when extracting the logical operators.
	 *
	 */

	public String[] getLogicalOperators(String queryString) {
		String temp = "",str1=" ";
		int i,j=0;
		for (i = 0; i < queryString.length(); i++) {
			temp = temp + queryString.charAt(i);
			if (i == queryString.length() - 1 || queryString.charAt(i) == ' ') {
				if (temp.trim().equals("and") || temp.trim().equals("or") || temp.trim().equals("not") || temp.trim().equals("AND") || temp.trim().equals("OR") || temp.trim().equals("NOT")) {
//					str[0] = str[0] + temp.trim();
					str1=str1+temp;
					j++;
					temp = "";
				} else {
					temp = "";
				}
			}
		}
		String arr[]=str1.trim().split(" ");
		String str2[]= new String[arr.length];
		for(i=0;i<arr.length;i++) {
			str2[i]= arr[i].trim();
		}
			if(j>0)
			return str2;
			else
				return null;
	}

	/*
	 * This method extracts the order by fields from the query string. Note: 
	 * 1. The query string can contain more than one order by fields. 2. The query
	 * string might not contain order by clause at all. 3. The field names,condition
	 * values might contain "order" as a substring. For eg:order_number,job_order
	 * Consider this while extracting the order by fields
	 */

	public String[] getOrderByFields(String queryString) {
		String temp[]=queryString.split("order by");
		String str[]=new String[1];
		int j=0;
		if(temp.length!=1) {
			str[0] = temp[1].trim();
			j++;
		}
		if(j>0)
		return str;
		else
			return null;
	}

	/*
	 * This method extracts the group by fields from the query string. Note:
	 * 1. The query string can contain more than one group by fields. 2. The query
	 * string might not contain group by clause at all. 3. The field names,condition
	 * values might contain "group" as a substring. For eg: newsgroup_name
	 * 
	 * Consider this while extracting the group by fields
	 */

	public String[] getGroupByFields(String queryString) {
		int a = queryString.indexOf("where");
		int c=0;
		String str[]=new String[1];
		if(a!=-1)
		{
			String temp[]=queryString.split("group by");
			if(temp.length!=1) {
				str[0] = temp[1].trim();
				c++;
			}
		}
			if(c>0)
				return str;
			else
				return null;
	}

	/*
	 * This method extracts the aggregate functions from the query string. Note:
	 *  1. aggregate functions will start with "sum"/"count"/"min"/"max"/"avg"
	 * followed by "(" 2. The field names might
	 * contain"sum"/"count"/"min"/"max"/"avg" as a substring. For eg:
	 * account_number,consumed_qty,nominee_name
	 * 
	 * Consider this while extracting the aggregate functions
	 */

	public String[] getAggregateFunctions(String queryString) {
		String input=queryString.toLowerCase();
		ArrayList<String> temp1=new ArrayList<String>();
		if(input.contains("("))
		{
			String[] temp=input.split(" |,");
			for(int i=0;i<temp.length;i++)
			{
				if(temp[i].endsWith(")"))
					temp1.add(temp[i]);
			}
			String[] result=temp1.toArray(new String[0]);
			return  result;
		}        return null;

	}

}