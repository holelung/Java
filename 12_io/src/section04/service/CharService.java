package section04.service;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class CharService {
/*
 * [문자 기반 스트림]
 * 
 * - 2byte 문자(char) 단위로 입/출력 하는 스트림
 * 
 * - 문자만 작성된 파일(txt, bin 등),
 *   채팅, JSON, 웹 요철(주소)/응답(HTML)
 *   
 * - 문자기반 최상의 스트림 :
 * Reader(입력), Writer(출력)
 */
	
	
	
	/** 문자 기반 스트림을 이용한 파일 출력 */
	public void fileOutput1() {
		FileWriter fw = null;
		
		try {
			String content = """
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
난 내 삶의 끝을 본적이 있어 내 가슴속은 갑갑해졌어
내 삶을 막은것은 나의 내일에 대한 두려움
반복됐던 기나긴 날 속에 버려진 내 자신을 본 후
나는 없었어 그리고 또 내일조차 없었어
내겐 점점 더 크게 더해갔던 이 사회를 탓하던 분노가
마침내 증오가 됐어 진실들은 사라졌어 혀 끝에서
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
다시 하나의 생명이 태어났고 또 다시 부모의 제압은 시작
됐지
네겐 사랑이 전혀 없는 것 내 힘겨운 눈물이 말라버렸지
무모한 거품은 날리고 흠~ 주위를 둘러봐 널 기다리고 있
어
그래 이젠 그만됐어 나는 하늘을 날고 싶었어
아직 우린 젊기에 괜찮은 미래가 있기에
자 이제 그 차가운 눈물은 닦고 COME BACK HOME
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
IN THE PLACE TO BE !! ONE,TWO,TREEE...
IN THE PLACE TO BE !! IN THE PLACE TO BE !! IN THE
PLACE TO BE !!
터질것 같은 내 심장은 날 미치게 만들 것 같았지만
난 이제 깨달았어,았-어 날 사랑했다는 것을
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
					""";
		// 폴더가 없을 경우 생성
		String path = "io_test/char";
		File folder = new File(path);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
			
		fw = new FileWriter(folder + "/" + "COME_BACK_HOME_서태지와이이들.txt");
		
		// 문자기반 스트르미을 이용해서 출력
		fw.write(content);// String, char[] 출력을 위한 기능이 제공
  	// 스트림에 남은 데이터를 밀어냄
		fw.flush(); // close() 시 자동으로 실행
			
		System.out.println("출력 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(fw != null) fw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // fileOutput
	
	public void fileOutput2() {
		FileWriter fw = null;
		BufferedWriter bw = null;
		
		try {
			String content = """
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
난 내 삶의 끝을 본적이 있어 내 가슴속은 갑갑해졌어
내 삶을 막은것은 나의 내일에 대한 두려움
반복됐던 기나긴 날 속에 버려진 내 자신을 본 후
나는 없었어 그리고 또 내일조차 없었어
내겐 점점 더 크게 더해갔던 이 사회를 탓하던 분노가
마침내 증오가 됐어 진실들은 사라졌어 혀 끝에서
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
다시 하나의 생명이 태어났고 또 다시 부모의 제압은 시작
됐지
네겐 사랑이 전혀 없는 것 내 힘겨운 눈물이 말라버렸지
무모한 거품은 날리고 흠~ 주위를 둘러봐 널 기다리고 있
어
그래 이젠 그만됐어 나는 하늘을 날고 싶었어
아직 우린 젊기에 괜찮은 미래가 있기에
자 이제 그 차가운 눈물은 닦고 COME BACK HOME
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
IN THE PLACE TO BE !! ONE,TWO,TREEE...
IN THE PLACE TO BE !! IN THE PLACE TO BE !! IN THE
PLACE TO BE !!
터질것 같은 내 심장은 날 미치게 만들 것 같았지만
난 이제 깨달았어,았-어 날 사랑했다는 것을
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 거칠은 인생속에
YOU MUST COME BACK HOME 떠나간 마음보다 따뜻한
YOU MUST COME BACK HOME 나를 완성하겠어
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
난 지금 무엇을 찾으려고 애를 쓰는 걸까
난 지금 어디로 쉬지않고 흘러가는가
					""";
		// 폴더가 없을 경우 생성
		String path = "io_test/char";
		File folder = new File(path);
		
		if(!folder.exists()) {
			folder.mkdir();
		}
			
		fw = new FileWriter(folder + "/" + "COME_BACK_HOME_서태지와이이들_buffer.txt");
		bw = new BufferedWriter(fw);
		
		// 문자기반 스트르미을 이용해서 출력
		bw.write(content);// String, char[] 출력을 위한 기능이 제공
  	// 스트림에 남은 데이터를 밀어냄
		bw.flush(); // close() 시 자동으로 실행
			
		System.out.println("출력 완료");
			
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				if(bw != null) bw.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	} // fileOutput2
	
	/*
	 * 파일 읽어오기 문자기반 스트림 + 보조스트림
	 */
	public void fileInput() {
		
		/* [try - with - resource]
		 * - 자바 7에서 추가
		 * 
		 * - finally 에서 잙성하던 close 구문을 자동수행하도록 만듦
		 */
		String path =  "io_test/char/COME_BACK_HOME_서태지와이이들.txt";
		
		try(BufferedReader br = new BufferedReader(new FileReader(path))) {

			StringBuilder sb = new StringBuilder();
			// 보조스트림을 이용해서 파일 내용 읽어오기
			String temp = null;
			while(true) {
				temp = br.readLine();
				if(temp == null) break;
				sb.append(temp+"\n");
			}
			System.out.println("----읽어오기 성공----");
			System.out.println(sb.toString());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	} // fileInput
	
	// Scanner 대신 스트림을 이용한 문자열 입력 받기 -> Scanner 개느림
	// 키보드 입력 -> 바이트(2진수) 코드 -> 문자 변환
	/**
	 * 
	 */
	public void keyboardInput() {
		
		// System.in : 기본 장치(키보드)와 연결된 InputStream 반환
		try(BufferedReader br = new BufferedReader(new InputStreamReader(System.in))) {
			System.out.print("문자열 입력1 : ");
			String input1 = br.readLine(); // 입력된 한줄 읽어오기
			
			System.out.print("문자열 입력2 : ");
			String input2 = br.readLine(); // 입력된 한줄 읽어오기
			
			
			System.out.println("input1 : " + input1);
			System.out.println("input2 : " + input2);
			
			
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
}
