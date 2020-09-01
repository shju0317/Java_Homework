package com.callor.book.service;

import java.util.Scanner;

public class BookServiceV1 {

	private Scanner scan;
	private String strBCode;
	private String strBName;

	public BookServiceV1() {
		scan = new Scanner(System.in);
		strBCode = "";
		strBName = "";
	}

	public void inputMain() {
		while (true) {
			System.out.println("================================");
			System.out.println("도서정보관리");
			System.out.println("--------------------------------");

			this.strBCode = this.inputBCode();

			if (strBCode.equals("QUIT")) {
				break;
			}

			this.strBName = this.inputBName();

			if (strBName.equals("QUIT")) {
				break;
			}

			System.out.println("================================");
			this.printBookInfo();
		}
		System.out.println("업무종료 :)");

	}

	private String inputBCode() {
		while (true) {
			System.out.print("도서코드(QUIT:종료) >> ");
			strBCode = scan.nextLine();

			int intBCodeLength = strBCode.length();
			if (intBCodeLength < 0 || intBCodeLength > 5) {
				System.out.println("도서코드는 13자리 이내의 숫자로 입력하세요");
				continue;
			}

			int intBCode = 0;
			try {
				intBCode = Integer.valueOf(strBCode);
			} catch (Exception e) {
				System.out.println("도서코드는 숫자로만 입력해야 합니다");
				continue;
			}

			// 도서 코드는 5자리 숫자형 문자열로 변환한다
			// 00001
			strBCode = String.format("%05d", intBCode);
			break;
		}
		return strBCode;
	}

	private String inputBName() {
		while (true) {
			System.out.print("도서명(QUIT:종료) >> ");
			strBName = scan.nextLine();

			if (strBName.isEmpty()) {
				System.out.println("도서명은 반드시 입력해야 합니다");
				continue;
			}
			break;
		}
		return strBName;
	}

	private void printBookInfo() {
		System.out.println("================================");
		System.out.println("입력한 도서정보");
		System.out.println("--------------------------------");
		System.out.printf("도서코드 : %s\n",this.strBCode);
		System.out.printf("도서명 : %s\n", this.strBName);
		System.out.println("================================");
	}
}