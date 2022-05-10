package com.javaex.ex01;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class PhoneBook {

	public static void main(String[] args)throws IOException{
		
		List<Person> pList = new ArrayList<>();
		
		
		Reader rd = new FileReader("./PhoneDB.txt");
		BufferedReader br = new BufferedReader(rd);
		
		Scanner sc = new Scanner(System.in);
		
		String name = null;
		String hp = null;
		String company = null;
		
		while(true) {
			
			String str = br.readLine(); //한줄씩 읽어줌  ***********다시*************
			
			if(str == null) {
				break;
			}
			String[] sArray = str.split(",");
			name =sArray[0]  ;
			hp = sArray[1] ;
			company = sArray[2]  ;
			
			pList.add(new Person (name,hp,company)); // ***********다시*************
		}
		
		
		while(true) {
		System.out.println("******************************");
		System.out.println("*       전화번호 관리 프로그램      *");
		System.out.println("******************************");
		
		System.out.println("1.리스트 2.등록 3.삭제 4.검색 5.종료");
		System.out.println("------------------------------");
		System.out.println(">메뉴번호:");
		int num = sc.nextInt();
		
			if(num == 5) {
				System.out.println("******************************");
				System.out.println("*           감사합니다.          *");
				System.out.println("******************************");
				break;
			}else if(num ==1) {
				System.out.println("<1.리스트>");
				for(int i=0; i<pList.size();i++){				
					System.out.println(i+1+"."+pList.get(i).getName()+pList.get(i).getHp()+pList.get(i).getCompany());
				}
				}else if(num == 2) {
					Writer fw = new FileWriter("./PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(fw);
					System.out.println("<2.등록>");
					
					System.out.println("이름: ");
					name = sc.next();
					
					System.out.println("전화번호: ");
					hp = sc.next();
					
					System.out.println("회사번호: ");
					company = sc.next();
					
					pList.add(new Person(name,hp,company));
					System.out.println("[등록완료]");
					
					for(Person add : pList) {
						String str = add.getName()+add.getHp()+add.getCompany();
						bw.write(str);
						bw.newLine();
					}
					bw.close();
				}else if(num==3) {
					Writer wt = new FileWriter("./PhoneDB.txt");
					BufferedWriter bw = new BufferedWriter(wt);
					System.out.println("3.삭제");
					
					System.out.println("번호:");
					num = sc.nextInt();
					
					pList.remove(num-1);  // 다시 배열이랑 같이 스타트
					System.out.println("삭제완료");
					
					for(Person minus : pList) {
						String str01 = minus.getName()+minus.getHp()+minus.getCompany();
						bw.write(str01);
						bw.newLine();
					}
					bw.close();
				}else if(num==4) {
					System.out.println("검색");
					System.out.println("이름:");
					name = sc.next();
					
					for(int i=0; i<pList.size();i++) {
						if(pList.get(i).getName().contains(name)) {
							System.out.println(i+1+pList.get(i).getName()+pList.get(i).getHp()+pList.get(i).getCompany());
						}
					}
				}else {
						System.out.println("틀린 번호 입니다. 다시 입력해 주세요.");
					}
				}
		
		
		
		
		
		
		
		
		
		
		sc.close();
		br.close();
		
	
		}
		
	}


